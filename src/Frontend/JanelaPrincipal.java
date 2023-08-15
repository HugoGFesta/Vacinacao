package Frontend;

import javax.swing.JOptionPane;
import Backend.Administrador;
import Backend.Gestor;
import Backend.Sistema;
import Backend.Utente;
import Serialize.Serializacao;

/**
 *
 * @author
 * Bruno Ferreira (bruno@dsi.uminho.pt)
 */
public class JanelaPrincipal extends javax.swing.JFrame {
    private Sistema sistema;
    private Serializacao bd;
    
    public JanelaPrincipal(Sistema sistema, Serializacao bd) {
        initComponents();
        this.sistema = sistema;
        this.bd = bd;
        
        //Força a maximização da janela
        this.setExtendedState(JanelaPrincipal.MAXIMIZED_BOTH);    
        
        //O processo de fecho da janela será controlado pelo programa
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        //Apenas mostra o menu de administração se o utilizador for um administrador
        mnuAdministrador.setVisible(sistema.getUtilizadorLigado() instanceof Administrador);
        
        //Apenas mostra o menu de utilizador se o de administração estiver oculto
        mnuUtente.setVisible(sistema.getUtilizadorLigado() instanceof Utente); 
        
        // Apenas mostra o menu de gestor se o utilizador for um gestor
        mnuGestor.setVisible(sistema.getUtilizadorLigado() instanceof Gestor);
        
    }
    
    private void guardarAlteracoes() {
        bd.guardar(sistema);
    }
    
    private void alterarPassword() {
        JanelaAlteracaoDadosUtilizador psw = new JanelaAlteracaoDadosUtilizador(sistema);
        psw.setVisible(true);
    }
    
    private void terminar() {        
        if (JOptionPane.showConfirmDialog(null, 
                "Deseja realmente sair do programa?", 
                "Sair",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            guardarAlteracoes();
            dispose();
            JanelaLogin login = new JanelaLogin(sistema, bd);
            login.setVisible(true);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        mnuPrincipal = new javax.swing.JMenuBar();
        mnuGeral = new javax.swing.JMenu();
        mniAlterarPassword = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mniTerminar = new javax.swing.JMenuItem();
        mnuAdministrador = new javax.swing.JMenu();
        menuEditarGestor = new javax.swing.JMenuItem();
        menuListarCentros = new javax.swing.JMenuItem();
        menuAlocarVacinasCentro = new javax.swing.JMenuItem();
        menuVacinasEfeitos = new javax.swing.JMenuItem();
        mnuGestor = new javax.swing.JMenu();
        editarcentroMenu = new javax.swing.JMenuItem();
        consultarUtenteMenu = new javax.swing.JMenuItem();
        registarVacinacaoMenu = new javax.swing.JMenuItem();
        mnuUtente = new javax.swing.JMenu();
        menuRegistarBoletim = new javax.swing.JMenuItem();
        menuConsultar = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Programa para a Vacinação em Portugal");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mnuGeral.setText("Geral");

        mniAlterarPassword.setText("Alteração de dados de utilizador");
        mniAlterarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAlterarPasswordActionPerformed(evt);
            }
        });
        mnuGeral.add(mniAlterarPassword);
        mnuGeral.add(jSeparator1);

