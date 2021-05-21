<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<form  modelAttribute="match" action="./updateTable" method="Post">
	<input type='hidden' id='teamAName' name='teamAName' value='${selectedTeams[0]}'/>
	<input type='hidden' id='teamBName' name='teamBName' value='${selectedTeams[1]}'/>
	<h1>${selectedTeams[0]}</h1>
		<br> <label>Runs   :</label> <input type="number" name="scoreOfTeamA" id="scoreOfTeamA" maxlength="3" ><br>
		<br> <label>Wickets:</label> <input type="number" name="wicketsOfTeamA" id="wicketsOfTeamA" maxLength="2"><br>
		<br> <label>Overs   :</label> <input type="number" step="any" name="oversOfTeamA" id="oversOfTeamA" maxlength="3"><br>
			
	<h1>${selectedTeams[1]}</h1>
		<br> <label>Runs   :</label> <input type="number" name="scoreOfTeamB" id="scoreOfTeamB" maxlength="3"><br>
		<br> <label>Wickets:</label> <input type="number" name="wicketsOfTeamB" id="wicketsOfTeamB" maxLength="2" ><br>
		<br> <label>Overs   :</label> <input type="number" step="any" name="oversOfTeamB" id="oversOfTeamB" maxlength="3"><br>	
		
		<br> <input type="submit" value="Update">
	</form>
</div>
</body>
</html>