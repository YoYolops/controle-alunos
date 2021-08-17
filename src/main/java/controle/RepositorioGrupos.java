package controle;

import java.util.HashMap;
import java.util.Map;

public class RepositorioGrupos {
    private Map<String, Grupo> mapaGrupos = new HashMap<String, Grupo>();

    public void adicionarGrupo(String nomeDoGrupo, int tamanhoDoGrupo) {
        Grupo novoGrupo = new Grupo(nomeDoGrupo, tamanhoDoGrupo);
        mapaGrupos.put(novoGrupo.getNome(), novoGrupo);
    }

    public Grupo getGrupoPeloNome(String nomeDoGrupo) {
        String upperNomeDoGrupo = nomeDoGrupo.toUpperCase();
        return mapaGrupos.get(upperNomeDoGrupo);
    }
}
