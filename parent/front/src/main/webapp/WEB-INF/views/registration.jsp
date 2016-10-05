<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>TrefPersonne Registration Form</title>

<style>

	.error {
		color: #ff0000;
	}
</style>

</head>

<body>

	<h2>Registration Form</h2>
 
	<form:form method="POST" modelAttribute="trefPersonne">
		<form:input type="hidden" path="peIcd" id="peIcd"/>
		<table>
			<tr>
				<td><label for="peName">NAME: </label> </td>
				<td><form:input path="peName" id="peName"/></td>
				<td><form:errors path="peName" cssClass="error"/></td>
		    </tr>
			<tr>
				<td><label for="createTime">CREATE TIME: </label> </td>
				<td><form:input path="createTime" id="createTime"/></td>
				<td><form:errors path="createTime" cssClass="error"/></td>
		    </tr>
			<tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"/>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
	<br/>
	<br/>
	Go back to <a href="<c:url value='/list' />">List of all trefPersonnes</a>
</body>
</html>