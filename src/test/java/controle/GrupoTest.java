package controle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrupoTest {
	@Test
	public void testConstrutorGrupo() {
		Grupo grupo = new Grupo("yoyo", 10);
		assertEquals("yoyo", grupo.getNome());

		Grupo grupo2 = new Grupo("yoyo2");
		assertEquals("yoyo2", grupo2.getNome());
	}

	/**
     * Cadastra vários alunos em um grupo onde o tamanho não foi especificado.
	 * Espera-se que o grupo cresça a medida no necessário para acomodar os novos membros
     */
	@Test
	public void testAdicionarAlunosComTamanhoVariavel() {
		Grupo grupo = new Grupo("yoyo");

		String membrosEsperados = "";
		for(int i = 0; i < 36; i++) {
			Aluno aluno = new Aluno("yoyo", String.valueOf(i), "Matemática");
			grupo.adicionarAluno(aluno);
			membrosEsperados += (aluno + "\n");
		}

		assertEquals(membrosEsperados, grupo.getMembros());
	}

	/**
     * Tenta adicionar o mesmo aluno várias vezes, o programa deve ignorar o pedido e apenas
	 * adicionar da primiera vez que foi pedido.
     */
	@Test
	public void testAdicionarMesmoAlunoVariasVezes() {
		Grupo grupo = new Grupo("yoyo");
		Aluno aluno = new Aluno("yoyo", "1", "Matemática");

		String membrosEsperados = aluno + "\n";

		for(int i = 0; i < 36; i++) {
			grupo.adicionarAluno(aluno);
		}

		assertEquals(membrosEsperados, grupo.getMembros());
	}

	/**
     * Tenta adicionar mais alunos do que o grupo permite, espera-se que,
	 * nesse caso, o grupo retorne false, indicando que o aluno não foi cadastrado
     */
	@Test
	public void testAdicionarAlunosComTamanhoFixo() {
		Grupo grupo = new Grupo("Joaninha", 10);
		boolean[] resultados = new boolean[11]; 

		for(int i = 0; i < 11; i++) {
			Aluno aluno = new Aluno("Joaninha", ("1" + i), "Joaninha");
			resultados[i] = grupo.adicionarAluno(aluno);

			if(i <= 9) {
				assertEquals(true, resultados[i]);
			} else {
				assertEquals(false, resultados[i]);
			}
		}
	}

	@Test
	public void testAlunoJaEstaNoGrupo() {
		// Alunos são diferenciados unica e exclusivamente pela matrícula
		Aluno aluno1 = new Aluno("yoyo", "1", "joaninha");
		Aluno aluno2 = new Aluno("yoyo", "2", "joaninha");
		Aluno aluno3 = new Aluno("yoyo", "3", "joaninha");

		Grupo grupo = new Grupo("Joaninha");

		grupo.adicionarAluno(aluno1);
		grupo.adicionarAluno(aluno2);

		assertEquals(true, grupo.alunoJaEstaNoGrupo(aluno1));
		assertEquals(true, grupo.alunoJaEstaNoGrupo(aluno2));
		assertEquals(false, grupo.alunoJaEstaNoGrupo(aluno3));
	}
}
