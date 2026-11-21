package com.pokeEcommerceApi.service.implement;

import java.time.LocalDate;
import java.util.List;

import com.pokeEcommerceApi.exception.ExistException;
import com.pokeEcommerceApi.exception.MoneyException;
import com.pokeEcommerceApi.exception.NotFoundException;
import com.pokeEcommerceApi.model.Order;

public interface OrderService {

	/**
	 * Método findAllOrders que devuelve una lista de todos los pedidos realizados
	 * 
	 * @return - Lista de todos los pedidos realizados
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se han encontrado pedidos
	 */
	List<Order> findAllOrders() throws NotFoundException;

	/**
	 * Método findOrdersByDate que devuelve una lista de pedidos filtrando por la fecha en la que se realizó dicho
	 * pedido
	 * 
	 * @param date
	 *            - Fecha en la que se realizó el pedido
	 * @return - Lista de todos los pedidos filtrando por la fecha en la que se realizaron
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado ningún pedido en la fecha indicada
	 */
	List<Order> findOrdersByDate(LocalDate date) throws NotFoundException;

	/**
	 * Método findOrderByStatus que devuelve una lista de pedidos filtrando por el estado de dicho pedido ("Completado"
	 * o "No completado")
	 * 
	 * @param status
	 *            - Estado del pedido ("Completado" o "No completado")
	 * @return - Lista de pedidos según su estado
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado ningún pedido en el estado indicado
	 */
	List<Order> findOrdersByStatus(String status) throws NotFoundException;

	/**
	 * Método createOrder que crea un nuevo pedido
	 * 
	 * @param newOrder
	 *            - Nuevo pedido
	 * @throws NotFoundException - Excepción que se lanza si no existe
	 * un entrenador o producto con el ID indicado
	 * @throws MoneyException - Excepción que se lanza si el entrenador
	 * que hace el pedido no tiene suficiente dinero para pagarlo
	 * @throws ExistException - Excepción que se lanza si el pedido ya
	 * está completado
	 */
	Order createOrder(Order newOrder) throws NotFoundException, MoneyException;

	/**
	 * Método changeOrderStatus que cambia el estado de un pedido
	 * en curso a completado
	 * @param id - ID del pedido cuyo estado se quiere cambiar
	 * @return - El estado del pedido cambiado a completado
	 * @throws NotFoundException - Excepción que se lanza si no
	 * se ha encontrado ningún pedido con el ID indicado
	 * @throws ExistException - Excepción que se lanza si el pedido
	 * ya está completado
	 */
	Order changeOrderStatus(Integer id) throws NotFoundException, ExistException;
	
}
