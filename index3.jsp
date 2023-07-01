<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일기장 프론트 페이지</title>
<link rel="stylesheet" href="css/hoyoboard.css">
</head>
<body>
	<div id="wrap" align="center">
		<h1>
		일기장으로 이동하실건가요?
		</h1>
		<hr size="3px" color="black">
		원신/스타레일 일기장
		<br>
		
		<div id="wrap" align="center">
		<input type="button" value="일기장 리스트"
			onclick="location.href='HoyoBoardServlet?command=hoyoboard_list'">

		<input type="button" value="메인 페이지로 돌아가기"
			onclick="location.href='home.jsp'">
		</div>
		
		<br>
		
		<img id="back" src="image/호요버스 마크.jpg">
	</div>
</body>
</html>