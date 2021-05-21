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



<ul>
  <li><a href="#" onclick="location.href='./showPointsTable.htm'">Points Table</a></li>
  <li><a href="#" onclick="location.href='./showAddTeam.htm'">Add Team</a></li>
  <li><a href="#" onclick="location.href='./showDeletePage.htm'">Delete Team</a></li>
  <li><a href="#" onclick="location.href='./showMatchDetails.htm'">Add Match</a></li>
</ul>

</div>

</body>
</html>
