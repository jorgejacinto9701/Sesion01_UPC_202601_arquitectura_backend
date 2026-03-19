package com.empresa.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	
	//Usando JPQL (Java Persistence Query Language)
	@Query("select c from Cliente c where c.dni = ?1")
	public List<Cliente> listaClientesPorDni(String dni);
	
	//Usando Query Method
	public List<Cliente> findByNombreLike(String nombre);
	public List<Cliente> findByNombreStartingWith(String nombre);
	public List<Cliente> findByEstado(int estado);
	public List<Cliente> findByFechaRegistroBefore(LocalDateTime fecha);
}
