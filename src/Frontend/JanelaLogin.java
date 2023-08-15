package Frontend;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import Backend.Sistema;
import Serialize.Serializacao;


public class JanelaLogin extends JDialog {    
    private Sistema sistema;
    private Serializacao bd;
    
    public JanelaLogin(Sistema sistema,Serializacao bd ) {
        initComponents();

        //Indica que a janela deve ser modal ou seja,
        //bloqueia a execução do programa até que a janela seja fechada
        this.setModal(true);           
        
        //Não permite o redimensionamento da janela
        this.setResizable(false);
        
        //Mostra a centralização da janela
        this.setLocationRelativeTo(null);
        
        //O processo de fecho da janela será controlado pelo programa
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);                                
        
        this.sistema = sistema;
        this.bd = bd;
      
        txtUtilizador.requestFocus();
    }   
    
    private void autenticar() {                
        if (txtUtilizador.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o nome de utilizador!");            
            txtUtilizador.requestFocus();
            return;
        }
        
        if (txtPassword.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a sua password!");
            txtPassword.requestFocus();
            return;
        }                              
        
        if (!sistema.autenticarUtilizador(txtUtilizador.getText(), new String(txtPassword.getPassword()))){
            JOptionPane.showMessageDialog(this, "As credenciais introduzidas não correspondem a um utilizador válido.",
                     "Autenticação", JOptionPane.WARNING_MESSAGE);
            txtUtilizador.requestFocus();            
        }else{
            JanelaPrincipal principal = new JanelaPrincipal(sistema, bd);
            principal.setVisible(true);
            dispose();
        }               
    }          
    
    private void registar() {
        JanelaRegistar jrg = new JanelaRegistar(sistema,bd, null);
        jrg.setVisible(true);
        dispose();
    }
    
    private void terminar() {
        if (JOptionPane.showConfirmDialog(null, 
                "Deseja realmente terminar o programa?", 
                "Terminar", 
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            sistema.terminar();
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUtilizador = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnOk = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabelRegistar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Autenticação");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("CodUtilizador:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, -1, -1));

        jLabel2.setText("Password:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));
        getContentPane().add(txtUtilizador, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 172, 26));
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 172, 27));

        btnOk.setText("Autenticar");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        getContentPane().add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 100, 30));

        btnSair.setText("Terminar");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 100, 30));

        jLabelRegistar.setForeground(new java.awt.Color(51, 51, 255));
        jLabelRegistar.setText("Clique aqui para criar uma nova conta");
        jLabelRegistar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRegistarMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelRegistar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 280, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        autenticar();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        terminar();
    }//GEN-LAST:event_btnSairActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void jLabelRegistarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRegistarMouseClicked
        registar();
    }//GEN-LAST:event_jLabelRegistarMouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelRegistar;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUtilizador;
    // End of variables declaration//GEN-END:variables
}
