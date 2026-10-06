package br.edu.ifsp.livraria.testes;

import br.edu.ifsp.livraria.Autor;
import br.edu.ifsp.livraria.Catalogo;
import br.edu.ifsp.livraria.CarrinhoDeCompras;
import br.edu.ifsp.livraria.produtos.Livro;
import java.time.LocalDate;


public class CadastroDeLivros {
    public static void main(String[] args) {
        Autor turini = new Autor("Rodrigo Turini");
        Livro desbravando = new Livro(turini);
        desbravando.setNome("Desbravando Java ");
        desbravando.setValor(59.90);

        Livro cabeca = new Livro(new Autor("Kathy Sierra"));
        cabeca.setNome("Use a Cabeca! Java");
        cabeca.setValor(89.00);

        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.adiciona(desbravando);
        carrinho.adiciona(cabeca);

        System.out.println("Livros cadastrados: " + Livro.getTotalCadastrados());
        System.out.println("Total do carrinho: " + carrinho.getTotal());

        // Teste da Etapa 1: acrescente ao final do main
        System.out.println("--- Etapa 1 ---");
        Livro livro = new Livro(new Autor("Herbert Schildt"));
        livro.setNome("   java para iniciantes  ");
        System.out.println("[" + livro.getNome() + "]");
        System.out.println(livro.setIsbn("978-85-66250-46-6"));
        System.out.println(livro.setIsbn("978-85-662"));
        System.out.println(livro.setIsbn("978-85-6625A-46-6"));
        System.out.println(livro.getIsbn());
        System.out.println(livro.setValor("59.90"));
        System.out.println(livro.setValor("59,90"));
        System.out.println(livro.setValor("abc"));
        System.out.println(livro.getValor());

        // Teste da Etapa 2: acrescente ao final do main e importe java.time.LocalDate
        System.out.println("--- Etapa 2 ---");
        livro.setDataPublicacao(LocalDate.of(2014, 1, 15));
        System.out.println(livro.anosDesdeAPublicacao(LocalDate.of(2026, 10, 1)));
        System.out.println(livro.anosDesdeAPublicacao(LocalDate.of(2024, 1, 14)));
        livro.mostrarDetalhes();

        // Teste da Etapa 3: acrescente ao final do main
        System.out.println("--- Etapa 3 ---");
        carrinho.adiciona(livro);
        System.out.println(carrinho.getQuantidade());
        System.out.println(carrinho.getTotal());
        carrinho.remove(0);
        System.out.println(carrinho.getQuantidade());
        System.out.println(carrinho.getTotal());
        carrinho.remove(livro);
        System.out.println(carrinho.getQuantidade());
        for (Livro item : carrinho.getLivros()) {
            System.out.println(item.getNome());
        }

        // Teste da Etapa 4: acrescente ao final do main e importe Catalogo
        System.out.println("--- Etapa 4 ---");
        desbravando.setDataPublicacao(LocalDate.of(2014, 1, 15));
        cabeca.setDataPublicacao(LocalDate.of(2005, 5, 20));
        Catalogo catalogo = new Catalogo();
        catalogo.cadastra(desbravando);
        catalogo.cadastra(cabeca);
        catalogo.cadastra(livro);
        System.out.println(catalogo.getTotalDeLivros());
        System.out.println(catalogo.buscaPorTitulo("  desbravando java ").getNome());
        System.out.println(catalogo.buscaPorTitulo("Java Avancado"));
        System.out.println(catalogo.buscaPorTrecho("java").size());
        System.out.println(catalogo.publicadosAntes(LocalDate.of(2010, 1, 1)).size());
        System.out.println(catalogo.adicionaCategoria("  Programacao "));
        System.out.println(catalogo.adicionaCategoria("programacao"));
        System.out.println(catalogo.adicionaCategoria("Java"));
        System.out.println(catalogo.getCategorias());
    }
}