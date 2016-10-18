<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>


	
		<form:form method="post" action="Success" commandName="userDetails">
		<center>
			<font size=5><b>Registration Form</b></font>
		</center>
		<table cellspacing="25" cellpadding="2" width="45%" bgcolor="PINK"
			align="center">

			<tr>
				<td><form:label path="name">
						<spring-message text="name" />
					</form:label>  Name:<td>
				
				<td><form:input path="name" required="true" title="field should not be empty" /></td>
			</tr>

           

			<tr>
				<td><form:label path="username">
						<spring-message text="username" />
					</form:label> User Name:<td>
				
				<td><form:input path="username" required="true" title="field should not be empty" /></td>
			</tr>
			

			<tr>
				<td><form:label path="password">
						<spring-message text="password" />
					</form:label> Password:<td>
				
				<td><form:input path="password" required="true" title="field should not be empty" /></td>
			</tr>
			
                  <tr>
				<td><form:label path="email">
						<spring-message text="email" />
					</form:label> E-mailId:<td>
				
				<td><form:input type="email"  path="email" required="true" 
				title="field shold not be empty" /></td>
			</tr>

			

			<tr>
				<td><form:label path="phone">
						<spring-message text="phone" />
					</form:label> MobileNumber:<td>
				
				<td><form:input type="tel" path="phone" required="true" title="field shold not be empty" /></td>
			</tr>
			
			<tr>
				<td><form:label path="address">
						<spring-message text="address" />
					</form:label> Address:<td>
				
				<td><form:input path="address" required="true" title="field shold not be empty" /></td>
			</tr>
			
			
			<tr>
			<td></td>
			<centre>
				<td><input type="submit" value="Register" ></td>
				</centre>
				</tr>
				
		</table>
	</form:form>
	
</body>
</html>