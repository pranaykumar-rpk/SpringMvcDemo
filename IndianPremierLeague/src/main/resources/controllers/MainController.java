package controllers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import models.Match;
import models.Team;
import services.ServiceFunctionalities;


@Controller
public class MainController {
	
	@Autowired
	ServiceFunctionalities serviceFunctionalities;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView addTeam(HttpServletRequest request, HttpServletResponse response){
		String teamName = request.getParameter("teamName");
		String shortName = request.getParameter("shortName");
		/*
		 * if(duplicateTeam(teamName,shortName)) {
		 * System.out.println("Error! Duplicate Team"); return new
		 * ModelAndView("errorMsg","msg","Error! Team Already Registered"); }else {
		 * System.out.println("Adding New Team");
		 * serviceFunctionalities.addTeam(teamName, shortName);
		 */
		try {
			serviceFunctionalities.addTeam(teamName, shortName);
			return new ModelAndView("register", "teamName", teamName);
		}catch(Exception e) {
			return new ModelAndView("errorMsg","msg","Error! Team Already Registered");
		}
		//return new ModelAndView("register", "teamName", teamName);	
	}
	
	
	private boolean duplicateTeam(String teamName, String shortName) {
		System.out.println("Checking tems:"+teamName+" "+shortName);
		System.out.println("Checking for duplicate ");
		List<Team> pointsTable = serviceFunctionalities.getPointsTable();
		System.out.println("Team List:"+pointsTable);
		for(int index=0;index<pointsTable.size();index++) {
			System.out.println("Checking index:"+index);
			System.out.println("Tem at index:"+pointsTable.get(index).toString());
			if(pointsTable.get(index).getTeamName().equalsIgnoreCase(teamName) || pointsTable.get(index).getShortName().equalsIgnoreCase(shortName)) {
				System.out.println("Returning true");
				return true;
			}
		}
		return false;
	}
	
	
	@RequestMapping(value = "/home.htm", method = RequestMethod.GET)
	public String goHome() {
		System.out.println("Called Home");
		return "index";
	}
	

	@RequestMapping(value = "/showPointsTable", method=RequestMethod.GET)
	public ModelAndView getPointsTable() {
		System.out.println("Called Get Points table");
		List<Team> pointsTable = serviceFunctionalities.getPointsTable();
		System.out.println("returning list:"+pointsTable);
		return new ModelAndView("pointsTable","pointsTable",pointsTable);
	}


	@RequestMapping(value = "/showAddTeam", method=RequestMethod.GET)
	public String gotoAddTeamPage() {
		System.out.println("Called Show AddTeam");
		return "addTeam";
	}
	
	@RequestMapping(value = "/deleteATeam", method=RequestMethod.POST)
	public ModelAndView deleteATeam(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Called Delete A Team");
		System.out.println("Selceted Team to delte:"+request.getParameter("selectedTeam"));
		serviceFunctionalities.deleteTeam(request.getParameter("selectedTeam"));
		List<Team> pointsTable = serviceFunctionalities.getPointsTable();
		return new ModelAndView("pointsTable","pointsTable",pointsTable);
	}
	
	
	
	@RequestMapping(value = "/showDeletePage", method=RequestMethod.GET)
	public ModelAndView gotoDeleteTeamPage() {
		System.out.println("Called Goto Delete page");
		List<Team> pointsTable = serviceFunctionalities.getPointsTable();
		return new ModelAndView("deleteTeam","pointsTable",pointsTable);
	}
	
	
	@RequestMapping(value = "/showMatchDetails", method=RequestMethod.GET)
	public ModelAndView gotoShowMatchDetailsPage() {
		System.out.println("Called Show AddMatch Page");
		List<Team> pointsTable = serviceFunctionalities.getPointsTable();
		List<String> teamNames = new ArrayList<>();
		for(int i=0;i<pointsTable.size();i++) {
			teamNames.add(pointsTable.get(i).getShortName());
		}
		return new ModelAndView("addMatch","pointsTable",pointsTable);
	}
	
	
	@RequestMapping(value = "/showUpdateTeam", method=RequestMethod.GET)
	public ModelAndView gotoShowUpdateTeamPage() {
		System.out.println("Called Show Update team Page");
		List<Team> pointsTable = serviceFunctionalities.getPointsTable();
		return new ModelAndView("updateTeam","pointsTable",pointsTable);
	}
	
