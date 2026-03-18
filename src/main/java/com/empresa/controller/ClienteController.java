package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
}
