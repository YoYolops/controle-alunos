package ufcg.controllers;

import java.util.Scanner;

public class Menu {
    String opcoes;
    Facade sistemaControleAlunos;

    public Menu() {
        this.sistemaControleAlunos = new Facade();
        this.opcoes = "(C)adastrar Aluno\n" + //
                "(E)xibir Aluno\n" + //
                "(N)ovo Grupo\n" + //
                "(A)locar Aluno no Grupo e Verificar Pertinência a Grupos\n" + //
                "(R)egistrar Aluno que Respondeu\n" + //
                "(I)mprimir Alunos que Responderam\n" + //
                "(O)lhaí quais Grupos o Aluno Tá\n" + //
                "(S)im, quero Fechar o Programa!\n" + //
                "";
    }

    public void run() {
        String opcaoEscolhida = "";
        Scanner sc = new Scanner(System.in);
        while(opcaoEscolhida.toLowerCase() != "s") {
            this.handleInput(opcaoEscolhida);
            System.out.println(opcoes);
            System.out.print("Opção> ");
            opcaoEscolhida = sc.next();
        }

        sc.close();
    }

    private void handleInput(String input) {
        try {
            switch (input.toLowerCase()) {
                case "c": System.out.println("Funcionalidade ainda não implementada");break;
                case "e": System.out.println("Funcionalidade ainda não implementada");break;
                case "n": System.out.println("Funcionalidade ainda não implementada");break;
                case "a": System.out.println("Funcionalidade ainda não implementada");break;
                case "r": System.out.println("Funcionalidade ainda não implementada");break;
                case "i": System.out.println("Funcionalidade ainda não implementada");break;
                case "o": System.out.println("Funcionalidade ainda não implementada");break;
                case "s": System.out.println("Funcionalidade ainda não implementada");break;
                default: break;
            }
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}
