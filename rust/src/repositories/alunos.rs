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

    pub fn procurar_aluno(&self, imatricula: &String) -> Option<&Aluno> {
        for aluno in &self.alunos {
            if aluno.get_matricula() == imatricula {
                return Some(&aluno);
            }
        }
        None
    }

    pub fn listar_alunos(&self) {
        for i in &self.alunos {
            i.display();
        }
    }

    pub fn aluno_already_registered(&self, matricula: &String) -> bool {
        match &self.procurar_aluno(matricula) {
            Some(_aluno) => return true,
            None => return false
        }
    }
}

