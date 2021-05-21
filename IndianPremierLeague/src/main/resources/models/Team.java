package models;

public class Team implements Comparable<Team>{
	String teamName;
	String shortName;
	int matchesPlayed;
	int matchesWon;
	int matchesLost;
	int matchesTied;
	double netRunRate;
	int pointsScored;
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public int getMatchesPlayed() {
		return matchesPlayed;
	}
	public void setMatchesPlayed(int matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}
	public int getMatchesWon() {
		return matchesWon;
	}
	public void setMatchesWon(int matchesWon) {
		this.matchesWon = matchesWon;
	}
	public int getMatchesLost() {
		return matchesLost;
	}
	public void setMatchesLost(int matchesLost) {
		this.matchesLost = matchesLost;
	}
	public int getMatchesTied() {
		return matchesTied;
	}
	public void setMatchesTied(int matchesTied) {
		this.matchesTied = matchesTied;
	}
	public double getNetRunRate() {
		return netRunRate;
	}
	public void setNetRunRate(double netRuntRate) {
		this.netRunRate = netRuntRate;
	}
	public int getPointsScored() {
		return pointsScored;
	}
	public void setPointsScored(int pointsScored) {
		this.pointsScored = pointsScored;
	}
	@Override
	public String toString() {
		return "Team [teamName=" + teamName + ", shortName=" + shortName + ", matchesPlayed=" + matchesPlayed
				+ ", matchesWon=" + matchesWon + ", matchesLost=" + matchesLost + ", matchesTied=" + matchesTied
				+ ", netRunRate=" + netRunRate + ", pointsScored=" + pointsScored + "]";
	}
	
	@Override
	public int compareTo(Team team) {
		if(team.getPointsScored()==this.getPointsScored()) {
			return team.getNetRunRate()>this.getNetRunRate()?1:-1;
		}
		return team.getPointsScored()>this.getPointsScored()?1:-1;
	}
	
}
