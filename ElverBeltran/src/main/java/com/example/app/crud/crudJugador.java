package com.example.app.crud;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.app.variables.Jugador;

public interface crudJugador extends JpaRepository<Jugador, Long>{
 
}
