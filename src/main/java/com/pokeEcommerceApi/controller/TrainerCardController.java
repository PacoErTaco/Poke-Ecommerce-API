package com.pokeEcommerceApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokeEcommerceApi.exception.ExistException;
import com.pokeEcommerceApi.exception.NotFoundException;
import com.pokeEcommerceApi.model.TrainerCard;
import com.pokeEcommerceApi.service.implement.TrainerCardService;

@RestController
@RequestMapping("/trainer")
public class TrainerCardController {

	@Autowired
	private TrainerCardService service;

	/**
	 * Endpoint getAllTrainers que devuelve todos los entrenadores Pokémon en base de datos
	 * 
	 * @return - Todos los entrenadores Pokémon en base de datos
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado ningún entrenador Pokémon en base de datos
	 */

	@GetMapping
	public List<TrainerCard> getAllTrainer() throws NotFoundException {
		return service.findAllTrainers();
	}

	/**
	 * Endpoint getTrainerByName que filtra por el nombre de un entrenador Pokémon
	 * 
	 * @param trainerName
	 *            - Nombre del entrenador Pokémon
	 * @return - Entrenador Pokémon encontrado filtrando por su nombre
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado ningún entrenador Pokémon con el nombre pasado por
	 *             parámetro
	 */

	@GetMapping("/name/{name}")
	public TrainerCard getTrainerByName(@PathVariable String trainerName) throws NotFoundException {
		return service.findTrainerByName(trainerName);
	}

	/**
	 * Endpoint createTrainer que crea un entrenador Pokémon nuevo en base de datos
	 * 
	 * @param newTrainer
	 *            - Nuevo entrenador que se quiere crear
	 * @return - Nuevo entrenador creado
	 * @throws ExistException
	 *             - Excepción que se lanza si alguno de los datos pertenecientes al nuevo entrenador ya existen en base
	 *             de datos
	 */

	@PostMapping
	public TrainerCard createTrainer(@RequestBody TrainerCard newTrainer) throws ExistException {
		return service.createTrainer(newTrainer);
	}

	/**
	 * Endpoint updateTrainer que actualiza los datos de un entrenador Pokémon en base de datos
	 * 
	 * @param id
	 *            - ID del entrenador Pokémon que se quiere actualizar
	 * @param newtrainerData
	 *            - Datos actualizados del entrenador Pokémon
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado el entrenador Pokémon filtrándolo en este caso por su
	 *             ID en base de datos
	 */

	@PutMapping("/id/{id}")
	public void updateTrainer(@PathVariable Integer id, @RequestBody TrainerCard newtrainerData) throws NotFoundException {
		service.updateTrainer(id, newtrainerData);
	}

	/**
	 * Endpoint deleteTrainer que borra un entrenador Pokémon en base de datos
	 * 
	 * @param id
	 *            - ID del entrenador Pokémon que se quiere borrar
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado el ID pasado por parámetro del entrenador Pokémon
	 */

	@DeleteMapping("/id/{id}")
	public void deleteTrainer(@PathVariable Integer id) throws NotFoundException {
		service.deleteTrainer(id);
	}

}
