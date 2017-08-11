package model;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Cliente {

    private int id;
    @NotNull
//    @Size(min = 2, max = 50, message = "errow")
    @Size(min = 2, max = 50)
    private String nome;

    private String login;
    private String senha;
    @Size(min = 4, max = 11)
    private String cpf;

    public Cliente() {

    }

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
