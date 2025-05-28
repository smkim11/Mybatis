<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/signStyle.css">
</head>
<body class="doc-list-body">

<div class="doc-header">
    <span class="user-info">${loginInfo.name}(Level ${loginInfo.level})님</span>
    <a href="/logout" class="btn-logout">로그아웃</a>
</div>

<h1 class="doc-title">문서 리스트</h1>

<c:if test="${loginInfo.level == 1 }">
    <a href="/addDoc" class="btn-add-doc">문서작성</a>
</c:if>

<table class="doc-table">
    <tr>
        <th>문서번호</th>
        <th>제목</th>
        <th>작성자</th>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr>
            <td>${list.documentNo }</td>
            <td><a href="/docOne?documentNo=${list.documentNo }" class="doc-link">${list.title }</a></td>
            <td>${list.writer }</td>
        </tr>
    </c:forEach>
</table>

<div class="pagination">
    <c:if test="${p.currentPage>1 }">
        <a href="/docView?currentPage=1" class="page-link">처음</a>
        <a href="/docView?currentPage=${p.currentPage-1 }" class="page-link">이전</a>
    </c:if>
    <span class="page-info">${p.currentPage } / ${p.lastPage }</span>
    <c:if test="${p.currentPage<p.lastPage }">
        <a href="/docView?currentPage=${p.currentPage+1 }" class="page-link">다음</a>
        <a href="/docView?currentPage=${p.lastPage }" class="page-link">마지막</a>
    </c:if>
</div>
</body>
</html>