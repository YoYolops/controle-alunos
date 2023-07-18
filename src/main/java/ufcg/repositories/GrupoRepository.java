package ufcg.repositories;

import java.util.ArrayList;
import java.util.List;
import ufcg.entities.Grupo;
import ufcg.entities.Aluno;

public class GrupoRepository {
    List<Grupo> grupos;

    public GrupoRepository() {
        this.grupos = new ArrayList<Grupo>();
    }

    public void cadastrarGrupo(String nome, int tamanho) throws Exception {
        if(this.getGrupo(nome) != null) throw new Exception("Grupo já cadastrado");
        Grupo novoGrupo = new Grupo(nome, tamanho);
        grupos.add(novoGrupo);
    }

    public void cadastrarGrupo(String nome) throws Exception {
        if(this.getGrupo(nome) != null) throw new Exception("Grupo já cadastrado");
        Grupo novoGrupo = new Grupo(nome);
        grupos.add(novoGrupo);
    }

    public void alocarAlunoEmGrupo(Aluno aluno, String nomeGrupo) throws Exception {
        Grupo grupoSelecionado = this.getGrupo(nomeGrupo);

        if(grupoSelecionado == null) throw new Exception("Grupo não cadastrado");
        else grupoSelecionado.adicionarAluno(aluno);
    }

    public List<Grupo> getGruposDoQualFazParte(Aluno aluno) {
        List<Grupo> gruposDoQualFazParte = new ArrayList<Grupo>();
        for(Grupo grupo : grupos) {
            if(grupo.isAlunoEmGrupo(aluno)) gruposDoQualFazParte.add(grupo);
        }
        return gruposDoQualFazParte;
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
