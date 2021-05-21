package services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.DaoFunctionalities;
import models.Team;


public class ServiceFunctionalitiesImpl implements ServiceFunctionalities{
	
	@Autowired
	DaoFunctionalities daoFunctionalities;

	@Override
	public void addTeam(String teamName,String shortName) {
		daoFunctionalities.addTeam(teamName,shortName);
	}

	@Override
	public List<Team> getPointsTable() {
		List<Team> list = daoFunctionalities.getPointsTable();
		Collections.sort(list);
		return list;
	}

	@Override
	public void updateTable(String teamShortName, Team team) {
		 daoFunctionalities.updatePointsTable(teamShortName,team);
	}

	@Override
	public void deleteTeam(String teamName) {
			daoFunctionalities.deleteTeam(teamName);
	}

}
