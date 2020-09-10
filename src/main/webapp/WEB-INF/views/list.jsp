<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>AjaxList</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>

	   function getAjaxList(){
	      
	      var url="${pageContext.request.contextPath}/restful/list.json"; //ajax 날라감
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
	             
	             $("<thead>",{
	               html : "<tr>"+
		            	   	 	"<th>"+"선택"+</th>"
			                   "<th>"+"종목명"+"</th>"
			                   "<th>"+"세후보유기간이자"+"</th>"
			                   "<th>"+"증권사"+"</th>"
			                   "<th>"+"매수금액"+"</th>"
			                   "<th>"+"매수일자"+"</th>"
			                   "<th>"+"발행이자율"+"</th>" 
			                   "<th>"+"할인발행율"+"</th>"
			                   "<th>"+"총상환금액"+"</th>"
			                   "<th>"+"만기일"+"</th>"
			                   "<th>"+"신용등급"+"</th>"+
		                 "</tr>"
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
	<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
        <thead>
          <tr>
         	<th>선택</th>
            <th>종목명</th>
            <th>세후보유기간이자</th>
            <th>증권사</th>
            <th>매수금액</th>
            <th>매수일자</th>
            <th>발행이자율</th> 
            <th>할인발행율</th>
            <th>총상환금액</th>
            <th>만기일</th>
            <th>신용등급</th>
          </tr>
        </thead>
    
        <tbody id="bond_tbody">
        <c:forEach var = "dto" items= "${list}">
          <tr>
          <td><input type="checkbox" name="checkbox" ></td>
            <td>${dto.bond_symbols}</td>
            <td>${dto.total_interest}</td>
            <td>${dto.bond_company}</td>
            <td>${dto.bond_price}</td>
            <td>${dto.bond_date}</td>
            <td>${dto.coupon_interest_rate}</td>
            <td>${dto.discount_rate}</td>
            <td>${dto.gross_price}</td>
            <td>${dto.maturity_date}</td>
            <td>${dto.grade}</td>
          </tr>
          </c:forEach>

        </tbody>
      </table>
</body>
</html>