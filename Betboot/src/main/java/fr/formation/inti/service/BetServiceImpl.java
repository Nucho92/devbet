package fr.formation.inti.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.IBetDao;
import fr.formation.inti.entities.Bet;
import fr.formation.inti.entities.Club;
import fr.formation.inti.entities.Gambling;
import fr.formation.inti.entities.Match;



@Service
public class BetServiceImpl implements IBetService{
	
	
	@Autowired
	private IBetDao betDao;

	@Override
	public List<Bet> getAllBet() {
	
		return betDao.findAll();
	}

	@Override
	public Bet findByBetId(int betId) {
	
		return betDao.findByBetId(betId);
	} 

	public void SaveBet(Bet bet) {
		betDao.save(bet);
	}

	@Override
	public List<Bet> findBetsByMatch(Match match) {
		
		return betDao.findBetsByMatch(match);
	}

	@Override
	public Bet getBetbyClubandMatch(Club club, Match match) {
		// TODO Auto-generated method stub
		return betDao.getBetbyClubandMatch(club, match);
	}

	

}
