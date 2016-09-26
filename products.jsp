<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<img src="resources/gro.jpg" class="img-thumbnail" style="width:120px;height:80px" align="left-center">
<h1 style="color:orange"><center>GROCERY BAZAR</center></h1>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
  <body>
<%@ include file="header.jsp" %>
<p><div class="container">
<ul class="list-inline">
<ul class="nav navbar-nav navbar-left">
<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="category.jsp"><h3 style="color:yellow">COOKIES&SNACKS</h3></a>
<ul class="dropdown-menu">
<li><a href="#">GRANOLA BARS</a></li>
<li><a href="#">DRIED FRUITS&VEGETABLES</a></li>
<li><a href="#">FRUIT SNACKS</a></li>
<li><a href="#">COOKIES</a></li>
<li><a href="#">NUTS&TRAIL MIXES</a></li>
</ul>
</li>
<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><h3 style="color:yellow">BREAKFAST&CEREAL</h3></a>
<ul class="dropdown-menu">
<li><a href="#">BREAKFAST BARS</a></li>
<li><a href="#">COLD CEREAL</a></li>
<li><a href="#">GRANOLA&MUESLI</a></li>
<li><a href="#">FROZEN BREAKFAST FOOD</a></li>
</ul>
</li>
<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><h3 style="color:yellow">CANDIES</h3></a>
<ul class="dropdown-menu">
<li><a href="#">GUMMY&CHEWY</a></li>
<li><a href="#">CHOCOLATE</a></li>
<li><a href="#">CANDY&LOLIPOPS</a></li>
<li><a href="#">MINTS</a></li>
<li><a href="#">GUM</a></li>
</ul>
</li>
<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><h3 style="color:yellow">ORGANIC FOODS</h3></a>
<ul class="dropdown-menu">
<li><a href="#">ALL ORGANIC FOODS</a></li>
</ul>
</li>
<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><h3 style="color:yellow">BEVERAGES</h3></a>
<ul class="dropdown-menu">
<li><a href="#">JUICE</a></li>
<li><a href="#">MILK&CREAM</a></li>
<li><a href="#">POWDERED DRINKS&MIXES</a></li>
<li><a href="#">COFFEE</a></li>
<li><a href="#">ENERGY BARS</a></li>
</ul>
</li>
</ul>
</ul>
</div></p>
 <div class="container-fluid">
  <div class="row">
  
  <div class="col-md-3 col-sm-4 col-xs-6">
    <div class="thumbnail_container">
      <div class="thumbnail">
          <img src="resources/img.jpg">
		  <h3>BEVERAGES</h3>
		  
      </div>
    </div>
</div>
<div class="col-md-3 col-sm-4 col-xs-6">
    <div class="thumbnail_container">
      <div class="thumbnail">
        <img src="resources/img1.jpg">
		<h3>GOURMET</h3>
		  
      </div>
    </div>  
</div>
<div class="col-md-3 col-sm-4 col-xs-6">
    <div class="thumbnail_container">
      <div class="thumbnail">
          <img src="resources/img3.jpg">
		  <h3>DAIRY</h3>
		  
      </div>
    </div>
</div>
<div class="col-md-3 col-sm-4 col-xs-6">
    <div class="thumbnail_container">
      <div class="thumbnail">
        <img src="resources/img4.jpg">
		<h3>Branded FOOD</h3>
      </div>
    </div>  
</div>
  <div class="col-md-3 col-sm-4 col-xs-6">
    <div class="thumbnail_container">
      <div class="thumbnail">
          <img src="resources/img5.jpg">
		  <h3>ORGANIC</h3>
		  
      </div>
    </div>
</div>
<div class="col-md-3 col-sm-4 col-xs-6">
    <div class="thumbnail_container">
      <div class="thumbnail">
        <img src="resources/img6.jpg">
		<h3>GROCERIES</h3>
		  </div>
    </div>  
</div>

</div>
</div>
<%@ include file="footer.jsp" %>
 </body>
 </html>
