package ufcg.entities;

public class Aluno {
    private String matricula;
    private String curso;
    private String nome;

    public Aluno(String matricula, String curso, String nome) {
        this.matricula = matricula;
        this.curso = curso;
        this.nome = nome;
    }

    public String toString() {
        return matricula + " - " + nome + " - " + curso;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public String getCurso() {
        return this.curso;
    }
}
