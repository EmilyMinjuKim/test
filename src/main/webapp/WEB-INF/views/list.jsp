<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<style>
	*{
		text-align : center;
	}
</style>

<html>
	<head>
		<meta charset="utf-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table style="margin-left: auto; margin-right: auto;" border= "1">
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>제목</td>
				<td>날짜</td>
				<td>히트</td>
			</tr>
			<c:forEach var = "dto" items= "${list}"> 
			<tr>
				<td>${dto.bId}</td>
				<td>${dto.bName}</td>
				<td>
					<c:forEach begin = "1" end = "${dto.bIndent}">-</c:forEach> 
					<a href= "content_view?bId=${dto.bId}">${dto.bTitle}</a> 
				</td>
				<td>${dto.bDate}</td>
				<td>${dto.bHit}</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="5"><a href="write_view">글작성</a></td>
			</tr>
		</table>
	</body>
</html>