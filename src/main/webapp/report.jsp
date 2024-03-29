<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>
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

				<c:if test="${'UR' == reportType}">
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Email ID</th>
								<th>User Type</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${userList}" var="user" varStatus="loop">
								<tr>
									<td><span id="firstName${loop.index+1}"><c:out value="${user.firstName}" /></span></td>
									<td><span id="lastName${loop.index+1}"><c:out value="${user.lastName}" /></span></td>
									<td><span id="email${loop.index+1}"><c:out value="${user.email}" /></span></td>
									<td>
										<span id="userType${loop.index+1}">
										<c:if test="${'A' == user.type}">Admin</c:if>
										<c:if test="${'C' == user.type}">Candidate</c:if>
										</span>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
				<c:if test="${'TR' == reportType}">
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>Test Date</th>
								<th>Assessment</th>
								<th>Test Marks</th>
								<th>Email ID</th>
								<th>Total Marks</th>
								<th>Result</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${testResultList}" var="testResult" varStatus="loop">
								<tr>
									<td><span id="testDate${loop.index+1}"><fmt:formatDate pattern = "dd-MM-yyyy HH:mm:ss"  value="${testResult.testDate}" /><%-- <c:out value="${testResult.testDate}" /> --%></span></td>
									<td><span id="assessment${loop.index+1}"><c:out value="${testResult.topic}" /></span></td>
									<td><span id="marks${loop.index+1}"><c:out value="${testResult.score}" /></span></td>
									<td><span id="email${loop.index+1}"><c:out value="${testResult.email}" /></span></td>
									<td><span id="totalMarks${loop.index+1}">50</span></td>
									<td>
										<span id="result${loop.index+1}">
										<c:if test="${testResult.score >= 30}">Passed</c:if>
										<c:if test="${testResult.score <  30}">Failed</c:if>
										</span>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>

			</div>
		</div>
	</div>

</body>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</html>
