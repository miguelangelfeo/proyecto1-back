package com.example.proyecto1.bd.JPA;


import com.example.proyecto1.bd.ORM.NombresORM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NombresJPA extends JpaRepository<NombresORM, Long> {



}
