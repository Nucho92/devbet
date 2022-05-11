package fr.formation.inti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.inti.entities.Match;


public interface IMatchDao extends JpaRepository<Match,Integer> {
	
	@Query("select m from Match m where m.matchId=?1")
	Match findMatchByMatchId(Integer matchId);
	
    List<Match> findByMatchId(Integer matchId);
	

	

}
