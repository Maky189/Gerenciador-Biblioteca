package com.biblioteca;

import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;

public class BibliotecaApp {
    public static void main(String[] args) {
        LivroRepository livroRepository = new LivroRepository();

        try {
            // Adicionar um livro
            Livro livro = new Livro("1", "O Senhor dos Anéis", "J.R.R. Tolkien", true);
            livroRepository.adicionarLivro(livro);
            System.out.println("Livro adicionado!");

            // Procurar um livro
            Livro livroProcurado = livroRepository.consultarLivro("1");
            System.out.println("Livro procurado: " + livroProcurado.getTitulo());

            // Atualizar um livro
            livroProcurado.setDisponivel(false);
            livroRepository.atualizarLivro(livroProcurado);
            System.out.println("Livro atualizado!");

            // Remover um livro
            livroRepository.removerLivro("1");
            System.out.println("Livro removido!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
