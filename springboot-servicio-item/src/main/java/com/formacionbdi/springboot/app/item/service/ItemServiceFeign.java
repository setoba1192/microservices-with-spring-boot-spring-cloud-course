package com.formacionbdi.springboot.app.item.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.formacionbdi.springboot.app.item.clientes.ProductoClienteRest;
import com.formacionbdi.springboot.app.item.models.Item;

@Service("itemServiceFeign")
public class ItemServiceFeign implements ItemService {

	@Autowired
	ProductoClienteRest clienteRest;

	@Override
	public List<Item> findAll() {
		return clienteRest.listar().stream().map(producto -> new Item(producto, 1)).collect(Collectors.toList());
	}

	public Item findById(Long id, Integer cantidad) {
		return new Item(clienteRest.detalle(id), cantidad);
	}

}