	@RequestMapping(value = "/startMatch", method = RequestMethod.POST)
	public ModelAndView startMatch(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Called Start match");
		String[] selectedTeams = request.getParameterValues("selected");
		System.out.println("Selected teams:"+selectedTeams[0]+"\n"+selectedTeams[1]);
		return new ModelAndView("matchDetails","selectedTeams",selectedTeams);
	}
	
	@RequestMapping(value = "/updateTable", method=RequestMethod.POST)
	public ModelAndView updateTable(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("match") Match match) {
		
		List<Team> pointsTable = serviceFunctionalities.getPointsTable();
		Team teamA  = getTeamOf(match.getTeamAName(),pointsTable);
		Team teamB  = getTeamOf(match.getTeamBName(),pointsTable);
		teamA.setMatchesPlayed(teamA.getMatchesPlayed()+1);
		teamB.setMatchesPlayed(teamB.getMatchesPlayed()+1);
		double rr = getRunRate(match);
		if(match.getScoreOfTeamA()==match.getScoreOfTeamB()) {
			//Match Tied
			System.out.println("Match Tied");
			teamA.setMatchesTied(teamA.getMatchesTied()+1);
			teamB.setMatchesTied(teamB.getMatchesTied()+1);
			teamA.setPointsScored(teamA.getPointsScored()+1);
			teamB.setPointsScored(teamB.getPointsScored()+1);
		}
		else if(match.getScoreOfTeamA()>match.getScoreOfTeamB()) {
			//Won By team A
			System.out.println("Won By Team A");
			teamA.setMatchesWon(teamA.getMatchesWon()+1);
			teamB.setMatchesLost(teamB.getMatchesLost()+1);
			teamA.setPointsScored(teamA.getPointsScored()+2);
			teamA.setNetRunRate(teamA.getNetRunRate()+rr);
			teamB.setNetRunRate(teamB.getNetRunRate()-rr);
			
		}else{
			//Won By Team B
			System.out.println("Won By Team B");
			teamB.setMatchesWon(teamB.getMatchesWon()+1);
			teamA.setMatchesLost(teamA.getMatchesLost()+1);
			teamB.setPointsScored(teamB.getPointsScored()+2);
			teamB.setNetRunRate(teamB.getNetRunRate()+rr);
			teamA.setNetRunRate(teamA.getNetRunRate()-rr);
		}
		System.out.println("Updating team A:"+teamA);
		serviceFunctionalities.updateTable(match.getTeamAName(),teamA);
		System.out.println("Updating team B:"+teamB);
		serviceFunctionalities.updateTable(match.getTeamBName(),teamB);
		pointsTable = serviceFunctionalities.getPointsTable();
		return new ModelAndView("pointsTable","pointsTable",pointsTable);
	}

	private double getRunRate(Match match) {
		double rrOfA;
		double rrOfB;
		rrOfA = (match.getScoreOfTeamA()*6)/120;
		rrOfB = (match.getScoreOfTeamB()*6)/120;
		System.out.println("RRA:"+rrOfA);
		System.out.println("RRB:"+rrOfB);
		double rr = ((rrOfA>rrOfB?(rrOfA-rrOfB):(rrOfB-rrOfA)))/100;
		System.out.println("Difference run rate:"+rr);
		DecimalFormat df = new DecimalFormat("#.000");
		double x = new Double(df.format(rr));
		System.out.println("Double(df.format(rr);"+x);
		return new Double(df.format(rr));
	}

	private Team getTeamOf(String teamAName, List<Team> pointsTable) {
		for(int i=0;i<pointsTable.size();i++) {
			if(pointsTable.get(i).getShortName().equalsIgnoreCase(teamAName)) {
				return pointsTable.get(i);
			}
		}
		return null;
	}
}
