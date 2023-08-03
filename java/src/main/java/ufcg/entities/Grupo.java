package ufcg.entities;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private String nome;
    private List<Aluno> membros;
    private int tamanho = 0;

    public Grupo(String nome, int tamanho) {
        if(tamanho <= 0) throw new IllegalArgumentException("Tamanho de grupo precisa ser maior que 0");
        this.nome = nome;
        this.membros = new ArrayList<Aluno>();
        this.tamanho = tamanho;
    }

    public Grupo(String nome) {
        this.nome = nome;
        this.membros = new ArrayList<Aluno>(null);
    }

    public void adicionarAluno(Aluno aluno) throws Exception {
        if(tamanho == 0 || membros.size() < tamanho) {
            membros.add(aluno);
        } else {
            throw new Exception("GRUPO CHEIO");
        }
    }

    public boolean isAlunoEmGrupo(Aluno aluno) {
        for(Aluno al : membros) if(aluno.getMatricula().equals(al.getMatricula())) return true;
        return false;
    }

    public String getNome() {
        return this.nome;
    }

    public List<Aluno> getMembros() {
        return this.membros;
    }
}
