<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>编辑用户</title>
 <!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="adminNavbar.html" flush="true" />
<div class="container">
    <div class=""row>
        <div class="col-md-4 col-md-offset-3">
        <h3>编辑用户</h3>
            <form action="editUser" method="post">
                <div class="form-group">
                <label for="uname">昵称</label>
                <input type="text" class="form-control" id="uname" name="uname" placeholder="" value=${requestScope.user.uname}>
                </div>
                <div class="form-group">
                  <label for="password">密码</label>
                  <input type="password" class="form-control" id="password" name="password" placeholder="" value=${requestScope.user.password}>
                </div>
                <input type="hidden" name="uid" value=${requestScope.user.uid}>
                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>
    </div>
</div>


<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>