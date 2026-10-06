package br.edu.ifsp.livraria.produtos;

import br.edu.ifsp.livraria.Autor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;


public class Livro {
    public static final double DESCONTO_MAXIMO = 0.3;
    private static int totalCadastrados;

    private String nome;
    private String isbn;
    private double valor;
    private Autor autor;
    private LocalDate dataPublicacao;

    private static final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Livro(Autor autor) {
        this.autor = autor;
        totalCadastrados++;
    }

    public boolean aplicaDescontoDe(double porcentagem) {
        if (porcentagem > DESCONTO_MAXIMO) {
            System.out.println("Desconto acima do permitido");
            return false;
        }
        this.valor -= this.valor * porcentagem;
        return true;
    }

    public void mostrarDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("ISBN: " + isbn);
        System.out.printf("Valor: R$ %.2f%n", valor);
        if(dataPublicacao != null){
            System.out.println("Publicado em: " + dataPublicacao.format(FORMATADOR));
        }
        System.out.println("Autor: " + autor.getNome());
        System.out.println("--");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().toUpperCase();
    }

    public String getIsbn() {
            return isbn;
    }

    public boolean setIsbn(String isbn) {
        if(isbnValido(isbn)){
            this.isbn = isbn.replace("-", "");
            return true;
        }
        return false;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean setValor(String texto){
        try {
            if(Double.parseDouble(texto) < 0){
                return false;
            }
            this.valor = Double.parseDouble(texto);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public Autor getAutor() {
        return autor;
    }

    public static int getTotalCadastrados() {
        return totalCadastrados;
    }

    public static boolean isbnValido(String isbn){
        if(isbn == null) {
            return false;
        }

        String paulinho = isbn.replace("-", "");

        if(paulinho.length() != 13){
            return false;
        }

        for (int i = 0; i < paulinho.length(); i++){
            char c = paulinho.charAt(i);

            if(!Character.isDigit(c)){
                return false;
            }
        }

        return true;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public int anosDesdeAPublicacao(LocalDate referencia){


        Period periodo = Period.between(this.dataPublicacao, referencia);
        int anos = periodo.getYears();

        return anos;
    }

    public int anosDesdeAPublicacao(){
        LocalDate hoje = LocalDate.now();
        return anosDesdeAPublicacao(hoje);
    }


}