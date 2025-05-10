package com.example.projetoDioBancoDeDados.Repository;


import com.example.projetoDioBancoDeDados.Entity.Painel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PainelRepositorio  extends JpaRepository<Painel, Long> {
    Painel findByName(String name);
}