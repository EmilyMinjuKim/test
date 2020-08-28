<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Insert title here</title>
		<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
		<script>

   function getAjaxList(){
      
      var url="${pageContext.request.contextPath}/restful/after.json"; //ajax 날라감
      //var url="restful/after.json"  //에러남
      
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
               html : "<td>"+ "번호" +"</td>"+
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
                htmls += '<a href="${pageContent.request.contextPath}/content_view?bId=' + this.bId + '">' + this.bTitle + '</a>' +'</td>';
                htmls += '<td>' +this.bDate+'</td>';
                htmls += '<td>' +this.bHit +'</td>';
                htmls += '</tr>';
                
             });
             //여기에 붙여야 한다.
             htmls += '<tr>';
             htmls += '<td colspan="5"><a href= "${pageContent.request.contextPath}/write_view">'+ "글작성" + '</a></td>';
             htmls += '</tr>';
             $("#list-table").append(htmls);
          },
             
             
          error: function (request, status, error){     
             alert("실패");
             alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
          }
          
          
          
        });   
   }
</script>
		<script>
			$(function(){
				getAjaxList();
			})
		</script>	
		
	</head>
	<body>
		<table id="list-table" width="500" cellpadding="0" cellspacing="0" border="1">
			
		</table>
	</body>
</html>