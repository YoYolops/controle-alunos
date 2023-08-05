mod facade;
mod repositories;
mod utils;
mod models;
mod errors;

use crate::{utils::io, facade::Facade, errors::handler as error_handler};

fn main() {
    const CONTROLE_ALUNOS: Facade = facade::Facade::new();
    let mut user_option: String = String::from("");
    
    while user_option.to_lowercase() != "s" {
        io::print_menu();
        user_option = io::input();

        match user_option.as_str().trim() {
            "c" => error_handler::handle(CONTROLE_ALUNOS.cadastrar_aluno()),
            "e" => CONTROLE_ALUNOS.consultar_aluno(),
            "n" => println!("(N)ovo Grupo"),
            "a" => println!("(A)locar Aluno no Grupo e Verificar pertinência a Grupos"),
            "r" => println!("(R)egistrar Aluno que Respondeu"),
            "i" => println!(""),
            "o" => println!(""),
            "s" => println!(""),
            _ => println!("Opção Inválida!")
        }
    }

    println!("Goodbye and thanks for the fish!!!");
}
