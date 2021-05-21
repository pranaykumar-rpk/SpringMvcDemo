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
	
	  <form action=./startMatch method="post">
        <table>
            <tr>
                <td colspan="2"><h3>Please Select 2 Teams for the Match</h3></td>
            </tr>
           
     <c:forEach var="team" items="${pointsTable}">
			<tr>    
    			<td>${team.getTeamName()}</td>
    			<td>${team.getShortName()}</td>
				<td><input type="checkbox" name="selected" value="${team.getShortName()}"></td>     	
    		</tr>
	</c:forEach>            
            <tr>
                <td colspan="3" align="center">
                        <input type="submit" value="Start" />
                </td>
            </tr>
        </table>
    </form>

	</div>
</div>
</body>
</html>