package Frontend;

import Backend.Administrador;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import Backend.CentroVacinacao;
import Backend.Sistema;

public class ListarInforCentros extends javax.swing.JFrame {

    private Sistema sistema;
    private AbstractTableModel modeloTabela;

    public ListarInforCentros(Sistema sistema) {
        initComponents();
        this.sistema = sistema;
        this.modeloTabela = criarModeloTabela();
        tabCentrosVacinacao.setModel(modeloTabela);
        
        btnRemover.setVisible(sistema.getUtilizadorLigado() instanceof Administrador);
        btnAdicionar.setVisible(sistema.getUtilizadorLigado() instanceof Administrador);
    }

    private AbstractTableModel criarModeloTabela() {
        String[] nomeColunas = {"Codigo", "Morada", "Localidade", "Gestor", "Postos"};

        return new AbstractTableModel() {
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }

            @Override
            public int getRowCount() {
                //Retorna o número de linhas que a tabela deverá ter
                return sistema.getListaCentrosVacinacao().size();
            }

            @Override
            public int getColumnCount() {
                //Retorna o número de colunas que a tabela deverá ter
                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                /*
                Este método é invocado quando se pretende "popular" cada uma das células da tabela
                Se a tabela tem 3 linhas e 2 colunas existem 6 células (3*2), logo o método será invocado 6 vezes
                    rowIndex representa a linha da célula (0 a rowCount -1)
                    columnIndex representa a coluna da célula (0 a ColumnCount -1)
                 */
                switch (columnIndex) {
                    case 0:
                        return sistema.getListaCentrosVacinacao().todos().get(rowIndex).getCodigo();
                    case 1:
                        return sistema.getListaCentrosVacinacao().todos().get(rowIndex).getMorada();
                    case 2:
                        return sistema.getListaCentrosVacinacao().todos().get(rowIndex).getLocalidade();
                    case 3:
                        return sistema.getListaCentrosVacinacao().todos().get(rowIndex).getGestor().getCodUtilizador();
                    case 4:
                        return Integer.parseInt(sistema.getListaCentrosVacinacao().todos().get(rowIndex).getNum_posto_atend());
                    default:
                        return "";
                }
            }
        };
    }

    private void adicionar() {
        JanelaDadosCentro janela = new JanelaDadosCentro(sistema, null, this);
        janela.setVisible(true);
    }

    private void editar() {
        int rowIndex = tabCentrosVacinacao.getSelectedRow();
        //Se nenhum registo selecionado, nao é possivel editar
        if (rowIndex == -1) {
            return;
        }

        String codigo = (String) modeloTabela.getValueAt(rowIndex, 0);

        try {
            CentroVacinacao centro = sistema.getListaCentrosVacinacao().getCentroVacinacao(codigo);
            JanelaDadosCentro janela = new JanelaDadosCentro(sistema, centro, this);
            janela.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }
    
    private void remover() {
        int rowIndex = tabCentrosVacinacao.getSelectedRow();
        String codigoCentro = (String) modeloTabela.getValueAt(rowIndex, 0);

        if (tabCentrosVacinacao.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Linha não selecionada!", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
                    try {
                        int opcao = JOptionPane.showConfirmDialog(null, "Quer realmente remover o Centro?", "Remover Centro", JOptionPane.YES_NO_OPTION);
                        if (opcao == JOptionPane.YES_OPTION) {
                            sistema.getListaCentrosVacinacao().remover(codigoCentro);
                        }
                        this.atualizar();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage());
                    }
                }
            }
    

    public void atualizar() {
        //Informa o modelo que foram efetuadas alteracoes, o modelo informa a tabela e os dados são redesenhados
        modeloTabela.fireTableDataChanged();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabCentrosVacinacao = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de Centros");

        tabCentrosVacinacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabCentrosVacinacao.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabCentrosVacinacao);

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdicionar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemover)
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnEditar)
                    .addComponent(btnRemover))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        adicionar();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        remover();
    }//GEN-LAST:event_btnRemoverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabCentrosVacinacao;
    // End of variables declaration//GEN-END:variables
}
