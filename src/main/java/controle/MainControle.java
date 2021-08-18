package controle;

import java.util.Scanner;

public class MainControle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controle controle = new Controle();
        String comando = "";

        while(true) {
            comando = menu(scanner);
            gerenciadorDeComando(comando, controle, scanner);
        }
    }

    private static String menu(Scanner scanner) {
        System.out.println("(C)adastrar Aluno\n(E)xibir Aluno\n(N)ovo Grupo\n(A)locar Aluno no Grupo e Verificar pertinência a Grupos\n(R)egistrar Aluno que Respondeu\n(I)mprimir Alunos que Responderam\b(O)lhaí quais Grupos o Aluno Tá.\n(S)im, quero Fechar o Programa!\n\nOpção> ");
        return scanner.nextLine().toUpperCase();
    }

    private static void gerenciadorDeComando(String comando, Controle controle, Scanner scanner) {
        switch (comando) {
			case "C":
				requisitarCadastroAluno(controle, scanner);
				break;
			case "E":
                exibirAluno(controle, scanner);
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

    private static void requisitarCadastroAluno(Controle controle, Scanner scanner) {
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        if("".equals(matricula.trim())) {
            System.out.println("Número de matrícula inválido");
            return;
        }
        if(controle.getAluno(matricula) != null) {
            System.out.println("MATRÍCULA JÁ CADASTRADA!");
        }

        System.out.print("\nNome: ");
        String nome = scanner.nextLine();
        if("".equals(nome.trim())) {
            System.out.println("Nome inválido");
            return;
        }

        System.out.print("\nCurso: ");
        String curso = scanner.nextLine();
        if("".equals(curso.trim())) {
            System.out.println("Curso inválido");
            return;
        }

        controle.cadastrarAluno(nome, matricula, curso);
    }

    private static void exibirAluno(Controle controle, Scanner scanner) {
        System.out.println("Matrícula: ");
        String matricula = scanner.nextLine();
        if("".equals(matricula.trim())) {
            System.out.println("Matrícula inválida");
            return;
        }

        Aluno resultadoDaBusca = controle.getAluno(matricula);
        if(resultadoDaBusca == null) {
            System.out.println("Aluno não cadastrado.");
        } else {
            System.out.println(resultadoDaBusca);
        }
    }

    private static void requisitaCadastroDeGrupo(Controle controle, Scanner scanner) {
        System.out.print("Grupo: ");
        String nomeDoGrupo = scanner.nextLine();
        if("".equals(nomeDoGrupo.trim())) {
            System.out.println("Nome de grupo inválido");
            return;
        }
        if(controle.getGrupoPeloNome(nomeDoGrupo) != null) {
            System.out.println("GRUPO JÁ CADASTRADO!");
            return;
        }

        System.out.print("Tamanho: ");
        String tamanho = scanner.nextLine();
        if(tamanho.trim() == "") { tamanho = null; }

        controle.adicionarGrupo(nomeDoGrupo, tamanho);
        System.out.println("CADASTRO REALIZADO!");

    }
}