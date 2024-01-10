<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	.box{
		margin-left:30%;
	}
	table, th, td {
  		border: 1px solid black;
  		border-collapse: collapse;
  		cellspacing=10
	}
	th, td {
  		padding-top: 10px;
  		padding-bottom: 20px;
  		padding-left: 30px;
  		padding-right: 40px;
	}
</style>
</head>
<body>
<div class="box">
<table border="2 solid black"  >
	<thead>
		<th> Id </th> <th> Name </th> <th> Mobile </th> <th>actions</th>
	</thead>
	<tbody>
    <c:forEach var="emp" items="${elist}">
      <tr>
		<td>${emp.eid}</td> 
		<td>${emp.ename}</td>
		<td>${emp.ejob}</td>
		<td>
			<a href="deleteemp?eid=${emp.eid}">delete</a>/
			<a href="editemp?eid=${emp.eid}">edit</a>
		</td>
  	</tr>
  	</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>