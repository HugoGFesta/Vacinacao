package Backend;

import java.util.ArrayList;
import java.util.HashMap;
import Excecoes.InforNaoExistenteException;
import Excecoes.UserJaExisteException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;

/**
* Representa uma lista de utilizadores do sistema
*/
public class ListaUtilizadores implements Serializable {
    
    /**
    * Cria a lista de utilizadores
    */
    private HashMap<String, Utilizador> listaUtilizadores;
    
    //Construtor
    public ListaUtilizadores() {
        listaUtilizadores = new HashMap<>();
    }
    
    //Verifica se o id do utilizador existe
    public boolean existe(String codUtilizador) {
        return listaUtilizadores.containsKey(codUtilizador);
    }
    
    //Devolve o id do utilizador
    public Utilizador getUtilizador(String codUtilizador) throws InforNaoExistenteException {
        if (codUtilizador == null) {
            throw new NullPointerException("O codigo do utilizador encontra-se vazio");
        }
        if (listaUtilizadores.containsKey(codUtilizador)) {
            return listaUtilizadores.get(codUtilizador);
        } else {
            throw new InforNaoExistenteException("O Utilizador " + codUtilizador + " nao existe. ");
        }
    }
    
    //Adiciona um utilizador 
    public void adicionar(Utilizador u) throws UserJaExisteException {
        if (u == null) {
            throw new NullPointerException("Erro: nao pode adicionar um utilizador vazio");
        }
        if (existe(u.getCodUtilizador())) {
            throw new UserJaExisteException("O codigo do utilizador: " + u.getCodUtilizador() + "ja existe");
        } else {
            listaUtilizadores.put(u.getCodUtilizador(), u);
        }
    }
    
    //Remove um utilizador
    public void remover(String codUtilizador) throws InforNaoExistenteException {
        if (codUtilizador.isEmpty()) {
            throw new NullPointerException("O codigo do utilizador esta em branco");
        }
        if (!existe(codUtilizador)) {
            throw new InforNaoExistenteException("O codigo do utilizador: " + codUtilizador + "nao existe");
        } else {
            listaUtilizadores.remove(codUtilizador);
        }
    }
    
    //Lista de utentes que pertencem a cada centro de vacinacao
    public ArrayList<Utente> getUtentes_Centro() {
        ArrayList<Utente> listaUtentesEmCentro = new ArrayList<>();
        for (Map.Entry<String, Utilizador> utentes : listaUtilizadores.entrySet()) {
            if (utentes.getValue() instanceof Utente) {
                Utente u = (Utente) utentes.getValue();
               listaUtentesEmCentro.add(u);
            }   
        }
        return listaUtentesEmCentro;
    }
    
    //Lista de gestores 
    public ArrayList<Gestor> listaGestores() {
        ArrayList<Gestor> gestores = new ArrayList <>();
        for(Map.Entry<String, Utilizador> users : listaUtilizadores.entrySet()) {
            if(users.getValue() instanceof Gestor) {
                Gestor m = (Gestor) users.getValue();
                gestores.add(m);
            }
        }
        return gestores;
    }
    
    //Lista todos os utilizadores
    public ArrayList<Utilizador> todos() {
        return new ArrayList<>(listaUtilizadores.values());
    }
    
    //Tamanho da lista de utilizadores
    public int size() {
        return listaUtilizadores.size();
    }
    
    //Estatisticas
    
    //O numero de vacinas administradas na populacao
    public int totalVacinasAdministradas() {
        int total = 0;
        for (Map.Entry<String, Utilizador> utentes : listaUtilizadores.entrySet()) {
            if (utentes.getValue() instanceof Utente) {
                Utente u = (Utente) utentes.getValue();
                total += u.getVacina_administrada().getDoseAtual();
            }
        }
        return total;
    }
    
    //Regista os efeitos secundarios na população vacinada
    public ArrayList<String> getListaEfeitosSecundarios() {
        HashSet<String> listaEfeitoSecundario = new HashSet<String>();
        for (Map.Entry<String, Utilizador> utentes : listaUtilizadores.entrySet()) {
            if (utentes.getValue() instanceof Utente) {
                Utente u = (Utente) utentes.getValue();
                listaEfeitoSecundario.add(u.getVacina_administrada().getEfeito_secundario());
            }
        }
        return new ArrayList<String>(listaEfeitoSecundario);
    }
}   
