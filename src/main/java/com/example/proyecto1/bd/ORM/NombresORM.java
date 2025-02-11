package com.example.proyecto1.bd.ORM;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "nombres")
@Entity
@Data
@NoArgsConstructor
public class NombresORM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;

    public NombresORM(String nombre) {
        this.nombre = nombre;
    }
}
