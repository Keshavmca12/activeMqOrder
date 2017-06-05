<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Order Status</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

	<div class="generic-container">
		<div class="well lead">Product Order Status from session</div>
		<table class="table table-hover table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${orders}" var="entry">
					<tr>
						<td>${entry.key}</td>
						<td>${entry.value.productName}</td>
						<td>${entry.value.status}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<h2>Order from database</h2>

		<c:if test="${not empty ordersDB}">
				<c:forEach var="listValue" items="${ordersDB}">
					<c:forEach var="blist" items="${listValue}"  >
					${blist} aaaa
					 <%-- <tr>
						<td>${blist.productName}</td>
						<td>${blist.status}</td>
					</tr> --%>
   					</c:forEach>
				</c:forEach>
		</c:if>
		<span class="well floatRight"> <a
			href="<c:url value='/newOrder' />">Buy More</a>
		</span>
	</div>
</body>
</html>