<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정을 위해 비번을 입력하는 창</title>
<link rel="stylesheet" href="css/hoyoboard.css">
<script src="script/hoyoboard.js"></script>
</head>
<body>
<div align="center">
<h1>비밀번호 확인</h1>
	<form name="frm" method="get" action="HoyoBoardServlet">
		<input type="hidden" name="command" value="hoyoboard_check_pass">
		<input type="hidden" name="num" value="${param.num}">
		<table style="width:80%">
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="pass" size="20">
				</td>
			</tr>
		</table>
		<br>
		<input type="submit" value="확인" onclick="return passCheck()">
		<br><br>
		${message}
	</form>
</div>
</body>
</html>