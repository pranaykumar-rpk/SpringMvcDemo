package services;

import java.util.List;

import models.Team;

public interface ServiceFunctionalities {

	public void addTeam(String teamName,String shortName);
	
	public List<Team> getPointsTable();
	
	public void updateTable(String teamShortName, Team team);

	public void deleteTeam(String parameter);
		
}
