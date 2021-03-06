<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>编辑公告</title>
 <!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="adminNavbar.html" flush="true" />

<div class="container">
    <div class=""row>
        <div class="col-md-4 col-md-offset-3">
        <h3>编辑公告</h3>
            <form action="editNotice" method="post">
                <div class="form-group">
                <label for="title">标题</label>
                <input type="text" class="form-control" id="title" name="title" placeholder="" value=${requestScope.notice.title}>
                </div>
                <div class="form-group">
                  <label for="content">内容</label>
                  <textarea class="form-control" rows="3" name="content">${requestScope.notice.content}</textarea>
                </div>
                <input type="hidden" name="nid" value=${requestScope.notice.nid}>
                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>
    </div>
</div>


<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>