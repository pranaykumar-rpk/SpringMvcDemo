<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<style>

.content {
  max-width: 505px;
  margin: auto;
}


.mainHeading{
	 padding: 20px 20px 20px 70px;
	 background-color: grey;
  	 color: white; 
  	 text-align: center;
  	 font-family:sans-serif;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

td{
 padding: 5px;
}


th {
  background-color: orange;
  color: white;
  padding: 15px;
  text-align: left;
}

</style>

<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>IPL - PointsTable </title>
</head>
<body>

<div class="content">
<h1 class="mainHeading">Indian Premier League</h1> 
<br> <br>

<div align="center">
<table border="1">

<c:forEach var="team" items="${pointsTable}">

<form action="./deleteATeam" method="post">
<tr>
    <td><input type="hidden" name="selectedTeam" value="${team.getTeamName()}" />${team.getShortName()}</td>
    <td>${team.getTeamName()}</td>
    <td> <input type="submit" name="delete" value="Delete"/></td>
</tr>
</form>


	
</c:forEach>
</table>
</div>
</div>
</body>
</html>