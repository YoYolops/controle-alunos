use crate::models::aluno::Aluno;

pub struct Grupo<> {
    nome: String,
    tamanho: usize,
    alunos: Vec<Aluno>
}

impl Grupo {
    pub fn new(inome: String, itamanho: usize) -> Self {
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
        if self.tamanho == 0 || self.alunos.len() < self.tamanho {
            if !self.is_aluno_alocado(aluno.get_matricula()) {
                self.alunos.push(aluno);
            }
        } else {
            println!("Grupo Cheio!");
        }

    }
}