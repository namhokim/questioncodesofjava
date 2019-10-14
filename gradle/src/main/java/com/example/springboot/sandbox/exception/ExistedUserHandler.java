package com.example.springboot.sandbox.exception;

import me.alidg.errors.HandledException;
import me.alidg.errors.WebErrorHandler;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class ExistedUserHandler implements WebErrorHandler {

    @Override
    public boolean canHandle(Throwable exception) {
        return exception instanceof UserAlreadyExistsException;
    }

    @Override
    public HandledException handle(Throwable exception) {
        return new HandledException("user.already_exists", BAD_REQUEST, null);
    }
}
