use crate::errors::parameters::InvalidParameters;
use crate::models::aluno::Aluno;

pub struct Grupo<> {
    nome: String,
    tamanho: isize,
    alunos: Vec<Aluno>
}

impl Grupo {
    pub fn new(inome: String, itamanho: isize) -> Self {
        Grupo {
            nome: inome,
            tamanho: itamanho,
            alunos: Vec::new()
        }
    }

    pub fn get_nome(&self) -> &String{
        &self.nome
    }

    pub fn is_aluno_alocado(&self, imatricula: &String) -> bool {
        for aluno in &self.alunos {
            if aluno.get_matricula() == imatricula {
                return true;
            }
        }
        false
    }

    pub fn alocar_aluno(&mut self, aluno: Aluno) {
        if !self.is_aluno_alocado(aluno.get_matricula()) {
            self.alunos.push(aluno);
        }
    }

    pub fn display(&self) {
        println!("- {} | Tamanho: {}", &self.get_nome(), &self.tamanho);
    }

}