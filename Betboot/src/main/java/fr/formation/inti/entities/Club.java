package fr.formation.inti.entities;
// Generated 9 mai 2022, 11:57:32 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Club generated by hbm2java
 */
@Entity
@Table(name = "club", catalog = "ligue1_gamble")
public class Club implements java.io.Serializable {

	private Integer clubId;
	private String name;
	private Integer played;
	private Integer won;
	private Integer lost;
	private Integer drawn;
	private Integer prestige;
	private Integer points;
	private String residency;
	private String logoPath;
	private Set<Results> resultsesForVictoryId = new HashSet<Results>(0);
	private Set<Results> resultsesForDrawHomeId = new HashSet<Results>(0);
	private Set<Bet> bets = new HashSet<Bet>(0);
	private Set<Match> matchesForClubVisitor = new HashSet<Match>(0);
	private Set<Results> resultsesForDrawVisitorId = new HashSet<Results>(0);
	private Set<Match> matchesForClubHome = new HashSet<Match>(0);
	private Set<Results> resultsesForLoseId = new HashSet<Results>(0);

	
	
	@Override
	public String toString() {
		return "Club [clubId=" + clubId + ", name=" + name + "]";
	}

	public Club() {
	}

	public Club(String name, String residency) {
		this.name = name;
		this.residency = residency;
	}

	public Club(String name, Integer played, Integer won, Integer lost, Integer drawn, Integer prestige, Integer points,
			String residency, String logoPath, Set<Results> resultsesForVictoryId, Set<Results> resultsesForDrawHomeId,
			Set<Bet> bets, Set<Match> matchesForClubVisitor, Set<Results> resultsesForDrawVisitorId,
			Set<Match> matchesForClubHome, Set<Results> resultsesForLoseId) {
		this.name = name;
		this.played = played;
		this.won = won;
		this.lost = lost;
		this.drawn = drawn;
		this.prestige = prestige;
		this.points = points;
		this.residency = residency;
		this.logoPath = logoPath;
		this.resultsesForVictoryId = resultsesForVictoryId;
		this.resultsesForDrawHomeId = resultsesForDrawHomeId;
		this.bets = bets;
		this.matchesForClubVisitor = matchesForClubVisitor;
		this.resultsesForDrawVisitorId = resultsesForDrawVisitorId;
		this.matchesForClubHome = matchesForClubHome;
		this.resultsesForLoseId = resultsesForLoseId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "club_id", unique = true, nullable = false)
	public Integer getClubId() {
		return this.clubId;
	}

	public void setClubId(Integer clubId) {
		this.clubId = clubId;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "played")
	public Integer getPlayed() {
		return this.played;
	}

	public void setPlayed(Integer played) {
		this.played = played;
	}

	@Column(name = "won")
	public Integer getWon() {
		return this.won;
	}

	public void setWon(Integer won) {
		this.won = won;
	}

	@Column(name = "lost")
	public Integer getLost() {
		return this.lost;
	}

	public void setLost(Integer lost) {
		this.lost = lost;
	}

	@Column(name = "drawn")
	public Integer getDrawn() {
		return this.drawn;
	}

	public void setDrawn(Integer drawn) {
		this.drawn = drawn;
	}

	@Column(name = "prestige")
	public Integer getPrestige() {
		return this.prestige;
	}

	public void setPrestige(Integer prestige) {
		this.prestige = prestige;
	}

	@Column(name = "points")
	public Integer getPoints() {
		return this.points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@Column(name = "residency", nullable = false, length = 45)
	public String getResidency() {
		return this.residency;
	}

	public void setResidency(String residency) {
		this.residency = residency;
	}

	@Column(name = "logo_path", length = 200)
	public String getLogoPath() {
		return this.logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "clubByVictoryId")
	public Set<Results> getResultsesForVictoryId() {
		return this.resultsesForVictoryId;
	}

	public void setResultsesForVictoryId(Set<Results> resultsesForVictoryId) {
		this.resultsesForVictoryId = resultsesForVictoryId;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "clubByDrawHomeId")
	public Set<Results> getResultsesForDrawHomeId() {
		return this.resultsesForDrawHomeId;
	}

	public void setResultsesForDrawHomeId(Set<Results> resultsesForDrawHomeId) {
		this.resultsesForDrawHomeId = resultsesForDrawHomeId;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "club")
	public Set<Bet> getBets() {
		return this.bets;
	}

	public void setBets(Set<Bet> bets) {
		this.bets = bets;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "clubByClubVisitor")
	public Set<Match> getMatchesForClubVisitor() {
		return this.matchesForClubVisitor;
	}

	public void setMatchesForClubVisitor(Set<Match> matchesForClubVisitor) {
		this.matchesForClubVisitor = matchesForClubVisitor;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "clubByDrawVisitorId")
	public Set<Results> getResultsesForDrawVisitorId() {
		return this.resultsesForDrawVisitorId;
	}

	public void setResultsesForDrawVisitorId(Set<Results> resultsesForDrawVisitorId) {
		this.resultsesForDrawVisitorId = resultsesForDrawVisitorId;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "clubByClubHome")
	public Set<Match> getMatchesForClubHome() {
		return this.matchesForClubHome;
	}

	public void setMatchesForClubHome(Set<Match> matchesForClubHome) {
		this.matchesForClubHome = matchesForClubHome;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "clubByLoseId")
	public Set<Results> getResultsesForLoseId() {
		return this.resultsesForLoseId;
	}

	public void setResultsesForLoseId(Set<Results> resultsesForLoseId) {
		this.resultsesForLoseId = resultsesForLoseId;
	}

}
