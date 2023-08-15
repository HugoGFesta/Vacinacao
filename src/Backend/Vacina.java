package Backend;

import java.io.Serializable;
import java.time.LocalDate;

public class Vacina implements Serializable {
    
    //Variáveis de Instância
    private String nome;
    private String codigo;
    private String fabricante;
    private int dose;
    private String restricao;
    private int num_tomas;
    private int limite_min_entredoses;
    private int limite_max_entredoses;
    private String efeito_secundario;
    private int doseAtual = 0;

    /**
     * Criar uma vacina cujos parametros são o nome, codigo, fabricante, dose,
     * restrições, numero de tomas, limite minimo de dias, limite maximo de dias
     * e efeitos secundarios
     *
     * @param nome - nome da vacina
     * @param codigo - codigo da vacina
     * @param fabricante - fabricante da vacina
     * @param dose - dose em ml da vacina
     * @param restricao - restrições da vacina
     * @param n_tomas - numero de tomas da vacina
     * @param limite_min_entredoses - limite min de dias entre tomas da vacina
     * @param limite_max_entredoses - limite max de dias entre tomas da vacina
     * @param efeito_secundario - efeito secundario da vacina
     *
     */
    public Vacina(String nome, String codigo, String fabricante, int dose, String restricao, int n_tomas, int limite_min_entredoses, int limite_max_entredoses, String efeito_secundario) {
        this.nome = nome;
        this.codigo = codigo;
        this.fabricante = fabricante;
        this.dose = dose;
        this.restricao = restricao;
        this.num_tomas = n_tomas;
        this.limite_min_entredoses = limite_min_entredoses;
        this.limite_max_entredoses = limite_max_entredoses;
        this.efeito_secundario = efeito_secundario;
    }

    //seletores
    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public int getDose() {
        return dose;
    }

    public String getRestricao() {
        return restricao;
    }

    public int getNum_tomas() {
        return num_tomas;
    }

    public int getLimite_min_entredoses() {
        return limite_min_entredoses;
    }

    public int getLimite_max_entredoses() {
        return limite_max_entredoses;
    }

    public String getEfeito_secundario() {
        return efeito_secundario;
    }

    public int getDoseAtual() {
        return doseAtual;
    }

    //modificadores
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public void setRestricao(String restricao) {
        this.restricao = restricao;
    }

    public void setNum_tomas(int num_tomas) {
        this.num_tomas = num_tomas;
    }

    public void setLimite_min_entredoses(int limite_min_entredoses) {
        this.limite_min_entredoses = limite_min_entredoses;
    }

    public void setLimite_max_entredoses(int limite_max_entredoses) {
        this.limite_max_entredoses = limite_max_entredoses;
    }

    public void setEfeito_secundario(String efeito_secundario) {
        this.efeito_secundario = efeito_secundario;
    }

    public void setDoseAtual() {
        this.doseAtual += 1;
    }

    //toString
    @Override
    public String toString() {
        return "Vacina:" + "\nnome= " + nome + "\ncodigo= " + codigo + "\nfabricante= " + fabricante + "\ndose= " + dose + "\nrestricao= " + restricao + "\nn_administracao= " + num_tomas + "\nlimite_min_entredoses= " + limite_min_entredoses + "\nlimite_max_entredoses= " + limite_max_entredoses + "\nefeito_secundario= " + efeito_secundario;
    }

}
