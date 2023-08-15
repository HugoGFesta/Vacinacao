package Backend;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CentroVacinacao implements Serializable {
    
    //Variáveis de Instância
    private String codigo;
    private String morada;
    private String localidade;
    private Gestor gestor;
    private Stock stock;
    private Marcacoes agenda;
    private int num_posto_atend;

    /**
     * Criar um centro de vacinacao cujos parametros são o código, morada,
     * localidade, gestor, numero de postos de atendimento, stock e agenda
     *
     * @param codigo - código do centro de vacinacao
     * @param morada - morada do centro de vacinacao
     * @param localidade - localidade do centro de vacinacao
     * @param gestor - gestor do centro de vacinacao
     * @param num_posto_atend - posto de atendimento do centro de vacinacao
     *
     */
    public CentroVacinacao(String codigo, String morada, String localidade, Gestor gestor, int num_posto_atend) {
        this.codigo = codigo;
        this.morada = morada;
        this.localidade = localidade;
        this.gestor = gestor;
        this.num_posto_atend = num_posto_atend;
        this.stock = null;
        this.agenda = null;
    }

    public CentroVacinacao() {
    }

    //seletores
    public String getCodigo() {
        return codigo;
    }

    public String getMorada() {
        return morada;
    }

    public String getLocalidade() {
        return localidade;
    }

    public Gestor getGestor() {
        return gestor;
    }

    public Stock getStock() {
        return stock;
    }

    public Marcacoes getAgenda() {
        return agenda;
    }

    public String getNum_posto_atend() {
        return Integer.toString(num_posto_atend);
    }

    //modificadores
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public void setAgenda(Marcacoes agenda) {
        this.agenda = agenda;
    }

    public void setNum_posto_atend(String num_posto_atend) {
        this.num_posto_atend = Integer.parseInt(num_posto_atend);
    }
    
    //Regista a vacinacao a um utente de uma dada vacina
    public void registarVacinacao(Utente u, String fabricante, String efeitos_secundarios) throws Exception {
        if (agenda.getMarcacaoUtente(u, u.getConsultarMarcacao())) {
            u.getVacina_administrada().setFabricante(fabricante);
            u.getVacina_administrada().setEfeito_secundario(efeitos_secundarios);
            u.getVacina_administrada().setDoseAtual();
            if (u.getVacina_administrada().getDoseAtual() == 1) {
                u.setData_administracao_1Dose(u.getConsultarMarcacao());
                u.setConsultarMarcacao(null);
            }
            if (u.getVacina_administrada().getDoseAtual() == 2) {
                u.setData_administracao_1Dose(u.getConsultarMarcacao());
                u.setConsultarMarcacao(null);
            }
        } else {
            throw new Exception("Não tem marcacao nesta data!");
        }
    }

    //toString
    @Override
    public String toString() {
        return "CentroVacinacao:" + "\ncodigo= " + codigo + "\nmorada= " + morada + "\nlocalidade= " + localidade + "\ngestor= " + gestor + "\nstock= " + stock + "\nmarcacaoes= " + agenda + "\nnum_posto_atend= " + num_posto_atend;
    }

}
