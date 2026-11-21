package com.pokeEcommerceApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.pokeEcommerceApi.exception.NotFoundException;
import com.pokeEcommerceApi.model.PokeMart;
import com.pokeEcommerceApi.repository.PokeMartRepository;
import com.pokeEcommerceApi.service.implement.PokeMartService;

@Service
public class PokeMartServiceImpl implements PokeMartService {

	@Autowired
	private PokeMartRepository repoPokeMart;

	@Override
	public List<PokeMart> findAllMarts() throws NotFoundException {

		try {
			List<PokeMart> allPokeMart = repoPokeMart.findAll();
			if (allPokeMart.isEmpty()) {
				throw new NotFoundException("No se han encontrado ninguna tienda Pokémon");
			}
			return allPokeMart;
		}
		catch (DataAccessException e) {
			throw new NotFoundException("Error consultando todas las tiendas Pokémon", e);
		}

	}

	@Override
	public List<PokeMart> findMartsByRegion(String region) throws NotFoundException {
		try {
			List<PokeMart> byRegion = repoPokeMart.findByRegionIgnoreCase(region);

			if (byRegion.isEmpty()) {
				throw new NotFoundException("No se ha encontrado ninguna tienda Pokémon");
			}
			return byRegion;
		}
		catch (DataAccessException e) {
			throw new NotFoundException("Error consultando tiendas Pokémon por región ", e);
		}
	}

	@Override
	public List<PokeMart> findMartsByCity(String city) throws NotFoundException {
		try {
			List<PokeMart> byCity = repoPokeMart.findByCityIgnoreCase(city);

			if (byCity.isEmpty()) {
				throw new NotFoundException("No se ha encontrado ninguna tienda Pokémon");
			}
			return byCity;
		}
		catch (DataAccessException e) {
			throw new NotFoundException("Error consultando tiendas Pokémon por ciudad o pueblo ", e);
		}
	}

}
