use std::fmt;

#[derive(Debug)]
pub enum InvalidParameters  {
    AlreadyRegisteredStudent,
    ValueNotFound
}

impl fmt::Display for InvalidParameters {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        match *self {
            Self::AlreadyRegisteredStudent => write!(f, "ERROR: You're attempting to register an already existent user"),
            Self::ValueNotFound => write!(f, "NOT FOUND ERROR: Could not find a correspondence internaly"),
        }
    }
}

impl std::error::Error for InvalidParameters {
    fn description(&self) -> &str {
        match *self {
            Self::AlreadyRegisteredStudent => "ERROR: You're attempting to register an already existent user",
            Self::ValueNotFound => "NOT FOUND ERROR: Could not find a correspondence internaly"
        }
    }
}