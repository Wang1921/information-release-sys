<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.*,bean.*,java.time.*" %>
<!DOCTYPE html>
<html>              
<head>
<meta charset="utf-8">
<title>公告</title>
<jsp:include page="resource.html" flush="true" />
</head>
<body>
<jsp:include page="navbar.html" flush="true" />
<div class="container">
    <div class=""row>
	    <div class="col-md-8 col-md-offset-2">
	        <div class="page-header">
			  <h1>${requestScope.notice.title}&nbsp;&nbsp;&nbsp;&nbsp;<small><% out.println(LocalDateTime.ofEpochSecond(((Notice)request.getAttribute("notice")).getTime(), 0, ZoneOffset.UTC).toString()); %></small></h1>
			</div>
			<p>${requestScope.notice.content}</p>
	    </div>
    </div>
</div>
</body>
</html>