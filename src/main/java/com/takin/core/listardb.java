package com.takin.core;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class listardb {
    public static List<Integer> idList = new ArrayList<>();
    public static List<String> nomeList = new ArrayList<>();

    public static void todaDB() {
        // Configurar a conexão com o banco de dados
        String url = "jdbc:sqlite:database.db";
        // Declaração de variáveis
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Estabelecer a conexão com o banco de dados
            connection = DriverManager.getConnection(url);

            // Criar a declaração SQL
            String sql = "SELECT * FROM usuarios";
            statement = connection.createStatement();

            // Executar a consulta SQL
            resultSet = statement.executeQuery(sql);

            // Criar listas para armazenar os dados
            

            // Iterar sobre o resultado e armazenar os dados nas listas
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");

                idList.add(id);
                nomeList.add(nome);
            }

            // Exibir os dados armazenados nos arrays
            System.out.println("IDs: " + idList);
            System.out.println("Nomes: " + nomeList);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fechar os recursos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

