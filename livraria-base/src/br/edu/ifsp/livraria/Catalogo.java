package br.edu.ifsp.livraria;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import br.edu.ifsp.livraria.produtos.Livro;

public class Catalogo {

    private List<Livro> livros;
    private List<String> categorias;

    public Catalogo() {
        this.livros = new ArrayList<>();
        this.categorias = new ArrayList<>();
    }

    public void cadastra(Livro livro){
        livros.add(livro);
    }

    public int getTotalDeLivros(){
        return livros.size();
    }

    public Livro buscaPorTitulo(String titulo){
        if(titulo == null){
            return null;
        }

        String titulo2 = titulo.trim().toLowerCase();

        for(Livro livro: livros){
            if(livro.getNome() != null){
                String TituloLivro = livro.getNome().trim().toLowerCase();

                if(TituloLivro.equals(titulo2)){
                    return livro;
                }
            }
        }
        return null;
    }

    public List<Livro> buscaPorTrecho(String trecho) {
        if(trecho == null){
            return null;
        }
        List <Livro> resultado = new ArrayList<>();

        String titulo2 = trecho.trim().toLowerCase();

        for(Livro livro: livros){
            if(livro.getNome() != null){
                String TituloLivro = livro.getNome().trim().toLowerCase();

                if(TituloLivro.contains(titulo2)){
                    resultado.add(livro);
                }
            }
        }
        return resultado;
    }

    public List<Livro> publicadosAntes(LocalDate limite){
        List <Livro> resultado = new ArrayList<>();

        for(Livro livro: livros){
            if(livro.getDataPublicacao()!= null){
                if(livro.getDataPublicacao().isBefore(limite)){
                    resultado.add(livro);
                }
            }
        }
        return resultado;
    }

    public boolean adicionaCategoria(String categoria){
        if(categoria == null){
            return false;
        }

        String categoriaPadrao = categoria.trim().toLowerCase();

        if(categorias.contains(categoriaPadrao)){
            return false;
        }

        categorias.add(categoriaPadrao);
        return true;
    }

    public List<String> getCategorias() {
        return categorias;
    }
}