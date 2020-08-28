<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Insert title here</title>
		<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
		<script type="text/javascript">
		function makeList(){
			var htmls="";
			
			$("#table_list").html(""); //자식 태그 가져오는 것. 공백이라면 초기화 하는 것
			
			$("<tr>" , {
				html : "<td>" + "번호" + "</td>"+
						"<td>" + "이름" + "</td>"+
						"<td>" + "제목" + "</td>"+
						"<td>" + "날짜" + "</td>"+
						"<td>" + "히트" + "</td>"
			}).appendTo("#table_list")
			
			//jsp값을 javascript에서 쓸 수 있는 방법
			
			<c:forEach var="boardVO" items="${list}">
				htmls += '<tr>';
				htmls += '<td>'+ '${boardVO.bId}'+'</td>';
				htmls += '<td>'+ '${boardVO.bName}'+'</td>';
				htmls += '<td>';
					<c:forEach begin="1" end="${boardVO.bIndent}">
						htmls += '-';
					</c:forEach>
				htmls += '<a href="${pageContent.request.contextPath}/content_view?bId=' + '${boardVO.bId}">${boardVO.bTitle}</a>';
				htmls += '</td>';
				htmls += '<td>'+'${boardVO.bDate}'+'</td>';
				htmls += '<td>'+'${boardVO.bHit}'+'</td>';
			</c:forEach>
			
			$("#table_list").append(htmls);
			
			$("#table_list").append(
					"<tr><td colspan='5'><a href= 'write_view'> 글작성  </a></td></tr>"
			);
		}//endgetList()
		</script>	
		<script>
			$(document).ready(function(){
				
				makeList();
				
			});	
			
		</script>
	</head>
	<body>
		<table id="table_list" width="500" cellpadding="0" cellspacing="0" border="1">
			
		</table>
	</body>
</html>