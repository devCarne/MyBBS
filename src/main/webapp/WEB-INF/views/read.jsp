<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        #replyShow {
            display: block;
        }
        #reply {
            display: none;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <title>Title</title>
    <script>
        $(document).ready(function () {
            $("#replyShowButton").click(function () {
                $("#replyShow").css("display","none")
                $("#reply").css("display","block")
            });
        });

        $(document).ready(function () {
            $.ajax({
                type: 'post',
                async: false,
                url: 'getReply',
                dataType: 'text',
                data: {bbs_num: ${posting.num}},
                success: function (data) {
                    let list = JSON.parse(data);
                    let result = "<hr>"
                    for(let i = 0; i < list.length; i++) {
                        result += "댓글번호: " + list[i].num + "<br>" +
                        "작성자: " + list[i].writer + "<br>" +
                        "내용 : " + list[i].comments + "<hr>";
                    }
                    $("#replys").html(result);
                }
            });
        });

        $(document).ready(function () {
            $("#replySubmit").click(function () {
                $.ajax({
                    type: 'post',
                    async: false,
                    url: 'reply',
                    dataType: 'text',
                    data: {comments: $("#comments").val(), bbs_num: ${posting.num}},
                    success: function (data) {
                        let list = JSON.parse(data);
                        let result = "<hr>"
                        for(let i = 0; i < list.length; i++) {
                            result += "댓글번호: " + list[i].num + "<br>" +
                                "작성자: " + list[i].writer + "<br>" +
                                "내용 : " + list[i].comments + "<hr>";
                        }
                        $("#replys").html(result);
                    }
                });
            })
        });
    </script>
</head>
<body>
글번호 : ${posting.num}<br>
제목 : ${posting.title}<br>
내용 : ${posting.content}<br>
<button type="button" onclick="location.href='update?num=${posting.num}'">수정</button>
<button type="button" onclick="location.href='delete?num=${posting.num}'">삭제</button>

<div id="replys">
</div>
<div id="replyShow">
    <button type="button" id="replyShowButton">댓글 작성</button>
</div>

<div id="reply">
    <input type="text" id="comments">
    <button type="button" id="replySubmit">댓글 등록</button>
</div>
</body>
</html>
