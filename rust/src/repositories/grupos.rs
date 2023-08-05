use crate::models::grupo::Grupo;

pub struct RepositorioGrupos<'a> {
    grupos: Vec<Grupo<'a>>
}

impl <'a> RepositorioGrupos<'a> {
    pub fn new() -> Self {
        RepositorioGrupos { grupos: Vec::new() }
    }

    pub fn cadastrar_novo_grupo(&mut self, inome: String, itamanho: isize) {
        self.grupos.push(Grupo::new(inome, itamanho));
    }

    pub fn listar_grupos(&self) {
        for grupo in &self.grupos {
            grupo.display();
        }
    }
}