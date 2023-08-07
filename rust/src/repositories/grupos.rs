use crate::models::{
    grupo::Grupo,
    aluno::Aluno
};

pub struct RepositorioGrupos {
    grupos: Vec<Grupo>
}

impl RepositorioGrupos {
    pub fn new() -> Self {
        RepositorioGrupos { grupos: Vec::new() }
    }

    pub fn cadastrar_novo_grupo(&mut self, inome: String, itamanho: usize) {
        match self.get_grupo(&inome) {
            Some(_) => println!("Já existe um grupo com esse nome"),
            None => {
                self.grupos.push(Grupo::new(inome, itamanho));
                println!("Grupo cadastrado!")
            },
        }
        
    }

    pub fn alocar_aluno_em_grupo(&mut self, aluno: Aluno, nome_grupo: &String) {
        for grupo in &mut self.grupos {
            if grupo.get_nome() == nome_grupo {
                grupo.alocar_aluno(aluno);
                println!("Aluno alocado!");
                return;
            }
        }
        println!("O grupo informado não existe. Aluno NÃO alocado");
    }

    pub fn get_grupo(&mut self, nome_grupo: &String) -> Option<&Grupo> {
        for grupo in &self.grupos {
            if grupo.get_nome() == nome_grupo {
                return Some(grupo);
            }
        }
        None
    }

    pub fn verificar_pertinencia_a_grupo(&mut self, nome_grupo: &String, matricula: &String) -> bool {
        match &self.get_grupo(nome_grupo) {
            Some(grupo) => return grupo.is_aluno_alocado(matricula),
            None => {
                println!("Grupo não cadastrado");
                return false;
            }
        }
    }

    pub fn display_grupos_do_estudante(&self, matricula: &String) {
        for grupo in &self.grupos {
            if grupo.is_aluno_alocado(matricula) {
                println!("- {}", grupo.get_nome())
            }
        }
    }
}