<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function getOpInfo() {
    window.location="GreenCarWeb/getOpInfo?carKeyword="+$("#carKeyword").val()+"&carTeamKeyword="+$("#carTeamKeyword").val();
    
	}
</script>
</head>
<body>
	<table>
	    <tr>
			<td >
			   车辆号:<input type="text" id="carKeyword"  name="carKeyword"/> 
			   车队号:<input type="text" id="carTeamKeyword"  name="carTeamKeyword"/> 
			   <input type="submit" value="查询" onclick="getOpInfo()" />
			</td>
			
			<td>
			     <input type="button" value="作业信息" onclick=""/>
			</td>
			    
			<td>
			      <input type="button" value="保养信息" onclick=""/>
			</td>
			
		</tr>
		<c:set var="#" value="${#}" scope="page" />
		
	    <c:if test="${not empty #}">
	    <tr>
	       <th>序号</th>
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
	    
	    <c:forEach items="${#}" var="#">
	       <tr style="text-align: center;">
					<td width="5%;">${#.tid }</td>
					<td width="25%;"></td>
					<td width="12%;"></td>
					<td width="8%;"></td>
					<td width="8%;"></td>
					<td width="8%;"></td>
		
	    </c:forEach>
	    </c:if>
	
	</table>
</body>
</html>