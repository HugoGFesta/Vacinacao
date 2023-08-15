package Backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Utente extends Utilizador implements Serializable {
    
    //Variáveis de Instância
    private String num_SNS;
    private String nome;
    private String morada;
    private String localidade;
    private Date data_nasc;
    private String historico_doencas;
    private String contacto;
    private String email;
    private CentroVacinacao centro_vacinacao;
    private Vacina vacina_administrada;
    private LocalDate data_administracao_1Dose;
    private LocalDate data_administracao_2Dose;
    private LocalDate consultarMarcacao;

    
    /**
     * Criar um utente cujos parametros são o nº SNS, morada, localidade, data
     * de nascimento, contacto e email
     *
     * @param num_SNS - nº SNS do utente
     * @param morada - morada do utente
     * @param localidade - localidade do utente
     * @param data_nasc - data de nascimento do utente
     * @param contacto - contacto do utente
     * @param email - email do utente
     *
     */
    public Utente(String codUtilizador, String password, String num_SNS, String nome, String morada, String localidade, Date data_nasc, String contacto, String email) {
        super(codUtilizador, password);
        this.num_SNS = num_SNS;
        this.nome = nome;
        this.morada = morada;
        this.localidade = localidade;
        this.data_nasc = data_nasc;
        this.contacto = contacto;
        this.email = email;
        this.centro_vacinacao = null;
        this.historico_doencas = "";
        this.vacina_administrada = null;
        this.data_administracao_1Dose = null;
        this.data_administracao_2Dose = null;
        this.consultarMarcacao = null;
    }
    
    //Construtores
    public Utente(String codUtilizador, String password) {
        super(codUtilizador, password);
        this.num_SNS = "";
        this.nome = "";
        this.morada = "";
        this.localidade = "";
        this.data_nasc = null;
        this.contacto = "";
        this.email = "";
        this.centro_vacinacao = null;
        this.historico_doencas = "";
        this.vacina_administrada = null;
        this.data_administracao_1Dose = null;
        this.data_administracao_2Dose = null;
        this.consultarMarcacao = null;
    }
    
    public Utente() {
    }
    
    //seletores
    public String getNum_SNS() {
        return num_SNS;
    }

    public String getNome() {
        return nome;
    }

    public String getMorada() {
        return morada;
    }

    public String getLocalidade() {
        return localidade;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public String getHistorico_doencas() {
        return historico_doencas;
    }

    public String getContacto() {
        return contacto;
    }

    public String getEmail() {
        return email;
    }

    public CentroVacinacao getCentro_vacinacao() {
        return centro_vacinacao;
    }

    public Vacina getVacina_administrada() {
        return vacina_administrada;
    }

    public LocalDate getData_administracao_1Dose() {
        return data_administracao_1Dose;
    }

    public LocalDate getData_administracao_2Dose() {
        return data_administracao_2Dose;
    }

    public LocalDate getConsultarMarcacao() {
        return consultarMarcacao;
    }

    //modificadores
    public void setNum_SNS(String num_SNS) {
        this.num_SNS = num_SNS;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public void setHistorico_doencas(String historico_doencas) {
        this.historico_doencas = historico_doencas;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCentro_vacinacao(CentroVacinacao centro_vacinacao) {
        this.centro_vacinacao = centro_vacinacao;
    }

    public void setVacina_administrada(Vacina vacina_administrada) {
        this.vacina_administrada = vacina_administrada;
    }

    public void setData_administracao_1Dose(LocalDate data_administracao_1Dose) {
        this.data_administracao_1Dose = data_administracao_1Dose;
    }

    public void setData_administracao_2Dose(LocalDate data_administracao_2Dose) {
        this.data_administracao_2Dose = data_administracao_2Dose;
    }

    public void setConsultarMarcacao(LocalDate consultarMarcacao) {
        this.consultarMarcacao = consultarMarcacao;
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
        final Utente other = (Utente) obj;
        if (!Objects.equals(this.num_SNS, other.num_SNS)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    //toString
    @Override
    public String toString() {
        return "Utente:" + "\nnum_SNS= " + num_SNS + "\nnome= " + nome + "\nmorada= " + morada + "\nlocalidade= " + localidade + "\ndata_nasc= " + data_nasc + "\nhistorico doencas= " + historico_doencas + "\ncontacto= " + contacto + "\nemail= " + email + "\ncentro_vacinacao= " + centro_vacinacao + "\nvacina_administrada= " + vacina_administrada + "\ndata_administracao_1Dose= " + data_administracao_1Dose + "\ndata_administracao_2Dose= " + data_administracao_2Dose;
    }

}
