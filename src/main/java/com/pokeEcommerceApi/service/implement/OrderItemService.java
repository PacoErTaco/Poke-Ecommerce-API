package com.pokeEcommerceApi.service.implement;

import java.util.List;

import com.pokeEcommerceApi.exception.NotFoundException;
import com.pokeEcommerceApi.model.OrderItem;

public interface OrderItemService {

	/**
	 * Método findAllOrderItems que devuelve una lista de todas las líneas de detalle de los pedidos
	 * 
	 * @return - Lista de todas las líneas de detalle de los pedidos
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado ningún detalle de pedido
	 */
	List<OrderItem> findAllOrderItems() throws NotFoundException;

}
