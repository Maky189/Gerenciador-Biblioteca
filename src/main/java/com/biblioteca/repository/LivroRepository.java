package com.biblioteca.repository;

import com.biblioteca.model.Livro;
import com.biblioteca.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Using basic sql code operations to the Livro
 
public class LivroRepository {
    // this method handles the adding of new books
    public void adicionarLivro(Livro livro) throws SQLException {
        String sql = "INSERT INTO Livro (id, titulo, autor, disponivel) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, livro.getId());
            stmt.setString(2, livro.getTitulo());
            stmt.setString(3, livro.getAutor());
            stmt.setBoolean(4, livro.isDisponivel());
            stmt.executeUpdate();
        }
    }

    //This other method provides informations of the book
    public Livro consultarLivro(String id) throws SQLException {
        String sql = "SELECT * FROM Livro WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Livro(rs.getString("id"), rs.getString("titulo"), rs.getString("autor"), rs.getBoolean("disponivel"));
                }
            }
        }
        return null;
    }

    // This method handles the updating of a book
    public void atualizarLivro(Livro livro) throws SQLException {
        String sql = "UPDATE Livro SET titulo = ?, autor = ?, disponivel = ? WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setBoolean(3, livro.isDisponivel());
            stmt.setString(4, livro.getId());
            stmt.executeUpdate();
        }
    }

    // This method removes a book
    public void removerLivro(String id) throws SQLException {
        String sql = "DELETE FROM Livro WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }
}
