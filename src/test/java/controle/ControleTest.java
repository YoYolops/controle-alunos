package controle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ControleTest {

	@Test
	public void testAdicionarGrupo() {
		Controle controle = new Controle();

		controle.adicionarGrupo("yoyo", "10");
		Grupo grupoAdicionado = controle.getGrupoPeloNome("yoyo");

		assertEquals("yoyo", grupoAdicionado.getNome());
	}

	@Test
	public void testCadastrarAluno() {
		Controle controle = new Controle();

		controle.cadastrarAluno("yoyo", "123", "joaninha");
		assertEquals("Aluno: 123 - yoyo - joaninha", controle.exibirAluno("123"));

		assertThrows(IllegalArgumentException.class, () -> controle.cadastrarAluno("yoyo", "", "Matemática"));
		assertThrows(IllegalArgumentException.class, () -> controle.cadastrarAluno("yoyo", "", ""));
		assertThrows(IllegalArgumentException.class, () -> controle.cadastrarAluno("", "", "Matemática"));
	}

	@Test
	public void testAlocarAlunoEmGrupo() {
		
	}

	@Test
	public void testVerificarPertinenciaAGrupo() {

	}

	@Test
	public void testAdicionarRespondente() {

	}

	@Test
	public void testGerarRelatorioDeRespondentes() {

	}

	@Test
	public void testExibirAluno() {

	}

}
