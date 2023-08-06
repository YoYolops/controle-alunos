
pub struct Aluno {
    nome: String,
    matricula: String,
    curso: String,
    is_origin: bool
}

impl Aluno {
    pub fn new(inome: String, imatricula: String, icurso: String) -> Aluno {
        Aluno {
            nome: inome,
            matricula: imatricula,
            curso: icurso,
            is_origin: true
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

    pub fn clone(&self) -> Self {
        Aluno {
            nome: String::from(&self.nome),
            matricula: String::from(&self.matricula),
            curso: String::from(&self.curso),
            is_origin: false
        }
    }

    pub fn display(&self) {
        println!("{} - {} - {}", &self.get_matricula(), &self.get_nome(), &self.get_curso());
    }
}

