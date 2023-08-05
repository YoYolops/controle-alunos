
pub struct Aluno {
    nome: String,
    matricula: String,
    curso: String
}

impl Aluno {
    pub fn new(inome: String, imatricula: String, icurso: String) -> Aluno {
        Aluno {
            nome: inome,
            matricula: imatricula,
            curso: icurso
        }
    }

    pub fn get_nome(&self) -> &String {
        &self.nome
    }

    pub fn get_matricula(&self) -> &String{
        &self.matricula
    }

    pub fn get_curso(&self) -> &String {
        &self.curso
    }

    pub fn display(&self) {
        println!("{} - {} - {};", &self.get_matricula(), &self.get_nome(), &self.get_curso());
    }
}

