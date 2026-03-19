package com.empresa.service;

import java.time.LocalDateTime;
import java.util.List;

import com.empresa.entity.Cliente;

public interface ClienteService {

	public List<Cliente> listaClientesPorDni(String dni);
	
	public List<Cliente> listaClientesPorNombreLike(String nombre);
	public List<Cliente> listaClientesPorNombreStartingWith(String nombre);
	public List<Cliente> listaClientesPorEstado(int estado);
	public List<Cliente> listaClientesPorFechaRegistroBefore(LocalDateTime fecha);
}
