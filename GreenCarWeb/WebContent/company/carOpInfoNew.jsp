<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet" type="text/css" href="/GreenCarWeb/company/css/cloud-admin.css">
<link rel="stylesheet" type="text/css" href="/GreenCarWeb/company/css/themes/default.css"
	id="skin-switcher">
<link rel="stylesheet" type="text/css" href="/GreenCarWeb/company/css/responsive.css">
<!-- STYLESHEETS -->
<!--[if lt IE 9]><script src="js/flot/excanvas.min.js"></script><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script><![endif]-->
<link rel="stylesheet" type="text/css" href="/GreenCarWeb/company/css/cloud-admin.css">
<link rel="stylesheet" type="text/css" href="/GreenCarWeb/company/css/themes/default.css"
	id="skin-switcher">
<link rel="stylesheet" type="text/css" href="/GreenCarWeb/company/css/responsive.css">


<!-- DATE RANGE PICKER -->
<link rel="stylesheet" type="text/css"
	href="/GreenCarWeb/company/js/bootstrap-daterangepicker/daterangepicker-bs3.css" />
<!-- TABLE CLOTH -->
<!-- <link rel="stylesheet" type="text/css"
	href="/GreenCarWeb/company/js/tablecloth/css/tablecloth.min.css" /> -->
<link rel="stylesheet" href="/GreenCarWeb/company/css/bootstrap-table.css">
<link rel="stylesheet" href="/GreenCarWeb/company/css/bootstrap.min.css">
<!-- FONTS -->
<script src="/GreenCarWeb/company/js/jquery/jquery-2.0.3.min.js"></script>
<script>
function getOpInfo(){
	$('#tableCarOpInfo').bootstrapTable('refresh',{limit:10,offset:0});
}

function searching(carNum) {
				$.ajax({  
					  url: "/GreenCarWeb/getGuaInfo_InOp.action",  
					  type:'post',
					  dataType:'json',
					  async:true,
					  data:{  
					  	carNum:carNum
						},  
					success:function(data){  
						var result=data
						var html = "";
						var tdHead = "<td>";
						var tdFoot = "</td>";
						$("#t1 tr:gt(0)").remove();//第一行是table的表格头不需清除。
						for(var i=0;i<result.length;i++){
							var guaInfo = result[i];
							
							var carNum=guaInfo.carNum;
							var mainPeriod=guaInfo.mainPeriod;
							var mainDes=guaInfo.mainDes;
							var times=guaInfo.times;
							
							html += "<tr>" + tdHead + (i + 1) + tdFoot + 
							tdHead + carNum + tdFoot +
							tdHead + mainPeriod + tdFoot + 
							tdHead + mainDes + tdFoot +
							tdHead + times + tdFoot + "</tr>";
						}
						$("#t1").append(html);//将新数据填充到table
					}
				}); 
}

function searchingByMotNum(motorcadeNum) {
	$.ajax({  
		  url: "/GreenCarWeb/getTaskInfo_InOp.action",  
		  type:'post',
		  dataType:'json',
		  async:true,
		  data:{  
		  	motorcadeNum:motorcadeNum
			},  
		success:function(data){  
			var result=data
			var html = "";
			var tdHead = "<td>";
			var tdFoot = "</td>";
			$("#t2 tr:gt(0)").remove();//第一行是table的表格头不需清除。
			for(var i=0;i<result.length;i++){
				var taskInfo = result[i];
				
				var motorcadeNum=taskInfo.motorcadeNum;
				var taskNum=taskInfo.taskNum;
				var commitTime=taskInfo.commitTime;
				var endTime=taskInfo.endTime;
				var finishTime=taskInfo.finishTime;
				var finishStatus=taskInfo.finishStatus;
				var taskDes=taskInfo.taskDes;
				
				html += "<tr>" + tdHead + (i + 1) + tdFoot + 
				tdHead + motorcadeNum + tdFoot +
				tdHead + taskNum + tdFoot + 
				tdHead + commitTime + tdFoot +
				tdHead + endTime + tdFoot + 
				tdHead + finishTime + tdFoot + 
				tdHead + finishStatus + tdFoot +
				tdHead + taskDes + tdFoot + 
				"</tr>";
			}
			$("#t2").append(html);//将新数据填充到table
		}
	}); 
}
</script>

