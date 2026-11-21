package com.pokeEcommerceApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pokeEcommerceApi.model.Object;
import com.pokeEcommerceApi.exception.ExistException;
import com.pokeEcommerceApi.exception.NotFoundException;
import com.pokeEcommerceApi.service.implement.ObjectService;

@RestController
@RequestMapping("/object")
public class ObjectController {

	@Autowired
	private ObjectService service;

	/**
	 * Endpoint getAllObjects que devuelve todos los productos disponibles en base de datos
	 * 
	 * @return - Todos los productos disponibles en base de datos
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado ningún producto en base de datos
	 */

	@GetMapping
	public List<Object> getAllObjects() throws NotFoundException {
		return service.findAllObjects();
	}

	/**
	 * Endpoint getObjectByName que filtra por el nombre del producto en base de datos y lo devuelve
	 * 
	 * @param name
	 *            - Nombre del producto
	 * @return - Un producto filtrado por su nombre
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado el producto en base de datos filtrando por su nombre
	 */

	@GetMapping("/name/{name}")
	public Object getObjectByName(@PathVariable String name) throws NotFoundException {
		return service.findObjectByName(name);
	}

	/**
	 * Endpoint getObjectsByType que filtra los productos en base de datos por su tipo de producto
	 * 
	 * @param type
	 *            - Tipo de producto
	 * @return - Todos los productos disponibles en base de datos filtrando por el tipo de producto
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado ningún producto en base de datos filtrándo por el
	 *             tipo de producto
	 */

	@GetMapping("/type/{type}")
	public List<Object> getObjectsByType(@PathVariable String type) throws NotFoundException {
		return service.findObjectsByType(type);
	}

	/**
	 * Endpoint getObjectsByGeneration que filtra los productos en base de datos segun la generación en la que se
	 * introdujeron
	 * 
	 * @param generation
	 *            - Número de generación
	 * @return - Todos los productos introducidos en la generación pasada por parámetro
	 * @throws ExistException
	 *             - Excepción que se lanza si la generación pasada por parámetro no existe
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha introducido ningún artículo en la generación pasada por
	 *             parámetro
	 */

	@GetMapping("/generation/{generation}")
	public List<Object> getObjectsByGeneration(@PathVariable Integer generation) throws ExistException, NotFoundException {
		return service.findObjectsByGeneration(generation);
	}

}
