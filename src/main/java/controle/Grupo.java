package controle;

public class Grupo {
    private String nome;
    private Aluno[] membros;

    public Grupo(String nomeDoGrupo) {
        if(nomeDoGrupo.trim() == "") { throw new IllegalArgumentException("Nome inválido"); }

        this.nome = nomeDoGrupo.toUpperCase();
        this.membros = new Aluno[10];
    }

    public Grupo(String nomeDoGrupo, int tamanhoDoGrupo) {
        if(tamanhoDoGrupo < 2) { throw new IllegalArgumentException("Tamanho inválido"); }
        if(nomeDoGrupo.trim() == "") { throw new IllegalArgumentException("Nome inválido"); }

        this.nome = nomeDoGrupo.toUpperCase();
        this.membros = new Aluno[tamanhoDoGrupo];
    }

    private boolean verificarNecessidadeDeExpansao() {
        for(Aluno aluno : membros) {
            if(aluno == null) { return false; } 
        }
        return true;
    }

    private void expandirMembros() {
        Aluno[] novoArray = new Aluno[this.membros.length + 10];

        for(int i = 0; i < membros.length; i++) {
            novoArray[i] = membros[i];
        }
        this.membros = novoArray;
    }

    public boolean adicionarAluno(Aluno aluno) {
        if(alunoJaEstaNoGrupo(aluno)) { return true; }
        if(verificarNecessidadeDeExpansao()) { expandirMembros(); }

        aluno.adicionarGrupo(this.nome);

        for(int i = 0; i < membros.length; i++) {
            if(membros[i] == null) {
                membros[i] = aluno;
                return true;
            }
        }
        return false; // só retorna false quando o grupo já está cheio
    }

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
}
