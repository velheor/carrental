package com.senla.training.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestExceptionHandler {
  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorMessage resourceNotFoundException(IllegalArgumentException ex, WebRequest request) {
    return new ErrorMessage(
        HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage(), request.getDescription(false));
  }

  @ExceptionHandler(NullPointerException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorMessage resourceNotFoundException(NullPointerException ex, WebRequest request) {
    return new ErrorMessage(
        HttpStatus.BAD_REQUEST.value(), new Date(), ex.getMessage(), "Bad enter");
  }

  @ExceptionHandler(UsernameNotFoundException.class)
  @ResponseStatus(value = HttpStatus.FORBIDDEN)
  public ErrorMessage resourceNotFoundException(UsernameNotFoundException ex, WebRequest request) {
    return new ErrorMessage(
        HttpStatus.FORBIDDEN.value(), new Date(), ex.getMessage(), request.getDescription(false));
  }

  @ExceptionHandler(BadCredentialsException.class)
  @ResponseStatus(value = HttpStatus.FORBIDDEN)
  public ErrorMessage resourceNotFoundException(BadCredentialsException ex, WebRequest request) {
    return new ErrorMessage(
        HttpStatus.FORBIDDEN.value(), new Date(), ex.getMessage(), request.getDescription(false));
  }
}
