<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.*,bean.*,java.time.*" %>
<!DOCTYPE html>
<html>              
<head>
<meta charset="utf-8">
<title>管理主页</title>
<jsp:include page="resource.html" flush="true" />
</head>
<body>
<jsp:include page="adminNavbar.html"></jsp:include>
<% 
List<User> users = (List)request.getAttribute("users");
List<Notice> notices = (List)request.getAttribute("notices");
//if (users == null)
    //request.getRequestDispatcher("adminServlet").forward(request, response);
    //response.sendRedirect("adminServlet");    
%>

<div class="container">
    <div class=""row>
    <div class="col-md-8">
        <div class="col-md-12">
        <!-- Nav tabs -->
		  <ul class="nav nav-tabs" role="tablist">
		    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">用户</a></li>
		    <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">公告</a></li>
		  </ul>
		
		  <!-- Tab panes -->
		  <div class="tab-content">
		    <div role="tabpanel" class="tab-pane active" id="home">
		      <div class="panel panel-default">
              <div class="panel-heading">
              <a href="addUser.jsp">新建用户</a>   
              </div>
              <div class="panel-body">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>昵称</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                    <% 
                       if (users!= null) {
                           for(User user : users) {
                               out.println("<tr>");
                               out.println("<th>"+user.getUid()+"</th>");
                               out.println("<td>"+user.getUname()+"</td>");
                               out.println("<td><a href='editUser?uid="+ user.getUid() +"' >编辑</a>\\<a onclick='deleteUser(this,"+user.getUid()+")'>删除</a></td>");
                               out.println("</tr>");
                           }
                       }
                        
                        %>
                        <tr></tr>
                    </tbody>
                </table>
              </div>
            </div>
		    </div>
		    <div role="tabpanel" class="tab-pane" id="profile">
		      <div class="panel panel-default">
              <div class="panel-heading">
              <a href="addNotice.jsp">新建公告</a>   
              </div>
              <div class="panel-body">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>名称</th>
                            <th>时间</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                    <% 
                       if (notices!= null) {
                           for(Notice notice : notices) {
                               out.println("<tr>");
                               out.println("<th>"+notice.getNid()+"</th>");
                               out.println("<td>"+notice.getTitle()+"</td>");
                               out.println("<td>"+ LocalDateTime.ofEpochSecond(notice.getTime(), 0, ZoneOffset.UTC).toString() +"</td>");
                               out.println("<td><a href='editNotice?nid="+ notice.getNid() +"' >编辑</a>\\<a onclick='deleteNotice(this,"+ notice.getNid() +")'>删除</a></td>");
                               out.println("</tr>");
                           }
                       }
                        %>
                        <tr></tr>
                    </tbody>
                </table>
              </div>
            </div>
		    </div>
		  </div>
            
        </div>
    </div>
    <div class="col-md-4">
        <div class="col-md-10">
            <button class="btn btn-primary" type="button">
              修改密码
            </button>
        </div>
    </div>
    </div>
</div>
<script type="text/javascript">
function deleteUser(obj,uid) {
    $.get("deleteUser?uid=" + uid);
    $(obj).parent().parent().remove();
}

function deleteNotice(obj,nid) {
    $.get("deleteNotice?nid=" + nid);
    $(obj).parent().parent().remove();
}
</script>
</body>
</html>