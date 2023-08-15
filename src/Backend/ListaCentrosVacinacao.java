package Backend;

import java.util.Map;
import java.util.TreeMap;
import Excecoes.UserJaExisteException;
import Excecoes.InforNaoExistenteException;
import java.io.Serializable;
import java.util.ArrayList;

/**
* Representa uma lista de centros de vacinacao do sistema
*/
public class ListaCentrosVacinacao implements Serializable {
    
    /**
    * Cria a lista de centros de vacinacao
    */
    private final Map<String, CentroVacinacao> listaCentrosVacinacao;

    //Construtor
    public ListaCentrosVacinacao() {
        listaCentrosVacinacao = new TreeMap<>();
    }
    
    //Cria um centro de vacinacao na lista
    public void criar(CentroVacinacao centro) throws UserJaExisteException {
        if (centro == null) {
            throw new NullPointerException("Não pode criar um Centro de Vacinacao vazio");
        }
        if (existe(centro.getCodigo())) {
            throw new UserJaExisteException("O Centro de Vacinacao ja existe");
        } else {
            listaCentrosVacinacao.put(centro.getCodigo(), centro);
        }
    }
    
    //Verifica se o id do centro existe
    public boolean existe(String codCentro) {
        return listaCentrosVacinacao.containsKey(codCentro);
    }
    
    //Remove um centro de vacinacao da lista
    public void remover(String codCentro) throws InforNaoExistenteException {
        if (codCentro.isEmpty()) {
            throw new NullPointerException("Nao introduziu o codigo do Centro de Vacinacao");
        }
        if (!existe(codCentro)) {
            throw new InforNaoExistenteException("O centro de vacinacao nao existe");
        } else {
            listaCentrosVacinacao.remove(codCentro);
        }
    }
    
    //Devolve o id do centro de vacinacao
    public CentroVacinacao getCentroVacinacao(String codigo) throws UserJaExisteException {
        if (listaCentrosVacinacao.containsKey(codigo)) {
            return listaCentrosVacinacao.get(codigo);
        } else {
            throw new UserJaExisteException("O centro já existe na lista");
        }
    }
    
    //Atribui um centro ao utente se pertencerem à mesma localidade
    public void localidadeUtente(Utente u) {
        for (Map.Entry<String, CentroVacinacao> entrada : listaCentrosVacinacao.entrySet()) {
            if (entrada.getValue().getLocalidade().equals(u.getLocalidade())) {
                u.setCentro_vacinacao(entrada.getValue());
            }
        }
    }
    
    //Utente escolhe um centro de vacinacao
    public void selecionarCentro(Utente u, String codigo) {
        u.setCentro_vacinacao(listaCentrosVacinacao.get(codigo));
    }
    
    //Tamanho da lista de centros
    public int size() {
        return listaCentrosVacinacao.size();
    }
    
    //Lista de todos os centros 
    public ArrayList<CentroVacinacao> todos() {
        return new ArrayList<>(listaCentrosVacinacao.values());
    }
}
