package Backend;

import java.io.Serializable;
import java.util.Objects;

public class Marcacao implements Serializable {
    
    //Variáveis de Instância
    private Utente marcacaoUtente;
    private boolean marcacaoRealizada;
    
    //Contrutor
    public Marcacao(Utente u, boolean marcacaoRealizada) {
        this.marcacaoUtente = u;
        this.marcacaoRealizada = marcacaoRealizada;
    }
    
    //seletores
    public Utente getMarcacaoUtente() {
        return marcacaoUtente;
    }

    public boolean isMarcacaoRealizada() {
        return marcacaoRealizada;
    }

    //modificadores
    public void setMarcacaoUtente(Utente marcacaoUtente) {
        this.marcacaoUtente = marcacaoUtente;
    }

    public void setMarcacaoRealizada(boolean marcacaoRealizada) {
        this.marcacaoRealizada = marcacaoRealizada;
    }
    
    //equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Marcacao other = (Marcacao) obj;
        if (this.marcacaoRealizada != other.marcacaoRealizada) {
            return false;
        }
        if (!this.marcacaoUtente.equals(other.getMarcacaoUtente())) {
            return false;
        }
        return true;
    }
    
    
    
}
