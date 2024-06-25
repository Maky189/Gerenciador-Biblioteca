package com.biblioteca;

import java.util.Scanner;

import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;

// This is the main class of my Library
public class BibliotecaApp {
    public static void main(String[] args) {
        LivroRepository livroRepository = new LivroRepository();

        try {
            // Adicionar um livro

            Scanner teclado = new Scanner(System.in);
            System.out.println("Coloque o título do livro:");  
            String book = teclado.next();
            System.out.println("Coloque o autor do livro:");
            String autor = teclado.next();

            Livro livro = new Livro("1", book, autor, true);
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
            teclado.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
