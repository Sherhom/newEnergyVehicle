<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" type="text/css"
	href="/GreenCarWeb/company/css/cloud-admin.css">
<link rel="stylesheet" type="text/css"
	href="/GreenCarWeb/company/css/themes/default.css" id="skin-switcher">
<link rel="stylesheet" type="text/css"
	href="/GreenCarWeb/company/css/responsive.css">
<!-- STYLESHEETS -->
<!--[if lt IE 9]><script src="/GreenCarWeb/company/js/flot/excanvas.min.js"></script><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script><![endif]-->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">
<!-- ANIMATE -->
<link rel="stylesheet" type="text/css"
	href="/GreenCarWeb/company/css/animatecss/animate.min.css" />
<!-- DATE RANGE PICKER -->
<link rel="stylesheet" type="text/css"
	href="/GreenCarWeb/company/js/bootstrap-daterangepicker/daterangepicker-bs3.css" />
<!-- TODO -->
<link rel="stylesheet" type="text/css"
	href="/GreenCarWeb/company/js/jquery-todo/css/styles.css" />
<!-- FULL CALENDAR -->
<link rel="stylesheet" type="text/css"
	href="/GreenCarWeb/company/js/fullcalendar/fullcalendar.min.css" />
<!-- GRITTER -->
<link rel="stylesheet" type="text/css"
	href="/GreenCarWeb/company/js/gritter/css/jquery.gritter.css" />
<!-- FONTS -->
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=ltIljHi0Q988RHCszb14Xfs7t6qZoTR5"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="box border green" style="width:20%;height:100%;margin:0px;float:left">
		<div class="box-title">
			<h4>
				<i class="fa fa-sitemap"></i>车辆状态
			</h4>
			<div class="tools hidden-xs">
				<a href="#box-config" data-toggle="modal" class="config"> <i
					class="fa fa-cog"></i>
				</a> <a href="javascript:;" class="reload"> <i class="fa fa-refresh"></i>
				</a> <a href="javascript:;" class="collapse"> <i
					class="fa fa-chevron-up"></i>
				</a> <a href="javascript:;" class="remove"> <i class="fa fa-times"></i>
				</a>
			</div>
		</div>
		<div class="box-body">
			<div id="tree2" class="tree tree-unselectable">
				<div class="tree-folder" style="display: none;">
					<div class="tree-folder-header">
						<i class="fa-folder fa"></i>
						<div class="tree-folder-name"></div>
					</div>
					<div class="tree-folder-content"></div>
					<div class="tree-loader" style="display: none;"></div>
				</div>
				<div class="tree-item" style="display: none;">
					<div class="tree-item-name"></div>
				</div>
	<!-- 			<div class="tree-folder" style="display: block;">
					<div class="tree-folder-header">
						<i class="green fa fa-folder"></i>
						<div class="tree-folder-name">Documents</div>
					</div>
					<div class="tree-folder-content" style="display: none;">
						<div class="tree-item" style="display: block;">
							<div class="tree-item-name">
								<i class="fa fa-file-text"></i> document1.pdf
							</div>
						</div>
						<div class="tree-item" style="display: block;">
							<div class="tree-item-name">
								<i class="fa fa-file-text"></i> document2.doc
							</div>
						</div>
						<div class="tree-item" style="display: block;">
							<div class="tree-item-name">
								<i class="fa fa-file-text"></i> document3.doc
							</div>
						</div>
						<div class="tree-item" style="display: block;">
							<div class="tree-item-name">
								<i class="fa fa-file-text"></i> document4.pdf
							</div>
						</div>
					</div>
					<div class="tree-loader" style="display: none;">
						<div class="tree-loading">
							<i class="fa fa-spinner fa-2x fa-spin"></i>
						</div>
					</div>
				</div>
				<div class="tree-folder" style="display: block;">
					<div class="tree-folder-header">
						<i class="fa-folder red fa"></i>
						<div class="tree-folder-name">Pictures</div>
					</div>
					<div class="tree-folder-content"></div>
					<div class="tree-loader" style="display: none;">
						<div class="tree-loading">
							<i class="fa fa-spinner fa-2x fa-spin"></i>
						</div>
					</div>
				</div> -->
				<div class="tree-folder" style="display: block;">
					<div class="tree-folder-header">
						<i class="fa-folder orange fa"></i>
						<div class="tree-folder-name">Music</div>
					</div>
					<div class="tree-folder-content"></div>
					<div class="tree-loader" style="display: none;">
						<div class="tree-loading">
							<i class="fa fa-spinner fa-2x fa-spin"></i>
						</div>
					</div>
				</div>
				<div class="tree-folder" style="display: block;">
					<div class="tree-folder-header">
						<i class="fa-folder blue fa"></i>
						<div class="tree-folder-name">Videos</div>
					</div>
					<div class="tree-folder-content"></div>
					<div class="tree-loader" style="display: none;">
						<div class="tree-loading">
							<i class="fa fa-spinner fa-2x fa-spin"></i>
						</div>
					</div>
				</div>
				<!-- <div class="tree-folder" style="display: block;">
					<div class="tree-folder-header">
						<i class="fa-folder fa"></i>
						<div class="tree-folder-name">Contacts</div>
					</div>
					<div class="tree-folder-content"></div>
					<div class="tree-loader" style="display: none;">
						<div class="tree-loading">
							<i class="fa fa-spinner fa-2x fa-spin"></i>
						</div>
					</div>
				</div> -->
				
			</div>
		</div>
	</div>
   
    <div id="allmap" style="width:80%;height:100%;float:right"></div>
    	
   <script type="text/javascript">
	// 百度地图API功能
