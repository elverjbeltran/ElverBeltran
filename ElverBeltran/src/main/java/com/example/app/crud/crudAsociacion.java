package com.example.app.crud;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.app.variables.Asociacion;


public interface crudAsociacion extends JpaRepository<Asociacion, Long> {

}