package com.controle;

import java.util.ArrayList;

public class RepositorioAlunos {
    private ArrayList<Aluno> alunos = new ArrayList<>();

    public void CadastrarAluno(String nome, String matricula, String curso) {
        if(!isValidAluno(nome, matricula, curso)) {
            throw IllegalArgumentException("Nome, matricula e/ou curso inválido");
        }

        Aluno aluno = new Aluno(nome, matricula, curso);
        this.alunos.add(aluno);
    }

    public Aluno getAluno(int index) {
        return alunos.get(index);
    }

    public int matriculaEstaCadastrada(String matricula) {
        return alunos.contains(matricula);
    }

    /** 
     * Verifica se os dados inseridos são aceitáveis 
     */
    private boolean isValidAluno(String nome, String matricula, String curso) {
        if(nome.trim() == "" || matricula.trim() == "" || curso.trim() == "") { return false; }
        return true;
    }
}