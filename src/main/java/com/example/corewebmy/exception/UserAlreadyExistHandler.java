package com.example.corewebmy.exception;

import com.example.corewebmy.config.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserAlreadyExistHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UserAlreadyExistException.class)
    public ExceptionResponse handlerException(Exception ex) {
        return ExceptionResponse.of()
                .error(Constants.USER_ALREADY_EXIST)
                .errorDescription(ex.getMessage())
                .httpStatus(HttpStatus.CONFLICT)
                .create();
    }

}
