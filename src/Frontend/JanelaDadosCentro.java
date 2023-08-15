package Frontend;

import javax.swing.JOptionPane;
import Backend.Sistema;
import Backend.CentroVacinacao;
import Backend.Gestor;

/**
 *
 *
 * 
 * Esta janela é utilizada para os seguintes casos de uso: * 
 *   1 - Alteração dos dados do utilizador ligado
 *   2 - Pelo Administrador, para criar um novo Utilizador
 *   3 - Pelo Administrador, para visualizar/editar os dados de um Utilizador já existente
 * 
 */
public class JanelaDadosCentro extends javax.swing.JDialog {
    //Referencia ao Sistema, a lista de utilizadores esta no sistema
    private Sistema sistema;    
    //Referencia a ListagemUtilizadores. Se for indicado, depois de alterarmos um registo podemos solicitar que a tabela seja redesenhada
    private ListarInforCentros listagem;
    //Referencia ao Utilizador que queremos visualizar/editar
    private CentroVacinacao centro;   
    
    public JanelaDadosCentro(Sistema sistema, CentroVacinacao centro, ListarInforCentros listagem) {
        initComponents();
        
        //Indica que a janela deve ser modal ou seja,
        //bloqueia a execução do programa até que a janela seja fechada
        this.setModal(true);           
        
        //Não permite o redimensionamento da janela
        this.setResizable(false);                        
        
        //Mostra a centralização da janela
        this.setLocationRelativeTo(null);
        
        //Guarda a referencia ao sistema
        this.sistema = sistema;   
        
        //Guarda a referencia ao centro
        this.centro = centro;
        
        //Guarda a referencia a listagem
        this.listagem = listagem;
        
        //No caso de um registo novo
        if (registoNovo()) {    
            //Altera o titulo da janela
            //Como construimos sempre uma nova janela, as caixas de texto já estão limpas
            setTitle("Criação de novo centro");
            txtCodigo.requestFocus();                      
        }else{
            //No caso de um registo existente
            //Altera o titulo da janela
            setTitle("Alteração de dados do Centro");
            //Preenche as caixas de texto com os dados do utilizador
            txtCodigo.setEditable(false);
            txtMorada.setText(centro.getMorada());
            txtLocalidade.setText(centro.getLocalidade());
            txtGestor.setText(centro.getGestor().getCodUtilizador());
            //txtPostos.setText(centro.getNum_posto_atend());
        }               
        
    }    
    
    private boolean registoNovo() {
        //Se centro == null consideramos que é um novo registo
        return centro == null;
    }    
    private void guardar() {
         if (registoNovo() && txtCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o Codigo pretendido!");            
            txtCodigo.requestFocus();
            return;
        }
        
        if (txtMorada.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a sua morada!");            
            txtMorada.requestFocus();
            return;
        }
        
        if (txtLocalidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a localidade");
            txtLocalidade.requestFocus();
            return;
        }       
        
        if (txtGestor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o seu codigo de Gestor!");
            txtGestor.requestFocus();
            return;
        }  
        
        if (txtPostos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o numero de Postos!");
            txtGestor.requestFocus();
            return;
        } 
        
              
        
        if (registoNovo()) {      
            txtCodigo.setEditable(true);                                 
            CentroVacinacao novo = new CentroVacinacao();
            novo.setCodigo(txtCodigo.getText());
            novo.setMorada(txtMorada.getText());
            novo.setLocalidade(txtLocalidade.getText());
            try {
                novo.setGestor((Gestor)sistema.getListaUtilizadores().getUtilizador(txtGestor.getText()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            novo.setNum_posto_atend(txtPostos.getText());
            
            
          
            try {
                sistema.getListaCentrosVacinacao().criar(novo);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                return;
            }                      
                  
        }else{
            centro.setMorada(txtMorada.getText());        
            centro.setLocalidade(txtLocalidade.getText());
            centro.getGestor().setCodUtilizador(txtGestor.getText());
            centro.setNum_posto_atend(txtPostos.getText());
        }                       
        
        //Se tiver feito uma referencia a listagem, atualiza a listagem
        if (listagem != null) listagem.atualizar();                 
        
        JOptionPane.showMessageDialog(this, "Registo guardado com sucesso.");
        fechar();
        
    }
    
    private void fechar() {
        dispose();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMorada = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPostos = new javax.swing.JTextField();
        txtLocalidade = new javax.swing.JTextField();
        txtGestor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alteração de dados de centro");

        jLabel1.setText("Codigo:");

        jLabel2.setText("Morada:");

        jLabel3.setText("Localidade:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        jLabel4.setText("Gestor:");

        jLabel5.setText("N Postos:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMorada, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addComponent(txtPostos)
                                    .addComponent(txtLocalidade)
                                    .addComponent(txtGestor))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFechar)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMorada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLocalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGestor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPostos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnGuardar))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        fechar();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtGestor;
    private javax.swing.JTextField txtLocalidade;
    private javax.swing.JTextField txtMorada;
    private javax.swing.JTextField txtPostos;
    // End of variables declaration//GEN-END:variables
}
