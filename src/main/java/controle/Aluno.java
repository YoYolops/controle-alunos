package controle;

import java.util.ArrayList;

public class Aluno {
    private String nome;
    private String matricula;
    private String curso;
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