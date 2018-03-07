<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();   
	String root = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=root %>/company/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=root %>/company/css/bootstrap-table.min.css" rel="stylesheet" />

<script src="<%=root %>/company/js/jquery-2.1.1.min.js"></script>
<script src="<%=root %>/company/js/bootstrap.min.js"></script>
<script src="<%=root %>/company/js/bootstrap-table.js"></script>
<script src="<%=root %>/company/js/bootstrap-table-zh-CN.js"></script>
<script src="<%=root %>/company/js/jquery.extends.js"></script>
<title>Insert title here</title>

</head>
<body>

</body>
</html>