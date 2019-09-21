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
    <div class="panel panel-default">
      <div class="panel-heading"><b>Registration</b></div>
      <div class="panel-body">
	<form class="form-horizontal" action="${pageContext.request.contextPath}/registration/do"
		method="post">
		<div class="form-group">
			<label class="control-label col-sm-5" for="firstName">First Name:</label>
			<div class="col-sm-3">
				<input type="text" name="firstName" id="firstName" class="form-control"
					pattern="[A-Za-z]{1,}" maxlength="40" required="required"></input>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-5" for="lastName">Last Name:</label>
			<div class="col-sm-3">
				<input type="text" name="lastName" id="lastName"
					class="form-control" pattern="[A-Za-z]{1,}" maxlength="40" required="required"></input>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-5" for="email">Email ID:</label>
			<div class="col-sm-3">
				<input type="email" name="email" id="email" class="form-control"
					maxlength="40" required="required"></input>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-5" for="password">Password:</label>
			<div class="col-sm-3">
				<input type="password" name="password" id="password"
					class="form-control" pattern=".{8,}" maxlength="40" required="required"></input>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-5 col-sm-3">
				<input type="submit" id="register" value="Submit"
					class="btn btn-primary">
			</div>
		</div>
	</form>
	</div>
	</div>
	</div>
</body>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</html>
