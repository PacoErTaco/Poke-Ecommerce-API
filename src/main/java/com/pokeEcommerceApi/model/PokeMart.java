package com.pokeEcommerceApi.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class PokeMart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String city;
	private String region;
	
	@ManyToMany
	@JoinTable(
		name = "mart_inventory",
		joinColumns = @JoinColumn(name = "poke_mart_id"),
		inverseJoinColumns = @JoinColumn(name = "object_id")
	)
	private List<Object> availableObjects;
	
}
