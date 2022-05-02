package fr.formation.inti.entities;
// Generated 2 mai 2022, 09:16:13 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Bet generated by hbm2java
 */
@Entity
@Table(name = "bet", catalog = "ligue1_gamble")
public class Bet implements java.io.Serializable {

	private int betId;
	private Bookmaker bookmaker;
	private Club club;
	private Match match;
	private Integer nbGambler;
	private Float rating;
	private Set<Gambling> gamblings = new HashSet<Gambling>(0);

	public Bet() {
	}

	public Bet(int betId, Bookmaker bookmaker, Match match) {
		this.betId = betId;
		this.bookmaker = bookmaker;
		this.match = match;
	}

	public Bet(int betId, Bookmaker bookmaker, Club club, Match match, Integer nbGambler, Float rating,
			Set<Gambling> gamblings) {
		this.betId = betId;
		this.bookmaker = bookmaker;
		this.club = club;
		this.match = match;
		this.nbGambler = nbGambler;
		this.rating = rating;
		this.gamblings = gamblings;
	}

	@Id

	@Column(name = "bet_id", unique = true, nullable = false)
	public int getBetId() {
		return this.betId;
	}

	public void setBetId(int betId) {
		this.betId = betId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookmaker_id", nullable = false)
	public Bookmaker getBookmaker() {
		return this.bookmaker;
	}

	public void setBookmaker(Bookmaker bookmaker) {
		this.bookmaker = bookmaker;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "club_id")
	public Club getClub() {
		return this.club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "match_id", nullable = false)
	public Match getMatch() {
		return this.match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	@Column(name = "nb_gambler")
	public Integer getNbGambler() {
		return this.nbGambler;
	}

	public void setNbGambler(Integer nbGambler) {
		this.nbGambler = nbGambler;
	}

	@Column(name = "rating", precision = 12, scale = 0)
	public Float getRating() {
		return this.rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bet")
	public Set<Gambling> getGamblings() {
		return this.gamblings;
	}

	public void setGamblings(Set<Gambling> gamblings) {
		this.gamblings = gamblings;
	}

}
