package com.pokeEcommerceApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.pokeEcommerceApi.exception.ExistException;
import com.pokeEcommerceApi.exception.NotFoundException;
import com.pokeEcommerceApi.model.TrainerCard;
import com.pokeEcommerceApi.repository.TrainerCardRepository;
import com.pokeEcommerceApi.service.implement.TrainerCardService;

@Service
public class TrainerCardServiceImpl implements TrainerCardService {

	@Autowired
	private TrainerCardRepository repoTrainer;

	@Override
	public List<TrainerCard> findAllTrainers() throws NotFoundException {
		try {
			List<TrainerCard> allTrainer = repoTrainer.findAll();

			if (allTrainer.isEmpty()) {
				throw new NotFoundException("No se han encontrado ninguna tienda Pokémon");
			}
			return allTrainer;
		}
		catch (DataAccessException e) {
			throw new NotFoundException("Error consultando todos los entrenadores Pokémon", e);
		}
	}

	@Override
	public TrainerCard findTrainerByName(String name) throws NotFoundException {
		try {
			Optional<TrainerCard> optional = repoTrainer.findByTrainerNameIgnoreCase(name);

			if (!optional.isPresent()) {
				throw new NotFoundException("No se ha encontrado ningún entrenador Pokémon con ese nombre");
			}

			return optional.get();
		}
		catch (DataAccessException e) {
			throw new NotFoundException("Error consultando un entrenador Pokémon por su nombre");
		}
	}

	@Override
	public TrainerCard createTrainer(TrainerCard newTrainer) throws ExistException {
		return repoTrainer.save(newTrainer);
	}

	@Override
	public void updateTrainer(Integer id, TrainerCard trainer) throws NotFoundException {

		try {
			TrainerCard existingTrainer = repoTrainer.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado ningún entrenador Pokémon con ese ID"));

			existingTrainer.setTrainerName(trainer.getTrainerName());
			existingTrainer.setMoney(trainer.getMoney());

			repoTrainer.save(existingTrainer);
		}
		catch (DataAccessException e) {
			throw new NotFoundException("Error actualizando un entrenador Pokémon ", e);
		}
	}

	@Override
	public void deleteTrainer(Integer id) throws NotFoundException {

		try {
			Optional<TrainerCard> optional = repoTrainer.findById(id);

			if (!optional.isPresent()) {
				throw new NotFoundException("No se ha encontrado ningún entrenador Pokémon con ese ID");
			}

			TrainerCard deleteTrainer = optional.get();

			repoTrainer.delete(deleteTrainer);

		}
		catch (DataAccessException e) {
			throw new NotFoundException("Error borrando un entrenador Pokémon ", e);
		}
	}

}
