<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캐릭터 등록하는 페이지</title>
<link rel="stylesheet" href="css/genshin.css">
</head>
<body>
<div id="wrap" align="center">
<h1>원신 캐릭터 등록 페이지</h1>
<form method="post" enctype="multipart/form-data" name="frm">
	<table>
		<tr>
			<th>캐릭터명</th>
			<td>
				<input type="text" name="name" size="90">
			</td>
		</tr>
		<tr>
			<th>속&nbsp;성</th>
			<td>
				<input type="text" name="element" size="90">
			</td>
		</tr>
		<tr>
			<th>성&nbsp;급</th>
			<td>
				<input type="text" name="hoshi" size="90">
			</td>
		</tr>
		<tr>
			<th>사&nbsp;진</th>
			<td>
				<input type="file" name="picture"><br>
				(주의 사항: 멋대로 사진을 처넣지 마시오)
			</td>
		</tr>
		<tr>
			<th>무&nbsp;기</th>
			<td>
				<input type="text" name="wepwon" size="90">
			</td>
		</tr>
		<tr>
			<th>레&nbsp;벨</th>
			<td>
				<input type="text" name="levels" size="90">
			</td>
		</tr>
		<tr>
			<th>돌&nbsp;파</th>
			<td>
				<input type="radio" name="ascend" value="0">명함			
				<input type="radio" name="ascend" value="1">1돌파
				<input type="radio" name="ascend" value="2">2돌파
				<input type="radio" name="ascend" value="3">3돌파
				<input type="radio" name="ascend" value="4">4돌파
				<input type="radio" name="ascend" value="5">5돌파
				<input type="radio" name="ascend" value="6">6돌파			
			</td>
		</tr>
	</table>
	<br>
	<input type="submit" value="등록" onclick="return writeCheck()">
	<input type="reset" value="재입력">
	<input type="button" value="목록" onclick="location.href='characterList.do'">
</form>
</div>
</body>
</html>