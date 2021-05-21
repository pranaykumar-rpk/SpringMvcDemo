package dao;

import java.util.List;

import models.Team;

public interface DaoFunctionalities {

	public void addTeam(String teamName,String shortName);
	
	public List<Team> getPointsTable();

	public void updatePointsTable(String teamShortName, Team team);

	public void deleteTeam(String teamName);
	
}
