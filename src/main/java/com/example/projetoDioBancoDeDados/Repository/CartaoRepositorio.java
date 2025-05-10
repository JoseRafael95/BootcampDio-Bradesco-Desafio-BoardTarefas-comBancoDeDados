package com.example.projetoDioBancoDeDados.Repository;

import com.example.projetoDioBancoDeDados.Entity.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepositorio extends JpaRepository<Cartao, Long> {
    Cartao findByColunaId(Long id);
}
