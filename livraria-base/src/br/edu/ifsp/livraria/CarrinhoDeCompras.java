package br.edu.ifsp.livraria;

import br.edu.ifsp.livraria.produtos.Livro;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private ArrayList<Livro> livros = new ArrayList<>();

    public void adiciona(Livro livro) {
        this.livros.add(livro);
    }

    public void remove(int posicao) {
        this.livros.remove(posicao);
    }

    public void remove(Livro livro){
        this.livros.remove(livro);
    }

    public double getTotal() {
        double total = 0;
        for (Livro livro : this.livros) {
            total += livro.getValor();
        }
        return total;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public int getQuantidade(){
        return livros.size();
    }

}