package com.schoolclass.demo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(H)
public class IncorrectFormatException extends RuntimeException {
}
