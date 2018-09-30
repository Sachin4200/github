<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
<div>
<h1 align="center"> Add Category</h1><hr>																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																	
<spring:form action="${pageContext.request.contextPath}/addCategory" modelAttribute="cat" method="POST">
<c:if test="${not empty cat.categoryName}">
CategoryId<spring:input type="text" path="categoryId" readonly="true" disabled="true"/>
<spring:hidden path="categoryId"/>
</c:if>
Category Name<spring:input type="text" path="categoryName"/>
Category Description<spring:input type="text" path="categoryDescription"/><br>
<c:if test="${empty cat.categoryName}"><input type="submit" value="add"/></c:if>
<c:if test="${not empty cat.categoryName}"><input type="submit" value="update"/></c:if>
</spring:form>
</div>

<c:if test="${not empty catgeoryList}">

<table border="1">
<thead>
<tr><td>categoryId</td>
<td>categoryName</td>
<td>categoryDescription</td>
<td>edit</td>
<td>delete</td>
</tr>
</thead>
<c:forEach items="${catgeoryList}" var="cate">
<tbody>
<tr>
<td>${cate.categoryId}</td>
<td>${cate.categoryName}</td>
<td>${cate.categoryDescription}</td>

<td><a href="editCategory/${cate.categoryId }">Edit</a></td>

<td><a href="deleteCategory/${cate.categoryId}">Delete</a></td>
</tr>
</tbody>
</c:forEach>
</table>
</c:if>
</body>
</html>	