use crate::utils::io;
use crate::errors::parameters::InvalidParameters;
use crate::repositories::{
    alunos::RepositorioAlunos,
    grupos
};
pub struct Facade {
    repositorio_alunos: RepositorioAlunos
}

impl Facade {
    pub fn new() -> Facade {
        Facade {repositorio_alunos: RepositorioAlunos::new()}
    }

    pub fn cadastrar_aluno(&mut self) -> Result<(), InvalidParameters> {
        print!("Matrícula: "); io::flush_stdout_buffer();
        let matricula: String = io::input();
    
        print!("Nome: "); io::flush_stdout_buffer();
        let nome: String = io::input();
    
        print!("Curso: "); io::flush_stdout_buffer();
        let curso: String = io::input();
    
        let _ = &self.repositorio_alunos.cadastrar_aluno(matricula, nome, curso)?;
        Ok(())
    }
}