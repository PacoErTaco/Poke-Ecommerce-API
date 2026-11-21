package com.pokeEcommerceApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.pokeEcommerceApi.exception.NotFoundException;
import com.pokeEcommerceApi.model.OrderItem;
import com.pokeEcommerceApi.repository.OrderItemRepository;
import com.pokeEcommerceApi.service.implement.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepository repoOrderItem;

	@Override
	public List<OrderItem> findAllOrderItems() throws NotFoundException {
		try {
			List<OrderItem> allOrderItem = repoOrderItem.findAll();

			if (allOrderItem.isEmpty()) {
				throw new NotFoundException("No se ha encontrado ningún detalle de pedido");
			}

			return allOrderItem;
		}
		catch (DataAccessException e) {
			throw new NotFoundException("Error consultando todos los detalles de pedidos");
		}
	}

}
