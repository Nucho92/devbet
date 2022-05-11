package fr.formation.inti.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.inti.entities.Bet;
import fr.formation.inti.entities.Gambling;
import fr.formation.inti.entities.User;


public interface IGamblingDao extends JpaRepository<Gambling, Integer>   {
	
	
	@Query("select g from Gambling g where g.gamblingId=?1 ")
	Gambling findGamblingByGamblingId(Integer gamblingId);
	
	@Query("select g from Gambling g where g.bet=?1 ")
	 List<Gambling> findGambilngsByBet(Bet bet);  
	 
	@Query("select g from Gambling g where g.user=?1 ")
	List<Gambling> findGambilngsByUser(User user);
	
}
 