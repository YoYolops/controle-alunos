mod facade;
mod repositories;
mod utils;
mod models;
mod errors;

use crate::utils::io;

fn main() {
    let mut user_option: String = String::from("");
    
    while user_option.to_lowercase() != "s" {
        io::print_menu();
        user_option = io::input();

        match user_option.as_str().trim() {
            "c" => println!("You chose a"),
            _ => println!("I just do not know what is happening")
        }
    }

    println!("Goodbye and thanks for the fish!!!");
}
