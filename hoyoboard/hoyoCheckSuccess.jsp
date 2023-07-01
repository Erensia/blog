<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인 절차 후, 각각의 결과에 따라서 두 페이지중 하나를 요청하는 페이지</title>
</head>
<body>
<script>
if(window.name=="update"){
	window.opener.parent.location.href=
		"HoyoBoardServlet?command=hoyoboard_update_form&num=${param.num}";
}else if(window.name=="delete"){
	alert('삭제되었습니다');
	window.opener.parent.location.href=
		"HoyoBoardServlet?command=hoyoboard_delete&num=${param.num}";
}
window.close();
</script>
</body>
</html>