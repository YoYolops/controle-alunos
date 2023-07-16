package ufcg.repositories;

import java.util.ArrayList;
import java.util.List;
import ufcg.entities.Grupo;
import ufcg.entities.Aluno;

public class GrupoRepository {
    List<Grupo> grupos;

    public GrupoRepository() {
        this.grupos = new ArrayList<Grupo>(null);
    }

    public void cadastrarGrupo(String nome, int tamanho) {
        Grupo novoGrupo = new Grupo(nome, tamanho);
        grupos.add(novoGrupo);
    }

    public void cadastrarGrupo(String nome) {
        Grupo novoGrupo = new Grupo(nome);
        grupos.add(novoGrupo);
    }

    public void alocarAlunoEmGrupo(Aluno aluno, String nomeGrupo) throws Exception {
        Grupo grupoSelecionado = this.getGrupo(nomeGrupo);

        if(grupoSelecionado == null) throw new Exception("Grupo não cadastrado");
        else grupoSelecionado.adicionarAluno(aluno);
    }

    public Grupo getGrupo(String nomeDoGrupo) {
        for(Grupo grupo : grupos) {
            if(grupo.getNome().equals(nomeDoGrupo)) {
                return grupo;
            }
        }
        return null;
    }
}
