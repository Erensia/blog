<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>캐릭터 리스트를 보여줄 jsp</title>
<link rel="stylesheet" href="css/genshin.css">
</head>
<body>
<div id="wrap" align="center">
<h1>원신 캐릭터 리스트</h1>
<h5>캐릭터명을 누르면 한줄평을 남길 수 있어요!</h5>
<hr>
<table class="list">
	<tr>
		<td colspan="5" style="border:white; text-align:right">
		<a href="characterWrite.do">캐릭터 등록</a>
		</td>
	</tr>
	
	<tr>
		<th style="width:100px;">캐릭터명</th>
		<th style="width:100px;">원소</th>
		<th style="width:100px;">성급</th>
		<th style="width:100px;">수정</th>
		<th style="width:100px;">삭제</th>
	</tr>
	
	<c:forEach var="character" items="${characterList}">
		<tr class="record" align="center">
			<td><a href="characterInfo.do?name=${character.name}">${character.name}</a></td>
			<c:choose>
				<c:when test="${character.element eq '불'}">
				<td bgcolor="#e91313">${character.element}</td>
				</c:when>
				<c:when test="${character.element eq '물'}">
				<td bgcolor="blue">${character.element}</td>
				</c:when>
				<c:when test="${character.element eq '풀'}">
				<td bgcolor="#118800">${character.element}</td>
				</c:when>
				<c:when test="${character.element eq '바위'}">
				<td bgcolor="yellow">${character.element}</td>
				</c:when>
				<c:when test="${character.element eq '번개'}">
				<td bgcolor="violet">${character.element}</td>
				</c:when>
				<c:when test="${character.element eq '얼음'}">
				<td bgcolor="#72cdfd">${character.element}</td>
				</c:when>
				<c:when test="${character.element eq '바람'}">
				<td bgcolor="cyan">${character.element}</td>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${character.hoshi eq '5성'}">
				<td bgcolor="yellow">${character.hoshi}</td>
				</c:when>
				<c:otherwise>
				<td bgcolor="violet">${character.hoshi}</td>
				</c:otherwise>		
			</c:choose>
			
		<td style="width:100px;">
		<a href="characterUpdate.do?name=${character.name}">캐릭터 수정</a>
		</td>
		<td style="width:100px;">
		<a href="characterDelete.do?name=${character.name}">캐릭터 삭제</a>
		</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="5">
			<input type="button" value="프론트 페이지로" onclick="location.href='index.jsp'">
		</td>
	</tr>
</table>
</div>
</body>
</html>