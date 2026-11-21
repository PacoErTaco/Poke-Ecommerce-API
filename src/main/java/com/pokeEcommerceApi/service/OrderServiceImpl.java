package com.pokeEcommerceApi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pokeEcommerceApi.exception.ExistException;
import com.pokeEcommerceApi.exception.MoneyException;
import com.pokeEcommerceApi.exception.NotFoundException;
import com.pokeEcommerceApi.model.Object;
import com.pokeEcommerceApi.model.Order;
import com.pokeEcommerceApi.model.OrderItem;
import com.pokeEcommerceApi.model.TrainerCard;
import com.pokeEcommerceApi.repository.ObjectRepository;
import com.pokeEcommerceApi.repository.OrderRepository;
import com.pokeEcommerceApi.repository.TrainerCardRepository;
import com.pokeEcommerceApi.service.implement.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository repoOrder;
	@Autowired
	private TrainerCardRepository repoTrainer;
	@Autowired
	private ObjectRepository repoObject;

	@Override
	public List<Order> findAllOrders() throws NotFoundException {
		try {
			List<Order> allOrder = repoOrder.findAll();

			if (allOrder.isEmpty()) {
				throw new NotFoundException("No se ha encontrado ningún pedido");
			}

			return allOrder;
		}
		catch (DataAccessException e) {
			throw new NotFoundException("Error consultando todos los pedidos");
		}

	}

	@Override
	public List<Order> findOrdersByDate(LocalDate date) throws NotFoundException {
		try {
			List<Order> byDate = repoOrder.findByOrderDate(date);

			if (byDate.isEmpty()) {
				throw new NotFoundException("No se ha encontrado ningún pedido en esa fecha");
			}

			return byDate;
		}
		catch (DataAccessException e) {
			throw new NotFoundException("Error consultando los pedidos por su fecha");
		}
	}

	@Override
	public List<Order> findOrdersByStatus(String status) throws NotFoundException {
		try {
			List<Order> byStatus = repoOrder.findByStatus(status);

			if (byStatus.isEmpty()) {
				throw new NotFoundException("No se ha encontrado ningún pedido en ese estado");
			}

			return byStatus;
		}
		catch (DataAccessException e) {
			throw new NotFoundException("Error consultando los pedidos por su estado");
		}
	}

	@Override
	@Transactional
	public Order createOrder(Order order) throws NotFoundException, MoneyException {

		TrainerCard trainer = repoTrainer.findById(order.getTrainer().getId()).orElseThrow(() -> new NotFoundException("No se ha encontrado ningún entrenador con ese ID"));

		order.setTrainer(trainer);
		order.setOrderDate(LocalDate.now());
		order.setStatus("EN CURSO");

		Integer totalPokemonDollar = 0;

		for (OrderItem item : order.getItems()) {
			Object object = repoObject.findById(item.getObject().getId()).orElseThrow(() -> new NotFoundException("No se ha encontrado ningún producto con ese ID"));

			item.setOrder(order);
			item.setObject(object);
			item.setPokemonDollar(object.getPokemonDollar());

			totalPokemonDollar += object.getPokemonDollar() * item.getAmount();
		}

		if (trainer.getMoney() < totalPokemonDollar) {
			throw new MoneyException("No tienes suficiente dinero");
		}
		trainer.setMoney(trainer.getMoney() - totalPokemonDollar);
		repoTrainer.save(trainer);

		order.setTotalPokemonDollar(totalPokemonDollar);
		return repoOrder.save(order);
	}

	@Override
	@Transactional
	public Order changeOrderStatus(Integer id) throws NotFoundException, ExistException {
		Order order = repoOrder.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado ningún pedido con ese ID"));
		
		if (order.getStatus().equalsIgnoreCase("COMPLETADO")) {
			throw new ExistException("Este pedido ya está completado");
		}
		
		order.setStatus("COMPLETADO");
		
		return repoOrder.save(order);
	}

}
