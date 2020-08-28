<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>


<html>
	<head>
		<meta charset="utf-8">
		<title>area</title>
	</head>
	<body>
		가로: <input type="text" size="5" id="width">
		세로: <input type="text" size="5" id="height">
		<input type="submit" value="입력"><br>
		결과: <span id="result"></span>
		
		<script>
		document.querySelector('input').addEventListener('click', function(event){
			var xhr = new XMLHttpRequest();
			xhr.open('POST', './result.php');
			xhr.onreadystatechange = function(){
				document.querySelector('#result').innerHTML = xhr.responseText;
			}
			var data = '';
			data += 'width=' + document.getElementById('width');
			data += '&height=' + document.getElementById('height');
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			xhr.send(data);
		});
		</script>
			
	</body>
</html>