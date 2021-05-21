package models;

public class Match {
	String teamAName;
	int scoreOfTeamA;
	double oversOfTeamA;
	int wicketsOfTeamA;
	String teamBName;
	int scoreOfTeamB;
	double oversOfTeamB;
	int wicketsOfTeamB;
	public String getTeamAName() {
		return teamAName;
	}
	public void setTeamAName(String teamAName) {
		this.teamAName = teamAName;
	}
	public int getScoreOfTeamA() {
		return scoreOfTeamA;
	}
	public void setScoreOfTeamA(int scoreOfTeamA) {
		this.scoreOfTeamA = scoreOfTeamA;
	}
	public double getOversOfTeamA() {
		return oversOfTeamA;
	}
	public void setOversOfTeamA(double oversOfTeamA) {
		this.oversOfTeamA = oversOfTeamA;
	}
	public int getWicketsOfTeamA() {
		return wicketsOfTeamA;
	}
	public void setWicketsOfTeamA(int wicketsOfTeamA) {
		this.wicketsOfTeamA = wicketsOfTeamA;
	}
	public String getTeamBName() {
		return teamBName;
	}
	public void setTeamBName(String teamBName) {
		this.teamBName = teamBName;
	}
	public int getScoreOfTeamB() {
		return scoreOfTeamB;
	}
	public void setScoreOfTeamB(int scoreOfTeamB) {
		this.scoreOfTeamB = scoreOfTeamB;
	}
	public double getOversOfTeamB() {
		return oversOfTeamB;
	}
	public void setOversOfTeamB(double oversOfTeamB) {
		this.oversOfTeamB = oversOfTeamB;
	}
	public int getWicketsOfTeamB() {
		return wicketsOfTeamB;
	}
	public void setWicketsOfTeamB(int wicketsOfTeamB) {
		this.wicketsOfTeamB = wicketsOfTeamB;
	}
	@Override
	public String toString() {
		return "Match [teamAName=" + teamAName + ", scoreOfTeamA=" + scoreOfTeamA + ", oversOfTeamA=" + oversOfTeamA
				+ ", wicketsOfTeamA=" + wicketsOfTeamA + ", teamBName=" + teamBName + ", scoreOfTeamB=" + scoreOfTeamB
				+ ", oversOfTeamB=" + oversOfTeamB + ", wicketsOfTeamB=" + wicketsOfTeamB + "]";
	}
	
	
		
}
