package Backend;

import Excecoes.InforNaoExistenteException;
import Excecoes.UserJaExisteException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;
/**
 * Representa uma lista de vacinas de um centro
 * 
 */
public class ListaVacinas implements Serializable {

    private final Map<String, Vacina> listaVacinas;
/**
 * Cria a lista de vacinas
 */
    //construtor
    public ListaVacinas() {
        this.listaVacinas = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    public void adicionar(Vacina v) throws UserJaExisteException {
        if (v == null) {
            throw new NullPointerException("Nao pode adicionar uma vacina vazia");
        }
        if (existe(v.getCodigo())) {
            throw new UserJaExisteException("A vacina " + v.getCodigo() + " ja existe");
        } else {
            listaVacinas.put(v.getCodigo(), v);
        }
    }

    public boolean existe(String codigo) {
        return listaVacinas.containsKey(codigo);
    }

    public void remover(String codigo) throws InforNaoExistenteException {
        if (codigo.isEmpty()) {
            throw new NullPointerException("O codigo da vacina encontra-se vazio!");
        }
        if (!existe(codigo)) {
            throw new InforNaoExistenteException("O equipamento " + codigo + " nao existe");
        } else {
            listaVacinas.remove(codigo);
        }
    }

    public Vacina getVacina(String codigo) throws InforNaoExistenteException {
        if (codigo == null) {
            throw new NullPointerException("O codigo da vacina encontra-se vazio!");
        }
        if (listaVacinas.containsKey(codigo)) {
            return listaVacinas.get(codigo);
        } else {
            throw new InforNaoExistenteException("A vacina " + codigo + " nao existe.");
        }
    }

    public ArrayList<Vacina> getListaVacinas() {
        return new ArrayList<>(listaVacinas.values());
    }
}
