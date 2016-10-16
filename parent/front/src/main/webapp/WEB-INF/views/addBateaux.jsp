<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>boat Registration Form</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
<div class="container">
	<div class="page-header bg-info">
	<h2 class="text-center">Playing with Spring MVC and bootstrap</h2>	
	</div>
	
	<div class="well">
	<h2 class="text-center">Registration Form</h2>
	<form:form method="POST" modelAttribute="trefBateaux" cssClass="form-horizontal">
		<div class="form-group">
			<form:input type="hidden" path="bpIcd" id="bpIcd"/>
		</div>
		<div class="form-group">
			<label class ="control-label col-sm-offset-2 col-sm-2" for="bpDevise">Name: </label> 
			<div class="col-sm-4">
				<form:input cssClass="form-control" path="bpDevise" id="bpDevise"/>
			</div>
			<form:errors path="bpDevise" cssClass="error"/>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-offset-2 col-sm-2" for="bpBatelier">Person: </label>
			<div class="col-sm-4">
				<form:select cssClass="form-control" path="bpBatelier.peIcd" id="bpBatelier">
					<c:forEach items="${listePersons}" var="trefpersonne">
						<form:option selected="${trefBateau.bpBatelier.peIcd == trefpersonne.peIcd ? 'selected':''}" value="${trefpersonne.peIcd}">${trefpersonne.peIcd} - ${trefpersonne.peName}</form:option>
					</c:forEach>
				</form:select>
			</div>
			<form:errors path="bpBatelier" cssClass="error"/>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-10">
				<c:choose>
					<c:when test="${edit}">
						<input class="btn btn-warning btn-ns" type="submit" value="Update"/>
					</c:when>
					<c:otherwise>
						<input class="btn btn-warning btn-ns" type="submit" value="Register"/>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>
	<br/>
	<br/>
	<a class="btn btn-info btn-ns" href="<c:url value='/list' />">Back to the List of people</a>
	</div>
	</div>
</body>
</html>