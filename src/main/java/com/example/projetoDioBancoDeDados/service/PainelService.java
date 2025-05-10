package com.example.projetoDioBancoDeDados.service;

import com.example.projetoDioBancoDeDados.Entity.Cartao;
import com.example.projetoDioBancoDeDados.Entity.Colunas;
import com.example.projetoDioBancoDeDados.Entity.Painel;
import com.example.projetoDioBancoDeDados.Repository.PainelRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PainelService {
    @Autowired
    PainelRepositorio painelRepositorio;

    @Autowired CartaoService cartaoService;

    Long idAtualPainel;



    public void listarPaineis(){

        for(Painel item : painelRepositorio.findAll()){
            Long id = item.getId();
            String nome = item.getName();
            String status = item.getStatus();

            System.out.println("Id: "+ id +" Nome: " + nome + " Status: " + status +"\n" );

        }

    }
    @Transactional
    public  void acessarTarefa(Long id){
        idAtualPainel = id;
        Optional<Painel> painel =  painelRepositorio.findById(id);
        List<Colunas> listaAtividade = painel.get().getColunas();
        for(Colunas item : listaAtividade){
            System.out.println(item.getNome() + " --> " + item.getStatus());
        }
    }

    @Transactional
    public void acessarAtividade( Long id){
        Optional<Painel> painel = painelRepositorio.findById(idAtualPainel);
        List<Colunas> listaAtividade = painel.get().getColunas();
        cartaoService.acessarCartao(id);
    }

    @Transactional
    public void adicionarPainel(String nome, String status){
        Painel painel = new Painel(nome, status);
           painelRepositorio.save(painel);
    }

    @Transactional
    public void adicionarAtividade(String nome, String status){
        Painel painel = painelRepositorio.getReferenceById(idAtualPainel);
        Colunas novaColuna = new Colunas(nome, status);
        novaColuna.setPainel(painel);
        painel.getColunas().add(novaColuna);

        painelRepositorio.save(painel);

    }





    public void excluirPainel(String nome) {
        Painel painel = painelRepositorio.findByName(nome);
        if (painel != null) {
            painelRepositorio.deleteById(painel.getId());
        } else {
            System.out.println("Painel não encontrado.");
        }
    }
}
