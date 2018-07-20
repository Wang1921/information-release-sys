<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册</title>
 <!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="navbar.html" flush="true" />

<div class="container">

    <div class=""row>
        <div class="col-md-4 col-md-offset-3">
        <h3>注册</h3>
            <form action="register" method="post">
                <div class="form-group">
                <label for="uname">昵称</label>
                <input type="text" class="form-control" id="uname" name="uname" placeholder="">
                </div>
                <div class="form-group">
                  <label for="password1">密码</label>
                  <input type="password" class="form-control" id="password1" name="password1" placeholder="">
                </div>
                <div class="form-group">
                  <label for="password2">确认密码</label>
                  <input type="password" class="form-control" id="password2" name="password2" placeholder="">
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