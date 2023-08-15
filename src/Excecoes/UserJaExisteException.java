package Excecoes;

public class UserJaExisteException extends Exception {
    
    public UserJaExisteException(){
    }
    
    public UserJaExisteException(String msg) {
        super(msg);
    }
}
