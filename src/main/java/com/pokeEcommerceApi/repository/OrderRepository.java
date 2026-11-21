package com.pokeEcommerceApi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokeEcommerceApi.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findByOrderDate(LocalDate date);
	
	List<Order> findByStatus(String status);
	
}
