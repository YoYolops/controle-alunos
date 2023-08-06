use super::alunos::RepositorioAlunos;
use crate::errors::parameters::InvalidParameters;

pub struct RepositorioRespondentes {
    matriculas_respondentes: Vec<String>
}

impl RepositorioRespondentes {
    pub fn new() -> Self {
        RepositorioRespondentes {
            matriculas_respondentes: Vec::new()
        }
    }

    pub fn adicionar_respondente(&mut self, matricula: String, rep_alunos: &RepositorioAlunos) -> Result<(), InvalidParameters> {
        if rep_alunos.aluno_already_registered(&matricula) {
            self.matriculas_respondentes.push(matricula);
            return Ok(());
        }
        Err(InvalidParameters::ValueNotFound)
    }

    pub fn display(&self, rep_alunos: &RepositorioAlunos) {
        for matricula in &self.matriculas_respondentes {
            match rep_alunos.procurar_aluno(matricula) {
                Some(aluno) => aluno.display(),
                None => (),
            }
        }
    }
}