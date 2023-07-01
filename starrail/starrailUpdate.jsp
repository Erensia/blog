<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>스타레일 캐릭터 수정</title>
<link rel="stylesheet" href="css/genshin.css">
</head>
<body>
<div id="wrap" align="center">
<h1>스타레일 캐릭터 정보 수정</h1>
<form method="post" enctype="multipart/form-data" name="frm">
	<input type="hidden" name="nomakeImg" value="${character.picture}">
	<table>
		<tr>
			<td style="width:112px; height:124px;" >
				<c:choose>
					<c:when test="${empty character.picture}">
						<img id="star" src="image/noimage.gif">
					</c:when>
					<c:otherwise>
						<img id="star" src="image/${character.picture}">
					</c:otherwise>
				</c:choose>
			</td>
			<td>
				<table>
					<tr>
						<th style="width:80px">캐릭터명</th>
						<td>
							캐릭터명 변경불가
							<input type="hidden" name="name" value="${character.name}" size="80">
						</td>
					</tr>
					<tr>
						<th>속성</th>
						<td>
							<input type="text" name="element" value="${character.element}" size="80">
						</td>
					</tr>
					<tr>
						<th>운명의 길</th>
						<td>
							<input type="text" name="michi" value="${character.michi}" size="80">
						</td>
					</tr>
					<tr>
						<th>성급</th>
						<td>
							<input type="text" name="hoshi" value="${character.hoshi}" size="80">
						</td>
					</tr>
					<tr>
						<th>사진</th>
						<td>
							<input type="file" name="picture">
							<br>
							(주의 사항 : 수정사항이 존재하면 사진을 다시 선택하세요)
						</td>
					</tr>
					<tr>
						<th>무기</th>
						<td>
							<input type="text" name="wepwon" value="${character.wepwon}" size="80">
						</td>
					</tr>
					<tr>
						<th>레벨</th>
						<td>
							<input type="text" name="levels" value="${character.levels}" size="80">
						</td>
					</tr>
					<tr>
						<th>돌파</th>
						<td>
						<c:choose>
							<c:when test="${character.ascend eq 0}">
								<input type="radio" name="ascend" value="0" checked="checked">명함
								<input type="radio" name="ascend" value="1">1돌파
								<input type="radio" name="ascend" value="2">2돌파
								<input type="radio" name="ascend" value="3">3돌파
								<input type="radio" name="ascend" value="4">4돌파
								<input type="radio" name="ascend" value="5">5돌파
								<input type="radio" name="ascend" value="6">6돌파
							</c:when>
							<c:when test="${character.ascend eq 1}">
								<input type="radio" name="ascend" value="0">명함
								<input type="radio" name="ascend" value="1" checked="checked">1돌파
								<input type="radio" name="ascend" value="2">2돌파
								<input type="radio" name="ascend" value="3">3돌파
								<input type="radio" name="ascend" value="4">4돌파
								<input type="radio" name="ascend" value="5">5돌파
								<input type="radio" name="ascend" value="6">6돌파						
							</c:when>
							<c:when test="${character.ascend eq 2}">
								<input type="radio" name="ascend" value="0">명함
								<input type="radio" name="ascend" value="1">1돌파				
								<input type="radio" name="ascend" value="2"checked="checked">2돌파
								<input type="radio" name="ascend" value="3">3돌파
								<input type="radio" name="ascend" value="4">4돌파
								<input type="radio" name="ascend" value="5">5돌파
								<input type="radio" name="ascend" value="6">6돌파	
							</c:when>
							<c:when test="${character.ascend eq 3}">
								<input type="radio" name="ascend" value="0">명함
								<input type="radio" name="ascend" value="1">1돌파				
								<input type="radio" name="ascend" value="2">2돌파
								<input type="radio" name="ascend" value="3"checked="checked">3돌파
								<input type="radio" name="ascend" value="4">4돌파
								<input type="radio" name="ascend" value="5">5돌파
								<input type="radio" name="ascend" value="6">6돌파	
							</c:when>
							<c:when test="${character.ascend eq 4}">
								<input type="radio" name="ascend" value="0">명함						
								<input type="radio" name="ascend" value="1">1돌파
								<input type="radio" name="ascend" value="2">2돌파
								<input type="radio" name="ascend" value="3">3돌파
								<input type="radio" name="ascend" value="4"checked="checked">4돌파
								<input type="radio" name="ascend" value="5">5돌파
								<input type="radio" name="ascend" value="6">6돌파	
							</c:when>
							<c:when test="${character.ascend eq 5}">
								<input type="radio" name="ascend" value="0">명함
								<input type="radio" name="ascend" value="1">1돌파	
								<input type="radio" name="ascend" value="2">2돌파
								<input type="radio" name="ascend" value="3">3돌파
								<input type="radio" name="ascend" value="4">4돌파
								<input type="radio" name="ascend" value="5"checked="checked">5돌파
								<input type="radio" name="ascend" value="6">6돌파					
							</c:when>
							<c:when test="${character.ascend eq 6}">
								<input type="radio" name="ascend" value="0">명함
								<input type="radio" name="ascend" value="1">1돌파
								<input type="radio" name="ascend" value="2">2돌파
								<input type="radio" name="ascend" value="3">3돌파
								<input type="radio" name="ascend" value="4">4돌파
								<input type="radio" name="ascend" value="5">5돌파							
								<input type="radio" name="ascend" value="6"checked="checked">6돌파
							</c:when>
							</c:choose>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<input type="submit" value="수정">
	<input type="reset" value="재입력">
	<input type="button" value="목록" onclick="location.href='starrailList.do'">
</form>
</div>
</body>
</html>