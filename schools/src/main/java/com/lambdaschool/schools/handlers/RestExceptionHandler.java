package com.lambdaschool.schools.handlers;

import com.lambdaschool.schools.exceptions.ResourceNotFoundException;
import com.lambdaschool.schools.models.ErrorDetails;
import com.lambdaschool.schools.services.HelperFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @Autowired
    HelperFunctions helperFunctions;

    public RestExceptionHandler(){
        super();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException (ResourceNotFoundException rnfe){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTimestamp(new Date());
        errorDetails.setStatus(HttpStatus.NOT_FOUND.value());
        errorDetails.setTitle("Resource Not Found");
        errorDetails.setDetail(rnfe.getMessage());
        errorDetails.setDeveloperMessage(rnfe.getClass().getName());
        errorDetails.setErrors(helperFunctions.getConstraintViolations(rnfe));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
