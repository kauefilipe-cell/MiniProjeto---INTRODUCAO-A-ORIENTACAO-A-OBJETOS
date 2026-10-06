package br.edu.ifsp.livraria;

public class Autor {
    private String nome;

    public Autor() {
    }

    public Autor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}