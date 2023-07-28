<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="styesheet" href="resources/css/member/main.css">
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<h3>회원 정보를 입력하세요.</h3>
	<form action="/member/register.do" method="get">
		<fieldset>
			<legend>회원가입</legend>
			<ul>
				<li><label for="id">아이디</label><input type="text" name="id"
					id="id"></li>
				<li><label for="pw">패스워드</label><input id="pw"
					type="password" name="pw" placeholder="******"></li>
				<li><label for="name">이름</label><input id="name" type="text"
					name="name"></li>
				<li><label for="age">나이</label><input id="age" type="text"
					name="age"></li>
				<li><label for="gender">성별</label> 남 <input id="gender"
					type="radio" name="gender" value="M" id="male"> 여<input
					type="radio" name="gender" id="female" value="F"></li>
				<li><label for="email">이메일</label><input id="email"
					type="text" name="email"></li>
				<li><label for="addr">주소</label><input type="text" id="addr"
					name="addr"></li>
				<li><label for="phone"> 전화번호</label><input id="phone"
					type="text" name="phone"></li>
				<li><label for="hobby">취미</label><input id="hobby" type="text"
					name="hobby"></li>
			</ul>

		</fieldset>
		<input type="submit" value="가입하기"> <input type="reset">
	</form>
</body>
</html>