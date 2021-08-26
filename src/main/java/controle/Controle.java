package controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Gerencia, integra e interage com os objetos Aluno e Grupo.
 * @author Yohan Lopes (https://github.com/YoYolops)
 */
public class Controle {
    private Map<String, Aluno> alunos = new HashMap<String, Aluno>();
    private ArrayList<Grupo> grupos = new ArrayList<>();
    private ArrayList<String> respondentes = new ArrayList<>();

    /**
     * Cria um novo grupo e adiciona ele ao registro
     */
    public void adicionarGrupo(String nomeDoGrupo, String tamanhoDoGrupo) {
        Grupo novoGrupo;

        if(nomeDoGrupo.trim().equals("")) { throw new IllegalArgumentException("Nome inválido"); }
        if(nomeDoGrupo.trim().equals("")) { throw new IllegalArgumentException("Nome inválido"); }

        if(tamanhoDoGrupo == null) {
            novoGrupo = new Grupo(nomeDoGrupo);
        } else {
            int tamanho = Integer.parseInt(tamanhoDoGrupo);
            novoGrupo = new Grupo(nomeDoGrupo, tamanho);
        }
        grupos.add(novoGrupo);
    }

    /**
     * Procura um grupo pelo nome cadastrado no registro mantido
     * @return o objeto encontrado, null caso não haja correspondências
     */
    public Grupo getGrupoPeloNome(String nomeDoGrupo) {
        for(Grupo grupo : grupos) {
            if(nomeDoGrupo.equals(grupo.getNome())) {
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
        // Como HashMap não aceita keys duplicadas, não há a necessidade de verificar se a matrícula está cadastrada, os dados serão sobrescritos
        this.alunos.put(matricula, aluno);
    }

    public Aluno getAluno(String matricula) {
        return alunos.get(matricula);
    }

    /**
     * Coleta o aluno portador da matrícula específicada e o aloca dentro do grupo específicado
     * @param matricula A matrícula do aluno que será alocado
     * @param nomeDoGrupo O nome do grupo cadastrado
     */
    public boolean alocarAlunoEmGrupo(String matricula, String nomeDoGrupo) {
        Aluno aluno = this.getAluno(matricula);
        Grupo grupo = this.getGrupoPeloNome(nomeDoGrupo);
        if(aluno == null) { throw new IllegalArgumentException("Matrícula inexistente"); }
        if(grupo == null) { throw new IllegalArgumentException("Grupo inexistente"); }

        return grupo.adicionarAluno(aluno);
    }

    /**
     * Verifica se um dado aluno já está cadastrado dentro de um grupo
     * @param matricula a matricula do aluno que será verificado
     * @param nomeDoGrupo autoexplicativo
     */
    public boolean verificarPertinenciaAGrupo(String matricula, String nomeDoGrupo) {
        Grupo grupo = this.getGrupoPeloNome(nomeDoGrupo);
        if(grupo == null) { throw new IllegalArgumentException("Grupo inválido"); }

        Aluno aluno = this.getAluno(matricula);
        if(aluno == null) { throw new IllegalArgumentException("Matrícula inválida"); }

        return !grupo.alunoJaEstaNoGrupo(aluno);
    }

    /**
     * Adiciona um aluno à lista de respondentes
     */
    public void adicionarRespondente(String matricula) {
        if(this.getAluno(matricula) == null) { throw new IllegalArgumentException("Matrícula inexistente"); }

        this.respondentes.add(matricula);
    }

    /**
     * Cria uma lista de todos os alunos que responderam perguntas dentro de um formato específico
     * @return A String da lista de alunos respondentes formatada
     */
    public String gerarRelatorioDeRespondentes() {
        String acumulado = "";

        for(int i = 0; i < this.respondentes.size(); i++) {
            Aluno aluno = this.getAluno(respondentes.get(i));

            acumulado += (i+1) + ". " + aluno + "\n";
        }

        return acumulado;
    }

    public String exibirAluno(String matricula) {
        Aluno aluno = this.getAluno(matricula);
        if(aluno == null) { throw new IllegalArgumentException("Matrícula Inválida"); }

        return "Aluno: " + aluno;
    }

    /** 
     * Verifica se os dados fornecidos são aceitáveis 
     */
    private boolean isValidAluno(String nome, String matricula, String curso) {
        if(nome.trim() == "" || curso.trim() == "") { return false; }
        return true;
    }
}
