package ufcg.controllers;

import java.util.List;
import java.util.Scanner;

import ufcg.entities.Aluno;
import ufcg.entities.Grupo;
import ufcg.repositories.AlunoRepository;
import ufcg.repositories.GrupoRepository;
import ufcg.repositories.RespondenteRepository;

public class Facade {
    GrupoRepository repositorioGrupos;
    AlunoRepository repositorioAlunos;
    RespondenteRepository repositorioRespondentes;

    public Facade() {
        this.repositorioAlunos = new AlunoRepository();
        this.repositorioGrupos = new GrupoRepository();
        this.repositorioRespondentes = new RespondenteRepository();
    }

    public void cadastrarAluno(Scanner sc) throws Exception {
        System.out.print("\nMatrícula: ");
        String matricula = sc.next();

        System.out.print("\nNome: ");
        String nome = sc.next();

        System.out.print("\nCurso: ");
        String curso = sc.next();

        repositorioAlunos.cadastrarAluno(nome, matricula, curso);
        System.out.print("\nCadastro realizado!");
    }

    public void consultarAluno(Scanner sc) {
        System.out.print("\nMatrícula: ");
        String matricula = sc.next();

        Aluno alunoEncontrado = repositorioAlunos.getAluno(matricula);
        if(alunoEncontrado == null) System.out.print("\nAluno não cadastrado");
        else System.out.print("\n" + alunoEncontrado);
    }

    public void cadastrarGrupo(Scanner sc) throws Exception {
        System.out.print("\nGrupo: ");
        String nome = sc.next();
        System.out.print("\nTamanho: ");
        int tamanho = sc.nextInt();

        repositorioGrupos.cadastrarGrupo(nome, tamanho);
    }

    public void alocarAlunoEmGrupos(Scanner sc) throws Exception {
        System.out.print("\n(A)locar Aluno ou (P)ertinênncia a Grupo?");
        String subOpcao = sc.next();

        if(subOpcao.toLowerCase().equals("a")) {
            System.out.print("\nMatrícula: ");
            String matricula = sc.next();

            Aluno alunoEncontrado = repositorioAlunos.getAluno(matricula);
            if(alunoEncontrado == null) System.out.print("\n Aluno não cadastrado");

            System.out.print("\nGrupo: ");
            String nomeGrupo = sc.next();

            repositorioGrupos.alocarAlunoEmGrupo(alunoEncontrado, nomeGrupo);
            System.out.print("\nAluno alocado");
        } else if(subOpcao.toLowerCase().equals("p")) {
            System.out.print("\nGrupo: ");
            String nomeGrupo = sc.next();

            System.out.print("\nAluno: ");
            String matriculaAluno = sc.next();

            Grupo grupoEncontrado = repositorioGrupos.getGrupo(nomeGrupo);
            if(grupoEncontrado == null) System.out.print("\nGrupo não cadastrado");

            Aluno alunoEncontrado = repositorioAlunos.getAluno(matriculaAluno);
            if(alunoEncontrado == null) System.out.print("\nAluno não registrado");
            
            if(grupoEncontrado.isAlunoEmGrupo(alunoEncontrado)) System.out.print("\nAluno pertence ao grupo");
            else System.out.print("\nAluno não pertence ao grupo");
        }
    }

    public void cadastrarAlunosQueRespondemQuestoesNoQuadro(Scanner sc) {
        System.out.print("\nMatricula: ");
        String matricula = sc.next();

        Aluno alunoEncontrado = repositorioAlunos.getAluno(matricula);
        if(alunoEncontrado == null) System.out.print("\nAluno não existe");
        else repositorioRespondentes.registrarRespondente(alunoEncontrado);
        System.out.print("\nAluno registrado");
    }

    public void imprimirAlunosQueRespondemQuestoesNoQuadro(Scanner sc) {
        List<Aluno> respondentes = repositorioRespondentes.getRegistroRespondentes();
        for(int i = 0; i < respondentes.size(); i++) {
            System.out.print("\n" + (i+1) + ". " + respondentes.get(i));
        }
    }

    public void checagemDosGruposDosAlunos(Scanner sc) throws Exception {
        System.out.print("\nAluno: ");
        String matricula = sc.next();

        Aluno alunoEncontrado = repositorioAlunos.getAluno(matricula);
        if(alunoEncontrado == null) throw new Exception("Aluno não existe");
        List<Grupo> gruposDoQualFazParte = repositorioGrupos.getGruposDoQualFazParte(alunoEncontrado);

        System.out.print("\nGrupos: ");
        for(Grupo grupo : gruposDoQualFazParte) System.out.print("\n- " + grupo.getNome());
    }

    public void imprimirEstatisticas(Scanner sc) {
        List<Aluno> todosOsAlunosCadastrados = repositorioAlunos.getTodosAlunosCadastrados();
        String relatorio = repositorioRespondentes.getRelatorioEstatisticas(todosOsAlunosCadastrados);
        System.out.print("\n"+relatorio);
    }
}
