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
			function gradeAjax(){
				$('form').submit(function(e){
					e.preventDefault();
					
					var gradeData={
						'kor': $('input[name=kor]').val(),
						'eng': $('input[name=eng]').val(),
						'math': $('input[name=math]').val()
					};
					
					
					$.ajax({
						url: $('form').attr('action'),
						type: 'POST',
						data: gradeData,
						success: function(data){
							var jsonObj = JSON.parse(data);
							$('body').html(""); //초기화 하고
							$('body').append(jsonObj);//데이터를 띄운다.
							
							
							$(data).each(function(){
								
							})
						},
						 error: function (data){
							 if(!$('#kor').val()){
								 alert("국어 점수를 입력하세요");
							 }else if(!$('#eng').val()){
								 alert("영어 점수를 입력하세요");
							 }else{
								 alert("수학 점수를 입력하세요");
							 }
						 }
					})
				})
			}
  	
		</script>
		<script>
			$(function(){
				gradeAjax();
			});
		</script>	
		
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/restful/gradeAjax.json">
			<lable for="kor">국어</lable>
			<input type="text" id="kor" name="kor" /><br>
			<lable for="eng">영어</lable>
			<input type="text" id="eng" name="eng" /><br>
			<lable for="math">수학</lable>
			<input type="text" id="math" name="math" /><br>
			<input id="sbmBtn" type="submit" value="SUBMIT">
			<input id="resBtn" type="reset" value="RESET">
		</form>
	</body>
</html>