package Excecoes;

public class InforNaoExistenteException extends Exception {
    
    public InforNaoExistenteException() {
        
    }
    public InforNaoExistenteException(String msg) {
        super(msg);
    }
}
