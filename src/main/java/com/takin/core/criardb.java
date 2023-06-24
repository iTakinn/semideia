package com.takin.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class criardb {
    public static void criar(String[] args) {
        // Nome do banco de dados SQLite
        String databaseName = "database.db";

        // Criar a conexão com o banco de dados
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseName)) {
            // Criar uma declaração
            Statement statement = connection.createStatement();

            // Criar o banco de dados
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, senha TEXT)");

            System.out.println("Banco de dados criado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
