package com.example.projetoDioBancoDeDados.service;

import com.example.projetoDioBancoDeDados.Entity.Cartao;
import com.example.projetoDioBancoDeDados.Repository.CartaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartaoService {

    @Autowired
    CartaoRepositorio cartaoRepositorio;

    @Transactional
    public void acessarCartao(Long id) {
        String bloqueado;
        for(Cartao item : cartaoRepositorio.findAll()){
            if(item.getId().equals(id)){
                if(item.isBloqueado()){
                    bloqueado = "Bloqueado";

                }else {
                    bloqueado = "Desbloqueado";
                }

                System.out.println("Cartão: " + item.getNome() + "Status: " + bloqueado );

            }
        }
    }
}
