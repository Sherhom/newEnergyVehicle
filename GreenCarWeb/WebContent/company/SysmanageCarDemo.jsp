<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String root = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=root%>/company/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=root%>/company/css/bootstrap-table.css" rel="stylesheet" />
<link href="<%=root%>/company/css/animatecss/animate.min.css"
	rel="stylesheet">
<link href="<%=root%>/company/css/style.min.css" rel="stylesheet">


<script src="<%=root%>/company/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=root%>/company/js/bootstrap/bootstrap.min.js"></script>
<script src="<%=root%>/company/js/bootstrap-table/bootstrap-table.js"></script>
<script src="<%=root%>/company/js/bootstrap-table/bootstrap-table-zh-CN.js"></script>
<script src="<%=root%>/company/js/bootstrap/bootstrap-treeview.min.js"></script>
<script src="<%=root%>/company/js/jquery/jquery.extends.js"></script>

<title>车辆信息管理</title>

</head>
<body class="gray-bg">
	<div class="modal fade" id="sysAddCar" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">添加车队车辆</h4>
				</div>
				<div class="modal-body">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">车辆编号</span>
						<input type="text" class="form-control" placeholder="请输入车辆编号" aria-describedby="basic-addon1">
					</div>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="sysModifyCar" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">修改车辆信息</h4>
				</div>
				<div class="modal-body">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">车辆品牌</span>
						<input type="text" class="form-control" placeholder="请输入车辆编号" aria-describedby="basic-addon1">
					</div>
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">承载能力</span>
						<input type="text" class="form-control" placeholder="请输入车辆承载吨位数" aria-describedby="basic-addon1">
					</div>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="wrapper wrapper-content animated fadeInRight" style="width:100%,height:100%">
		<div class="col-sm-4">
			<div id="tree"></div>
		</div>
		<div class="col-sm-8">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>车队详细信息</h5>
				</div>
				<div class="ibox-content">

					<div class="row">
						<div id="toolbar" class="btn-group">
							<!-- 工具栏 -->
							<button id="btn_add" type="button" class="btn btn-primary btn-sm"
								data-toggle="modal" data-target="#sysAddCar">
								<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
							</button>

							<button id="btn_delete" type="button"
								class="btn btn-danger btn-sm"
								onclick="sysGetSections">
								<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除
							</button>
						</div>
						<div class="col-sm-12">
							<table class="table table-striped table-bordered table-hover"
								id="demoTable">
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		function operateEvents(){
		};
		
		function createModifyBtn(){
			return [
				'<button type="button" class="btn btn-primary" id="modify" data-toggle="modal" data-target="#sysModifyCar" >修改</button>'
			]
		}
		
		let _demoTable = $('#demoTable').bootstrapTable({
            sidePagination:'server',//设置为服务器端分页
            url: '<%=root%>/car/sysgetCarinfo.action',
			method : 'post',
			queryParams : function(params) {
				var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					limit : params.limit, //页面大小
					offset : params.offset, //页码
					motorcade : 1
				};
				return temp;
			},
			contentType : 'application/x-www-form-urlencoded;charset=utf-8',
			striped : true,
			clickToSelect : true,
			pagenumber : 1,
			pageSize : 5,
			pagination : true,
			pageList : [ 10, 30, 50 ],
			showToggle : true,
			showRefresh : true,

			sortable : true,
			idField : 'id',
			columns : [ {
				field : 'state',
				width : '10%',
				checkbox : true
			}, {
				field : 'carNum',
				width : '10%',
				title : '车辆编号',
				align : 'center'
			}, {
				field : 'carBrand',
				width : '10%',
				title : '车辆品牌',
				align : 'center'
			}, {
				field : 'carryingCapacity',
				width : '10%',
				title : '承载能力',
				align : 'center'
			}, {
				field : 'operate',
				width : '10%',
				title : '操作',
				align : 'center',
				events : operateEvents,
				formatter : createModifyBtn
			} ],
			toolbar : '#toolbar'

		});
		
		function getTree(){
			var data = [
				  {
				    text: "Team1",
				    nodes: [
				      {
				        text: "Car 1",
				      },
				      {
				        text: "Car 2"
				      }
				    ]
				  },
				  {
				    text: "Parent 2",
				    nodes: [
				    	{
				    		text:"Car 3"	
				    	}
				    	 
				    ]
				  },
				  {
				    text: "Parent 3"
				  },
				  {
				    text: "Parent 4"
				  },
				  {
				    text: "Parent 5"
				  }
				];
			return data;
		}
		$('#tree').treeview({data:getTree()});
		
	});
</script>
</html>