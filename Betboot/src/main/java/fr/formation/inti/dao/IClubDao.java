package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Club;

public interface IClubDao extends JpaRepository<Club, Integer> {

}
