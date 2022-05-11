package fr.formation.inti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.IResultsDao;
import fr.formation.inti.entities.Results;

@Service
public class ResultsServiceImpl implements IResultsService {

	@Autowired
	private IResultsDao resultsDao;


	@Override
	public void saveResults(Results result) {
		this.resultsDao.save(result);

	}

	@Override
	public Results getResultsByResultsId(Integer resultId) {
		return resultsDao.findResultsByResultsId(resultId);
	}

	@Override
	public List<Results> getAllResults() {
		// TODO Auto-generated method stub
		return resultsDao.findAll();
	}

	@Override
	public Page<Results> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

		return this.resultsDao.findAll(pageable);

	}
}
