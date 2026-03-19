package com.empresa.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Cliente;
import com.empresa.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> listaClientesPorDni(String dni) {
		return clienteRepository.listaClientesPorDni(dni);
	}

	@Override
	public List<Cliente> listaClientesPorNombreLike(String nombre) {
		return clienteRepository.findByNombreLike(nombre);
	}

	@Override
	public List<Cliente> listaClientesPorNombreStartingWith(String nombre) {
		return clienteRepository.findByNombreStartingWith(nombre);
	}

	@Override
	public List<Cliente> listaClientesPorEstado(int estado) {
		return clienteRepository.findByEstado(estado);
	}

	@Override
	public List<Cliente> listaClientesPorFechaRegistroBefore(LocalDateTime fecha) {
		return clienteRepository.findByFechaRegistroBefore(fecha);
	}

}