var map = new BMap.Map("allmap");      
map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);      
// 创建地理编码实例      

var myGeo = new BMap.Geocoder();      
// 根据坐标得到地址描述    
myGeo.getLocation(new BMap.Point(116.364, 39.993), function(result){      
    if (result){
      alert(result.address);
    var addComp = result.addressComponents;
      myGeo.getPoint(result.address, function(point){      
    if (point) {      
        map.centerAndZoom(point, 16);      
        map.addOverlay(new BMap.Marker(point));      
    }      
 }, 
addComp.city);
    }      
});
   
</script> 

	<!--/PAGE -->
	<!-- JAVASCRIPTS -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- JQUERY -->
	<script src="js/jquery/jquery-2.0.3.min.js"></script>
	<!-- JQUERY UI-->
	<script src="js/jquery-ui-1.10.3.custom/js/jquery-ui-1.10.3.custom.min.js"></script>
	<!-- BOOTSTRAP -->
	<script src="bootstrap-dist/js/bootstrap.min.js"></script>
	
		
	<!-- DATE RANGE PICKER -->
	<script src="js/bootstrap-daterangepicker/moment.min.js"></script>
	
	<script src="js/bootstrap-daterangepicker/daterangepicker.min.js"></script>
	<!-- SLIMSCROLL -->
	<script type="text/javascript" src="js/jQuery-slimScroll-1.3.0/jquery.slimscroll.min.js"></script><script type="text/javascript" src="js/jQuery-slimScroll-1.3.0/slimScrollHorizontal.min.js"></script>
	<!-- BLOCK UI -->
	<script type="text/javascript" src="js/jQuery-BlockUI/jquery.blockUI.min.js"></script>
	<!-- FUELUX TREE -->
	<script type="text/javascript" src="js/fuelux-tree/fuelux.tree-sampledata.js"></script>
	<script type="text/javascript" src="js/fuelux-tree/fuelux.tree.min.js"></script>
	<!-- COOKIE -->
	<script type="text/javascript" src="js/jQuery-Cookie/jquery.cookie.min.js"></script>
	<!-- CUSTOM SCRIPT -->
	<script src="js/script.js"></script>
	<script>
		jQuery(document).ready(function() {		
			App.setPage("treeview");  //Set current page
			App.init(); //Initialise plugins and elements
		});
	</script>
	<!-- /JAVASCRIPTS -->
</body>
</html>