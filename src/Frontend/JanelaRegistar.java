package Frontend;
import Backend.Utente;
import Backend.Sistema;
import javax.swing.JOptionPane;
import Serialize.Serializacao;

/**
 *
 * @author Miguel Caldas
 */
public class JanelaRegistar extends javax.swing.JFrame {

    private Sistema sistema;
    //Referencia ao Utente que queremos visualizar/editar
    private Utente utente;
    
    private Serializacao bd;
    
    public JanelaRegistar(Sistema sistema,Serializacao bd, Utente utente) {
        initComponents();
        
        //Não permite o redimensionamento da janela
        this.setResizable(false);                        
        
        //Mostra a centralização da janela
        this.setLocationRelativeTo(null);
        
        //Guarda a referencia ao sistema
        this.sistema = sistema;   
        
        this.utente = utente;
        this.bd = bd;
        
        //No caso de um registo novo
        if (registoNovo()) {    
            //Altera o titulo da janela
            //Como construimos sempre uma nova janela, as caixas de texto já estão limpas
            setTitle("Criação de novo utilizador");
            usernameTextField.requestFocus();                      
        }else{
            //No caso de um registo existente
            //Altera o titulo da janela
            setTitle("Registo ja existente");
            //Preenche as caixas de texto com os dados do utilizador
        }               
        
    }

    private boolean registoNovo() {
        //Se utente == null consideramos que é um novo registo
        return utente == null;
    }
    
    private void registar(){
         if (registoNovo() && nomeTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o Nome pretendido!");            
            nomeTextField.requestFocus();
            return;
        }
         
         if (usernameTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o seu USERNAME");            
            usernameTextField.requestFocus();
            return;
        }
        
        if (nSNSTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o seu numero do SNS");            
            nSNSTextField.requestFocus();
            return;
        }
        
        if (moradaTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a sua morada!");
            moradaTextField.requestFocus();
            return;
        }       
        
        if (localidadeTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a sua localidade!");
            localidadeTextField.requestFocus();
            return;
        }  
        
        if (dateChooser.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a sua data de nascimento!");
            dateChooser.requestFocus();
            return;
        } 
        
        if (contactoTxtField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o seu contacto!");
            contactoTxtField.requestFocus();
            return;
        } 
        
        if (mailTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o seu email!");
            mailTextField.requestFocus();
            return;
        }
        
        if (passwordoTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a nova password!");
            passwordoTextField.requestFocus();
            return;
        }       
        
        if (cpasswordTxtField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a password de confirmação!");
            cpasswordTxtField.requestFocus();
            return;
        }  
        
        String password = new String(passwordoTextField.getText());
        
        if (!password.equals(new String(cpasswordTxtField.getText()))){
            JOptionPane.showMessageDialog(this, "A password de confirmação não corresponde à password introduzida!");
            cpasswordTxtField.requestFocus();
            return;
        }
        
              
        
        if (registoNovo()) {      
            usernameTextField.setEditable(true);                                 
            Utente novo = new Utente();
            novo.setCodUtilizador(usernameTextField.getText());
            novo.setNome(nomeTextField.getText());
            novo.setNum_SNS(nSNSTextField.getText());
            novo.setMorada(moradaTextField.getText());
            novo.setLocalidade(localidadeTextField.getText());
            novo.setData_nasc(dateChooser.getDate());
            novo.setContacto(contactoTxtField.getText());
            novo.setEmail(mailTextField.getText());
            novo.setPassword(passwordoTextField.getText());
            
            
          
            try {
                sistema.getListaUtilizadores().adicionar(novo);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                return;
            }                      
                  
        }else{
            usernameTextField.setEditable(false);
            utente.setNome(nomeTextField.getText());        
            utente.setNum_SNS(nSNSTextField.getText());
            utente.setMorada(moradaTextField.getText());
            utente.setLocalidade(localidadeTextField.getText());
            utente.setData_nasc(dateChooser.getDate());
            utente.setContacto(contactoTxtField.getText());
            utente.setEmail(mailTextField.getText());
            utente.setPassword(passwordoTextField.getText());
        }               
        
        JOptionPane.showMessageDialog(this, "Registo guardado com sucesso.");
        fechar();
        
    }
    
