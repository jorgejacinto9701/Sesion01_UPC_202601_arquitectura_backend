package com.empresa.controller;

import com.empresa.entity.Alumno;
import com.empresa.entity.Tipo;
import com.empresa.service.AlumnoService;
import com.empresa.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/tipo")
public class TipoController {


    @Autowired
    private TipoService service;

    @GetMapping("/porId/{filtro}")
    @ResponseBody
    public ResponseEntity<List<Tipo>> listaPorEmail(@PathVariable("filtro") int filtro){
        List<Tipo> lista = service.listaPorId(filtro);
        return ResponseEntity.ok(lista);
    }
}
