package com.pokeEcommerceApi.service.implement;

import java.util.List;
import com.pokeEcommerceApi.model.Object;
import com.pokeEcommerceApi.exception.ExistException;
import com.pokeEcommerceApi.exception.NotFoundException;

public interface ObjectService {

	/**
	 * Método findAllObjects que devuelve una lista de todos los productos disponibles
	 * 
	 * @return - Lista de todos los productos disponibles
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado ningún artículo en la base de datos
	 */
	List<Object> findAllObjects() throws NotFoundException;

	/**
	 * Método findObjectByName que devuelve un producto según el nombre que se pase por parámetro
	 * 
	 * @param name
	 *            - Nombre del producto
	 * @return - Producto que coincida con el nombre que se pasa por parámetro
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado ningún artículo por su nombre
	 */
	Object findObjectByName(String name) throws NotFoundException;

	/**
	 * Método findObjectsByType que devuelve una lista de todos los objetos según su tipo
	 * 
	 * @param type
	 *            - Tipo de objeto
	 * @return Lista de todos los objetos filtrando por el tipo de objeto
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado el tipo de artículo indicado
	 */
	List<Object> findObjectsByType(String type) throws NotFoundException;

	/**
	 * Método findObjectsByGeneration que devuelve una lista de todos los objetos según la generación en la que se
	 * introdujeron
	 * 
	 * @param generation
	 *            - Número de generación
	 * @return - Lista de todos los objetos filtrando por la generación en la que se introdujeron
	 * @throws ExistException
	 *             - Excepción que se lanza si la generación pasada por parámetro no existe
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha introducido ningún artículo en la generación pasada por
	 *             parámetro
	 */
	List<Object> findObjectsByGeneration(Integer generation) throws ExistException, NotFoundException;

}
