package ufcg.repositories;

import java.util.ArrayList;
import java.util.List;
import ufcg.entities.Aluno;

public class AlunoRepository {
    List<Aluno> alunos;

    public AlunoRepository() {
        this.alunos = new ArrayList<Aluno>();
    }

    public void cadastrarAluno(String nome, String matricula, String curso) throws Exception {
        if(this.isAlunoCadastrado(matricula)) throw new Exception("Matrícula já cadastrada!");
        Aluno novoALuno = new Aluno(matricula, curso, nome);
        alunos.add(novoALuno);
    }

    public boolean isAlunoCadastrado(String matricula) {
        for(Aluno aluno : alunos) {
            if(aluno.getMatricula().equals(matricula)) return true;
        }
        return false;
    }

    public Aluno getAluno(String matricula) {
        for(Aluno aluno : alunos) {
            if(aluno.getMatricula().equals(matricula)) return aluno;
        }
        return null;
    }

    public List<Aluno> getTodosAlunosCadastrados() {
        return this.alunos;
    }
}
