package com.takin.core;

import java.sql.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class criaruser {
    public static void main(String nome, String senha) {
        String SHASenha = hashPassword(senha);
        String url = "jdbc:sqlite:";
        String dbdb = "database.db";

        try (Connection connection = DriverManager.getConnection(url+dbdb)) {
            // Preparar a instrução SQL para inserção
            String sql = "INSERT INTO usuarios (nome, senha) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, nome);
            statement.setString(2, SHASenha);

            // Executar a instrução SQL
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int userId = generatedKeys.getInt(1);
                    System.out.println("Usuário criado com sucesso! ID: " + userId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static String hashPassword(String password) {
        try {
            // Cria uma instância do algoritmo de hash SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Calcula o hash da senha
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            // Converte o hash para uma representação hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
