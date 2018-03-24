<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	String path = request.getContextPath();
	String root = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">
	body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=ltIljHi0Q988RHCszb14Xfs7t6qZoTR5"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/library/LuShu/1.2/src/LuShu_min.js"></script>
<title>Insert title here</title>
<link href="<%=root%>/company/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=root%>/company/css/bootstrap-table.css" rel="stylesheet" />
<link href="<%=root%>/company/css/animatecss/animate.min.css"
	rel="stylesheet">
<link href="<%=root%>/company/css/style.min.css" rel="stylesheet">
<link href="<%=root%>/company/css/daterangepicker-bs3.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.45/css/bootstrap-datetimepicker.css" rel="stylesheet">



</head>
<body>

<div class="box border green" style="width:20%;height:100%;margin:0px;float:left">
<div class="box-title">
	<h4><i class="fa fa-calendar"></i>车队信息 </h4>
</div>
<div class="box-body">
<div class="form-group">  
    <label class="control-label">开始日期：</label>  
    <div class="input-group date">  
        <input class="form-control  validate[required,date[yyyy-MM-dd]]" name="stirng1" id="dateBegin" />  
        <span class="input-group-addon">  
            <span class="glyphicon glyphicon-calendar"></span>  
        </span>  
    </div>
    <label class="control-label">结束日期：</label>  
    <div class="input-group date">  
        <input class="form-control  validate[required,date[yyyy-MM-dd]]" name="stirng1" id="dateEnd" />  
        <span class="input-group-addon">  
            <span class="glyphicon glyphicon-calendar"></span>  
        </span>  
    </div>  
</div>  

	<div id="tree" class="tree tree-unselectable"></div>

</div>

</div>
<div id="allmap" style="width:80%;height:100%;float:right"></div>
</body>
<script src="<%=root%>/company/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=root%>/company/js/bootstrap/bootstrap.min.js"></script>
<script src="<%=root%>/company/js/bootstrap-table/bootstrap-table.js"></script>
<script src="<%=root%>/company/js/bootstrap-table/bootstrap-table-zh-CN.js"></script>
<script src="<%=root%>/company/js/bootstrap/bootstrap-treeview.js"></script>
<script src="<%=root%>/company/js/jquery/jquery.extends.js"></script>
<script src="<%=root%>/company/js/moment-with-locales.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.45/js/bootstrap-datetimepicker.min.js"></script>



<script type="text/javascript">
let carNumNow;

$('#dateBegin').datetimepicker();
$('#dateEnd').datetimepicker();
//生成车队的Tree begin
var tree = {
		init: function(){ 
			$.get("/GreenCarWeb/car/initCarTeamDetailTree.action",
				function(result){
					$('#tree').treeview({
						data:result,
						onNodeSelected:function(event,node){
							refreshMotorcade(node.text);
						}
					});
				})
		
		}
	};
tree.init();


function refreshMotorcade(nodeText){
	nodeText = nodeText + "";
	var carReg = /TEAM\d+/;
	if(!carReg.test(nodeText)){
		alert(nodeText);
		var  regx = new RegExp("\\d+");
		var num = nodeText.match(regx);
		carNumNow = parseInt(num);	
		queryPath(carNumNow);
	}
}
function queryPath(carNum){
	$.get("/GreenCarWeb/car/queryCarPathHistory.action",
			{
				carNum : carNum
			},
			function(result){
				map.clearOverlays();
				resultOBJ = eval('(' + result + ')');
				alert(resultOBJ);
				let points = new Array();
				for(var idx = 0;idx < resultOBJ.length;idx++){
					points[idx] = new BMap.Point(resultOBJ[idx].longtitude,resultOBJ[idx].latitude);
				}
				var polyline = new BMap.Polyline(points,
		   									 {strokeColor:"blue", strokeWeight:2, strokeOpacity:0.5});
				map.addOverlay(polyline);
				let lushu = new BMapLib.LuShu(map,points,{
	                defaultContent:"",
	                autoView:true,//是否开启自动视野调整，如果开启那么路书在运动过程中会根据视野自动调整
	                icon  : new BMap.Icon('http://lbsyun.baidu.com/jsdemo/img/car.png', new BMap.Size(52,26),{anchor : new BMap.Size(27, 13)}),
	                speed: 1000,
	                enableRotation:true//是否设置marker随着道路的走向进行旋转
	                });
				lushu.start();
			});
}

var map = new BMap.Map("allmap");
map.centerAndZoom(new BMap.Point(116.399, 39.910), 13);
map.addControl(new BMap.MapTypeControl({
	mapTypes:[
        BMAP_NORMAL_MAP,
        BMAP_HYBRID_MAP
    ]}));
var navigationControl = new BMap.NavigationControl({
    // 靠左上角位置
    anchor: BMAP_ANCHOR_TOP_LEFT,
    // LARGE类型
    type: BMAP_NAVIGATION_CONTROL_LARGE,
    // 启用显示定位
    enableGeolocation: true
  });
 map.addControl(navigationControl);
    /*
var polyline = new BMap.Polyline([
    new BMap.Point(116.399, 39.910),
    new BMap.Point(116.405, 39.920)
    ],
    {strokeColor:"blue", strokeWeight:6, strokeOpacity:0.5}
  	);
map.addOverlay(polyline);
*/
</script>
</html>