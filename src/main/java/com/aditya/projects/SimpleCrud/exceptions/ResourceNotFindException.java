package com.aditya.projects.SimpleCrud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User Not Exists")
public class ResourceNotFindException extends RuntimeException{

    public ResourceNotFindException(String message){
        super(message);
    }
}
