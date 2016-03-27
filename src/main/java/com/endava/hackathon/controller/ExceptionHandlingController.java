package com.endava.hackathon.controller;

import com.endava.hackathon.dto.ServerResponse;
import com.endava.hackathon.exceptions.UserNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlingController {
    private static final Logger LOGGER = Logger.getLogger(ExceptionHandlingController.class);

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ServerResponse userNotFound(UserNotFoundException e) {
        return new ServerResponse(ServerResponse.Status.ERROR, e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ServerResponse badRequest(HttpMessageNotReadableException e) {
        return new ServerResponse(ServerResponse.Status.ERROR, "The given parameters were not correct.");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ServerResponse unknownException(Exception e) {
        LOGGER.debug(e.getMessage(), e);
        return new ServerResponse(ServerResponse.Status.ERROR, "An unexpected exception occurred while processing the request.");
    }
}
