use super::parameters::InvalidParameters;

pub fn handle(result: Result<(), InvalidParameters>) {
    match result {
        Err(message) => println!("{}", message),
        _ => println!()
    }
}