package controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controle {
    private Map<String, Aluno> alunos = new HashMap<String, Aluno>();
    private ArrayList<Grupo> grupos = new ArrayList<>();

    public void adicionarGrupo(String nomeDoGrupo, String tamanhoDoGrupo) {
        Grupo novoGrupo;

        if(tamanhoDoGrupo == null) {
            novoGrupo = new Grupo(nomeDoGrupo);
        } else {
            int tamanho = Integer.parseInt(tamanhoDoGrupo);
            novoGrupo = new Grupo(nomeDoGrupo, tamanho);
        }
        grupos.add(novoGrupo);
    }

    public Grupo getGrupoPeloNome(String nomeDoGrupo) {
        for(Grupo grupo : grupos) {
            if(nomeDoGrupo.toUpperCase().equals(grupo.getNome())) {
                return grupo;
            }
        }
        return null;
    }


    public void cadastrarAluno(String nome, String matricula, String curso) {
        if(!isValidAluno(nome, matricula, curso)) {
            throw new IllegalArgumentException("Nome, matricula e/ou curso inválido");
        }

        Aluno aluno = new Aluno(nome, matricula, curso);
        this.alunos.put(matricula, aluno);
    }

    public Aluno getAluno(String matricula) {
        return alunos.get(matricula);
    }

    /** 
     * Verifica se os dados inseridos são aceitáveis 
     */
    private boolean isValidAluno(String nome, String matricula, String curso) {
        if(nome.trim() == "" || matricula.trim() == "" || curso.trim() == "") { return false; }
        return true;
    }
}
