package ufcg.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ufcg.entities.Aluno;
import java.util.Map;

public class RespondenteRepository {
    Map<Aluno, Integer> respondentes;

    public RespondenteRepository() {
        this.respondentes = new HashMap<Aluno, Integer>();
    }

    public void registrarRespondente(Aluno aluno) {
        if(respondentes.containsKey(aluno)) respondentes.put(aluno, respondentes.get(aluno)+1);
        else respondentes.put(aluno, 1);
    }

    public Map<Aluno, Integer> getAlunoMaisChamado() {
        int quantChamadas = 0;
        Aluno alunoMaisChamado = null;

        for(Aluno key : respondentes.keySet()) {
            if(respondentes.get(key) > quantChamadas) {
                alunoMaisChamado = key;
                quantChamadas = respondentes.get(key);
            }
        }

        Map<Aluno, Integer> mapResposta = new HashMap<Aluno, Integer>();
        // procurando algum outro aluno empatado
        for(Aluno key : respondentes.keySet()) {
            if(!key.getMatricula().equals(alunoMaisChamado.getMatricula()) && respondentes.get(key) == quantChamadas) {
                mapResposta.put(key, quantChamadas);
            }
        }
        mapResposta.put(alunoMaisChamado, quantChamadas);
        return mapResposta;
    }

}
