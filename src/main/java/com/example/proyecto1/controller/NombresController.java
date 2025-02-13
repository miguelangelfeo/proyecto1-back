package com.example.proyecto1.controller;


import com.example.proyecto1.bd.JPA.NombresJPA;
import com.example.proyecto1.bd.ORM.NombresORM;
import com.example.proyecto1.controller.DTO.NombresDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://104.248.106.174")
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class NombresController {

    private NombresJPA nombresJPA;
    List<NombresDTO> nombres = new ArrayList<>();


    @PostMapping(path = "/nombre")
    public String guardarEstudiante(@RequestBody NombresDTO nombre) {
        nombres.add(nombre);
        nombresJPA.save(new NombresORM(nombre.nombre()));
        return "Nombre guardado";
    }

    @GetMapping(path = "/nombres-bd")
    public List<NombresORM> obtenerEstudiantesBD() {
        return nombresJPA.findAll();
    }

}
