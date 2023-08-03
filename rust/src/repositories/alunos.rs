use crate::models::aluno::Aluno;
use crate::errors::parameters::InvalidParameters;

pub struct RepositorioAlunos {
    alunos: Vec<Aluno>
}

impl RepositorioAlunos {
    pub fn new() -> RepositorioAlunos {
        RepositorioAlunos {
            alunos: Vec::new()
        }
    }

    pub fn cadastrar_aluno(&mut self, imatricula: String, inome: String, icurso: String) -> Result<(), InvalidParameters> {
        if self.aluno_already_registered(&imatricula) {
            return Err(InvalidParameters::AlreadyRegisteredStudent);
        }

        let novo_aluno = Aluno::new(inome, imatricula, icurso);
        self.alunos.push(novo_aluno);
        Ok(())
    }

    pub fn listar_alunos(&self) {
        for i in &self.alunos {
            println!("{} - {} - {}", i.get_matricula(), i.get_nome(), i.get_curso());
        }
    }

    fn aluno_already_registered(&self, matricula: &String) -> bool {
        for i in &self.alunos {
            if i.get_matricula() == matricula {
                return true;
            }
        }
        false
    }
}

