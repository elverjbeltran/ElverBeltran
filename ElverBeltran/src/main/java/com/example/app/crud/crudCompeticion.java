package com.example.app.crud;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.app.variables.Competicion;

public interface crudCompeticion extends JpaRepository<Competicion, Long> {

}
