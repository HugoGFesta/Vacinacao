package Backend;

import java.io.Serializable;

public class Administrador extends Utilizador implements Serializable {

    //construtor
    public Administrador() {
    }

    /**
    * Cria um administrador cujos parametros são o codigo e a password
    * @param codUtilizador
    * @param password
    */
    public Administrador(String codUtilizador, String password) {
        super(codUtilizador, password);
    }

}
