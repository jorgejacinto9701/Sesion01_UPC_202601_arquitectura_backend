package com.empresa.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Empleado;
import com.empresa.service.EmpleadoService;

@RestController
@RequestMapping("/rest/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoService service;
	
	
	@GetMapping("/porFechaNacimientoBefore/{anio}-{mes}-{dia}")
	public  ResponseEntity<List<Empleado>> listaEmpleadoPorFechaNacimientoBefore(@PathVariable("anio") int paramAnio, 
													  @PathVariable("mes") int paramMes, 
													  @PathVariable("dia") int paramDia) {
		LocalDate fecha = LocalDate.of(paramAnio, paramMes, paramDia);
		List<Empleado> lista =  service.listaEmpleadoPorFechaNacimientoBefore(fecha);
		
		return ResponseEntity.ok(lista);
	}
}
