<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改密码</title>
 <!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="navbar.html" flush="true" />

<div class="container">
    <div class=""row>
        <div class="col-md-4 col-md-offset-3">
        <h3>修改密码</h3>
            <form action="changePassword" method="post">
                <div class="form-group">
                <label for="oldPassword">旧密码</label>
                <input type="password" class="form-control" id="oldPassword" name="oldPassword" placeholder="">
                </div>
                <div class="form-group">
                  <label for="newPassword1">新密码</label>
                  <input type="password" class="form-control" id="newPassword1" name="newPassword1" placeholder="">
                </div>
                <div class="form-group">
                  <label for="newPassword2">确认密码</label>
                  <input type="password" class="form-control" id="newPassword2" name="newPassword2" placeholder="">
                </div>
                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>
    </div>
</div>


<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>