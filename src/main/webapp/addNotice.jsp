<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>新建公告</title>
 <!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="adminNavbar.html" flush="true" />

<div class="container">
    <div class=""row>
        <div class="col-md-4 col-md-offset-3">
        <h3>新建公告</h3>
            <form action="addNotice" method="post">
                <div class="form-group">
                <label for="title">标题</label>
                <input type="text" class="form-control" id="title" name="title" placeholder="">
                </div>
                <div class="form-group">
                  <label for="content">内容</label>
                  <textarea class="form-control" rows="3" name="content"></textarea>
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