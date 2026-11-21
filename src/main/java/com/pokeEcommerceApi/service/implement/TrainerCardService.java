package com.pokeEcommerceApi.service.implement;

import java.util.List;
import com.pokeEcommerceApi.exception.ExistException;
import com.pokeEcommerceApi.exception.NotFoundException;
import com.pokeEcommerceApi.model.TrainerCard;

public interface TrainerCardService {

	/**
	 * Método findAllTrainers que devuelve una lista de todos los entrenadores registrados
	 * 
	 * @return - Lista de todos los entrenadores registrados
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado ningún entrenador
	 */
	List<TrainerCard> findAllTrainers() throws NotFoundException;

	/**
	 * Método findTrainerByName que devuelve un entrenador cuyo nombre es igual o parecido al que se le pasa por
	 * parámetro
	 * 
	 * @param name
	 *            - Nombre del entrenador
	 * @return - Entrenador cuyo nombre sea igual o coincidente al que se le pasa por parámetro
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado ningún entrenador
	 */
	TrainerCard findTrainerByName(String name) throws NotFoundException;

	/**
	 * Método createTrainer que crea un nuevo entrenador
	 * 
	 * @param newTrainer
	 *            - Nuevo entrenador
	 * @throws ExistException
	 *             - Excepción que se lanza si el nombre del nuevo entrenador ya existe.
	 */
	TrainerCard createTrainer(TrainerCard newTrainer) throws ExistException;

	/**
	 * Método updateTrainer que actualiza los datos de un entrenador
	 * 
	 * @param id
	 *            - ID del entrenador
	 * @param newTrainerData
	 *            - Entrenador al que se le van a actualizar los datos
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado ningún entrenador
	 */
	void updateTrainer(Integer id, TrainerCard newTrainerData) throws NotFoundException;

	/**
	 * Método deleteTrainer que borra a un entrenador según su ID.
	 * 
	 * @param id
	 *            - ID del entrenador que se quiere borrar
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado ningún entrenador
	 */
	void deleteTrainer(Integer id) throws NotFoundException;

}
