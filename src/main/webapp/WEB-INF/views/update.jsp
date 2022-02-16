<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="updateQuery" method="post">
    <input type="text" name="num" value="${posting.num}" hidden>
    제목 : <input type="text" name="title" value="${posting.title}"><br>
    내용 : <input type="text" name="content" width="500px" height="350px" value="${posting.content}"><br>
    <input type="submit" value="수정">
</form>
</body>
</html>
