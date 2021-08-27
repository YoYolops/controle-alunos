package controle;

/**
 * Entidade que representa um Grupo de estudos. Armazena o nome o grupo e seus membros
 * @author Yohan Lopes (https://github.com/YoYolops)
 */
public class Grupo {
    private String nome;
    private Aluno[] membros;
    /** 
     * O grupo possui um limite de estudantes ou não? é isso que tamanhoFixo representa
     */
    private boolean tamanhoFixo;

    /**
     * Gerencia a criação do objeto quando o t grupo não possui tamanho limite
     */
    public Grupo(String nomeDoGrupo) {
        if(nomeDoGrupo.trim() == "") { throw new IllegalArgumentException("Nome inválido"); }

        this.nome = nomeDoGrupo;
        this.membros = new Aluno[10];
        this.tamanhoFixo = false;
    }

    /**
     * Gerencia a criação do objeto quando o grupo possui um tamanho máximo
     */
    public Grupo(String nomeDoGrupo, int tamanhoDoGrupo) {
        if(tamanhoDoGrupo < 2) { throw new IllegalArgumentException("Tamanho inválido"); }
        if(nomeDoGrupo.trim() == "") { throw new IllegalArgumentException("Nome inválido"); }

        this.nome = nomeDoGrupo;
        this.membros = new Aluno[tamanhoDoGrupo];
        this.tamanhoFixo = true;
    }

    /** 
     * Por ter adotado um array como estrutura de dados padrão, verifica se a lotação
     * máxima do array foi atingida.
     * @return booleano true caso o array de alunos esteja lotado, false caso contrário
     */
    private boolean estaLotado() {
        for(Aluno aluno : membros) {
            if(aluno == null) { return false; } 
        }
        return true;
    }

    /** 
     * Expande o array de alunos para que mais possam ser adicionados. Só é executada
     * quando um número máximo para quantidade de alunos não é especificado
     */
    private void expandirMembros() {
        Aluno[] novoArray = new Aluno[this.membros.length + 10];

        for(int i = 0; i < membros.length; i++) {
            novoArray[i] = membros[i];
        }
        this.membros = novoArray;
    }

    public boolean adicionarAluno(Aluno aluno) {
        boolean lotacaoMaxima = estaLotado();

        if(alunoJaEstaNoGrupo(aluno)) { return true; }
        if(!this.tamanhoFixo && lotacaoMaxima) { expandirMembros(); }

        for(int i = 0; i < membros.length; i++) {
            if(membros[i] == null) {
                membros[i] = aluno;
                aluno.adicionarGrupo(this.nome);
                return true;
            }
        }
        return false; // só retorna false quando o grupo já está cheio
    }

    /**
     * Verifica se um aluno já está cadastrado no grupo
     * @return true caso esteja, falso caso contrário
     */
    public boolean alunoJaEstaNoGrupo(Aluno aluno) {
        String matriculaDoAluno = aluno.getMatricula();

        for(int i = 0; i < membros.length; i++) {
            if(membros[i] != null) {
                String matriculaDoMembro = membros[i].getMatricula();
                if(matriculaDoMembro.equals(matriculaDoAluno)) { return true; }
            }
        }
        return false;
    }

    public String getNome() {
        return this.nome;
    }

    public String getMembros() {
        String membros = "";

        for(int i = 0; i < this.membros.length; i++) {
            if(this.membros[i] != null) { membros += (this.membros[i] + "\n"); }
        }

        return membros;
    }
}
