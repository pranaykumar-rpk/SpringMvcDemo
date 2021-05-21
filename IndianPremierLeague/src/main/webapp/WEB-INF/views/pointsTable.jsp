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
<title>IPL - PointsTable </title>
</head>
<body>

<div class="content">
<h1 class="mainHeading">Indian Premier League</h1> 
<br> <br>

<div align="center">
<table border="1">
<tr>
	<th>Team</th>
	<th>M</th>
	<th>W</th>
	<th>L</th>
	<th>T</th>
	<th>NRR</th>
	<th>P</th>
</tr>
<c:forEach var="team" items="${pointsTable}">
	<tr>    
    	<td>${team.getTeamName()}</td>
    	<td style="text-align: center">${team.getMatchesPlayed()}</td>
    	<td style="text-align: center">${team.getMatchesWon()}</td>
    	<td style="text-align: center">${team.getMatchesLost()}</td>
    	<td style="text-align: center">${team.getMatchesTied()}</td>
    	<td style="text-align: center">${team.getNetRunRate()}</td>
    	<td style="text-align: center">${team.getPointsScored()}</td>
    </tr>
</c:forEach>
</table>
<br>
*Note: M:Matches Played, W:Wins, L:Losses, T:Ties, NRR:Net Run Rate, P:Points

<br> <br>

<!-- <input type="button"  onclick="location.href='./home.htm'" value="Home" > -->

</div>
</div>
</body>
</html>