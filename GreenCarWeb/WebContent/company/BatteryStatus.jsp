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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>电池状态管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=root%>/company/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=root%>/company/css/bootstrap-table.css" rel="stylesheet" />
<link href="<%=root%>/company/css/animatecss/animate.min.css"
	rel="stylesheet">
<link href="<%=root%>/company/css/style.min.css" rel="stylesheet">


<script src="<%=root%>/company/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=root%>/company/js/bootstrap/bootstrap.min.js"></script>
<script src="<%=root%>/company/js/bootstrap-table/bootstrap-table.js"></script>
<script
	src="<%=root%>/company/js/bootstrap-table/bootstrap-table-zh-CN.js"></script>
<script src="<%=root%>/company/js/bootstrap/bootstrap-treeview.js"></script>
<script src="<%=root%>/company/js/jquery/jquery.extends.js"></script>
<!-- bootbox -->
<script src="https://cdn.bootcss.com/bootbox.js/4.4.0/bootbox.min.js"></script>
</head>
<body>
	<div class="wrapper wrapper-content animated fadeInRight"
		style="width: 100%, height:100%">
		<div class="col-sm-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>电池信息</h5>
				</div>
				<div class="ibox-content">

					<div class="row">
						<div id="toolbar" class="btn-group">
							<!-- 工具栏 -->
							<button id="batteryMaintainAddBatteryBtn" type="button"
								class="btn btn-primary btn-sm" data-toggle="modal"
								data-target="#batteryMaintainAddBattery">
								<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增电池
							</button>
						</div>
						<div class="col-sm-12">
								<table class="table table-striped table-bordered table-hover"
									id="batteryTable">
								</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=root%>/company/js/batteryMaintain.js"></script>
</body>
</html>