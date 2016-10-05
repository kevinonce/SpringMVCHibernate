<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List of TrefPersonne</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of TrefPersonne</h2>	
	<table>
		<tr>
			<td>ID</td><td>CREATE TIME</td><td>NAME</td><td>EDIT</td><td>DELETE</td>
		</tr>
		<c:forEach items="${trefPersonnes}" var="trefpersonne">
			<tr>
			<td>${trefpersonne.peIcd}</td>
			<td>${trefpersonne.createTime}</td>
			<td>${trefpersonne.peName}</td>
			<td><a href="<c:url value='/edit-${trefpersonne.peIcd}-trefPersonne' />">${trefpersonne.peIcd}</a></td>
			<td><a href="<c:url value='/delete-${trefpersonne.peIcd}-trefPersonne' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/new' />">Add New TrefPersonne</a>
</body>
</html>