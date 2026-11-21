package com.pokeEcommerceApi.service.implement;

import java.util.List;

import com.pokeEcommerceApi.model.PokeMart;
import com.pokeEcommerceApi.exception.NotFoundException;

public interface PokeMartService {

	/**
	 * Método findAllMarts que devuelve todas las tiendas registradas en BBDD
	 * 
	 * @return - Lista de todas las tiendas registradas
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado ninguna tienda.
	 */
	List<PokeMart> findAllMarts() throws NotFoundException;

	/**
	 * Método findMartsByRegion que devuelve todas las tiendas según la región que se indique por parámetro
	 * 
	 * @param region
	 *            - Nombre de la región
	 * @return - Lista de todas las tiendas según la región
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado ninguna tienda
	 */
	List<PokeMart> findMartsByRegion(String region) throws NotFoundException;

	/**
	 * Método findMartsByCity que devuelve todas las tiendas según la ciudad que se le indique por parámetro
	 * 
	 * @param city
	 *            - Nombre de la ciudad o pueblo
	 * @return - Lista de todas las tiendas según la región
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado ninguna tienda
	 */
	List<PokeMart> findMartsByCity(String city) throws NotFoundException;

}
