package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.entities.Bet;
import fr.formation.inti.entities.Club;
import fr.formation.inti.entities.Gambling;
import fr.formation.inti.entities.Match;
public interface IBetService {
	
	List<Bet> getAllBet();
	Bet findByBetId(int betId);
	void  SaveBet(Bet bet);
	List<Bet> findBetsByMatch(Match match); 
	
	Bet getBetbyClubandMatch(Club club, Match match);
} 
 