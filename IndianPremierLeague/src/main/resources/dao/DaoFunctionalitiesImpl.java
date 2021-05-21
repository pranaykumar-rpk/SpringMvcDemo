package dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import models.Team;


public class DaoFunctionalitiesImpl implements DaoFunctionalities {
	
	@Autowired
	DataSource datasource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;


	@Override
	public void addTeam(String teamName,String shortName) {
		System.out.println("Upating new Team in Database");
		String sql="insert into pointstable(teamName,shortName,matchesPlayed,matchesWon,matchesLost,matchesTied,netRunRate,pointsScored) values(?,?,?,?,?,?,?,?)";
		jdbcTemplate.setDataSource(datasource);
		jdbcTemplate.update(sql, new Object[] {teamName,shortName,0,0,0,0,0.00,0});
		System.out.println("Team Added Successfully");
	}


	@Override
	public List<Team> getPointsTable() {
		System.out.println("Getting points table from Database");
		String sql = "SELECT * FROM pointstable";
        List<Team> pointsTable = (ArrayList<Team>)jdbcTemplate.query(sql,new BeanPropertyRowMapper<Team>(Team.class));
        return pointsTable;
	}


	@Override
	public void updatePointsTable(String teamShortName, Team team) {
		System.out.println("Upating Points table");
		System.out.println("Team Name:"+teamShortName);
		String sql = "update pointstable set teamName=?, shortName=?, matchesPlayed=?, matchesWon=?, matchesLost=?, matchesTied=?, netRunRate=?, pointsScored=? where shortName=?";
        jdbcTemplate.update(sql, new Object[]{team.getTeamName(),team.getShortName(),team.getMatchesPlayed(),team.getMatchesWon(),team.getMatchesLost(),team.getMatchesTied(),team.getNetRunRate(),team.getPointsScored(),teamShortName});
        System.out.println("Updated Team record sucessfully");
	}


	@Override
	public void deleteTeam(String teamName) {
		System.out.println("Deleting the team in the database");
		String deleteQuery = "delete from pointstable where teamName=?";
		jdbcTemplate.update(deleteQuery, teamName);
		System.out.println(teamName+" Team Deleted Successfully");
	}

}
