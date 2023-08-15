package Backend;

import Excecoes.UserJaExisteException;
import java.io.Serializable;

/**
 * Representa o sistema
 * 
 */
public class Sistema implements Serializable {
    
    //Variáveis de Instância
    private final String nomeAplicacao = "Sistema de Vacinacao";
    private ListaUtilizadores listaUtilizadores;
    private ListaCentrosVacinacao listaCentrosVacinacao;
    private Utilizador utilizadorLigado;
    
    //construtor
    public Sistema() {
        this.listaUtilizadores = new ListaUtilizadores();
        this.listaCentrosVacinacao = new ListaCentrosVacinacao();
        utilizadorLigado = null;   
    }
    
    //seletores
    public String getNomeAplicacao() {
        return nomeAplicacao;
    }

    public ListaUtilizadores getListaUtilizadores() {
        return listaUtilizadores;
    }

    public ListaCentrosVacinacao getListaCentrosVacinacao() {
        return listaCentrosVacinacao;
    }

    public Utilizador getUtilizadorLigado() {
        return utilizadorLigado;
    }
    
    //Autenticação do utilizador
    public boolean autenticarUtilizador(String codUtilizador, String password) {
        if (listaUtilizadores.existe(codUtilizador)) {
            try {
                Utilizador u = listaUtilizadores.getUtilizador(codUtilizador);
                if (u.getPassword().equals(password)) {
                    utilizadorLigado = u;
                    return true;
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    public void iniciar() throws UserJaExisteException {
        listaUtilizadores.adicionar(new Administrador("admin", "admin"));
        listaUtilizadores.adicionar(new Gestor("gestor", "gestor"));
    }

    public void terminar() {
        System.exit(0);
    }
}