<script>
function getCarNum(){
	
	var t=$('#tableCarOpInfo').find('tbody').find('tr.selected');
	//alert(t.length);
	//alert(t.children().eq(1).html());
	var carNum;
	
	carNum=t.children().eq(1).text();
		
	//alert(carNum);
	searching(carNum);
}

function getMotorcadeNum(){
	//alert("hello!");
	var t=$('#tableCarOpInfo').find('tbody').find('tr.selected');
	//alert(t.children().eq(2).text());
	var motorcadeNum;
	
	motorcadeNum=t.children().eq(2).text();
	searchingByMotNum(motorcadeNum);
}
</script>
</head>
<body>
<!-- 
	<div class="box border purple" style="height: 100%">
		<div class="box-title">
			<h4>
				<i class="fa fa-list-ul"></i>车辆运维信息
			</h4>
		</div>
 -->
		<div class="box-body" style="height: 100%;width:100%">
			<!-- ORDERS -->
			<div class="row">
				<!-- ORDER SCROLL -->
				<!-- <div class="col-md-4">
					<div class="panel panel-default">
						<div class="panel-body orders">
							<div class="scroller" data-height="650px" data-always-visible="1"
								data-rail-visible="1">
								<ul class="list-unstyled" id="carteamList">
									<li class="clearfix" value="1">
										<div class="text-right pull-left">
											<h4 class="cost">Team1</h4>
										</div>
									</li>
									<li class="clearfix" value="2">
										<div class="text-right pull-left">
											<h4 class="cost">Team2</h4>
										</div>
									</li>
									<li class="clearfix" value="3">
										<div class="text-right pull-left">
											<h4 class="cost">Team3</h4>
										</div>
									</li>
									<li class="clearfix">
										<div class="text-right pull-left">
											<h4 class="cost">Team4</h4>
										</div>
									</li>
									<li class="clearfix">
										<div class="text-right pull-left">
											<h4 class="cost">Team5</h4>
										</div>
									</li>
									<li class="clearfix">
										<div class="text-right pull-left">
											<h4 class="cost">Team6</h4>
										</div>
									</li>
									<li class="clearfix">
										<div class="text-right pull-left">
											<h4 class="cost">Team7</h4>
										</div>
									</li>
									<li class="clearfix">
										<div class="text-right pull-left">
											<h4 class="cost">Team8</h4>
										</div>
									</li>
									<li class="clearfix">
										<div class="text-right pull-left">
											<h4 class="cost">Team9</h4>
										</div>
									</li>
									<li class="clearfix">
										<div class="text-right pull-left">
											<h4 class="cost">Team10</h4>
										</div>
									</li>
								</ul>
							</div>
						</div>

					</div>
				</div> -->
				<!-- /ORDER SCROLL -->
				<!-- ORDER DETAILS -->
				<div class="col-md-12">
					<div class="box-body center">


						
					</div>
					<!-- BOX -->
					<div class="box border blue" style="margin-bottom:10px">
						<div class="box-title">
							<h4>
								<i class="fa fa-table"></i>车辆运维信息
							</h4>
							<!-- <div class="tools">
								<a href="#box-config" data-toggle="modal" class="config"> <i
									class="fa fa-cog"></i>
								</a> <a href="javascript:;" class="reload"> <i
									class="fa fa-refresh"></i>
								</a> <a href="javascript:;" class="collapse"> <i
									class="fa fa-chevron-up"></i>
								</a> <a href="javascript:;" class="remove"> <i
									class="fa fa-times"></i>
								</a>
							</div> -->
						</div>
						<div class="box-body">
										<table>
	    <tr>
			<td >
			        车辆号:<input type="text" id="carKeyword"  name="carKeyword"/>    
			</td>
			<td>
			        车队号:<input type="text" id="carTeamKeyword"  name="carTeamKeyword"/> 
			</td>
			<td><input class="btn btn-primary btn-sm" type="submit" value="查询" onclick="getOpInfo()" /></td>
			
			<td>
			<button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">
	                        作业信息
			</button>
			</td>
			 
			<td>
			<button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal2">
				保养信息
            </button>
            </td>
            
			
		</tr>
	    </table>
		
							<table class="table table-striped" id="tableCarOpInfo">
							     
                               <!--表在这里  -->
							</table>
						</div>
						<!-- <div class='text-center'>
							<ul class='pagination'>
								<li class='disabled'><a href='#'> <i
										class='fa fa-angle-left'></i>
								</a></li>
								<li class='active'><a href='#'> 1 </a></li>
								<li><a href='#'>2</a></li>
								<li><a href='#'>3</a></li>
								<li><a href='#'>4</a></li>
								<li><a href='#'>5</a></li>
								<li><a href='#'> <i class='fa fa-angle-right'></i>
								</a></li>
							</ul>
						</div> -->
					</div>
					<!-- /BOX -->
				</div>
				<!-- /ORDER DETAILS -->
			</div>
			<!-- ORDERS -->
		</div>
