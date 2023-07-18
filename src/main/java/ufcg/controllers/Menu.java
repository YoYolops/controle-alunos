package ufcg.controllers;

import java.util.Scanner;

public class Menu {
    String opcoes;
    Facade sistemaControleAlunos;

    public Menu() {
        this.sistemaControleAlunos = new Facade();
        this.opcoes = "\n(C)adastrar Aluno\n" + //
                "(E)xibir Aluno\n" + //
                "(N)ovo Grupo\n" + //
                "(A)locar Aluno no Grupo e Verificar Pertinência a Grupos\n" + //
                "(R)egistrar Aluno que Respondeu\n" + //
                "(I)mprimir Alunos que Responderam\n" + //
                "(O)lhaí quais Grupos o Aluno Tá\n" + //
                "(Z)Gerar estatísticas\n" + //
                "(S)im, quero Fechar o Programa!\n" + //
                "";
    }

    public void run() {
        String opcaoEscolhida = "";
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n"); // altera o comportamento de scanner.next() para que agora capture espaços em branco como parte do input
        while(opcaoEscolhida.toLowerCase() != "s") {
            this.handleInput(opcaoEscolhida, sc);
            System.out.print("\n" + opcoes);
            System.out.print("\nOpção> ");
            opcaoEscolhida = sc.next();
        }
        sc.close();
    }

    private void handleInput(String input, Scanner sc) {
        try {
            switch (input.toLowerCase()) {
                case "c": sistemaControleAlunos.cadastrarAluno(sc);break;
                case "e": sistemaControleAlunos.consultarAluno(sc);break;
                case "n": sistemaControleAlunos.cadastrarGrupo(sc); break;
                case "a": sistemaControleAlunos.alocarAlunoEmGrupos(sc); break;
                case "r": sistemaControleAlunos.cadastrarAlunosQueRespondemQuestoesNoQuadro(sc); ;break;
                case "i": sistemaControleAlunos.imprimirAlunosQueRespondemQuestoesNoQuadro(sc); ;break;
                case "o": sistemaControleAlunos.checagemDosGruposDosAlunos(sc); ;break;
                case "z": sistemaControleAlunos.imprimirEstatisticas(sc); ;break;
                default: System.out.println("Opção inválida"); break;
            }
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}
