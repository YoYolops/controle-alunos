package com.controle;

public class Main {

    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        String escolha = "";

        while(true) {
            escolha = menu(scanner);
            gerenciadorDeComando();
        }
    }

    private static void menu(Scanner scanner) {
        System.out.println("(C)adastrar Aluno\n(E)xibir Aluno\n(N)ovo Grupo\n(A)locar Aluno no Grupo e Verificar pertinência a Grupos\n(R)egistrar Aluno que Respondeu\n(I)mprimir Alunos que Responderam\b(O)lhaí quais Grupos o Aluno Tá.\n(S)im, quero Fechar o Programa!\n\nOpção> ");
        return scanner.nextLine().toUpperCase();
    }

    private void gerenciadorDeComando(String comando, Controle controle, Scanner scanner) {
        switch (opcao) {
			case "C":
				System.out.println("Funcionalidade não implementada");
				break;
			case "E":
            System.out.println("Funcionalidade não implementada");
				break;
			case "N":
                System.out.println("Funcionalidade não implementada");
				break;
			case "A":
                System.out.println("Funcionalidade não implementada");
				break;
			case "R":
                System.out.println("Funcionalidade não implementada");
				break;
			case "I":
                System.out.println("Funcionalidade não implementada");
				break;
			case "O":
                System.out.println("Funcionalidade não implementada");
				break;
            case "S":
                System.out.println("Funcionalidade não implementada");
                break;
			default:
				System.out.println("Opção inválida!");
		}

    }
}