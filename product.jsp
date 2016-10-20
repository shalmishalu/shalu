<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.Random"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<%@ include file="/views/header.jsp" %>
<body>
<div class="container-fluid"
style="background-color:crimson; color: black; height: 80px;">
<center>
<h2>WELCOME ADMIN</h2>
</center>
</div>
<div class="container">
<h1>Add  Product</h1>
<c:url var="addAction" value="/addproduct"></c:url>
<form:form action="${addAction}" commandName="product"
			class="form-horizontal">
	<div class="form-group">
<form:label path="id" class="control-label col-sm-2">
<spring:message text="ID" />
</form:label>
<div class="col-sm-10">
		<%
		   Random r = new Random();
			int id = r.nextInt(999);
		%>
<c:choose>
<c:when test="${!empty product.id}">
<form:input path="id" disabled="true" readonly="true" />
</c:when>
<c:otherwise>
<td><form:input path="id" patttern=".{3,7}" required="true"
	title="id should contains 3 to 7 characters" />
</c:otherwise>
</c:choose>
<form:input path="id" hidden="true" value="<%=id%>" />
</div>
</div>
			<br>
			<div class="form-group">
				<form:label path="name" class="control-label col-sm-2">

					<spring:message text="Name" />

				</form:label>
				<div class="col-sm-10">
					<form:input path="name" required="true" class="form-control" />
				</div>
			</div>
			<br>
			<div class="form-group">
				<form:label path="price" class="control-label col-sm-2">

					<spring:message text="Price" />

				</form:label>
				<div class="col-sm-10">
					<form:input path="price" required="true" />
				</div>
			</div>
			<br>

			<div class="form-group">
				<form:label path="description" class="control-label col-sm-2">

					<spring:message text="Description" />

				</form:label>
				<div class="col-sm-10">
					<form:input path="description" required="true" />
				</div>
			</div>
			<br>
			<div class="form-group">
				<form:label path="supplier_id" class="control-label col-sm-2">

					<spring:message text="Supplier" />

				</form:label>
				<div class="col-sm-10">
					<%-- <td><form:input path="supplier.name" required="true" /></td> --%>

					<form:select path="supplier.name" items="${supplierList}"
						itemValue="name" itemLabel="name" />
				</div>
			</div>
			<br>
			<div class="form-group">
				<form:label path="category_id" class="control-label col-sm-2">

					<spring:message text="Category" />

				</form:label>
				<div class="col-sm-10">
					<%-- <td><form:input path="category.name" required="true" /></td> --%>

					<form:select path="category.name" items="${categoryList}"
						itemValue="name" itemLabel="name" />
				</div>
			</div>
			<br>
			<%-- <div class="form-group">
									<form:label path="image"  class="control-label col-sm-2">Image</form:label>   
									<div class="col-sm-10">    
							   <form:input type="file" path="image" />
							       
</div>
</div> --%>
			<br>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<c:if test="${!empty product.name}">

						<input type="submit" class="btn btn-success"
							value="<spring:message text="editproduct"/>" />

					</c:if>
					<c:if test="${empty product.name}">

						<input type="submit" class="btn btn-primary"
							value="<spring:message text="addproduct"/>" />

					</c:if>
				</div>
			</div>

		</form:form>

		<br>
		<h3>Product List</h3>
		<c:if test="${!empty productList}">
			<div class="table-responsive">
				<table class="table">
					<thead>
					<tr>
                 <th>Product ID</th>
                 <th>Product Name</th>
                 <th>Product Description</th>
                 <th>Price</th>
                 <th>Product Category</th>
                <th>Product Supplier</th>
                <!-- <th>Product Image</th> -->

							<th>Edit</th>

							<th>Delete</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${productList}" var="product">

							<tr><td>${product.id}</td>
								<td>${product.name}</td>
								<td>${product.description}</td>
								<td>${product.price}</td>
								<td>${product.category.name}</td>
								<td>${product.supplier.name}</td>
								<%-- <td>
								<img src="<c:url value="G:images /${product.id}.jpg"/>"></td> --%>

								<td><a href="<c:url value='editproduct/${product.id}' />">Edit</a></td>

								<td><a href="<c:url value='removeproduct/${product.id}' />">Delete</a></td>

							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>
		</div>
		</div>
		<%@ include file="/views/footer.jsp" %>
       </body>
        </html>