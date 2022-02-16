<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
<c:set var="name" value="${sessionName}"/>
    <c:choose>
        <c:when test="${name eq null}">
                Guest 접속 중
                <a href="/">로그인</a>
        </c:when>
        <c:otherwise>
                ${sessionName} 접속 중
                <a href="logout">로그아웃</a><br>
                <button type="button" onclick="location.href='write'">글쓰기</button>
        </c:otherwise>
    </c:choose>
</header>

<section>
    <form action="search" method="post">
        <select name="searchOption">
            <option value="title">제목</option>
            <option value="writer">작성자</option>
        </select>
        <input type="search" name="searchValue">
        <input type="submit" value="검색">
    </form>
    <table border="1">
        <tr>
            <th>No</th><th>제목</th><th>작성자</th><th>작성일자</th><th>댓글수</th>
        </tr>
    <c:forEach var="l" items="${list}" begin="${currentPage * 5 - 4}" end="${currentPage * 5}">
        <tr>
            <td>${l.num}</td><td><a href="read?num=${l.num}">${l.title}</a></td><td>${l.writer}</td><td>${l.regDate}</td><td>${l.replyCnt}</td>
        </tr>
    </c:forEach>
    </table>
    <div id="pageSelect">
        <c:forEach begin="1" end="${pageQuantity}" varStatus="v">
            <a href="board?page=${v.count}">${v.count}</a>
        </c:forEach>
    </div>
</section>
</body>
</html>
