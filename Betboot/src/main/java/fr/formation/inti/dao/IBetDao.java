package fr.formation.inti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.inti.entities.Bet;
import fr.formation.inti.entities.Club;
import fr.formation.inti.entities.Gambling;
import fr.formation.inti.entities.Match;

public interface IBetDao extends JpaRepository<Bet, Integer>   {
	
	
	@Query("select b from Bet b where b.betId=?1 ")
	Bet findByBetId(int betId);	
	
	@Query("select b from Bet b where b.match=?1 ")
	 List<Bet> findBetsByMatch(Match match); 
	
	@Query("select b from Bet b where b.club=?1 and b.match=?2 ")
	Bet getBetbyClubandMatch(Club club, Match match);
	
}
 