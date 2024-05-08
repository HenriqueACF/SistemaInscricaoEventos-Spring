package com.henriqueassis.eventsmicroservice.exceptions;

public class EventFullException extends RuntimeException{

    public EventFullException(){
        super("EVENTO ESTÁ LOTADO");
    }

    public EventFullException(String message){
        super(message);
    }

}
