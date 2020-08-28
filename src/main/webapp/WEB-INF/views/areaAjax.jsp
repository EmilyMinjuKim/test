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
   	function areaAjax(){
	     $('form').submit(function(event){//form에서 작성해서 보낸 데이터를 event가 갖다줘 Model model이랑 비슷
	    	 
		    	event.preventDefault();
		     
		     	var formData= {
			    	'width' : $('input[name=width]').val(),// $('#width').val() 이거랑 같은 의미
			    	'height' : $('input[name=height]').val()
		     	};
		    	 
		   	   $.ajax({
		          url: $('form').attr('action'),//동적으로 가져오는것
		          type: 'POST',
		          data : formData,
		          	/* {data에는 이런식으로 객체가 직접적으로 들어갈 수도 있어
		          		'width' : $('input[name=width]').val(),// $('#width').val() 이거랑 같은 의미
		          		'height' : $('input[name=height]').val()
		           		}; */
		          cache: false, //이걸 안쓰거나 true쓰면 수정해도 값 반영이 잘 안될때가 있음
		          dataType: "json",   //통신해서 response로 받을 언어
		         //data: '',         //내가 서버쪽으로 넘겨줄 데이터
		          success: function(data){
		             var jsonObj = JSON.parse(data);
		             
		             $('body').html("");
		             $('body').append(jsonObj);
		          },  
		             error: function (xhr, status){     
		             alert(xhr + " : " + status);
		          }
	          
	        });  
	 };
	</script>
	
	<script>
	$(function(){
		areaAjax();
	});
	</script>	
	
</head>
<body>
	<form action="${pageContext.request.contextPath}/restful/recAjax.json">
		<lable for="width">가로</lable>
		<input type="text" id="width" name="width" /><br>
		<lable for="height">세로</lable>
		<input type="text" id="height" name="height" /><br>
		<input id="sbmBtn" type="submit" value="SUBMIT">
		<input id="resBtn" type="reset" value="RESET">
	</form>
</body>
</html>