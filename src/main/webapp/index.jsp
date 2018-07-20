<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.*,bean.*,java.time.*" %>
<!DOCTYPE html>
<html>  			
<head>
<meta charset="utf-8">
<title>主页</title>
<jsp:include page="resource.html" flush="true" />
</head>
<body>
<jsp:include page="navbar.html" flush="true" />
<div class="container">
    <div class=""row>
    <div class="col-md-8">
        <div class="col-md-12">
	        <div class="panel panel-default">
			  <div class="panel-heading">
			    <h3 class="panel-title">公告</h3>
			  </div>
			  <div class="panel-body">
			    <div class="list-group">
				  <% 
				  List<Notice> notices = (List)request.getAttribute("notices");
				  
				  for(Notice notice : notices) {
				      out.println("<a href='notice?nid="+ notice.getNid() +"' class='list-group-item'>" +
			                    notice.getTitle()
			                    + "<span style='float:right;'>"+ LocalDateTime.ofEpochSecond(notice.getTime(), 0, ZoneOffset.UTC).toString() +"</span></a>");
				  }
				  %>
				</div>
			  </div>
			</div>
        </div>
    </div>
    <div class="col-md-4">
        <div class="col-md-10">
			<a class="btn btn-primary" role="button" href="changePassword.jsp">
			  修改密码
			</a>
        </div>
    </div>
    </div>
</div>
</body>
</html>