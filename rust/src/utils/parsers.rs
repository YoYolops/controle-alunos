pub fn parse_to_int(str: &String) -> usize {
    let parsed_value: usize = str
        .trim()
        .parse()
        .expect("Panicked while parsing string");

    parsed_value
}