package com.pokeEcommerceApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokeEcommerceApi.exception.NotFoundException;
import com.pokeEcommerceApi.model.PokeMart;
import com.pokeEcommerceApi.service.implement.PokeMartService;

@RestController
@RequestMapping("/pokemart")
public class PokeMartController {

	@Autowired
	private PokeMartService service;

	/**
	 * Endpoint getAllPokeMart que devuelve todas las tiendas Pokémon en base de datos.
	 * 
	 * @return - Todas las tiendas Pokémon en base de datos
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado ninguna tienda Pokémon
	 */

	@GetMapping
	public List<PokeMart> getAllPokeMart() throws NotFoundException {
		return service.findAllMarts();
	}

	/**
	 * Endpoint getPokeMartByRegion que devuelve todas las tiendas Pokémon de una región específica
	 * 
	 * @param region
	 *            - Región que se quiere consultar
	 * @return - Todas las tiendas Pokémon de una región específica
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado ninguna tienda Pokémon en la región pasada por
	 *             parámetro
	 */
	@GetMapping("/region/{region}")
	public List<PokeMart> getPokeMartByRegion(@PathVariable String region) throws NotFoundException {
		return service.findMartsByRegion(region);
	}

	/**
	 * Endpoint getPokeMartByRegion que devuelve todas las tiendas Pokémon de una ciudad o pueblo específico
	 * 
	 * @param city
	 *            - ciudad o pueblo que se quiere consultar
	 * @return - Todas las tiendas Pokémon de una ciudad o pueblo específico
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado ninguna tienda Pokémon en la ciudad o pueblo pasados
	 *             por parámetro
	 */
	@GetMapping("/city/{city}")
	public List<PokeMart> getPokeMartByCity(@PathVariable String city) throws NotFoundException {
		return service.findMartsByCity(city);
	}
}
