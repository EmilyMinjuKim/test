<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Content view</title>


</head>
<body>
	<table id="list-table" style="margin-left: auto; margin-right: auto;" width="500" border="1">
		<form action="modify" method="post">
			<input type="hidden" name="bId" value="${content_view.bId}">
			<tr>
				<td>번호</td>
				<td>${content_view.bId}</td>
			</tr>
			<tr>
				<td>히트</td>
				<td>${content_view.bHit}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="bName"
					value="${content_view.bName}"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle"
					value="${content_view.bTitle}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" name="bContent">${content_view.bContent}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정">
					&nbsp;&nbsp; <a href="list">목록보기</a> &nbsp;&nbsp;
					<a id="a-delete" href="${pageContext.request.contextPath}/rest/delete?bId=${content_view.bId}">삭제</a>
					&nbsp;&nbsp; <a href="reply_view?bId=${content_view.bId}">답변</a></td>
				</td>
			</tr>
		</form>
	</table>
	
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<!-- 이걸 넣는 이유? 넣으면 어떤 현상이 일어나는지 -->
<!--
		-->
<script>
function getAjaxList(){
    
    var url="${pageContext.request.contextPath}/restful/after.json"; //ajax 날라감
		$.ajax({
	          url: url,
	          type: 'GET',
	          cache: false, //이걸 안쓰거나 true쓰면 수정해도 값 반영이 잘 안될때가 있음
	          dataType: "json",   //통신해서 response로 받을 언어
	         //data: '',         //내가 서버쪽으로 넘겨줄 데이터
	          success: function(result){
	             console.log(result);
	             
	             var htmls ="";
	             $("#list-table").html("");
	             
	             $("<tr>",{
	               html :    "<td>"+ "번호" +"</td>"+
	                     "<td>"+ "이름" +"</td>"+
	                     "<td>"+ "제목" +"</td>"+
	                     "<td>"+ "날짜" +"</td>"+
	                     "<td>"+ "히트" +"</td>"
	               }).appendTo("#list-table");
	             
	             $(result).each(function(){//foreach문
	                
	                htmls += '<tr>';
	                htmls += '<td>'+this.bId+'</td>';
	                htmls +='<td>'+this.bName+'</td>';
	                htmls += '<td>'
	                	for(var i=0; i < this.bIndent; i++){
	                		htmls += '-'
	                	}
	                htmls += '<a href="${pageContext.request.contextPath}/content_view?bId=' + this.bId + '">' + this.bTitle + '</a></td>';
	                htmls += '<td>' +this.bDate+'</td>';
	                htmls += '<td>' +this.bHit +'</td>';
	                htmls += '</tr>';
	                
	             });
	             //여기에 붙여야 한다.
	             htmls += '<tr>';
	             htmls += '<td colspan="5"><a href= "${pageContent.request.contextPath}/write_view">'+ "글작성" + '</a></td>';
	             htmls += '</tr>';
	             $('#list-table').append(htmls);
	          },
	             
	             
	          error: function (request, status, error){     
	             alert("실패");
	             alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	          }
	          
	          
	          
	        });   
	   
}
</script>
<script>
			
		</script>

<script>
			$(document).ready(function(){//왜 이렇게 해야하는 건지 반드시 숙지해야함
				$("#a-delete").click(function(event){
					event.preventDefault(); // link로써 기존 기능(클릭) 없애겠다는 의미
					console.log("ajax 호출전")
					
					 $.ajax({
			             type : "DELETE",
			             url : "${pageContext.request.contextPath}/rest/delete/" + "${content_view.bId}",
			             //요즘엔 이런식으로 uri에 명령어를 써
			             ///delete/ 사실은 타입을 url에 대놓고 쓰면 안됨
			             //자바스크립트 안에 el은 그대로 먹혀
			             data:{"bId":"${content_view.bId}"},
			             success: function (result) {       
			                    console.log(result); 
			                    getAjaxList();               
			             },
			             error: function (e) {
			                 console.log(e);
			             }
			         })
			          
			      });
			});
</script>
	
</body>
</html>