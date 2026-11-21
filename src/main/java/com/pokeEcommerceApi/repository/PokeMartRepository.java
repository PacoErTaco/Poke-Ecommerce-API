package com.pokeEcommerceApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokeEcommerceApi.model.PokeMart;

@Repository
public interface PokeMartRepository extends JpaRepository<PokeMart, Integer> {

	List<PokeMart> findByRegionIgnoreCase(String region);

	List<PokeMart> findByCityIgnoreCase(String city);
	
}
