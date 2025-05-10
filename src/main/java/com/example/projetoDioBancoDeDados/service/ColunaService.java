package com.example.projetoDioBancoDeDados.service;

import com.example.projetoDioBancoDeDados.Entity.Cartao;
import com.example.projetoDioBancoDeDados.Entity.Colunas;
import com.example.projetoDioBancoDeDados.Entity.Painel;
import com.example.projetoDioBancoDeDados.Repository.CartaoRepositorio;
import com.example.projetoDioBancoDeDados.Repository.ColunaRepositorio;
import com.example.projetoDioBancoDeDados.Repository.PainelRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ColunaService {
    @Autowired
    PainelRepositorio painelRepositorio;

    @Autowired
    ColunaRepositorio colunaRepositorio;

    @Autowired
    CartaoRepositorio cartaoRepositorio;



    @Transactional
    public void adicionarColuna(String nomePainel,String nomeColuna){

        Painel painel = painelRepositorio.findByName(nomePainel);

        if(painel == null){
            System.out.println("painel nulo");
            return;
        }

        Colunas coluna = new Colunas();
        coluna.setNome(nomeColuna);
        coluna.setPainel(painel);
        coluna.setStatus("Listado");

        colunaRepositorio.save(coluna);
        painelRepositorio.save(painel);


    }
    @Transactional
    public void moverColuna(String nomePainel, String nomeColuna, String status){
        Painel painel = painelRepositorio.findByName(nomePainel);
        for (Colunas item : painel.getColunas()){
            if(item.getNome().equalsIgnoreCase(nomeColuna)){
                String statusAnterior = item.getStatus();
                item.setStatus(status);
                System.out.println(statusAnterior + " --> " + status);
            }
        }
    }

    @Transactional
    public void excluirColuna(String nomePainel, String nomeColuna){
        boolean encontrado = false;

        Painel painel = painelRepositorio.findByName(nomePainel);
        for(Colunas item : painel.getColunas()) {
            if(item.getNome().equalsIgnoreCase(nomeColuna)) {
                colunaRepositorio.deleteById(item.getId());
                  encontrado = true;
                  break;
            }
        }
        if(!encontrado){
            System.out.println("Não encontrado");
        }
    }

    @Transactional
    public void listarColuna(String nomePainel, String nomeColuna){
        Painel painel = painelRepositorio.findByName(nomePainel);
        for(Colunas item :painel.getColunas()) {
            System.out.println(item.getNome() + "-->" + item.getStatus());
        }
        }


}

