<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="/GreenCarWeb/company/bootstrap-dist/css/bootstrap.css" rel="stylesheet">

<script type="text/javascript" src="/GreenCarWeb/company/js_yk/js/jquery-2.0.3.min.js"></script>
<script>
function getOpInfo() {
    window.location="/GreenCarWeb/getOpInfo.action?carKeyword="+$("#carKeyword").val()+"&carTeamKeyword="+$("#carTeamKeyword").val();
    

}

function searching(carNum) {
				$.ajax({  
					  url: "/GreenCarWeb/getGuaInfo_InOp",  
					  type:'post',
					  dataType:'text',
					  async:true,
					  data:{  
					  	carNum:carNum
						},  
					success:function(data){  
						
					}
				}); 
}
</script>

<script>
function getCarNum(){
	var t=document.getElementsByTagName("table")[0];
	var carNum;
	for(var i=0;i<t.rows.length;i++){
		if(t.rows(i).cells(1).firstChild.checked){
			carNum=t.rows(i).cell(2).innerText;
			break;
		}

	}
	searching(carNum);
}
</script>
</head>

<body>

	<table>
	    <tr>
			<td >
			        车辆号:<input type="text" id="carKeyword"  name="carKeyword"/>    
			</td>
			<td>
			        车队号:<input type="text" id="carTeamKeyword"  name="carTeamKeyword"/> 
			</td>
			<td><input type="submit" value="查询" onclick="getOpInfo()" /></td>
			
			<td>
			<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
	                        作业信息
			</button>
			</td>
			 
			<td>
			<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal2">
				保养信息
            </button>
            </td>
            
			
		</tr>
		
		<c:set var="allOpInfo" value="${allOpInfo}" scope="page" />
		
	     <c:if test="${not empty pageScope.allOpInfo}">
	    <tr>
	       <th width="5%">序号</th>
	       <th><input type="checkbox"></th>
	       <th>车辆号</th>
	       <th>车队号</th>
	       <th>司机姓名</th>
	       <th>车辆品牌</th>
	       <th>承载能力</th>
	       <th>出厂日期</th>
	       <th>电池编号</th>
	       <th>保养时间</th>
	       <th>行驶里程</th>
	    </tr>
	   
	    <c:forEach items="${pageScope.allOpInfo}" var="opInfo">
	       <tr style="text-align: center;">
	                <td></td>
	                <td><input type="checkbox"></td>
					<td >${opInfo.carNum}</td>
					<td >${opInfo.motorcadeNum}</td>
					<td >${opInfo.driverName}</td>
					<td >${opInfo.carBrand}</td>
					<td >${opInfo.carryingCapacity}</td>
					<td >${opInfo.dataManu}</td>
					<td >${opInfo.batteryNum}</td>
					<td >${opInfo.times}</td>
					<td >${opInfo.totalMile}</td>
		  </tr>
		
	    </c:forEach>
	    </c:if>
	
	</table>
	
	<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					模态框（Modal）1
				</h4>
			</div>
			<div class="modal-body">
				      
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
					 <table>
		
		<c:set var="guaInfo" value="${guaInfo}" scope="page" />
		
	     <c:if test="${not empty pageScope.guaInfo}">
	    <tr>
	       <th width="5%">序号</th>
	     
	       <th>车牌号</th>
	       <th>保养周期</th>
	       <th>保养信息</th>
	       <th>时间</th>
	       
	    </tr>
	   
	    <c:forEach items="${pageScope.guaInfo}" var="soleGuaInfo">
	       <tr style="text-align: center;">
	                <td></td>
	              
					<td >${soleGuaInfo.carNum}</td>
					<td >${soleGuaInfo.mainPeriod}</td>
					<td >${soleGuaInfo.mainDes}</td>
					<td >${soleGuaInfo.times}</td>
					
		  </tr>
		
	    </c:forEach>
	    </c:if>
	
	</table>
				</h4>
			</div>
			<div class="modal-body">
				在这里添加一些文本
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary">
					提交更改
				</button>
			</div>
		</div>
	</div>
</div>

<script>
$(function () { $('#myModal').modal('hide')});
</script>

<script>
   $(function () { $('#myModal').on('show.bs.modal', function () {
      getCarNum();
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




<script type="text/javascript" src="/GreenCarWeb/company/bootstrap-dist/js/bootstrap.js"></script>
</html>