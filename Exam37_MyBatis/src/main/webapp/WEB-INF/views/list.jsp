<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- jsp에서는 자바코드를 사용하는 걸 선호하지 않기 때문에 ... %=은 잘 사용하지 않음. EL을 많이 사용하거나 JSTL사용, jstl을 사용하려면 3행을 선언해줘야함-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table width="500" cellpadding="0" cellsapcing="0" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>하트</td>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.bId }</td>
				<td>${dto.bName }</td>
				<td><c:forEach begin="1" end="${dto.bIndent }">-</c:forEach> <a
					href="content_view?bId=${dto.bId }">${dto.bTitle }</a></td>
				<td>${dto.bDate }</td>
				<td>${dto.bHit }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="write_view"> 글작성</a></td>
		</tr>
	</table>


</body>
</html>