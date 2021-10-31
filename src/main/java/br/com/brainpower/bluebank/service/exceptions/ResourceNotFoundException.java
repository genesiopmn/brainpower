package br.com.brainpower.bluebank.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id){
        super("Resource not found ID " + id);
    }
}
