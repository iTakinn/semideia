package com.takin;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import com.takin.core.criaruser;
import com.takin.core.listardb;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Modo de Entrada");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] options = { "Usuário", "Administrador" };
        int modo = JOptionPane.showOptionDialog(frame, "Escolha o modo de entrada:", "Modo de Entrada",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (modo == 1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String senhaDigitada = JOptionPane.showInputDialog(frame, "Digite a senha para continuar...");

            if (senhaDigitada.equals("1234")) {
                JOptionPane.showMessageDialog(frame, "Autorizado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String[] adminOptions = { "Listar banco de dados", "Adicionar um usuário", "Remover um usuário",
                        "Criar um novo banco de dados" };

                int numer = JOptionPane.showOptionDialog(frame, "Escolha uma opção:", "Opções do Administrador",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, adminOptions, adminOptions[0]);

                switch (numer) {
                    case 0:
                        JOptionPane.showMessageDialog(frame, "Listando banco de dados...", "Ação Executada",
                                JOptionPane.INFORMATION_MESSAGE);
                        listardb.todaDB();
                        break;

                    case 1:
                        String nome = JOptionPane.showInputDialog(frame, "Nome para o usuário:");
                        String senha = JOptionPane.showInputDialog(frame, "Digite a senha para o usuário:");

                        criaruser.main(nome, senha);
                        break;

                    case 2:
                        // TODO: Implement removing a user
                        break;

                    case 3:
                        // TODO: Implement creating a new database
                        break;

                    default:
                        // Handle invalid option
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Senha incorreta. Tente novamente.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (modo == 0) {
            JOptionPane.showMessageDialog(frame, "Entrando como usuário", "Modo de Entrada",
                    JOptionPane.INFORMATION_MESSAGE);
            // Action for the user mode
        } else {
            JOptionPane.showMessageDialog(frame, "Modo inválido. Encerrando aplicação.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }

        frame.dispose();
        
        // Create and display the main JFrame
        JFrame mainFrame = new JFrame("Main Frame");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().add(new JLabel("Welcome to the application!"));
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
