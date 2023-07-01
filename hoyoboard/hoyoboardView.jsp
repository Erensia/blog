<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta charset="UTF-8">
<title>선택한 게시글 상세보기</title>
<link rel="stylesheet" href="css/hoyoboard.css">
<script src="script/hoyoboard.js"></script>
</head>
<body>
<div id="wrap" align="center">
<h1>일기장 상세보기</h1>
<table>
	<tr>
		<th>작성자</th>
		<td>
			${board.name}
		</td>
		<th>이메일</th>
		<td>
			${board.email}
		</td>
	</tr>
	
	<tr>
		<th>작성일</th>
		<td>
			<fmt:formatDate value="${board.writedate}"/>
		</td>
		<th>조회수</th>
		<td>
			${board.readcount}
		</td>
	</tr>
	
	<tr>
		<th>내용</th>
		<td colspan="3">
			<pre>
				${board.content}
			</pre>
		</td>
	</tr>
</table>
<br><br>
<input type="button" value="게시글 수정" onclick="open_win('HoyoBoardServlet?command=hoyoboard_check_pass_form&num=${board.num}','update')">
<input type="button" value="게시글 삭제" onclick="open_win('HoyoBoardServlet?command=hoyoboard_check_pass_form&num=${board.num}','delete')">
<input type="button" value="기시글 리스트" onclick="location.href='HoyoBoardServlet?command=hoyoboard_list'">
<input type="button" value="게시글 등록" onclick="location.href='HoyoBoardServlet?command=hoyoboard_write_form'">
</div>
</body>
</html>