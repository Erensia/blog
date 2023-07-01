<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>스타레일 캐릭터 정보</title>
<link rel="stylesheet" href="css/genshin.css">
</head>
<body>
<div id="wrap" align="center">
<h1>스타레일 캐릭터의 정보</h1>
<form method="post" enctype="multipart/form-data" name="frm" action="starrailInfo.do">
	<input type="hidden" name="nomakeImg" value="${character.picture}">
	<table>
		<tr>
			<td style="width:112px; height:124px;">
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
						<td>
							${character.name}
							<input type="hidden" name="name" value="${character.name}" size="80">
						</td>
					</tr>
					<tr>
						<th>속성</th>
						<td>
							${character.element}
							<input type="hidden" name="element" value="${character.element}" size="80">
						</td>
					</tr>
					<tr>
						<th>운명의 길</th>
						<td>
							${character.michi}
							<input type="hidden" name="michi" value="${character.michi}" size="80">
						</td>
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
					<tr>
						<th>성급</th>
						<td>
							${character.hoshi}
							<input type="hidden" name="hoshi" value="${character.hoshi}" size="80">
						</td>
					</tr>
					<tr>
						<th>무기</th>
						<td>
							${character.wepwon}
							<input type="hidden" name="wepwon" value="${character.wepwon}" size="80">
						</td>
					</tr>
					<tr>
						<th>레벨</th>
						<td>
							${character.levels}
							<input type="hidden" name="levels" value="${character.levels}" size="80">
						</td>
					</tr>
					<tr>
						<th>한줄평</th>
						<td>
							<textarea name="info" cols="80">${character.info}</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="한줄평 등록">
							<input type="reset" value="한줄평 삭제">
							<input type="button" value="목록" onclick="location.href='starrailList.do'">
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>