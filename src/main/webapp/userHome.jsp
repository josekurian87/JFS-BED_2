<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>${title}</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css" />
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand"><b>Online Assessment System - ${title}</b></a>
			</div>
			<ul class="nav navbar-nav navbar-right">
		      <li><a href="${pageContext.request.contextPath}/logout/do"><b>Logout</b></a></li>
    		</ul>
		</div>
	</nav>
	<p>&nbsp;</p>

	<div class="container">
		<div class="panel panel-default">
			<div id="msg" class="panel-heading"><b id="msg">${title}</b></div>
			<div class="panel-body">
			<c:if test="${'SA' == loginResult}">
				<a href="${pageContext.request.contextPath}/users/all" class="btn btn-info" role="button">View list of all candidates</a>
				<a href="${pageContext.request.contextPath}/tests/all" class="btn btn-info" role="button">View list of all tests taken</a>
			</c:if>
			<c:if test="${'SC' == loginResult}">
				<a href="${pageContext.request.contextPath}/spring/do" class="btn btn-info" role="button">Spring Assessment</a>
				<a href="${pageContext.request.contextPath}/hibernate/do" class="btn btn-info" role="button">Hibernate Assessment</a>
			</c:if>
			<a href="${pageContext.request.contextPath}/logout/do" class="btn btn-info" role="button">Logout</a>
			</div>
		</div>
	</div>

</body>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</html>
