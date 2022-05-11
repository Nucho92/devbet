package fr.formation.inti.service;

import java.util.List;

import org.springframework.data.domain.Page;

import fr.formation.inti.entities.Results;

public interface IResultsService {
	
	List <Results> getAllResults();
	
	void saveResults(Results result);
	
	Results getResultsByResultsId(Integer resultId);
	
	Page<Results> findPaginated(int pageNo, int pageSize);

}
