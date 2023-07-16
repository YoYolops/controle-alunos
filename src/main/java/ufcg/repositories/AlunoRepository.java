package ufcg.repositories;

import java.util.ArrayList;
import java.util.List;
import ufcg.entities.Aluno;

public class AlunoRepository {
    List<Aluno> alunos;

    public AlunoRepository() {
        this.alunos = new ArrayList<Aluno>(null);
    }

    public void cadastrarAluno(String nome, String matricula, String curso) {
        Aluno novoALuno = new Aluno(matricula, curso, nome);
        alunos.add(novoALuno);
    }

    public boolean isAlunoCadastrado(String matricula) {
        for(Aluno aluno : alunos) {
            if(aluno.getMatricula().equals(matricula)) return true;
        }
        return false;
    }
}
