package fr.formation.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.IMatchDao;
import fr.formation.inti.entities.Match;

@Service
public class MatchServiceImpl implements IMatchService {

	@Autowired
	private IMatchDao matchDao;
	
	@Override
	public Match getMatchByMatchId(Integer matchId) {
		
		return matchDao.findMatchByMatchId(matchId);
	}

	@Override
	public List<Match> getAllMatches() {
		return matchDao.findAll();
	}


	@Override
	public List<Match> findByMatchId(Integer matchId) {

		return matchDao.findByMatchId(matchId);
	}

	@Override
	public void saveMatch(Match match) {
		this.matchDao.save(match);
		
	}

}
