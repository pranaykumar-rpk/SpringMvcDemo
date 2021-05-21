<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<style>
.content {
  max-width: 500px;
  margin: auto;
}

.mainHeading{
	 padding: 20px 20px 20px 70px;
	 background-color: grey;
  	 color: white; 
  	 font-family:sans-serif;
}

ul {
  list-style-type: none;
  dispaly: inline-block;
  margin: 0;
  padding: 0;
  width: 200px;
  background-color: #f1f1f1;
}

li a {
  display: block;
  color: #000;
  padding: 8px 16px;
  text-decoration: none;
}

/* Change the link color on hover */
li a:hover {
  background-color: #555;
  color: white;
}

</style>
<body>

<div class="content">
<h1 class="mainHeading">Indian Premier League</h1>

<h5>${teamName} team registered successfully</h5>

<!-- <input type="button"  onclick="location.href='./home.htm'" value="Home" > -->


</div>
</body>
</html>
