package com.henriqueassis.eventsmicroservice.exceptions;

public class EventNotFoundException extends  RuntimeException {

    public EventNotFoundException(){
        super("EVENTO NÃO ENCONTRADO");
    }

    public EventNotFoundException(String message){
        super(message);
    }
}
