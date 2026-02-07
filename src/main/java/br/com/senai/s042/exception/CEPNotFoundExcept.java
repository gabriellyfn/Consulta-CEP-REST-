package br.com.senai.s042.exception;

public class CEPNotFoundExcept extends RuntimeException{
    public CEPNotFoundExcept(String message){
        super(message);
    }
    public CEPNotFoundExcept(String message, Throwable cause){
        super(message, cause);
    }

}
