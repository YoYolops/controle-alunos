use crate::utils::{
    io,
    parsers
};
use crate::repositories::{
    alunos::RepositorioAlunos,
    grupos::RepositorioGrupos,
    respondentes::RepositorioRespondentes
};
use crate::models::{
    aluno::Aluno,
};
pub struct Facade {
    repositorio_alunos: RepositorioAlunos,
    repositorio_grupos: RepositorioGrupos,
    repositorio_respondentes: RepositorioRespondentes
}

impl Facade {
    pub fn new() -> Self {
        Facade {
            repositorio_alunos: RepositorioAlunos::new(),
            repositorio_grupos: RepositorioGrupos::new(),
            repositorio_respondentes: RepositorioRespondentes::new()
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

    pub fn alocar_aluno_em_grupo(&mut self) {
        print!("(A)locar Aluno ou (P)ertinência a Grupo? "); io::flush_stdout_buffer();
        let user_option: String = io::input().to_lowercase();

        match user_option.as_str().trim() {
            "a" => {
                print!("Matrícula: "); io::flush_stdout_buffer();
                let matricula: String = io::input();
                print!("Grupo: "); io::flush_stdout_buffer();
                let nome_grupo: String = io::input();

                let aluno: Option<&Aluno> = self.repositorio_alunos.procurar_aluno(&matricula);
                match aluno {
                    Some(unwraped_aluno) => {
                        self.repositorio_grupos.alocar_aluno_em_grupo(unwraped_aluno.clone(), &nome_grupo);
                    },
                    None => println!("Aluno não cadastrado!"),
                };
            },
            "p" => {
                print!("Grupo: "); io::flush_stdout_buffer();
                let nome_grupo: String = io::input();
                print!("Aluno: "); io::flush_stdout_buffer();
                let matricula_aluno: String = io::input();

                if !self.repositorio_alunos.aluno_already_registered(&matricula_aluno) {
                    println!("Aluno não existe");
                    return;
                }

                if self.repositorio_grupos.verificar_pertinencia_a_grupo(&nome_grupo, &matricula_aluno) {
                    println!("Aluno pertence ao grupo");
                } else {
                    println!("Aluno não pertence ao grupo");
                }
            }
            _ => println!("Opção inválida"),
        }
    }

    pub fn cadastrar_respondente(&mut self) {
        print!("Matricula: "); io::flush_stdout_buffer();
        let matricula: String = io::input();

        match &self.repositorio_respondentes.adicionar_respondente(matricula, &self.repositorio_alunos) {
            Ok(_) => println!("Aluno Registrado!"),
            Err(_) => println!("Matricula informada não existe no sistema")
        }
    }
}