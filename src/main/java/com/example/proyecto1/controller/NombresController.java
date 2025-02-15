package com.example.proyecto1.controller;

import com.example.proyecto1.bd.ORM.NombresORM;
import com.example.proyecto1.controller.DTO.NombresDTO;
import com.example.proyecto1.logica.NombresService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/backend/datos")
@CrossOrigin(origins = "*")
public class NombresController {

    private final NombresService nombresService;

    @PostMapping
    public String guardarEstudiante(@RequestBody NombresDTO nombre) {
        nombresService.guardar(nombre);
        return "Nombre guardado";
    }

    @GetMapping
    public List<NombresORM> obtenerEstudiantesBD() {
        return nombresService.obtenerTodos();
    }
}
