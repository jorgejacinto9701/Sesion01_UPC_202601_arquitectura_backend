package com.empresa.service;

import java.util.List;

import com.empresa.entity.Cliente;

public interface ClienteService {

	public List<Cliente> listaClientesPorDni(String dni);
	
}
