package com.study.board.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BoardNotFoundException extends Exception {
    public BoardNotFoundException(String message) {
        super(message);
    }
}
