package Backend;

import java.io.Serializable;

public class Utilizador implements Serializable {
    
    //Variáveis de Instância
    private String codUtilizador;
    private String password;
    
    //Contrutores
    public Utilizador(String codUtilizador, String password){
        this.codUtilizador = codUtilizador;
        this.password = password;
    }
    
    public Utilizador() {
    }
    
    //seletores
    public String getCodUtilizador() {
        return codUtilizador;
    }
    
    public String getPassword() {
        return password;
    }

    //modificadores
    public void setCodUtilizador(String codUtilizador) {
        if(codUtilizador.isEmpty()) {
            throw new NullPointerException("Codigo do Utilizador encontra-se em branco");
        } else {
        this.codUtilizador = codUtilizador;
        }
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    //toString
    @Override
    public String toString() {
        return "Utilizador:" + " \ncodUtilizador= " + codUtilizador + "\npassword= " + password;
    }
}

