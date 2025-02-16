package com.example.proyecto1.controller;

import com.example.proyecto1.bd.ORM.NombresORM;
import com.example.proyecto1.controller.DTO.NombresDTO;
import com.example.proyecto1.logica.NombresService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/backend")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class NombresController {

    private final NombresService nombresService;

    @PostMapping(path = "/nombre")
    public String guardarNombre(@RequestBody NombresDTO nombre) {
        nombresService.guardar(nombre);
        return "Nombre guardado correctamente";
    }

    @GetMapping(path = "/nombres")
    public List<NombresORM> obtenerNombres() {
        return nombresService.obtenerTodos();
    }
}