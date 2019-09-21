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
			<div class="panel-heading"><b>${title}</b></div>
			<div class="panel-body">

			<form class="form-horizontal" action="${pageContext.request.contextPath}/evaluate/${topic}/test"
				method="post">
				<ul class="list-group">
					<c:forEach items="${questionList}" var="question" varStatus="loop">
						<li class="list-group-item">
							<span id="question${loop.index+1}"><b><c:out value="${question.question}" /></b></span><br>
							<input type="radio" id="Q${loop.index+1}-Opt1" name="Question${loop.index+1}" value="${question.option1}">&nbsp;<span id="option1${loop.index+1}"><c:out value="${question.option1}" /></span><br>
							<input type="radio" id="Q${loop.index+1}-Opt2" name="Question${loop.index+1}" value="${question.option1}">&nbsp;<span id="option2${loop.index+1}"><c:out value="${question.option2}" /></span><br>
							<input type="radio" id="Q${loop.index+1}-Opt3" name="Question${loop.index+1}" value="${question.option1}">&nbsp;<span id="option3${loop.index+1}"><c:out value="${question.option3}" /></span><br>
							<input type="radio" id="Q${loop.index+1}-Opt4" name="Question${loop.index+1}" value="${question.option1}">&nbsp;<span id="option4${loop.index+1}"><c:out value="${question.option4}" /></span><br>
						</li>
					</c:forEach>
				</ul>
				<div class="form-group">
					<div class="col-sm-offset-5 col-sm-3">
						<input type="submit" id="submit${topic}" value="Submit Test"
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
