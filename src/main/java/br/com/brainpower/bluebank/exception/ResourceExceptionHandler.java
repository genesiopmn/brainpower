package br.com.brainpower.bluebank.exception;

import br.com.brainpower.bluebank.service.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException resourceNotFoundException, HttpServletRequest httpServletRequest){
        String error = "Resource Not Found Exception";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), httpStatus.value(), error, resourceNotFoundException.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(standardError);
    }
}