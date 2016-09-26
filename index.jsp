<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Food Grocery</title>
<img src="resources/gro.jpg" class="img-thumbnail" style="width:120px;height:80px" align="left">
<h1 style="color:orange"><center>GROCERY BAZAR</center></h1>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.carousel-inner > .item > img,
.carousel-inner > .item > a > img{
   width:92%;
   margin:a;
}
</style>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
<ol class="carousel-indicators">
<li data-target="#mycarousel" data-slide-to="0" class="active"></li>
<li data-target="#mycaurosel" data-sliide-to="1"></li>
<li data-target="#mycaurosel" data-slide-to="2"></li>
<li data-target="#mycaurosel" data-slide-to="3"></li>
<li data-target="#mycaurosel" data-slide-to="4"></li>
<li data-target="#mycaurosel" data-slide-to="5"></li>
</ol>
<div class="carousel-inner" role="listbox">
<div class="item active">
<img src="resources/choco.jpg" alt="choco" width="500" height="460"/>
</div>
<div class="item">
<img src="resources/kopiko.jpg"alt="kopiko" width="500" height="460"/>
</div>
<div class="item">
<img src="resources/anjir.jpg"alt="anjir" width="500" height="460"/>
</div>
<div class="item">
<img src="resources/ba.jpg"alt="ba" width="50O" height="460"/>
</div>
<div class="item">
<img src="resources/juic.jpg"alt="juic"width="500" height="460"/>
</div>
<div class="item">
<img src="resources/swee.jpeg"alt="swee"width="500"height="460"/>
</div>
<div class="item">
<img src="resources/org.jpeg"alt="org"width="500"height="460"/>
</div>
<div class="item">
<img src="resources/break.jpeg"alt="break"width="500"height="460"/>
</div>
</div>
</div>
<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
     <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>

