use std::fmt;

#[derive(Debug)]
pub enum InvalidParameters  {
    AlreadyRegisteredStudent,
}

impl fmt::Display for InvalidParameters {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        match *self {
            InvalidParameters::AlreadyRegisteredStudent => write!(f, "ERROR: You're attempting to register an already existent user"),
        }
    }
}

impl std::error::Error for InvalidParameters {
    fn description(&self) -> &str {
        match *self {
            InvalidParameters::AlreadyRegisteredStudent => "ERROR: You're attempting to register an already existent user"
        }
    }
}