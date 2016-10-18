<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Category Page</title>

</head>
<body>
	<h3>Add a Category</h3>

	<c:url var="addAction" value="/category/add"></c:url>

	<form:form action="${addAction}" commandName="category">
	<h>${message}</h>
		<table>
			<tr>
				<td>Category Id</td>
				<td><input type="text" name="id"/></td>
				</tr>
				<tr>
				<td>Category Name</td>
				<td><input type="text" name="name"/></td>
				</tr>
				<tr>
				<td>Category Description</td>
				<td><input type="text" name="description"/></td>
				</tr>
				
			<tr>
<td><input type="submit" value="Add Category"></td>
</tr>	
				
		</table>
	</form:form>
	
	<table>
			<tr>
				<th width="80">Category ID</th>
				<th width="120">Category Name</th>
				<th width="120">Category Description</th>
				
			</tr>
			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td>${category.id}</td>
					<td>${category.name}</td>
					<td>${category.description}</td>
					<td><a href="<c:url value='category/edit/${category.id}' />">Edit</a></td>
					<td><a href="<c:url value='category/remove/${category.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>

</body>
</html>