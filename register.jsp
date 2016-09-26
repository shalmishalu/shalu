 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WELCOME TO SHOPBUZ</title>
<img src="resources/gro.jpg" class="img-thumbnail" style="width:180px;height:120px" align="left-center">
<h1 style="color:orange"><center>GROCERY BAZAR</center></h1>

<script type="text/javascript">
function validation()
{               var check_email = /^[\w\.]+@[a-zA-Z_]+?\.[a-zA-Z\.]{2,6}$/;
                var check_username = /^[a-zA-Z0-9_]{5}$/;
                var check_name = /^[a-zA-Z]{3,16}$/;
                var check_phone = /^[0-9]{10}$/;
if(document.myform.firstname.value=="")
{
alert("please enter firstname");
document.myform.firstname.focus();
return false;
}
else if(check_name.test(document.myform.firstname.value) == false)
 {
 alert('Invalid  firstname');
 document.myform.firstname.focus();
 return false;
 }
 if(document.myform.lastname.value=="")
 {
 alert("please enter lastname");
document.myform.lastname.focus();
 return false;
}
else if(check_name.test(document.myform.lastname.value) == false)
{
alert('Invalid  lastname');
document.myform.lastname.focus();
return false;
}
if(document.myform.username.value=="")
{
alert("please enter username");
document.myform.username.focus();
return false;
}
else if(check_username.test(document.myform.username.value) == false)
{
alert('Invalid  username');
document.myform.username.focus();
return false;
}
if(document.myform.email.value=="")
{
alert("please enter email");
document.myform.email.focus();
return false;
}
else if(check_email.test(document.myform.email.value) == false)
{
alert('Invalid  email');
document.myform.email.focus();
return false;
}
if(document.myform.password.value=='')
{
alert("Please enter Password.");
document.myform.password.focus();
return false;
}

if(document.myform.passconf.value=='')
{
alert("Please confirm Password.");
document.myform.passconf.focus();
return false;
}
else if(document.myform.password.value!=document.myform.passconf.value)
{
alert("Password does not match.");
document.myform.password.focus();
return false;
}


if(document.myform.phone.value=="")
{
alert("please enter phone");
document.myform.phone.focus();
return false;
}
else if(check_phone.test(document.myform.phone.value) == false)
{
alert('Invalid  phone');
document.myform.phone.focus();
return false;
}
}


</script>
</head>

<body>

<%@ include file="header.jsp" %>

<form name="myform" action="success.jsp" onSubmit="return validation()" method="post">

<center>
<font size=5 style="color:red"><b>Registration Form</b></font>
<table cellspacing="25" cellpadding="2" width="30%" style="color:blue" align="center" >
<tr>
<td>FIRST NAME</td>
<td><input type="text" name="firstname"  value=""size="25" /></td>
</tr>
<tr>
<td >LAST NAME</td>
<td><input type="text" name="lastname"  value=""size="25" /></td>
</tr>
<tr>
<td>USERNAME</td>
<td><input type="text" name="username" value="" size="25" /></td>
</tr>
<tr>
<td>EMAIL</td>
<td><input type="text" name="email"  value="" size="25" /></td>
</tr>
<tr>
<td>PASSWORD</td>
<td><input type="password" name="password"  value="" size="25" /></td>
</tr>

<tr>
<td>CONFIRM PASS</td>
<td><input type="password" name="passconf"  value="" size="25" /></td>
</tr>
<tr>
<td>CONTACT</td>
<td><input type="text" name="contact"  size="25" /></td>
</tr></center>
</table>
<center><p><input type="submit" value="Submit" /></p></center>
</form>
<%@ include file="footer.jsp" %>
</body>
</html>

