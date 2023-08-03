pub fn input() -> String {
    let mut input_string: String = String::new();
    std::io::stdin()
        .read_line(&mut input_string)
        .expect("Panicked while colecting user input");

    input_string
}

pub fn print_menu() {
    println!("(C)adastrar Aluno");
    println!("(E)xibir Aluno");
    println!("(N)ovo Grupo");
    println!("(A)locar Aluno no Grupo e Verificar pertinência a Grupos");
    println!("(R)egistrar Aluno que Respondeu");
    println!("(I)mprimir Alunos que Responderam");
    println!("(O)lhaí quais Grupos o Aluno Tá.");
    println!("(S)im, quero Fechar o Programa!");
    println!();
    print!("Opção> ");
}