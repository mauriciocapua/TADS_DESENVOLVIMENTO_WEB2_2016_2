package model;

import java.util.List;

public class Cliente {

    private int id;
    private String nome;
    private List<Dependente> dependentes;

    public Cliente() {

    }

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Cliente(int id, String nome, List<Dependente> dependentes) {
        this.id = id;
        this.nome = nome;
        this.dependentes = dependentes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

}
