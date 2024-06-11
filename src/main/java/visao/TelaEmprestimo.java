package visao;

import dao.AmigoDAO;
import dao.EmprestimoDAO;
import dao.FerramentaDAO;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Amigo;
import modelo.Emprestimo;


/*Interface gráfica para gerenciamento de empréstimos de ferramentas, permitindo o registro, alteração e exclusão de empréstimos.*/
public class TelaEmprestimo extends javax.swing.JFrame {

    int xMouse, yMouse; //variaveis para permitir o manuseio da janela
    private AmigoDAO objetoamigo;
    private FerramentaDAO objetoferramenta;
    private EmprestimoDAO objetoemprestimo;

    public TelaEmprestimo() {
        initComponents();
        this.objetoamigo = new AmigoDAO();
        this.objetoferramenta = new FerramentaDAO();
        this.objetoemprestimo = new EmprestimoDAO();

        carregaTabela();
    }

    public void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTableEmprestimos.getModel();
        modelo.setNumRows(0);

        ArrayList<Emprestimo> minhalista = objetoemprestimo.getMinhaLista();

        for (Emprestimo e : minhalista) {
            String dataDevolucao = (e.getDataDevolucao() != null) ? e.getDataDevolucao().toString() : "Pendente";

            modelo.addRow(new Object[]{
                e.getId(),
                e.getIdAmigo(),
                e.getIdFerramenta(),
                e.getDataEmprestimo(),
                dataDevolucao // Exibe "Pendente" se a data de devolucao for nula
            });
        }
        exibirAmigoComMaisEmprestimos();
    }

    private void exibirAmigoComMaisEmprestimos() {
        Amigo amigoComMaisEmprestimos = objetoamigo.getAmigoComMaisEmprestimos();

        if (amigoComMaisEmprestimos != null) {
            JTFqtdemprestimos.setText(amigoComMaisEmprestimos.getNome() + ", " + amigoComMaisEmprestimos.getTotalEmprestimos());
        } else {
            JTFqtdemprestimos.setText("Nenhum amigo encontrado");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPmenu = new javax.swing.JPanel();
        JBsair1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        JBregistrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEmprestimos = new javax.swing.JTable();
        JBalterar = new javax.swing.JButton();
        JBapagar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JTFferramenta = new javax.swing.JTextField();
        JTFamigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JTFdata = new javax.swing.JTextField();
        JTFdevolucao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        JTFqtdemprestimos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        JPmenu.setBackground(new java.awt.Color(102, 153, 255));
        JPmenu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                JPmenuMouseDragged(evt);
            }
        });
        JPmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPmenuMousePressed(evt);
            }
        });

        JBsair1.setBackground(new java.awt.Color(255, 204, 204));
        JBsair1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        JBsair1.setForeground(new java.awt.Color(255, 255, 255));
        JBsair1.setText("X");
        JBsair1.setBorder(null);
        JBsair1.setBorderPainted(false);
        JBsair1.setContentAreaFilled(false);
        JBsair1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBsair1.setFocusPainted(false);
        JBsair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBsair1ActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(204, 255, 204));
        jLabel4.setFont(new java.awt.Font("Ubuntu Mono", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Empréstimos");

        javax.swing.GroupLayout JPmenuLayout = new javax.swing.GroupLayout(JPmenu);
        JPmenu.setLayout(JPmenuLayout);
        JPmenuLayout.setHorizontalGroup(
            JPmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPmenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBsair1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JPmenuLayout.setVerticalGroup(
            JPmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPmenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(JPmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBsair1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(106, 106, 106))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        JBregistrar.setBackground(new java.awt.Color(102, 153, 255));
        JBregistrar.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        JBregistrar.setForeground(new java.awt.Color(255, 255, 255));
        JBregistrar.setText("Registrar");
        JBregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBregistrarActionPerformed(evt);
            }
        });

        jTableEmprestimos.setBackground(new java.awt.Color(255, 255, 255));
        jTableEmprestimos.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jTableEmprestimos.setForeground(new java.awt.Color(0, 0, 0));
        jTableEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Amigo", "Ferramenta", "Data", "Data devolução"
            }
        ));
        jTableEmprestimos.setToolTipText("");
        jTableEmprestimos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmprestimosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableEmprestimos);

        JBalterar.setBackground(new java.awt.Color(102, 153, 255));
        JBalterar.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        JBalterar.setForeground(new java.awt.Color(255, 255, 255));
        JBalterar.setText("Alterar");
        JBalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBalterarActionPerformed(evt);
            }
        });

        JBapagar.setBackground(new java.awt.Color(102, 153, 255));
        JBapagar.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        JBapagar.setForeground(new java.awt.Color(255, 255, 255));
        JBapagar.setText("Apagar");
        JBapagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBapagarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Data:");

        jLabel5.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("ID Ferramenta:");

        JTFferramenta.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N

        JTFamigo.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("ID Amigo:");

        jLabel7.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Data Devolucao:");

        JTFdata.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N

        JTFdevolucao.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Amigo que fez mais emprestimos:");

        JTFqtdemprestimos.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        JTFqtdemprestimos.setForeground(new java.awt.Color(0, 0, 0));
        JTFqtdemprestimos.setText("Amigo, 10");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFamigo, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTFferramenta)
                                    .addComponent(JTFdevolucao, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBregistrar)
                        .addGap(262, 262, 262)
                        .addComponent(JBapagar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBalterar)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(52, 52, 52)
                                .addComponent(JTFqtdemprestimos))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(JTFdata, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JTFamigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(JTFferramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTFdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(JTFdevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTFqtdemprestimos))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBregistrar)
                    .addComponent(JBapagar)
                    .addComponent(JBalterar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JPmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JBsair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBsair1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBsair1ActionPerformed
    //metodo para mudar a posicao da janela
    private void JPmenuMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPmenuMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_JPmenuMouseDragged
    //metodo para mexer a janela
    private void JPmenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPmenuMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_JPmenuMousePressed

    private void JBregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBregistrarActionPerformed
        try {
            int idAmigo = Integer.parseInt(this.JTFamigo.getText());
            int idFerramenta = Integer.parseInt(this.JTFferramenta.getText());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dataEmprestimo = new Date(sdf.parse(this.JTFdata.getText()).getTime());
            Date dataDevolucao = null;

            // Verifica se foi inserida uma data de devolução
            if (!this.JTFdevolucao.getText().isEmpty()) {
                dataDevolucao = new Date(sdf.parse(this.JTFdevolucao.getText()).getTime());

                // Verifica se a data de emprestimo eh maior que a data de devolução
                if (dataEmprestimo.after(dataDevolucao)) {
                    throw new ParseException("Data de empréstimo posterior à data de devolução", 0);
                }
            }

            // Cria o objeto de emprestimo com a data de devolucao
            Emprestimo emprestimo = new Emprestimo(objetoamigo.carregaAmigo(idAmigo),
                    objetoferramenta.carregaFerramenta(idFerramenta),
                    dataEmprestimo,
                    dataDevolucao);

            // Registra o emprestimo
            if (objetoemprestimo.registrarEmprestimo(emprestimo)) {
                JOptionPane.showMessageDialog(rootPane, "Emprestimo cadastrado com sucesso!");
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            carregaTabela(); // Atualiza a tabela
        }
    }//GEN-LAST:event_JBregistrarActionPerformed

    private void jTableEmprestimosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmprestimosMouseClicked
        if (this.jTableEmprestimos.getSelectedRow() != -1) {
            String id_amigo = this.jTableEmprestimos.getValueAt(this.jTableEmprestimos.getSelectedRow(), 1).toString();
            String id_ferramenta = this.jTableEmprestimos.getValueAt(this.jTableEmprestimos.getSelectedRow(), 2).toString();
            String data = this.jTableEmprestimos.getValueAt(this.jTableEmprestimos.getSelectedRow(), 3).toString();

            this.JTFamigo.setText(id_amigo);
            this.JTFferramenta.setText(id_ferramenta);
            this.JTFdata.setText(data);
        }
    }//GEN-LAST:event_jTableEmprestimosMouseClicked

    private void JBalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBalterarActionPerformed
        try {
            // Recebendo e validando dados da interface gráfica
            int id = Integer.parseInt(this.jTableEmprestimos.getValueAt(this.jTableEmprestimos.getSelectedRow(), 0).toString());
            int idAmigo = Integer.parseInt(this.JTFamigo.getText());
            int idFerramenta = Integer.parseInt(this.JTFferramenta.getText());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dataEmprestimo = new Date(sdf.parse(this.JTFdata.getText()).getTime());
            Date dataDevolucao = null;

            if (!this.JTFdevolucao.getText().isEmpty() && !this.JTFdevolucao.getText().contains("_")) {
                dataDevolucao = new Date(sdf.parse(this.JTFdevolucao.getText()).getTime());

                if (dataEmprestimo.after(dataDevolucao)) {
                    throw new ParseException("Data de empréstimo posterior à data de devolução", 0);
                }
            }

            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setId(id);
            emprestimo.setIdAmigo(objetoamigo.carregaAmigo(idAmigo));
            emprestimo.setIdFerramenta(objetoferramenta.carregaFerramenta(idFerramenta));
            emprestimo.setDataEmprestimo(dataEmprestimo);
            emprestimo.setDataDevolucao(dataDevolucao);

            // Atualiza o empréstimo
            if (objetoemprestimo.updateEmprestimoBD(emprestimo)) {
                JOptionPane.showMessageDialog(rootPane, "Emprestimo atualizado com sucesso!");
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            carregaTabela(); // Atualiza a tabela
        }
    }//GEN-LAST:event_JBalterarActionPerformed

    private void JBapagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBapagarActionPerformed

        try {
            int id = 0;
            int idAmigo = 0;

            if (this.jTableEmprestimos.getSelectedRow() == -1) {
                throw new Mensagens("Primeiro, selecione um empréstimo para remover");
            } else {
                id = Integer.parseInt(this.jTableEmprestimos.getValueAt(this.jTableEmprestimos.getSelectedRow(), 0).toString());
                idAmigo = objetoemprestimo.carregaEmprestimo(id).getIdAmigo().getId();
            }

            int resposta = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja remover este empréstimo?", "Confirmação", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION && this.objetoemprestimo.deleteEmprestimoBD(id)) {
                JOptionPane.showMessageDialog(rootPane, "Empréstimo removido com sucesso!");
            }
        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        } finally {
            carregaTabela();
        }
    }//GEN-LAST:event_JBapagarActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBalterar;
    private javax.swing.JButton JBapagar;
    private javax.swing.JButton JBregistrar;
    private javax.swing.JButton JBsair1;
    private javax.swing.JPanel JPmenu;
    private javax.swing.JTextField JTFamigo;
    private javax.swing.JTextField JTFdata;
    private javax.swing.JTextField JTFdevolucao;
    private javax.swing.JTextField JTFferramenta;
    private javax.swing.JLabel JTFqtdemprestimos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEmprestimos;
    // End of variables declaration//GEN-END:variables
}
