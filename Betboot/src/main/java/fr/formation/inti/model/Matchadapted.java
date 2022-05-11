package fr.formation.inti.model;

import fr.formation.inti.entities.Match;

public class Matchadapted {
	
	private Match match;
	private Float cotevictoryclubhome;
	private Float cotevictoryclubvisitor;
	private Float cotedunull;
	private Integer BetIdClubHome;
	private Integer BetIdClubvisitor;
	private Integer BetIdDrawn;
	public Match getMatch() {
		return match;
	}
	public void setMatch(Match match) {
		this.match = match;
	}

	public Integer getBetIdClubHome() {
		return BetIdClubHome;
	}
	public void setBetIdClubHome(Integer betIdClubHome) {
		BetIdClubHome = betIdClubHome;
	}
	public Integer getBetIdClubvisitor() {
		return BetIdClubvisitor;
	}
	public void setBetIdClubvisitor(Integer betIdClubvisitor) {
		BetIdClubvisitor = betIdClubvisitor;
	}
	public Integer getBetIdDrawn() {
		return BetIdDrawn;
	}
	public void setBetIdDrawn(Integer betIdDrawn) {
		BetIdDrawn = betIdDrawn;
	}
	@Override
	public String toString() {
		return "Matchadapted [match=" + match + ", cotevictoryclubhome=" + cotevictoryclubhome
				+ ", cotevictoryclubvisitor=" + cotevictoryclubvisitor + ", cotedunull=" + cotedunull + "]";
	}
	public Float getCotevictoryclubhome() {
		return cotevictoryclubhome;
	}
	public void setCotevictoryclubhome(Float cotevictoryclubhome) {
		this.cotevictoryclubhome = cotevictoryclubhome;
	}
	public Float getCotevictoryclubvisitor() {
		return cotevictoryclubvisitor;
	}
	public void setCotevictoryclubvisitor(Float cotevictoryclubvisitor) {
		this.cotevictoryclubvisitor = cotevictoryclubvisitor;
	}
	public Float getCotedunull() {
		return cotedunull;
	}
	public void setCotedunull(Float cotedunull) {
		this.cotedunull = cotedunull;
	}

	

}
