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
                requisitaCadastroDeGrupo(controle, scanner);
				break;
			case "A":
                gerenciadorDePedidoDeAlocacao(controle, scanner);
				break;
			case "R":
                adicionarAlunoRespondente(controle, scanner);
				break;
			case "I":
                exibirAlunosRespondentes(controle);
				break;
			case "O":
                participaDeQueGrupos(controle, scanner);
				break;
            case "S":
                fecharAplicacao();
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
        if(!validarMatricula(matricula, controle)) { return; }

        String representacaoAluno = controle.exibirAluno(matricula);
        System.out.println(representacaoAluno);
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

    private static void participaDeQueGrupos(Controle controle, Scanner scanner) {
        System.out.print("Aluno: ");
        String matricula = scanner.nextLine();
        if(!validarMatricula(matricula, controle)) { return; }

        Aluno aluno = controle.getAluno(matricula);
        String gruposQueParticipa = aluno.getGrupos();
        System.out.println(gruposQueParticipa);
    }

    private static void gerenciadorDePedidoDeAlocacao(Controle controle, Scanner scanner) {
        System.out.print("(A)locar Aluno ou (P)ertinência a Grupo? ");
        String comando = scanner.nextLine().trim().toUpperCase();

        switch(comando) {
            case "A":
                alocarAlunoEmGrupo(controle, scanner);
            case "P":
                pertinenciaAGrupo(controle, scanner);
            default:
                System.out.println("Opção inválida");
        }
    }

    private static void pertinenciaAGrupo(Controle controle, Scanner scanner) {
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        if(!validarMatricula(matricula, controle)) { return; }

        String nomeDoGrupo = scanner.nextLine();
        if("".equals(nomeDoGrupo.trim())) {
            System.out.println("Nome de grupo inválido");
            return;
        }
        if(controle.getGrupoPeloNome(nomeDoGrupo) == null) {
            System.out.println("Grupo não existe");
            return;
        }

        if(controle.verificarPertinenciaAGrupo(matricula, nomeDoGrupo)) {
            System.out.println("ALUNO NÃO PERTECENTE AO GRUPO");
        } else {
            System.out.println("ALUNO PERTENCE AO GRUPO");
        }
    }

    private static void alocarAlunoEmGrupo(Controle controle, Scanner scanner) {
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        if(!validarMatricula(matricula, controle)) { return; }
        
        System.out.print("Grupo: ");
        String nomeDoGrupo = scanner.nextLine();
        if("".equals(nomeDoGrupo.trim())) {
            System.out.println("Nome de grupo inválido");
            return;
        }
        if(controle.getGrupoPeloNome(nomeDoGrupo) == null) {
            System.out.println("Grupo não existe");
            return;
        }

        controle.alocarAlunoEmGrupo(matricula, nomeDoGrupo);
        System.out.println("ALUNO ALOCADO!");
    }

    private static void adicionarAlunoRespondente(Controle controle, Scanner scanner) {
        System.out.println("Matrícula: ");
        String matricula = scanner.nextLine();
        if(!validarMatricula(matricula, controle)) { return; }

        controle.adicionarRespondente(matricula);
        System.out.println("ALUNO REGISTRADO!");
    }

    private static void exibirAlunosRespondentes(Controle controle) {
        String respondentes = controle.gerarRelatorioDeRespondentes();
        System.out.println(respondentes);
    }

    private static void fecharAplicacao() {
        System.out.println("Xauuu!!!");
        System.exit(0);
    }

    private static boolean validarMatricula(String matricula, Controle controle) {
        if("".equals(matricula.trim())) {
            System.out.println("Matrícula inválida");
            return false;
        }
        if(controle.getAluno(matricula) == null) {
            System.out.println("Matrícula não existe");
            return false;
        }

        return true;
    }
}