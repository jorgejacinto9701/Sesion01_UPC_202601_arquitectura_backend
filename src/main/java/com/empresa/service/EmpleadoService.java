package com.empresa.service;

import java.time.LocalDate;
import java.util.List;

import com.empresa.entity.Empleado;

public interface EmpleadoService {

	public List<Empleado> listaEmpleadoPorFechaNacimientoBefore(LocalDate fecha);
}
