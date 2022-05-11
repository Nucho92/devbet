package fr.formation.inti.service;

import java.util.List;

import org.springframework.data.domain.Page;

import fr.formation.inti.entities.Club;

public interface IClubService {
	
	List <Club> getAllClubs();
	
	Page<Club> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