        mniTerminar.setText("Terminar");
        mniTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTerminarActionPerformed(evt);
            }
        });
        mnuGeral.add(mniTerminar);

        mnuPrincipal.add(mnuGeral);

        mnuAdministrador.setText("Administrador");
        mnuAdministrador.setToolTipText("");
        mnuAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAdministradorActionPerformed(evt);
            }
        });

        menuEditarGestor.setText("Listar Gestores");
        menuEditarGestor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarGestorActionPerformed(evt);
            }
        });
        mnuAdministrador.add(menuEditarGestor);

        menuListarCentros.setText("Listar informação sobre os centros de vacinação");
        menuListarCentros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListarCentrosActionPerformed(evt);
            }
        });
        mnuAdministrador.add(menuListarCentros);

        menuAlocarVacinasCentro.setText("Alocar quantidades de vacinas");
        menuAlocarVacinasCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAlocarVacinasCentroActionPerformed(evt);
            }
        });
        mnuAdministrador.add(menuAlocarVacinasCentro);

        menuVacinasEfeitos.setText("Vacinas adminstradas/Efeitos secundários");
        menuVacinasEfeitos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVacinasEfeitosActionPerformed(evt);
            }
        });
        mnuAdministrador.add(menuVacinasEfeitos);

        mnuPrincipal.add(mnuAdministrador);

        mnuGestor.setText("Gestor");

        editarcentroMenu.setText("Editar Centro");
        editarcentroMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarcentroMenuActionPerformed(evt);
            }
        });
        mnuGestor.add(editarcentroMenu);

        consultarUtenteMenu.setText("Consultar Utentes Centro");
        consultarUtenteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarUtenteMenuActionPerformed(evt);
            }
        });
        mnuGestor.add(consultarUtenteMenu);

        registarVacinacaoMenu.setText("Registar Vacinacao de Utente");
        registarVacinacaoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registarVacinacaoMenuActionPerformed(evt);
            }
        });
        mnuGestor.add(registarVacinacaoMenu);

        mnuPrincipal.add(mnuGestor);

        mnuUtente.setText("Utente");

        menuRegistarBoletim.setText("Registar Boletim de Saude");
        menuRegistarBoletim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegistarBoletimActionPerformed(evt);
            }
        });
        mnuUtente.add(menuRegistarBoletim);

        menuConsultar.setText("Consultar Centro de Vac");
        menuConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarActionPerformed(evt);
            }
        });
        mnuUtente.add(menuConsultar);

        jMenuItem1.setText("Fazer Marcacao");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuUtente.add(jMenuItem1);

        mnuPrincipal.add(mnuUtente);

        setJMenuBar(mnuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 281, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTerminarActionPerformed
        terminar();
    }//GEN-LAST:event_mniTerminarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        terminar();
    }//GEN-LAST:event_formWindowClosing

    private void menuRegistarBoletimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRegistarBoletimActionPerformed
        RegistoDoencas regdoenca = new RegistoDoencas(sistema, null);
        regdoenca.setVisible(true);
        
    }//GEN-LAST:event_menuRegistarBoletimActionPerformed

    private void mniAlterarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAlterarPasswordActionPerformed
        alterarPassword();
    }//GEN-LAST:event_mniAlterarPasswordActionPerformed

    private void menuEditarGestorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarGestorActionPerformed
        new ListaGestores(sistema).setVisible(true);
    }//GEN-LAST:event_menuEditarGestorActionPerformed

    private void mnuAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAdministradorActionPerformed
        new ListarInforCentros(sistema).setVisible(true);
    }//GEN-LAST:event_mnuAdministradorActionPerformed

    private void menuVacinasEfeitosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVacinasEfeitosActionPerformed
        new SaberNumeroVacinasEfeitos().setVisible(true);
    }//GEN-LAST:event_menuVacinasEfeitosActionPerformed

    private void menuConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarActionPerformed
        new JanelaConsultarCentro(sistema).setVisible(true);
    }//GEN-LAST:event_menuConsultarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new JanelaMarcacao().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void editarcentroMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarcentroMenuActionPerformed
        new ListarInforCentros(sistema).setVisible(true);
    }//GEN-LAST:event_editarcentroMenuActionPerformed

    private void menuListarCentrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListarCentrosActionPerformed
        ListarInforCentros listar = new ListarInforCentros(sistema);
        listar.setVisible(true);
    }//GEN-LAST:event_menuListarCentrosActionPerformed

    private void consultarUtenteMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarUtenteMenuActionPerformed
        ListaUtentesCentro lst = new ListaUtentesCentro(sistema);
        lst.setVisible(true);
    }//GEN-LAST:event_consultarUtenteMenuActionPerformed

    private void registarVacinacaoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registarVacinacaoMenuActionPerformed
        RegistoVacinaEfeitosSecundarios regist = new RegistoVacinaEfeitosSecundarios(sistema, null, null);
        regist.setVisible(true);
    }//GEN-LAST:event_registarVacinacaoMenuActionPerformed

    private void menuAlocarVacinasCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAlocarVacinasCentroActionPerformed
        new JanelaAlocarVacinas(sistema, null).setVisible(true);
    }//GEN-LAST:event_menuAlocarVacinasCentroActionPerformed
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem consultarUtenteMenu;
    private javax.swing.JMenuItem editarcentroMenu;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem menuAlocarVacinasCentro;
    private javax.swing.JMenuItem menuConsultar;
    private javax.swing.JMenuItem menuEditarGestor;
    private javax.swing.JMenuItem menuListarCentros;
    private javax.swing.JMenuItem menuRegistarBoletim;
    private javax.swing.JMenuItem menuVacinasEfeitos;
    private javax.swing.JMenuItem mniAlterarPassword;
    private javax.swing.JMenuItem mniTerminar;
    private javax.swing.JMenu mnuAdministrador;
    private javax.swing.JMenu mnuGeral;
    private javax.swing.JMenu mnuGestor;
    private javax.swing.JMenuBar mnuPrincipal;
    private javax.swing.JMenu mnuUtente;
    private javax.swing.JMenuItem registarVacinacaoMenu;
    // End of variables declaration//GEN-END:variables
}
