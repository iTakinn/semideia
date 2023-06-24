package com.takin;

import java.sql.Time;
import java.util.Scanner;

import com.takin.core.criaruser;
import com.takin.core.listardb;


public class Main {
    public static void main(String[] args)  {
        Scanner scn = new Scanner(System.in);
        System.out.println("escolha o modo de entrada:");
        System.out.println("0 - usuario");
        System.out.println("1 - administrador");
        System.out.println();
        int modo = scn.nextInt();
    
        if (modo == 1){
            System.out.println("digite a senha pra isso...");
            int senhadita = scn.nextInt();
            if (senhadita == 1234){
                System.out.println("escolha uma merda:");
                System.out.println("listar db - 1");
                System.out.println("add um merda - 2");
                System.out.println("tirar um merda - 3");
                System.out.println("criar uma db nova - 4");
                System.out.print("");
                int numer = scn.nextInt();

                if (numer == 1){
                    System.out.println("Listando db...");
                    listardb.todaDB();
                }  else if(numer == 2 ){
                    System.out.println("criando um user...");
                    System.out.println("nome para o usuario:");
                    scn.nextLine();
                    String nomee = scn.nextLine();
                    System.out.println("");
                    System.out.println("Digite a senha para o usuario:");
                    System.out.print("");
                    String senha = scn.nextLine();
                    
                    criaruser.main(nomee, senha);

                } else if( numer == 3){

                } else if( numer == 4){

                } else {

                }
            }else{
                System.out.println("senha errada, tente novamente");
            }
        }else if (modo == 0){
            System.out.println("entrando como usuario");
            //açao usuario
        }
        
    }
}