<!-- 		
	</div>
-->
	<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					作业信息
				</h4>
			</div>
			<div class="modal-body">
				    <table id="t2">
			
	    <tr>
	       <th width="5%">序号</th>
	     
	       <th>车队编号</th>
	       <th>任务编号</th>
	       <th>发布时间</th>
	       <th>截止时间</th>
	       <th>实际完成时间</th>
	       <th>完成状态</th>
	       <th>任务描述</th>
	       
	    </tr>
	   
	</table>  
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<!-- 
				<button type="button" class="btn btn-primary">
					提交更改
				</button>
				 -->
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>

<!-- 模态框（Modal） -->


<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
	                                 保养信息
				</h4>
			</div>
			<div class="modal-body">
		<table id="t1">
			
	    <tr>
	       <th width="5%">序号</th>
	     
	       <th>车牌号</th>
	       <th>保养周期</th>
	       <th>保养信息</th>
	       <th>时间</th>
	       
	    </tr>
	   
	</table>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				
			</div>
		</div>
	</div>
</div>
	

	
	
	<!-- JQUERY UI-->
	<!-- <script
		src="/GreenCarWeb/company/js/jquery-ui-1.10.3.custom/js/jquery-ui-1.10.3.custom.min.js"></script> -->
	<!-- BOOTSTRAP -->
	<!-- <script src="bootstrap-dist/js/bootstrap.min.js"></script> -->


	<!-- DATE RANGE PICKER -->
	<script src="/GreenCarWeb/company/js/bootstrap-daterangepicker/moment.min.js"></script>

	<script src="/GreenCarWeb/company/js/bootstrap-daterangepicker/daterangepicker.min.js"></script>
	<!-- SLIMSCROLL -->
	<script type="text/javascript"
		src="/GreenCarWeb/company/js/jQuery-slimScroll-1.3.0/jquery.slimscroll.min.js"></script>
	<script type="text/javascript"
		src="/GreenCarWeb/company/js/jQuery-slimScroll-1.3.0/slimScrollHorizontal.min.js"></script>
	<!-- BLOCK UI -->
	<script type="text/javascript"
		src="/GreenCarWeb/company/js/jQuery-BlockUI/jquery.blockUI.min.js"></script>
	<!-- TABLE CLOTH -->
	<!-- <script type="text/javascript"
		src="/GreenCarWeb/company/js/tablecloth/js/jquery.tablecloth.js"></script>
	<script type="text/javascript"
		src="/GreenCarWeb/company/js/tablecloth/js/jquery.tablesorter.min.js"></script> -->
	<!-- COOKIE -->
	<!-- <script type="text/javascript"
		src="/GreenCarWeb/company/js/jQuery-Cookie/jquery.cookie.min.js"></script> -->
	<!-- CUSTOM SCRIPT -->
	<script src="/GreenCarWeb/company/js/script.js"></script>
	<script src="/GreenCarWeb/company/js/bootstrap.min.js"></script>
	<script src="/GreenCarWeb/company/js/bootstrap-table/bootstrap-table.js"></script>
	<script src="/GreenCarWeb/company/js/bootstrap-table/bootstrap-table-zh-CN.js"></script>
	<script src="/GreenCarWeb/company/js/carOp.js"></script>
	
<script>
$(function () { $('#myModal').modal('hide')});
</script>

<script>
   $(function () { $('#myModal').on('show.bs.modal', function () {
      getMotorcadeNum();
   })});
</script>

<script>
$(function () { $('#myModal2').modal('hide')});
</script>

<script>
   $(function () { $('#myModal2').on('show.bs.modal', function () {
      getCarNum();
   })});
</script>	
	
</body>
</html>