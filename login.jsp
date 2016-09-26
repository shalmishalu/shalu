<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Shopbuzz</title>
<img src="resources/gro.jpg" class="img-thumbnail" style="width:120px;height:80px" align="left-center">
<h1 style="color:orange"><center>GROCERY BAZAR</center></h1>
<script type="text/javascript">
function submitFunction()
{
var username=document.getElementById("username").value;
var password=document.getElementById("password").value;
if((username==null || username=="") || (password==null || password==""))
{
alert("username or password can't be empty");
}
else
{
	if(username=="abcdef")
	{
		if(password=="123456")
		{
	    window.open("products.jsp");
		}
		else
		{
		alert("Password doesn't match");
		return false;
		}
	}
	else
	{
	alert("username doesn't exists");
	return false;
	}
}
}
</script>
</head>
<body>
<%@ include file="header.jsp" %>
<center><h1 style="color:red">LOGIN</h1></center>
<form name="login" onSubmit="submitFunction()" method="post" id="form_id">
   <table cellpadding="2" cellspacing="25" style="color:blue" width="30%" align="center">
  <tr>
<td style="color:blue">USERNAME &nbsp;<input type="text" name="username" id ="username"/>
</td>
</tr>
<tr>
<td style="color:blue">PASSWORD &nbsp;<input type="password" name="pwd" id ="password"/>
</td>
</tr>
</table>
<<center><input type="submit" value="Login" id ="submit" ></center>
</form>
<%@ include file="footer.jsp" %>
</body>
</html>