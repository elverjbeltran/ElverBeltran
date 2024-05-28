package com.example.app.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.variables.Entrenador;

public interface crudEntrenador extends JpaRepository<Entrenador, Long> {

}
