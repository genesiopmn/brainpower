package br.com.brainpower.bluebank.exception;

import br.com.brainpower.bluebank.service.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

/**
 * Exceção para controlar todas as exceções emitidas na API
 * Controle centralizado e resposta adquedas para o controller
 */
@ControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException resourceNotFoundException, HttpServletRequest httpServletRequest){
        String error = "Resource Not Found Exception";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), httpStatus.value(), error, resourceNotFoundException.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(standardError);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError> illegalArgumentException(IllegalArgumentException illegalArgumentException, HttpServletRequest httpServletRequest){
        String error = "Illegal Argument Exception";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), httpStatus.value(), error, illegalArgumentException.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(standardError);
    }
    @ExceptionHandler(AccountDisableException.class)
    public ResponseEntity<StandardError> accountDisableException(AccountDisableException accountDisableException, HttpServletRequest httpServletRequest){
        String error = "Account Disable";
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError(Instant.now(), httpStatus.value(), error, accountDisableException.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(standardError);
    }
    @ExceptionHandler(NoBalanceAccount.class)
    public ResponseEntity<StandardError> NoBalanceAccount(NoBalanceAccount noBalanceAccount, HttpServletRequest httpServletRequest){
        String error = "Not Found Balance";
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError(Instant.now(), httpStatus.value(), error, noBalanceAccount.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(standardError);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> errorCannotDelete(DataIntegrityViolationException dataIntegrityViolationException, HttpServletRequest httpServletRequest){
        String error = "Cannot Delete From Database";
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError(Instant.now(), httpStatus.value(), error, dataIntegrityViolationException.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(standardError);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> exception(StandardError standardErrorException, HttpServletRequest httpServletRequest){
        String error = "Error";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), httpStatus.value(), error, standardErrorException.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(standardError);
    }
}
