<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>캐릭터 정보를 삭제하는 페이지</title>
<link rel="stylesheet" href="css/genshin.css">
</head>
<body>
<div id="wrap" align="center">
<h1>원신 캐릭터 정보 삭제</h1>
<form action="characterDelete.do" method="post">
	<table>
		<tr>
			<td style="width:256px">
				<c:choose>
					<c:when test="${empty character.picture}">
						<img src="image/noimage.gif">
					</c:when>
					<c:otherwise>
						<img src="image/${character.picture}">
					</c:otherwise>
				</c:choose>
			</td>
			<td>
				<table>
					<tr>
						<th style="width:80px">캐릭터명</th>
						<td>${character.name}</td>
					</tr>
					<tr>
						<th>속성</th>
						<td>${character.element}</td>
					</tr>
					<tr>
						<th>성급</th>
						<td>${character.hoshi}</td>
					</tr>
					<tr>
						<th>무기</th>
						<td>${character.wepwon}</td>
					</tr>
					<tr>
						<th>레벨</th>
						<td>${character.levels}</td>
					</tr>
					<tr>
						<th>한줄평</th>
						<td>${character.info}</td>
					</tr>
					<tr>
						<th>돌파</th>
						<td>
							<c:choose>
								<c:when test="${character.ascend eq 0}">
									명함
								</c:when>
								<c:otherwise>
									${character.ascend}돌파
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<br>
	<input type="hidden" name="name" value="${character.name}">
	<input type="submit" value="삭제">
	<input type="button" value="목록" onclick="location.href='characterList.do'">
</form>
</div>
</body>
</html>
