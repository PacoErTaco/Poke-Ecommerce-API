package com.pokeEcommerceApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.pokeEcommerceApi.model.Object;
import com.pokeEcommerceApi.exception.ExistException;
import com.pokeEcommerceApi.exception.NotFoundException;
import com.pokeEcommerceApi.repository.ObjectRepository;
import com.pokeEcommerceApi.service.implement.ObjectService;


@Service
public class ObjectServiceImpl implements ObjectService {
	private static final Integer MAXGENERATION = 9;

	@Autowired
	private ObjectRepository repoObject;

	@Override
	public List<Object> findAllObjects() throws NotFoundException {

		try {
			List<Object> allObject = repoObject.findAll();

			if (allObject.isEmpty()) {
				throw new NotFoundException("No se ha encontrado ningún artículo");
			}

			return allObject;
		}
		catch (DataAccessException e) {
			throw new NotFoundException("Error al consultar los artículos ", e);
		}

	}

	@Override
	public Object findObjectByName(String name) throws NotFoundException {
		try {
			Optional<Object> byName = repoObject.findByObjectNameIgnoreCase(name);

			if (!byName.isPresent()) {
				throw new NotFoundException("No se ha encontrado ningún artículo con ese nombre");
			}

			Object objectName = byName.get();

			return objectName;
		}
		catch (DataAccessException e) {
			throw new NotFoundException("Error consultando un artículo por su nombre");
		}
	}

	@Override
	public List<Object> findObjectsByType(String type) throws NotFoundException {
		try {
			List<Object> byType = repoObject.findByObjectTypeIgnoreCase(type);

			if (byType.isEmpty()) {
				throw new NotFoundException("No se ha encontrado ningún artículo con ese tipo");
			}

			return byType;
		}
		catch (DataAccessException e) {
			throw new NotFoundException("Error consultando por tipo de artículo");
		}
	}

	@Override
	public List<Object> findObjectsByGeneration(Integer generation) throws ExistException, NotFoundException {
		try {
			List<Object> byGeneration = repoObject.findByGeneration(generation);
			
			if (generation > MAXGENERATION) {
				throw new ExistException("Todavía no ha salido esa generación de Pokémon");
			}
			
			else if (byGeneration.isEmpty()) {
				throw new NotFoundException("No se ha encontrado ningún artículo incluido en esta generación");
			}
			
			return byGeneration;
		}
		catch (DataAccessException e) {
			throw new ExistException("Error consultando artículos por número de generación");
		}
	}

}
