mod facade;
mod repositories;
mod utils;
mod models;
mod errors;

use crate::{utils::io, facade::Facade};

fn main() {
    let mut system_facade: Facade = Facade::new();
    let mut user_option: String = String::from("");
    
    while user_option.to_lowercase() != "s" {
        io::print_menu();
        user_option = io::input();

        match user_option.as_str().trim() {
            "c" => system_facade.cadastrar_aluno(),
            "e" => system_facade.consultar_aluno(),
            "n" => system_facade.cadastrar_grupo(),
            "a" => system_facade.alocar_aluno_em_grupo(),
            "r" => system_facade.cadastrar_respondente(),
            "i" => println!(""),
            "o" => println!(""),
            "s" => println!(""),
            _ => println!("Opção Inválida!")
        }
    }

    println!("Goodbye and thanks for the fish!!!");
}
