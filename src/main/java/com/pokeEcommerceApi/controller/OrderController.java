package com.pokeEcommerceApi.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokeEcommerceApi.exception.ExistException;
import com.pokeEcommerceApi.exception.MoneyException;
import com.pokeEcommerceApi.exception.NotFoundException;
import com.pokeEcommerceApi.model.Order;
import com.pokeEcommerceApi.service.implement.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService service;

	/**
	 * Endpoint getAllOrders que devuelve todos los pedidos realizados en base de datos
	 * 
	 * @return - Todos los pedidos realizados en base de datos
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha realizado ningún pedido en base de datos
	 */

	@GetMapping
	public List<Order> getAllOrders() throws NotFoundException {
		return service.findAllOrders();
	}

	/**
	 * Endpoint getOrdersByDate que devuelve todos los pedidos realizados en una fecha específica
	 * 
	 * @param date
	 *            - Fecha en la que se realizó el/los pedidos
	 * @return - Todos los pedidos realizados en una fecha específica
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha realizado ningún pedido en la fecha pasada por parámetro
	 */

	@GetMapping("/date/{date}")
	public List<Order> getOrdersByDate(@PathVariable LocalDate date) throws NotFoundException {
		return service.findOrdersByDate(date);
	}

	/**
	 * Endpoint getOrderByStatus que devuelve todos los pedidos cuyo estado coincida con el que se pasa por parámetro
	 * 
	 * @param status
	 *            - Estado actual del pedido (Completado o En curso)
	 * @return - Todos los pedidos filtrando por su estado
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado ningún pedido con el estado pasado por parámetro
	 */

	@GetMapping("/status/{status}")
	public List<Order> getOrdersByStatus(@PathVariable String status) throws NotFoundException {
		return service.findOrdersByStatus(status);
	}

	/**
	 * Endpoint createOrder que crea un pedido nuevo en base de datos
	 * 
	 * @param newOrder
	 *            - Nuevo pedido que se quiere realizar
	 * @return - Pedido nuevo realizado/creado
	 * @throws NotFoundException - Excepción que se lanza si no existe
	 * un entrenador o producto con el ID indicado
	 * @throws MoneyException - Excepción que se lanza si el entrenador
	 * que realiza el pedido no tiene suficiente dinero para pagarlo
	 */

	@PostMapping
	public Order createOrder(@RequestBody Order newOrder) throws NotFoundException, MoneyException {
		return service.createOrder(newOrder);
	}

	/**
	 * Endpoint changeOrderStatus que cambia el estado de un pedido
	 * en curso a completado
	 * @param id - ID del pedido cuyo estado se quiere cambiar
	 * @return - El estado del pedido cambiado a completado
	 * @throws NotFoundException - Excepción que se lanza si no
	 * se ha encontrado ningún pedido con el ID indicado
	 * @throws ExistException - Excepción que se lanza si el pedido
	 * ya está completado
	 */
	@PutMapping("/id/status/{id}")
	public Order changeOrderStatus(@PathVariable Integer id) throws NotFoundException, ExistException {
		return service.changeOrderStatus(id);
	}
	
}
