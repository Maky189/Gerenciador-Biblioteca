package com.biblioteca.model;

// This class handles the usuario objects operations and has its getters and setters too
public class Usuario {
    private String id;
    private String nome;
    private String email;
    private String numero;

    public Usuario() {}

    public Usuario(String id, String nome, String email, String numero) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.numero = numero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getnumero() {
        return numero;
    }

    public void setnumero(String numero) {
        this.numero = numero;
    }

    public void remover(String nome) {
        this.id = null;
        this.email = null;
        this.nome = null;
    }
}
 