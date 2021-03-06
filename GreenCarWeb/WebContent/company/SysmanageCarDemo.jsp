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
<script src="<%=root%>/company/js/bootstrap/bootstrap-treeview.js"></script>
<script src="<%=root%>/company/js/jquery/jquery.extends.js"></script>
<!-- bootbox -->
<script src="https://cdn.bootcss.com/bootbox.js/4.4.0/bootbox.min.js"></script>

<title>车辆信息管理</title>

</head>
<body>
	<div class="modal fade" id="sysAddCar" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog"  role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">添加车队车辆</h4>
				</div>
				<div class="modal-body">
					<div class="input-group">
						<span class="input-group-addon" >车辆编号</span>
						<input type="text" class="form-control" id="sysAddCarNum" placeholder="请输入车辆编号" aria-describedby="basic-addon1">
					</div>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" id="btnAddCarSave" class="btn btn-primary">保存</button>
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
						<input type="text" id="sys-carteam-mofify-carBrand" class="form-control" placeholder="请输入车辆品牌" aria-describedby="basic-addon1">
					</div>
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">承载能力</span>
						<input type="text" id="sys-carteam-mofify-carryingCapacity" class="form-control" placeholder="请输入车辆承载吨位数" aria-describedby="basic-addon1">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button"  class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" id="sys-carteam-mofify-btnsave" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>
	
	
	
	<div class="box border blue" style="margin-bottom: 10px;width:100%;height:100%">
	   <div class="box-title">
            <h4>
               <i class="fa fa-table"></i>车队信息管理
            </h4>
      </div>
      <div class="box-body" style="width:100%,height:100%">
      <!-- 
      <div class="wrapper wrapper-content animated fadeInRight" style="width:100%,height:100%">
       -->
       <div class="row">
        <div class="col-sm-4">
            <div id="tree" class="tree tree-unselectable"></div>
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
      </div>
	</div>
	
	
	
	
	
<script src="<%=root%>/company/js/sysmanagecar.js"></script>
</body>

</html>