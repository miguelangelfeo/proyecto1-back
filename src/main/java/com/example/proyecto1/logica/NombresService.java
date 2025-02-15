package com.example.proyecto1.logica;

import com.example.proyecto1.bd.JPA.NombresJPA;
import com.example.proyecto1.bd.ORM.NombresORM;
import com.example.proyecto1.controller.DTO.NombresDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NombresService {
    private final NombresJPA nombresJPA;

    public NombresService(NombresJPA nombresJPA) {
        this.nombresJPA = nombresJPA;
    }

    public NombresORM guardar(NombresDTO nombre) {
        return nombresJPA.save(new NombresORM(nombre.nombre()));
    }

    public List<NombresORM> obtenerTodos() {
        return nombresJPA.findAll();
    }
}
