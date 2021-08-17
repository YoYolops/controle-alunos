package controle;

import java.util.HashMap;
import java.util.Map;

public class RepositorioAlunos {
    private Map<String, Aluno> mapaAlunos = new HashMap<String, Aluno>();

    public void CadastrarAluno(String nome, String matricula, String curso) {
        if(!isValidAluno(nome, matricula, curso)) {
            throw new IllegalArgumentException("Nome, matricula e/ou curso inválido");
        }

        Aluno aluno = new Aluno(nome, matricula, curso);
        this.mapaAlunos.put(matricula, aluno);
    }

    public Aluno getAluno(String matricula) {
        return mapaAlunos.get(matricula);
    }

    /** 
     * Verifica se os dados inseridos são aceitáveis 
     */
    private boolean isValidAluno(String nome, String matricula, String curso) {
        if(nome.trim() == "" || matricula.trim() == "" || curso.trim() == "") { return false; }
        return true;
    }
}