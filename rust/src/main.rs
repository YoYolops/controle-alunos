use repositories::alunos::RepositorioAlunos;

use crate::repositories::alunos;

pub mod repositories;
pub mod utils;
mod models;

fn main() {
    let mut alunos: RepositorioAlunos = alunos::RepositorioAlunos::new();
    alunos.listar_alunos();
    alunos.cadastrar_aluno(String::from("250B"), String::from("Yohan Lopes Rodrigues"), String::from("Ciências da Computação"));
    alunos.cadastrar_aluno(String::from("250B"), String::from("Yohan Lopes Rodrigues"), String::from("Ciências da Computação"));
    alunos.cadastrar_aluno(String::from("250B"), String::from("Yohan Lopes Rodrigues"), String::from("Ciências da Computação"));
    alunos.listar_alunos();
}
