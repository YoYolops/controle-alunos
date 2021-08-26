package controle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlunoTest {

	@Test
	public void testConstrutorAluno() {
		assertThrows(IllegalArgumentException.class, () -> new Aluno("", "123", "Matemática"));
		assertThrows(IllegalArgumentException.class, () -> new Aluno("yoyo", "123", ""));
		assertThrows(IllegalArgumentException.class, () -> new Aluno("yoyo", "", "Matemática"));
	}

	@Test
	public void testAdicaoDeGrupo() {
		Aluno aluno = new Aluno("yoyo", "123", "Mat");

		aluno.adicionarGrupo("Joao");

		assertEquals("Grupos:\n- Joao\n", aluno.getGrupos());

		aluno.adicionarGrupo("Joao2");
		aluno.adicionarGrupo("Joao3");
		assertEquals("Grupos:\n- Joao\n- Joao2\n- Joao3\n", aluno.getGrupos());
	}

	@Test
	public void testAdicaoDeGrupoVazio() {
		Aluno aluno = new Aluno("yoyo", "123", "Mat");
		assertThrows(IllegalArgumentException.class, () -> aluno.adicionarGrupo(""));
		assertThrows(IllegalArgumentException.class, () -> aluno.adicionarGrupo("    "));
	}
}
