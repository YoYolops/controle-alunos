package ufcg.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ufcg.entities.Aluno;
import java.util.Map;

public class RespondenteRepository {
    Map<Aluno, Integer> respondentes;
    List<Aluno> registroDeOrdem;

    public RespondenteRepository() {
        this.respondentes = new HashMap<Aluno, Integer>();
        this.registroDeOrdem = new ArrayList<Aluno>();
    }

    public void registrarRespondente(Aluno aluno) {
        registroDeOrdem.add(aluno);
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

    public Map<String, Integer> getQuantidadeAlunosChamadosPorCurso() { // Falta ordenar o resultado para exibir os mais chamados primeiro
        Map<String, Integer> respondentesPorCurso = new HashMap<String, Integer>();
        for(Aluno key : respondentes.keySet()) {
            if(respondentesPorCurso.get(key.getCurso()) == null) respondentesPorCurso.put(key.getCurso(), 1);
            else respondentesPorCurso.put(key.getCurso(), respondentesPorCurso.get(key.getCurso()) + 1);
        }
        return respondentesPorCurso;
    }

    public List<Aluno> getAlunosNuncaChamados(List<Aluno> todosOsAlunos) {
        List<Aluno> alunosNuncaChamados = new ArrayList<Aluno>();
        for(Aluno aluno : todosOsAlunos) {
            if(respondentes.get(aluno) == null) alunosNuncaChamados.add(aluno);;
        }
        return alunosNuncaChamados;
    }

    public String getRelatorioEstatisticas(List<Aluno> alunosAtivos) {
        Map<Aluno, Integer> alunoMaisChamado = this.getAlunoMaisChamado();
        Map<String, Integer> alunosMaisChamadoPorCurso = this.getQuantidadeAlunosChamadosPorCurso();
        List<Aluno> alunosNuncaChamados = this.getAlunosNuncaChamados(alunosAtivos);

        String estatisticas = "Aluno(s) mais chamado(s):\n";
        for(Aluno aluno : alunoMaisChamado.keySet()) {
            estatisticas += "- " + aluno.toString() + "\n";
        }

        estatisticas += "\n" + "Alunos mais chamados por curso:\n";
        for(String curso : alunosMaisChamadoPorCurso.keySet()) {
            estatisticas += "- " + curso + ": " + alunosMaisChamadoPorCurso.get(curso) + "\n";
        }

        estatisticas += "\nAlunos nunca chamados:\n";
        for(Aluno aluno : alunosNuncaChamados) {
            estatisticas += "- " + aluno.toString() + "\n";
        }

        return estatisticas;
    }

    public List<Aluno> getRegistroRespondentes() {
        return this.registroDeOrdem;
    }

}
