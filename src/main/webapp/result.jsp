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
		</div>
	</nav>
	<p>&nbsp;</p>

	<div class="container">
		<c:if test="${'' != loginResult}">
			<c:if test="${'I' == loginResult}">
				<div id="msg" class="alert alert-danger">
					<strong>${message}</strong>
				</div>
				<a href="${pageContext.request.contextPath}/" class="btn btn-info" role="button">Home Page</a>
			</c:if>
			<c:if test="${'F' == loginResult}">
				<div id="msg" class="alert alert-danger">
					<strong>${message}</strong>
				</div>
				<a href="${pageContext.request.contextPath}/" class="btn btn-info" role="button">login again</a>
			</c:if>
		</c:if>
		<c:if test="${'' != registrationResult}">
			<c:if test="${'D' == registrationResult}">
				<div id="msg" class="alert alert-danger">
					<strong>${message}</strong>
				</div>
				<a href="${pageContext.request.contextPath}/register/do" class="btn btn-info" role="button">Register Again</a>
			</c:if>
			<c:if test="${'S' == registrationResult}">
				<div id="msg" class="alert alert-success">
					<strong>${message}</strong>
					<p>&nbsp;</p>
					<strong>${message2}</strong>
				</div>
				<a href="${pageContext.request.contextPath}" class="btn btn-info" role="button">LOGIN</a>
			</c:if>
		</c:if>
		<c:if test="${'' != assessmentResult}">
			<c:if test="${'F' == assessmentResult}">
				<div id="msg" class="alert alert-danger">
					<strong>${message}</strong>
				</div>
				<a href="${pageContext.request.contextPath}/" class="btn btn-info" role="button">Exit</a>
			</c:if>
			<c:if test="${'P' == assessmentResult}">
				<div id="msg" class="alert alert-success">
					<strong>${message}</strong>
					<strong>${userData.firstName}${userData.lastName}&nbsp;${userData.email}</strong>
				</div>
				<a href="${pageContext.request.contextPath}/" class="btn btn-info" role="button">Exit</a>
			</c:if>
		</c:if>
		<c:if test="${'' != sessionResult}">
			<c:if test="${'E' == sessionResult}">
				<div id="msg" class="alert alert-danger">
					<strong>${message}</strong>
				</div>
			</c:if>
		</c:if>
	</div>
</body>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</html>
