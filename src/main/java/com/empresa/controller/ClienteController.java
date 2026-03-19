package com.empresa.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Cliente;
import com.empresa.service.ClienteService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/rest/cliente")
@Tag(name = "Cliente", description = "Operaciones sobre cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@GetMapping("/porDni/{filtro}")
	public ResponseEntity<List<Cliente>> listaClientesPorDni(@PathVariable("filtro") String parametro){
		List<Cliente> lista = service.listaClientesPorDni(parametro);
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/porNombreLike/{filtro}")
	public ResponseEntity<List<Cliente>> listaClientesPorNombreLike(@PathVariable("filtro") String parametro){
		List<Cliente> lista = service.listaClientesPorNombreLike(parametro+"%");
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/porNombreStartingWith/{filtro}")
	public ResponseEntity<List<Cliente>> listaClientesPorNombreStartingWith(@PathVariable("filtro") String parametro){
		List<Cliente> lista = service.listaClientesPorNombreStartingWith(parametro);
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/porEstado/{filtro}")
	public ResponseEntity<List<Cliente>> listaClientesPorEstado(@PathVariable("filtro") int parametro){
		List<Cliente> lista = service.listaClientesPorEstado(parametro);
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/porFechaRegistroBefore")
	public ResponseEntity<List<Cliente>> listaClientesPorFechaRegistroBefore(@RequestParam LocalDate fecha){
		List<Cliente> lista = service.listaClientesPorFechaRegistroBefore(fecha.atStartOfDay());
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/porFechaRegistroBefore2/{anio}-{mes}-{dia}")
	public ResponseEntity<List<Cliente>> listaClientesPorFechaRegistro(@PathVariable("anio") int paramAnio, 
										@PathVariable("mes") int paramMes, @PathVariable("dia") int paramDia){
		LocalDate fecha = LocalDate.of(paramAnio, paramMes, paramDia);
		List<Cliente> lista = service.listaClientesPorFechaRegistroBefore(fecha.atStartOfDay());
		return ResponseEntity.ok(lista);
	}
	
}
