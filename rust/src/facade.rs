use crate::utils::{
    io,
    parsers
};
use crate::repositories::{
    alunos::RepositorioAlunos,
    grupos::RepositorioGrupos
};
pub struct Facade<'a> {
    repositorio_alunos: RepositorioAlunos,
    repositorio_grupos: RepositorioGrupos<'a>
}

impl<'a> Facade <'a> {
    pub fn new() -> Self {
        Facade {
            repositorio_alunos: RepositorioAlunos::new(),
            repositorio_grupos: RepositorioGrupos::new()
        }
    }

    pub fn cadastrar_aluno(&mut self) {
        print!("Matrícula: "); io::flush_stdout_buffer();
        let matricula: String = io::input();
    
        print!("Nome: "); io::flush_stdout_buffer();
        let nome: String = io::input();
    
        print!("Curso: "); io::flush_stdout_buffer();
        let curso: String = io::input();
    
        // might cast an error:
        match &self.repositorio_alunos.cadastrar_aluno(matricula, nome, curso) {
            Ok(_) => println!("Cadastro Realizado!"),
            Err(_error) => println!("Matrícula já Cadastrada!"),
        }
    }

    pub fn consultar_aluno(&self) {
        print!("Matrícula: "); io::flush_stdout_buffer();
        let matricula:String = io::input();
        println!();
        match &self.repositorio_alunos.procurar_aluno(&matricula) {
            Some(aluno) => aluno.display(),
            None => println!("Aluno não cadastrado")
        }
    }

    pub fn cadastrar_grupo(&mut self) {
        print!("Grupo: "); io::flush_stdout_buffer();
        let nome_grupo: String = io::input();
        print!("Tamanho: "); io::flush_stdout_buffer();
        let tamanho: isize = parsers::parse_to_int(&io::input());

        self
            .repositorio_grupos
            .cadastrar_novo_grupo(nome_grupo, tamanho);

        println!("Cadastro Realizado");
    }
}