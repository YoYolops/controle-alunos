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
		Controle controle = new Controle();

		controle.cadastrarAluno("yoyo", "123", "Joaninha");
		controle.adicionarGrupo("Joaninha", "10");

		assertThrows(IllegalArgumentException.class, () -> controle.alocarAlunoEmGrupo("", "Joaninha"));
		assertThrows(IllegalArgumentException.class, () -> controle.alocarAlunoEmGrupo("123", ""));

		controle.alocarAlunoEmGrupo("123", "Joaninha");
		Aluno aluno = controle.getAluno("123");
		String gruposEsperados = "Grupos:\n- Joaninha\n";

		assertEquals(gruposEsperados, aluno.getGrupos());
	}

	@Test
	public void testVerificarPertinenciaAGrupo() {
		Controle controle = new Controle();

		assertThrows(IllegalArgumentException.class, () -> controle.verificarPertinenciaAGrupo("", "Joaninha"));
		assertThrows(IllegalArgumentException.class, () -> controle.verificarPertinenciaAGrupo("123", ""));

		controle.cadastrarAluno("yoyo", "123", "Joaninha");
		controle.adicionarGrupo("Joaninha", "10");

		assertEquals(true, controle.verificarPertinenciaAGrupo("123", "Joaninha"));
		controle.alocarAlunoEmGrupo("123", "Joaninha");
		assertEquals(false, controle.verificarPertinenciaAGrupo("123", "Joaninha"));
	}

	@Test
	public void testAdicionarRespondente() {
		Controle controle = new Controle();
		controle.cadastrarAluno("yoyo", "123", "Joaninha");

		assertThrows(IllegalArgumentException.class, () -> controle.adicionarRespondente(""));
		assertThrows(IllegalArgumentException.class, () -> controle.adicionarRespondente("!@##$%&"));

		controle.adicionarRespondente("123");
		
		String relatorioEsperado = "1. 123 - yoyo - Joaninha\n";
		String relatorioObtido = controle.gerarRelatorioDeRespondentes();

		assertEquals(relatorioEsperado, relatorioObtido);
	}

	@Test
	public void testGerarRelatorioDeRespondentes() {
		Controle controle = new Controle();
		controle.cadastrarAluno("yoyo", "123", "Joaninha");
		controle.cadastrarAluno("yoyo", "321", "Joaninha");

		controle.adicionarRespondente("123");
		controle.adicionarRespondente("321");

		String relatorioEsperado = "1. 123 - yoyo - Joaninha\n" + "2. 321 - yoyo - Joaninha\n";
		String relatorioObtido = controle.gerarRelatorioDeRespondentes();

		assertEquals(relatorioEsperado, relatorioObtido);
	}

	@Test
	public void testExibirAluno() {
		Controle controle = new Controle();
		controle.cadastrarAluno("yoyo", "123", "Joaninha");

		assertThrows(IllegalArgumentException.class, () -> controle.exibirAluno(""));

		String exibicaoEsperada = "Aluno: 123 - yoyo - Joaninha";
		String exibicaoObtida = controle.exibirAluno("123");

		assertEquals(exibicaoEsperada, exibicaoObtida);
	}
}
