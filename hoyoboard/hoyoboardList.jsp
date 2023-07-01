<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta charset="UTF-8">
<title>일기장 페이지</title>
<link rel="stylesheet" href="css/hoyoboard.css">
</head>
<body>
<div id="wrap" align="center">
<h1>호요버스 일기장</h1>
	<table class="list">
		<tr>
		<td colspan="5" style="border:white; text-align:right">
			<a href="HoyoBoardServlet?command=hoyoboard_write_form">게시글 등록</a>
		</td>
	</tr>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회</th>
	</tr>
	<c:forEach var="board" items="${boardlist}">
	<tr class="record">
		<td>${board.num}</td>
		<td>
			<a href="HoyoBoardServlet?command=hoyoboard_view&num=${board.num}">${board.title}</a>
		</td>
		<td>${board.name}</td>
		<td><fmt:formatDate value="${board.writedate}"/></td>
		<td>${board.readcount}</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="5" align="center">
			<form action="HoyoBoardServlet" method="post">
				<select name="searchName" size="1">
					<option value="name">작성자</option>
					<option value="title">글제목</option>
				</select>
				<input type="text" name="searchValue">
				<input type="hidden" name="command" value="hoyoboard_search">
				<input type="submit" value="찾기">
				<input type="button" value="전체글보기" onclick="location.href='HoyoBoardServlet?command=hoyoboard_list'">
			</form>
		</td>
	</tr>
	</table>
	<br>
	<input type="button" value="메인 페이지로 돌아가기" onclick="location.href='home.jsp'">
</div>
</body>
</html>