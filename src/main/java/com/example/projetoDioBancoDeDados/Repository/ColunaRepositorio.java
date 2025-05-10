package com.example.projetoDioBancoDeDados.Repository;


import com.example.projetoDioBancoDeDados.Entity.Colunas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColunaRepositorio extends JpaRepository<Colunas, Long> {

}