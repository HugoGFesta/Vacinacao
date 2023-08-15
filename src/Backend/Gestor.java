package Backend;

import java.io.Serializable;

public class Gestor extends Utilizador implements Serializable {
    
    private String codigoCentro;
    
    /**
    * Cria um gestor cujos parametros são o codigo e a password
    * @param codUtilizador
    * @param password
    */
    public Gestor(String codUtilizador, String password) {
        super(codUtilizador, password);
        codigoCentro = null;
    }
    
    public Gestor() {
    }
    
    //seletor
    public String getCodigoCentro() {
        return codigoCentro;
    }
    
    //modificador
    public void setCodigoCentro(String codigoCentro) {
        this.codigoCentro = codigoCentro;
    }
}
