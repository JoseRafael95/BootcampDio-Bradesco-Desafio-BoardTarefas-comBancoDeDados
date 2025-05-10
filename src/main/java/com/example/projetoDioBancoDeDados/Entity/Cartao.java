package com.example.projetoDioBancoDeDados.Entity;

import jakarta.persistence.*;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private boolean Bloqueado = false;

    @ManyToOne
    @JoinColumn(name = "Coluna_id")
    private Colunas coluna;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isBloqueado() {
        return Bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        Bloqueado = bloqueado;
    }

    public Colunas getColuna() {
        return coluna;
    }

    public void setColuna(Colunas coluna) {
        this.coluna = coluna;
    }
}
