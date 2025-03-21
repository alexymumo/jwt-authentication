package com.technobraintask.ecommerce_api.exceptions;


import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ProblemDetail problemDetail(Exception exception) {

        ProblemDetail problemDetail = null;

        exception.printStackTrace();

        if (exception instanceof AccessDeniedException) {
            problemDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403),exception.getMessage());
            problemDetail.setProperty("description","Not authorized");
        }

        if (exception instanceof ExpiredJwtException) {
            problemDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403),exception.getMessage());
            problemDetail.setProperty("description","expired jwt token");
        }

        if (exception instanceof BadCredentialsException) {
            problemDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(401),exception.getMessage());
            problemDetail.setProperty("description","incorrect credentials");
        }
        return problemDetail;


    }
}
