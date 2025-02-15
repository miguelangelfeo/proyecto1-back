package com.example.proyecto1.controller;


import com.example.proyecto1.bd.JPA.NombresJPA;
import com.example.proyecto1.bd.ORM.NombresORM;
import com.example.proyecto1.controller.DTO.NombresDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/backend")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
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
