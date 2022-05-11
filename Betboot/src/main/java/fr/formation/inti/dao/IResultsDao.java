package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.inti.entities.Results;

public interface IResultsDao extends JpaRepository<Results, Integer>{
	
	@Query("select r from Results r where r.resultId=:resultId")
	Results findResultsByResultsId(Integer resultId);

}
