package visao;

import dao.FerramentaDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Ferramenta;

/*Interface gráfica para cadastro, alteração e exclusão de ferramentas, com uma tabela para exibir os dados das ferramentas cadastradas. Permite também calcular o custo total das ferramentas cadastradas.*/
public class TelaFerramenta extends javax.swing.JFrame {

    private int xMouse, yMouse; //variaveis para permitir o manuseio da janela

    private FerramentaDAO objetoferramenta;

    public TelaFerramenta() {
        initComponents();
        this.objetoferramenta = new FerramentaDAO();
        carregaTabela();
    }

    public void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTableFerramenta.getModel();
        modelo.setNumRows(0);

        ArrayList<Ferramenta> minhalista;
        minhalista = objetoferramenta.getMinhaLista();

        for (Ferramenta ferramenta : minhalista) {
            modelo.addRow(new Object[]{
                ferramenta.getId(),
                ferramenta.getNome(),
                ferramenta.getMarca(),
                ferramenta.getCusto(),});
        }
        custoTotal();
    }

    private void custoTotal() {
        double custoTotal = objetoferramenta.getTotal();
        String custoTotalFormatado = String.format("%.2f", custoTotal);
        this.JTFtotal.setText(custoTotalFormatado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPmenu = new javax.swing.JPanel();
        JBsair = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        JBalterar = new javax.swing.JButton();
        JTFmarca = new javax.swing.JTextField();
        JBapagar = new javax.swing.JButton();
        JBcadastrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JTFnome = new javax.swing.JTextField();
        JTFcusto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFerramenta = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        JTFtotal = new javax.swing.JLabel();

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

        JBsair.setBackground(new java.awt.Color(255, 204, 204));
        JBsair.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        JBsair.setForeground(new java.awt.Color(255, 255, 255));
        JBsair.setText("X");
        JBsair.setBorder(null);
        JBsair.setBorderPainted(false);
        JBsair.setContentAreaFilled(false);
        JBsair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBsair.setFocusPainted(false);
        JBsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBsairActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(204, 255, 204));
        jLabel4.setFont(new java.awt.Font("Ubuntu Mono", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ferramentas");

        javax.swing.GroupLayout JPmenuLayout = new javax.swing.GroupLayout(JPmenu);
        JPmenu.setLayout(JPmenuLayout);
        JPmenuLayout.setHorizontalGroup(
            JPmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPmenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBsair, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JPmenuLayout.setVerticalGroup(
            JPmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPmenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(JPmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBsair, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        JBalterar.setBackground(new java.awt.Color(102, 153, 255));
        JBalterar.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        JBalterar.setForeground(new java.awt.Color(255, 255, 255));
        JBalterar.setText("Alterar");
        JBalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBalterarActionPerformed(evt);
            }
        });

        JTFmarca.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N

        JBapagar.setBackground(new java.awt.Color(102, 153, 255));
        JBapagar.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        JBapagar.setForeground(new java.awt.Color(255, 255, 255));
        JBapagar.setText("Apagar");
        JBapagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBapagarActionPerformed(evt);
            }
        });

        JBcadastrar.setBackground(new java.awt.Color(102, 153, 255));
        JBcadastrar.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        JBcadastrar.setForeground(new java.awt.Color(255, 255, 255));
        JBcadastrar.setText("Cadastrar");
        JBcadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBcadastrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Marca:");

        jLabel3.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Custo:");

        JTFnome.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N

        JTFcusto.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N

        jTableFerramenta.setBackground(new java.awt.Color(255, 255, 255));
        jTableFerramenta.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jTableFerramenta.setForeground(new java.awt.Color(0, 0, 0));
        jTableFerramenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Marca", "Custo"
            }
        ));
        jTableFerramenta.setToolTipText("");
        jTableFerramenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFerramentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFerramenta);

        jLabel5.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Gasto Total:");

        JTFtotal.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        JTFtotal.setForeground(new java.awt.Color(0, 0, 0));
        JTFtotal.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTFnome)
                            .addComponent(JTFmarca)
                            .addComponent(JTFcusto, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JBcadastrar)
                        .addGap(141, 141, 141)
                        .addComponent(JBalterar)
                        .addGap(111, 111, 111)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBapagar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(JTFtotal)
                        .addGap(87, 87, 87))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(JTFnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTFmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFtotal))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTFcusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBcadastrar)
                    .addComponent(JBalterar)
                    .addComponent(JBapagar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JPmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JBsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBsairActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBsairActionPerformed
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

    private void JBalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBalterarActionPerformed
        try {
            // recebendo e validando dados da interface gr�fica.
            int id = 0;
            String nome = "";
            String marca = "";
            double custo = 0;

            if (this.JTFnome.getText().length() < 2) {
                throw new Mensagens("Nome deve conter ao menos 2 caracteres.");
            } else {
                nome = this.JTFnome.getText();
            }

            if (this.JTFmarca.getText().length() <= 0) {
                throw new Mensagens("Marca deve conter ao menos 2 caracteres.");
            } else {
                marca = this.JTFmarca.getText();
            }

            if (this.JTFcusto.getText().length() < 2) {
                throw new Mensagens("Custo deve conter ao menos 1 numero.");
            } else {
                custo = Double.parseDouble(this.JTFcusto.getText());
            }

            if (this.jTableFerramenta.getSelectedRow() == -1) {
                throw new Mensagens("Primeiro Selecione uma Ferramenta para Alterar");
            } else {
                id = Integer.parseInt(this.jTableFerramenta.getValueAt(this.jTableFerramenta.getSelectedRow(), 0).toString());
            }

            if (this.objetoferramenta.updateFerramentaBD(new Ferramenta(id, nome, marca, custo))) {

                // limpa os campos
                this.JTFnome.setText("");
                this.JTFmarca.setText("");
                this.JTFcusto.setText("");
                JOptionPane.showMessageDialog(rootPane, "Ferramenta alterada com Sucesso!");

            }
            System.out.println(this.objetoferramenta.getMinhaLista().toString());
        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um numero.");
        } finally {
            carregaTabela(); // atualiza a tabela.
        }
    }//GEN-LAST:event_JBalterarActionPerformed

    private void JBapagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBapagarActionPerformed
        try {
            // validando dados da interface gráfica.
            int id = 0;
            if (this.jTableFerramenta.getSelectedRow() == -1) {
                throw new Mensagens(
                        "Primeiro Selecione uma Ferramenta para APAGAR");
            } else {
                id = Integer.parseInt(this.jTableFerramenta.
                        getValueAt(this.jTableFerramenta.getSelectedRow(), 0).
                        toString());
            }
            // retorna 0 -> primeiro botão | 1 -> segundo botão | 2 -> terceiro botão
            int respostaUsuario = JOptionPane.
                    showConfirmDialog(null,
                            "Tem certeza que deseja apagar esta Ferramenta ?");
            if (respostaUsuario == 0) {// clicou em SIM
                // envia os dados para a Ferramenta processar
                if (this.objetoferramenta.deleteFerramentaBD(id)) {
                    // limpa os campos
                    this.JTFnome.setText("");
                    this.JTFmarca.setText("");
                    this.JTFcusto.setText("");
                    JOptionPane.showMessageDialog(rootPane,
                            "Ferramenta apagada com sucesso!");
                }
            }
            // atualiza a tabela.
            System.out.println(this.objetoferramenta.getMinhaLista().toString());
        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            // atualiza a tabela.
            carregaTabela();
        }
    }//GEN-LAST:event_JBapagarActionPerformed

    private void JBcadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBcadastrarActionPerformed
        try {
            // recebendo e validando dados da interface gráfica.
            String nome = "";
            String marca = "";
            double custo = 0;
            if (this.JTFnome.getText().length() < 2) {
                throw new Mensagens("Nome deve conter ao menos 2 caracteres.");
            } else {
                nome = this.JTFnome.getText();
            }
            if (this.JTFmarca.getText().length() <= 0) {
                throw new Mensagens("Marca deve conter ao menos 2 caracteres.");
            } else {
                marca = this.JTFmarca.getText();
            }
            if (this.JTFcusto.getText().length() < 0) {
                throw new Mensagens("Custo deve ser número e maior que zero.");
            } else {
                custo = Double.parseDouble(this.JTFcusto.getText());
            }
            // envia os dados para o Controlador cadastrar
            if (this.objetoferramenta.insertFerramentaBD(new Ferramenta(nome, marca, custo))) {
                JOptionPane.showMessageDialog(rootPane, "Ferramenta Cadastrado com Sucesso!");
                this.JTFnome.setText("");
                this.JTFmarca.setText("");
                this.JTFcusto.setText("");
            }
            //Exibi no console a ferramenta cadastrado
            System.out.println(this.objetoferramenta.getMinhaLista().toString());
        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um n�mero.");
        } finally {
            carregaTabela(); // atualiza a tabela.
        }
    }//GEN-LAST:event_JBcadastrarActionPerformed

    private void jTableFerramentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFerramentaMouseClicked
        if (this.jTableFerramenta.getSelectedRow() != -1) {
            String nome = this.jTableFerramenta.getValueAt(this.jTableFerramenta.getSelectedRow(), 1).toString();
            String marca = this.jTableFerramenta.getValueAt(this.jTableFerramenta.getSelectedRow(), 2).toString();
            String custo = this.jTableFerramenta.getValueAt(this.jTableFerramenta.getSelectedRow(), 3).toString();

            this.JTFnome.setText(nome);
            this.JTFmarca.setText(marca);
            this.JTFcusto.setText(custo);
        }
    }//GEN-LAST:event_jTableFerramentaMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TelaFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFerramenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBalterar;
    private javax.swing.JButton JBapagar;
    private javax.swing.JButton JBcadastrar;
    private javax.swing.JButton JBsair;
    private javax.swing.JPanel JPmenu;
    private javax.swing.JTextField JTFcusto;
    private javax.swing.JTextField JTFmarca;
    private javax.swing.JTextField JTFnome;
    private javax.swing.JLabel JTFtotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFerramenta;
    // End of variables declaration//GEN-END:variables
}
