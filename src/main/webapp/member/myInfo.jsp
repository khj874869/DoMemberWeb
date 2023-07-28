<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/member/main.css">
<title>마이페이지</title>

</head>
<body>
	<h1>마이페이지</h1>
	<form action="/member/memberUpdate.do"" method="post">
	<fieldset>
	<legend>학생상세정보</legend>
	<ul>
		<li><label for="id">아이디</label>
		<input type="text" name="id" id="id" value="${member.memberId}" readonly></li>
		<li><label for="pw">패스워드</label>
		<input id="pw" type="password" name="pw"></li>
		<li><label for="name">이름</label>
		<input id="name" type="text"name="name" value="${member.memberName }" readonly></li>
		<li><label for="age">나이</label>
		<input id="age" type="text"name="age" value="${member.memberAge }" readonly></li>
		<li><label for="gender">성별</label> 
		<input type = "hidden" id ="gender" name = "gender" value= "${member.gender }">	
		<c:if test="${member.memberGender eq 'M'}">남자</c:if> 
		<c:if test="${member.memberGender eq 'F'}">여자</c:if>
		<li><label for="email">이메일</label><input id="email" type="text" name="email" value="${member.memberEmail}"  ></li>
		<li><label for="phone"> 전화번호</label><input id="phone" type="text" name="phone" value="${member.memberphone}" ></li>
		<li><label for="addr">주소</label><input type="text" id="addr" name="addr" value = "${member.memberAddress}"></li>
		<li><label for="hobby">취미</label><input id="hobby" type="text" name="hobby" value = "${member.memberhobby}"></li>
		<li><label for="member-date">가입날짜</label><input id="member-date" type="text" name="member-date" value = "${member.memberdate}"></li>
	</ul>

	</fieldset>
	<div>
	<button>수정하기</button>
	<a href="javascript:void(0)" onclick="checkDelete">탈퇴하기</a>
	</div>
	</form>
	<script>
	function checkDelete(){
		const memberId = '${sessionScope.memberId}';
		if(confirm("탈퇴하시겠습니까?")){
			location.href="/member/delete.do?memberId="+memberId;
		}
	}
	</script>
</body>
</html>