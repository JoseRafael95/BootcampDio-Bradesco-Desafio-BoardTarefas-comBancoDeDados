package com.example.projetoDioBancoDeDados.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Painel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String name;

    private String status;

    @OneToMany(mappedBy = "painel", cascade = CascadeType.ALL)
    private List<Colunas> colunas;

    public Painel() {

    }

    public Painel(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Colunas> getColunas() {
        return colunas;
    }

    public void setColunas(List<Colunas> colunas) {
        this.colunas = colunas;
    }

}
