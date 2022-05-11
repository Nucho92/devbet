package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.entities.Match;

public interface IMatchService {
	
  
   List <Match> getAllMatches();
   
   List<Match> findByMatchId(Integer matchId);

   Match getMatchByMatchId(Integer matchId);
   
   void saveMatch(Match match);
}
