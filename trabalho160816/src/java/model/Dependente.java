package model;

public class Dependente {

    private int id;
    private String nome;

    public Dependente() {

    }

    public Dependente(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Dependente(String nomeDependente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

}
