package sk.stuba.fei.uim.oop.assignment3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BadRequestException extends RuntimeException {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void BadRequestException(){}
}
