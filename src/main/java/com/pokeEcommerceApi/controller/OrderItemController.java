package com.pokeEcommerceApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokeEcommerceApi.exception.NotFoundException;
import com.pokeEcommerceApi.model.OrderItem;
import com.pokeEcommerceApi.service.implement.OrderItemService;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

	@Autowired
	private OrderItemService service;

	/**
	 * Endpoint getAllOrderItems que devuelve todos los detalles de pedidos disponibles en base de datos
	 * 
	 * @return - Todos los detalles de pedidos disponibles en base de datos
	 * @throws NotFoundException
	 *             - Excepción que se lanza si no se ha encontrado ningún detalle de pedido en base de datos
	 */

	@GetMapping
	public List<OrderItem> getAllOrderItems() throws NotFoundException {
		return service.findAllOrderItems();
	}

}
