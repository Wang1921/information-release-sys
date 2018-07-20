<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录</title>
 <!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="adminNavbar.html" flush="true" />

<div class="container">

    <div class=""row>
        <div class="col-md-4 col-md-offset-3">
        <h3>登录</h3>
            <form action="adminLogin" method="post">
                <div class="form-group">
                <label for="aid">管理员ID</label>
                <input type="text" class="form-control" id="aid" name="aid" placeholder="">
                </div>
                <div class="form-group">
                  <label for="password">密码</label>
                  <input type="password" class="form-control" id="password" name="password" placeholder="">
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