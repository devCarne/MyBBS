<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <title>Title</title>
</head>
<script>
    function inputCheck() {
        if ($("#id").val().length === 0) {
            alert("아이디를 입력하세요.");
            $("#id").focus();
            return false;
        } else if ($("#pw").val().length === 0) {
            alert("비밀번호를 입력하세요.");
            $("#pw").focus();
            return false;
        } else if ($("#name").val().length === 0) {
            alert("이름을 입력하세요.");
            $("#name").focus();
            return false;
        }
    }
</script>
<body>
<form action="signUpQuery" method="post">
    ID : <input type="text" name="id" id="id"><br>
    PW : <input type="password" name="pw" id="pw"><br>
    name : <input type="text" name="name" id="name"><br>
    <input type="submit" onclick="return inputCheck()" value="등록">
</form>
<button type="button" onclick="location.href='/'">취소</button>
</body>
</html>
