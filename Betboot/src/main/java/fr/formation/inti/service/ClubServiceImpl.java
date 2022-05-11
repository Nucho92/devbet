package fr.formation.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.IClubDao;
import fr.formation.inti.entities.Club;

@Service
public class ClubServiceImpl implements IClubService {

	@Autowired
	private IClubDao clubDao;
	
	@Override
	public List<Club> getAllClubs() {
	
		return clubDao.findAll();
	}

	@Override
	public Page<Club> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending():
			Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.clubDao.findAll(pageable);
	}

}
