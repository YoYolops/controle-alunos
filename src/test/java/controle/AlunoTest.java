package controle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlunoTest {

	@Test
	public void testAluno() {
		assertThrows(IllegalArgumentException.class, () -> new Aluno("   ", "123", "Matemática"));
		assertThrows(IllegalArgumentException.class, () -> new Aluno("yoyo", "123", ""));
		assertThrows(IllegalArgumentException.class, () -> new Aluno("yoyo", "", "Matemática"));
	}

}
