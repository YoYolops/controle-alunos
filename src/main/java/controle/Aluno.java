package controle;

import java.util.ArrayList;

/**
 * Entidade que representa um aluno, além de nome, matricula e curso, armazena também os
 * nomes dos grupos no qual o aluno está cadastrado 
 * 
 * @author Yohan Lopes (https://github.com/YoYolops)
 */
public class Aluno {
    private String nome;
    private String matricula;
    private String curso;
    /** 
     * ArrayList com os nomes dos grupos nos quais o aluno está inscrito 
     */
    private ArrayList<String> grupos = new ArrayList<>();

    public Aluno(String nomeAluno, String matriculaAluno, String cursoAluno) {
        if(nomeAluno.trim() == "") {
            throw new IllegalArgumentException("Nome inválido");
        }
        if(matriculaAluno.trim() == "") {
            throw new IllegalArgumentException("Matrícula inválida");
        }
        if(cursoAluno.trim() == "") {
            throw new IllegalArgumentException("Curso inválido");
        }

        this.nome = nomeAluno;
        this.matricula = matriculaAluno;
        this.curso = cursoAluno;
    }

    public void adicionarGrupo(String nomeDoGrupo) {
        if(!grupos.contains(nomeDoGrupo)) {
            grupos.add(nomeDoGrupo);
        }
    }

/*     public boolean alunoEstaNoGrupo(String nomeDoGrupo) {
        for(String nome : grupos) {
            if(nome.equals(nomeDoGrupo)) {
                return true;
            }
        }
        return false;
    } */

    public String getNome() {
        return this.nome;
    }

    public String getCurso() {
        return this.curso;
    }

    public String getMatricula() {
        return this.matricula;
    }

    /** 
     * Retorna os grupos dos quais o aluno faz parte, formatados no padrão exigido.
     */  
    public String getGrupos() {
        String stringRetorno = "Grupos:\n";

        for(String grupo : grupos) {
            stringRetorno += ("- " + grupo + "\n");
        }
        return stringRetorno;
    }

/*     public boolean equals(Object obj) {
        Aluno aluno = (Aluno) obj;

        if(this.matricula.equals(aluno.getMatricula())) { return true; }
        return false;
    } */

    public String toString() {
        return "Aluno:" + " - "  + this.matricula + " - " + this.nome + " - " + this.curso;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(this.matricula);
    }
}