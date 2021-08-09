package com.controle;

public class Aluno {
    private String nome;
    private String matricula;
    private String curso;

    public Aluno(String nome, String matricula, String curso) {
        if(nome.trim() == "") {
            throw IllegalArgumentException("Nome inválido");
        } else if(matricula.trim() == "") {
            throw IllegalArgumentException("Matrícula inválida");
        } else if( curso.trim() == "") {
            throw IllegalArgumentException("Curso inválido");
        }

        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public boolean equals(Object obj) {
        Aluno aluno = (Aluno) obj;

        if(this.matricula.equals(aluno.getMatricula())) { return true; }
        return false;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCurso() {
        return this.curso;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public String toString() {
        return "Aluno:" + " - "  + this.matricula + " - " + this.nome + " - " + this.curso;
    }
}