    private void fechar() {
        this.dispose();
        JanelaLogin login = new JanelaLogin(sistema,bd);
        login.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nSNSTextField = new javax.swing.JTextField();
        nSNSLabel = new javax.swing.JLabel();
        moradaLabel = new javax.swing.JLabel();
        localidadeLabel = new javax.swing.JLabel();
        dataNascimentoLabel = new javax.swing.JLabel();
        contactoLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        moradaTextField = new javax.swing.JTextField();
        localidadeTextField = new javax.swing.JTextField();
        contactoTxtField = new javax.swing.JTextField();
        mailTextField = new javax.swing.JTextField();
        dateChooser = new com.toedter.calendar.JDateChooser();
        registarButton = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        passLabel = new javax.swing.JLabel();
        cpassLabel = new javax.swing.JLabel();
        cpasswordTxtField = new javax.swing.JTextField();
        passwordoTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Janela Registar");

        nSNSTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nSNSTextFieldActionPerformed(evt);
            }
        });

        nSNSLabel.setText("Nº do SNS:");

        moradaLabel.setText("Morada:");

        localidadeLabel.setText("Localidade:");

        dataNascimentoLabel.setText("Data de Nascimento:");

        contactoLabel.setText("Contacto Telefónico:");

        emailLabel.setText("Email:");

        moradaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moradaTextFieldActionPerformed(evt);
            }
        });

        contactoTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactoTxtFieldActionPerformed(evt);
            }
        });

        registarButton.setText("Registar");
        registarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registarButtonActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        passLabel.setText("Password:");

        cpassLabel.setText("Confirmar Password:");

        jLabel9.setText("Nome:");

        usernameLabel.setText("Username:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nomeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(usernameTextField))
                .addContainerGap(155, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 74, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(nSNSLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(60, 60, 60)
                            .addComponent(nSNSTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(moradaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(70, 70, 70)
                            .addComponent(moradaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(localidadeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(60, 60, 60)
                            .addComponent(localidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(dataNascimentoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(contactoLabel)
                            .addGap(20, 20, 20)
                            .addComponent(contactoTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(mailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(passLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(passwordoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cpassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(cpasswordTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(210, 210, 210)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(registarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 74, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addContainerGap(379, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 71, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nSNSLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nSNSTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(moradaLabel)
                        .addComponent(moradaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(localidadeLabel)
                        .addComponent(localidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dataNascimentoLabel)
                        .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(contactoLabel)
                        .addComponent(contactoTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(emailLabel)
                        .addComponent(mailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(passLabel)
                        .addComponent(passwordoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cpassLabel)
                        .addComponent(cpasswordTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(20, 20, 20)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonCancelar)
                        .addComponent(registarButton))
                    .addGap(0, 103, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nSNSTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nSNSTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nSNSTextFieldActionPerformed

    private void moradaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moradaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moradaTextFieldActionPerformed

    private void contactoTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactoTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactoTxtFieldActionPerformed

    private void registarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registarButtonActionPerformed
        registar();
    }//GEN-LAST:event_registarButtonActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
        JanelaLogin lg = new JanelaLogin(sistema, bd);
        lg.setVisible(true);
    }//GEN-LAST:event_jButtonCancelarActionPerformed
 
    
    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaRegistar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaRegistar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaRegistar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaRegistar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JanelaRegistar(sistema,bd, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contactoLabel;
    private javax.swing.JTextField contactoTxtField;
    private javax.swing.JLabel cpassLabel;
    private javax.swing.JTextField cpasswordTxtField;
    private javax.swing.JLabel dataNascimentoLabel;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel localidadeLabel;
    private javax.swing.JTextField localidadeTextField;
    private javax.swing.JTextField mailTextField;
    private javax.swing.JLabel moradaLabel;
    private javax.swing.JTextField moradaTextField;
    private javax.swing.JLabel nSNSLabel;
    private javax.swing.JTextField nSNSTextField;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JLabel passLabel;
    private javax.swing.JTextField passwordoTextField;
    private javax.swing.JButton registarButton;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
