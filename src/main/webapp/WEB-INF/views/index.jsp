<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<style>
    #policy {
        position: absolute;
        left: 300px;
        width: 300px;
        height: 200px;
        display: none;
        background-color: white;
    }

    #mask {
        position: fixed;
        width: 100%;
        height: 100%;
        top: 0;
        left: 0;
        display: none;
        background-color:black;
        opacity: 0.8;
    }

</style>
<head>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <title>Title</title>
    <script>
        $(document).ready(function () {
            $("#popPolicy").click(function (e) {
                $("#mask").css("display","block");
                $("#policy").css("display", "block");
                $("body").css("overflow","hidden");
            });
        });

        $(document).ready(function () {
            $("#agreement").click(function () {
                if ($("#agreement").prop("checked", true)) {
                    $("#signUp").show();
                }
            });
        });
    </script>
</head>
<body>
<form action="signIn" method="post">
    ID : <input type="text" name="id"><br>
    PW : <input type="password" name="pw">
    <input type="submit" value="로그인">
</form><br>

<button type="button" id="popPolicy">회원가입</button>
<button type="button" onclick="location.href='board'">비회원으로</button>

<div id="mask"></div>
<div id="policy" data-popup="a">
    <h2>가입 전 주의사항</h2>
    <p>
        1. 싸우지 않습니다.<br>
        2. 비속어를 사용하지 않습니다.
    </p>
    <hr>
    <input type="checkbox" id="agreement" value="동의합니다.">
    <button type="button" id="signUp" onclick="location.href='signUp'" hidden>가입하기</button>
</div>
</body>
</html>
