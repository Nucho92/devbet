package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.entities.Bet;
import fr.formation.inti.entities.Gambling;
import fr.formation.inti.entities.User;
public interface IGamblingService {
	
	List<Gambling> getAllGamblings();
	Gambling findGamblingByGamblingId(Integer gamblingId);
	void SaveGambling(Gambling gambling);
	List<Gambling> findGambilngsByBet(Bet bet);
	
	List<Gambling> findGambilngsByUser(User user);
} 
 