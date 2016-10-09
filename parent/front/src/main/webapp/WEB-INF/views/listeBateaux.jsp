<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List of boats</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>


<body>
<div class="container">
	<div class="page-header bg-info">
	<h2 class="text-center">Playing with Spring MVC and boostrap</h2>	
	</div>
	<div class="well">
		<h3 class="text-center">boats of ${personne.peName} ID[${personne.peIcd}]</h3>
		<table class="table table-striped table-bordered text-center">
			<thead class="bg-primary">
			<tr>
				<td>ID</td><td>Name</td><td><a class="btn btn-info btn-sm text-right" title="add boat" href="<c:url value='/bateaux/new/${personne.peIcd}' />"><span class="glyphicon glyphicon-plus-sign"></span></a></td>
			</tr>
			</thead>
			<c:forEach items="${listeBateaux}" var="trefBateaux" varStatus="loop">
				<tr>
					<td>${trefBateaux.bpIcd}</td>
					<td>${trefBateaux.bpDevise}</td>
					<td>
						<div class="btn-group">
							<a class="btn btn-warning btn-ns" title="modify" href="<c:url value='/bateaux/edit-${trefBateaux.bpIcd}-bateau' />"><span class="glyphicon glyphicon-pencil"></span></a>
							<a class="btn btn-warning btn-ns" title="delete" href="<c:url value='/bateaux/delete-${trefBateaux.bpIcd}-bateau' />"><span class="glyphicon glyphicon-remove"></span></a>
						</div>
					</td>
				</tr>				
			</c:forEach>
		</table>
			<a class="btn btn-info btn-sm" href="<c:url value='/list' />">Back to the List of people</a>
	</div>
		<c:if test="${success != null}">
		<div class="alert alert-success">
		  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		  <strong>Success!</strong> ${success}
		</div>
	</c:if>
</div>
<br/>
</body>
</html>