package com.biblioteca.repository;

import com.biblioteca.model.Usuario;
import com.biblioteca.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// This class handles uses the sql codes in the tables of usuario, with the operations: 
public class UsuarioRepository {
    // Handles adding user
    public void adicionarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO Usuario (id, nome, email, numero) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getId());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(3, usuario.getnumero());
            stmt.executeUpdate();
        }
    }

    // Handles consulting an user
    public Usuario consultarUsuario(String id) throws SQLException {
        String sql = "SELECT * FROM Usuario WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(rs.getString("id"), rs.getString("nome"), rs.getString("email"), rs.getString("numero"));
                }
            }
        }
        return null;
    }

    //handles updating a user
    public void atualizarUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE Usuario SET nome = ?, email = ?, numero = ? WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getnumero());
            stmt.setString(3, usuario.getId());
            stmt.executeUpdate();
        }
    }

    //handles removing an user from the usuario table
    public void removerUsuario(String id) throws SQLException {
        String sql = "DELETE FROM Usuario WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }
}
 
