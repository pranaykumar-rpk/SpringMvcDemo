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

<form action="./register" method="Post">
		<br> <label>Team Name:</label> <input type="text" name="teamName" id="teamName" maxlength="45"><br>
		<br> <label>Short Name:</label> <input type="text" name="shortName" id="shortName" maxLength="4"><br>
		<br>
		Note: Short name must have max up to 4 characters
		<br>
		<br> <input type="submit" value="register">
	</form>


</div>


</body>
</html>
