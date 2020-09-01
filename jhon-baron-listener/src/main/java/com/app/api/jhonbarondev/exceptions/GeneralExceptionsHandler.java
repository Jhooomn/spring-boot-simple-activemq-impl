package com.app.api.jhonbarondev.exceptions;

import com.app.api.jhonbarondev.exceptions.response.ResponseData;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionsHandler {

  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  public ResponseData handleGeneralException(Exception exception) {
    return ResponseData.builder()
        .id(UUID.randomUUID().toString())
        .message("There was an unexpected error. Try later.")
        .build();
  }

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(EmployeeExceptions.class)
  public ResponseData handleEmployeeException(EmployeeExceptions exception) {
    return ResponseData.builder()
        .id(UUID.randomUUID().toString())
        .message(exception.getMessage())
        .build();
  }
}
