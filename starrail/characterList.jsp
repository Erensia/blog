<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>스타레일 캐릭터 리스트</title>
<link rel="stylesheet" href="css/genshin.css">
</head>
<body>
<div id="wrap" align="center">
<h1>스타레일 캐릭터 리스트</h1>
<h5>캐릭터명을 누르면 한줄평을 남길 수 있어요!</h5>
<hr>
<table class="list">
	<tr>
		<td colspan="6" style="border:white; text-align:right">
		<a href="starrailWrite.do">캐릭터 등록</a>
		</td>
	</tr>
	
	<tr>
		<th style="width:100px;">캐릭터명</th>
		<th style="width:100px;">속성</th>
		<th style="width:100px;">운명의 길</th>
		<th style="width:100px;">성급</th>
		<th style="width:100px;">수정</th>
		<th style="width:100px;">삭제</th>
	</tr>
	
	<c:forEach var="character" items="${character}">
		<tr class="record" align="center">
			<td><a href="starrailInfo.do?name=${character.name}">${character.name}</a></td>
			<c:choose>
				<c:when test="${character.element eq '물리'}">
				<td bgcolor="gray">${character.element}</td>
				</c:when>
				<c:when test="${character.element eq '화염'}">
				<td bgcolor="red">${character.element}</td>
				</c:when>
				<c:when test="${character.element eq '양자'}">
				<td bgcolor="darkviolet">${character.element}</td>
				</c:when>
				<c:when test="${character.element eq '허수'}">
				<td bgcolor="yellow">${character.element}</td>
				</c:when>
				<c:when test="${character.element eq '번개'}">
				<td bgcolor="violet">${character.element}</td>
				</c:when>
				<c:when test="${character.element eq '얼음'}">
				<td bgcolor="#72cdfd">${character.element}</td>
				</c:when>
				<c:when test="${character.element eq '바람'}">
				<td bgcolor="green">${character.element}</td>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${character.michi eq '파멸'}">
				<td style="background-image:url('/image/스타레일 파멸.webp')">
				${character.michi}</td>
				</c:when>
				<c:when test="${character.michi eq '지식'}">
				<td style="background-image:url('/image/스타레일 지식.webp')">
				${character.michi}</td>
				</c:when>
				<c:when test="${character.michi eq '풍요'}">
				<td style="background-image:url('/image/스타레일 풍요.webp')">
				${character.michi}</td>
				</c:when>
				<c:when test="${character.michi eq '공허'}">
				<td style="background-image:url('/image/스타레일 공허.webp')">
				${character.michi}</td>
				</c:when>
				<c:when test="${character.michi eq '화합'}">
				<td style="background-image:url('/image/스타레일 화합.webp')">
				${character.michi}</td>
				</c:when>
				<c:when test="${character.michi eq '수렵'}">
				<td style="background-image:url('/image/스타레일 수렵.webp')">
				${character.michi}</td>
				</c:when>
				<c:when test="${character.michi eq '보존'}">
				<td style="background-image:url('/image/스타레일 보존.webp')">
				${character.michi}</td>
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
		<a href="starrailUpdate.do?name=${character.name}">캐릭터 수정</a>
		</td>
		<td style="width:100px;">
		<a href="starrailDelete.do?name=${character.name}">캐릭터 삭제</a>
		</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="6">
			<input type="button" value="프론트 페이지로" onclick="location.href='index2.jsp'">
		</td>
	</tr>
</table>
</div>
</body>
</html>