package com.example.rest.exception;

import com.example.rest.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
@ResponseStatus
public class ExceptionHandlerMesg extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DepartmentExceptionRaBabu.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentExceptionRaBabu e, WebRequest request){
    ErrorMessage msg = new ErrorMessage(HttpStatus.NOT_FOUND,e.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }
}
