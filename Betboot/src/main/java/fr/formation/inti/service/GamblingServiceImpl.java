package fr.formation.inti.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.IBetDao;
import fr.formation.inti.dao.IGamblingDao;
import fr.formation.inti.dao.IMatchDao;
import fr.formation.inti.entities.Bet;
import fr.formation.inti.entities.Gambling;
import fr.formation.inti.entities.Match;
import fr.formation.inti.entities.Results;
import fr.formation.inti.entities.User;
import fr.formation.inti.model.Matchadapted;



@Service
public class GamblingServiceImpl implements IGamblingService{
	
	
	@Autowired
	private IGamblingDao gamblingDao;

	
	@Override
	public List<Gambling> getAllGamblings() {
		
		return gamblingDao.findAll();
	}



	@Override
	public Gambling findGamblingByGamblingId(Integer gamblingId) {
		
		return gamblingDao.findGamblingByGamblingId(gamblingId);
	}



	@Override
	public void SaveGambling(Gambling gambling) {
		gamblingDao.save(gambling);
		
	}



	@Override
	public List<Gambling> findGambilngsByBet(Bet bet) {
		
		return gamblingDao.findGambilngsByBet(bet);
	}



	@Override
	public List<Gambling> findGambilngsByUser(User user) {
		// TODO Auto-generated method stub
		return gamblingDao.findGambilngsByUser(user);
	}
	
	
	
	
	
	
	
} 
	
		

