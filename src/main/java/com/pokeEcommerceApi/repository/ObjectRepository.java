package com.pokeEcommerceApi.repository;

import java.util.List;
import java.util.Optional;
import com.pokeEcommerceApi.model.Object;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRepository extends JpaRepository<Object, Integer> {

	Optional<Object> findByObjectNameIgnoreCase(String name);
	
	List<Object> findByObjectTypeIgnoreCase(String type);
	
	List<Object> findByGeneration(Integer generation);
}
