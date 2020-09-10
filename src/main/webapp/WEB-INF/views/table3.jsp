<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>last demo</title>
  <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>

<div>
<table style="border: 1px;" id="dynamicTable">
<thead>
<tr>
<th>이름</th>
<th>직업</th>
<th>나이</th>
<th>취미</th>
</tr>
</thead>
<tbody id="dynamicTbody">
	
</tbody>
</table>
</div>
<div>
<input type="text" placeholder="이름" id="inName">
<input type="text" placeholder="직업" id="inJob"> 
<input type="text" placeholder="나이" id="inAge">
<input type="text" placeholder="취미" id="inHobby">
<button onclick="tableCreate()">table_append</button>
</div>
 
<script>
function tableCreate(){
	var tc = new Array();
	var html = '';
				
	var name = $("#inName").val();
	var job = $("#inJob").val();
	var age = $("#inAge").val();
	var hobby = $("#inHobby").val();
				
	html += '<tr>';
	html += '<td>'+name+'</td>';
	html += '<td>'+job+'</td>';
	html += '<td>'+age+'</td>';
	html += '<td>'+hobby+'</td>';
	html += '</tr>';
				
	$("#dynamicTable").append(html);
				
	$("#inName").val('');
	$("#inJob").val('');
	$("#inAge").val('');
	$("#inHobby").val('');
	}
</script>
 
</body>
</html>
