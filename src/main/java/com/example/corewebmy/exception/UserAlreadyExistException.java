package com.example.corewebmy.exception;

import com.example.corewebmy.config.Constants;

public class UserAlreadyExistException extends RuntimeException {

    private final long serialVersionUID = -138567463525337L;

    public UserAlreadyExistException(){
        super(Constants.USER_ALREADY_EXIST_DESCRIPTION);
    }

}
