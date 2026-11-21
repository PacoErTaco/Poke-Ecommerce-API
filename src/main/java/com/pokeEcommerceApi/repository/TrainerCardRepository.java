package com.pokeEcommerceApi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokeEcommerceApi.model.TrainerCard;

@Repository
public interface TrainerCardRepository extends JpaRepository<TrainerCard, Integer> {

	Optional<TrainerCard> findByTrainerNameIgnoreCase(String name);
	
}
