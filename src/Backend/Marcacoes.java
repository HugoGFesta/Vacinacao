package Backend;

import java.util.List;
import java.io.Serializable;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Marcacoes implements Serializable {
    
    //Variáveis de Instância
    private HashMap<LocalDate, ArrayList<Marcacao>> agenda;
    private int limiteMarcacoes = -1;
    
    //Contrutor
    public Marcacoes() {
        agenda = new HashMap<>();
    }
    
    //seletor
    public int getLimiteMarcacoes() {
        return limiteMarcacoes;
    }
    
    //modificador
    public void setLimiteMarcacoes(int limiteMarcacoes) {
        this.limiteMarcacoes = limiteMarcacoes;
    }
    
    //Regista a marcacão da 1º vacina
    public void primeiraMarcacao(LocalDate data, Utente utente) throws Exception {
        ArrayList<Marcacao> marcacoes = agenda.get(data);
        utente.setData_administracao_1Dose(data);
        if(limiteMarcacoes > 0 && marcacoes.size() >= limiteMarcacoes) {
            throw new Exception ("Limite Marcacoes excedido!");
        }
        Marcacao m = new Marcacao(utente, false);
        if (marcacoes == null) {
            marcacoes = new ArrayList<>();
            marcacoes.add(m);
            agenda.put(data, marcacoes);
            utente.setConsultarMarcacao(data);
        } else if (!marcacoes.contains(m)) {
            utente.setConsultarMarcacao(data);
            marcacoes.add(m); 
        }
    }
    
    //Regista a marcacão da 2º vacina
    public boolean segundaMarcacao(LocalDate data, Utente utente) throws Exception {
        ArrayList<Marcacao> marcacoes = agenda.get(data);
        if (utente.getVacina_administrada().getNum_tomas() < 2) {
            throw new Exception("Vacina não tem segunda dose");
        }
        if (utente.getData_administracao_1Dose() == null) {
            throw new Exception("Não tomou a primeira dose!");
        }
        if(limiteMarcacoes > 0 && marcacoes.size() >= limiteMarcacoes) {
            throw new Exception ("Limite Marcacoes excedido!");
        }
        int minimo = utente.getVacina_administrada().getLimite_min_entredoses();
        int maximo = utente.getVacina_administrada().getLimite_max_entredoses();
        long daysBetween = DAYS.between(utente.getData_administracao_1Dose(), data);
        Marcacao m = new Marcacao(utente, false);
        if (minimo < daysBetween && daysBetween < maximo) {
            if (marcacoes == null) {
                marcacoes = new ArrayList<>();
                marcacoes.add(m);
                agenda.put(data, marcacoes);
                utente.setConsultarMarcacao(data);
            } else if (!marcacoes.contains(m)) {
                marcacoes.add(m);
                utente.setConsultarMarcacao(data);
            }
            return true;
        }
        return false;
    }
    
    //Cancela uma marcacão efetuada
    public void cancelarMarcacao(LocalDate data, Utente utente) {
        ArrayList<Marcacao> marcacoes = agenda.get(data);
        Marcacao m = new Marcacao(utente, false);
        if (marcacoes != null) {
            marcacoes.remove(m);
            utente.setConsultarMarcacao(null);
            if (marcacoes.isEmpty()) {
                agenda.remove(data);

            }
        }
    }
    
    //Lista de Utentes que faltaram à marcacão
    public ArrayList<Utente> getUtentesEmFalta() {
        ArrayList<Utente> emFalta = new ArrayList <>();
        LocalDate hoje = LocalDate.now();
        for(Map.Entry<LocalDate, ArrayList<Marcacao>> faltaram : agenda.entrySet()) {
            if(faltaram.getKey().isBefore(hoje)) {
                for(Marcacao m : faltaram.getValue()) {
                    if(!m.isMarcacaoRealizada()) {
                        emFalta.add(m.getMarcacaoUtente());
                    }
                }
            }
        }
        return emFalta;
    }
    
    //Lista de utentes com marcações no dia seguinte
    public List<Utente> getMarcacoesDiaSeguinte(LocalDate data) {
        return agenda.get(data).stream().map(Marcacao::getMarcacaoUtente).collect(Collectors.toList());
    }
    
    //Utente numa data tem marcacão
    public boolean getMarcacaoUtente(Utente u, LocalDate data) {
        Marcacao m = new Marcacao(u, false);
        ArrayList<Marcacao> marcacao = agenda.get(data);
        return marcacao.contains(m);
    }
}
