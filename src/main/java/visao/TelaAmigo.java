package visao;

import dao.AmigoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Amigo;

/*A classe TelaAmigo é responsável por criar a interface gráfica para interação com dados de amigos.*/
public class TelaAmigo extends javax.swing.JFrame {

    private int xMouse, yMouse; //variaveis para permitir o manuseio da janela
    private AmigoDAO objetoamigo;

    public TelaAmigo() {
        initComponents();
        this.objetoamigo = new AmigoDAO();
        carregaTabela();
    }

    public void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTableAmigo.getModel();
        modelo.setNumRows(0);

        ArrayList<Amigo> minhalista;
        minhalista = objetoamigo.getMinhaLista();

        for (Amigo amigo : minhalista) {
            modelo.addRow(new Object[]{
                amigo.getId(),
                amigo.getNome(),
                amigo.getTelefone(),});
        }
    }

    public ArrayList<String> getListaAmigos() {
        return this.objetoamigo.getMinhaLista();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPmenu = new javax.swing.JPanel();
        JBsair = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        JBapagar = new javax.swing.JButton();
        JTFtelefone = new javax.swing.JTextField();
        JBcadastrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTFnome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAmigo = new javax.swing.JTable();
        JBalterar = new javax.swing.JButton();

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

        jLabel3.setBackground(new java.awt.Color(204, 255, 204));
        jLabel3.setFont(new java.awt.Font("Ubuntu Mono", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Amigos");

        javax.swing.GroupLayout JPmenuLayout = new javax.swing.GroupLayout(JPmenu);
        JPmenu.setLayout(JPmenuLayout);
        JPmenuLayout.setHorizontalGroup(
            JPmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPmenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBsair, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JPmenuLayout.setVerticalGroup(
            JPmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPmenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(JPmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBsair, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        JBapagar.setBackground(new java.awt.Color(102, 153, 255));
        JBapagar.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        JBapagar.setForeground(new java.awt.Color(255, 255, 255));
        JBapagar.setText("Apagar");
        JBapagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBapagarActionPerformed(evt);
            }
        });

        JTFtelefone.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        JBcadastrar.setBackground(new java.awt.Color(102, 153, 255));
        JBcadastrar.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        JBcadastrar.setForeground(new java.awt.Color(255, 255, 255));
        JBcadastrar.setText("Cadastrar");
        JBcadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBcadastrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel2.setText("Telefone:");

        JTFnome.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        jTableAmigo.setBackground(new java.awt.Color(255, 255, 255));
        jTableAmigo.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jTableAmigo.setForeground(new java.awt.Color(0, 0, 0));
        jTableAmigo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone"
            }
        ));
        jTableAmigo.setToolTipText("");
        jTableAmigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAmigoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAmigo);

        JBalterar.setBackground(new java.awt.Color(102, 153, 255));
        JBalterar.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        JBalterar.setForeground(new java.awt.Color(255, 255, 255));
        JBalterar.setText("Alterar");
        JBalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBalterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBcadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBalterar)
                        .addGap(69, 69, 69)
                        .addComponent(JBapagar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(JTFtelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(42, 42, 42)
                            .addComponent(JTFnome, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTFnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTFtelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBalterar)
                    .addComponent(JBapagar)
                    .addComponent(JBcadastrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void JBapagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBapagarActionPerformed
        try {
            // validando dados da interface gráfica.
            int id = 0;
            if (this.jTableAmigo.getSelectedRow() == -1) {
                throw new Mensagens(
                        "Primeiro Selecione um Amigo para APAGAR");
            } else {
                id = Integer.parseInt(this.jTableAmigo.
                        getValueAt(this.jTableAmigo.getSelectedRow(), 0).
                        toString());
            }
            // retorna 0 -> primeiro botão | 1 -> segundo botão | 2 -> terceiro botão
            int respostaUsuario = JOptionPane.
                    showConfirmDialog(null,
                            "Tem certeza que deseja apagar este Amigo ?");
            if (respostaUsuario == 0) {// clicou em SIM
                // envia os dados para o Amigo processar
                if (this.objetoamigo.deleteAmigoBD(id)) {
                    // limpa os campos
                    this.JTFnome.setText("");
                    this.JTFtelefone.setText("");
                    JOptionPane.showMessageDialog(rootPane,
                            "Amigo apagado com sucesso!");
                }
            }
            // atualiza a tabela.
            System.out.println(this.objetoamigo.getMinhaLista().toString());
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
            String telefone = "";
            if (this.JTFnome.getText().length() < 2) {
                throw new Mensagens("Nome deve conter ao menos 2 caracteres.");
            } else {
                nome = this.JTFnome.getText();
            }
            if (this.JTFtelefone.getText().length() <= 0) {
                throw new Mensagens("Telefone deve conter ao menos 2 caracteres.");
            } else {
                telefone = this.JTFtelefone.getText();
            }

            // envia os dados para o Controlador cadastrar
            if (this.objetoamigo.insertAmigoBD(new Amigo(nome, telefone))) {
                JOptionPane.showMessageDialog(rootPane, "Amigo Cadastrado com Sucesso!");
                this.JTFnome.setText("");
                this.JTFtelefone.setText("");
            }
            //Exibi no console o amigo cadastrado
            System.out.println(this.objetoamigo.getMinhaLista().toString());
        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um n�mero.");
        } finally {
            carregaTabela(); // atualiza a tabela.
        }
    }//GEN-LAST:event_JBcadastrarActionPerformed

    private void jTableAmigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAmigoMouseClicked
        if (this.jTableAmigo.getSelectedRow() != -1) {
            String nome = this.jTableAmigo.getValueAt(this.jTableAmigo.getSelectedRow(), 1).toString();
            String telefone = this.jTableAmigo.getValueAt(this.jTableAmigo.getSelectedRow(), 2).toString();

            this.JTFnome.setText(nome);
            this.JTFtelefone.setText(telefone);
        }
    }//GEN-LAST:event_jTableAmigoMouseClicked

    private void JBalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBalterarActionPerformed
        try {
            // recebendo e validando dados da interface gr�fica.
            int id = 0;
            String nome = "";
            String telefone = "";

            if (this.JTFnome.getText().length() < 2) {
                throw new Mensagens("Nome deve conter ao menos 2 caracteres.");
            } else {
                nome = this.JTFnome.getText();
            }

            if (this.JTFtelefone.getText().length() <= 0) {
                throw new Mensagens("Telefone deve conter ao menos 2 caracteres.");
            } else {
                telefone = this.JTFtelefone.getText();
            }
            if (this.jTableAmigo.getSelectedRow() == -1) {
                throw new Mensagens("Primeiro Selecione um Amigo para Alterar");
            } else {
                id = Integer.parseInt(this.jTableAmigo.getValueAt(this.jTableAmigo.getSelectedRow(), 0).toString());
            }

            // envia os dados para o Amigo processar
            if (this.objetoamigo.updateAmigoBD(new Amigo(id, nome, telefone))) {

                // limpa os campos
                this.JTFnome.setText("");
                this.JTFtelefone.setText("");
                JOptionPane.showMessageDialog(rootPane, "Amigo Alterado com Sucesso!");

            }
            System.out.println(this.objetoamigo.getMinhaLista().toString());
        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um n�mero.");
        } finally {
            carregaTabela(); // atualiza a tabela.
        }
    }//GEN-LAST:event_JBalterarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAmigo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBalterar;
    private javax.swing.JButton JBapagar;
    private javax.swing.JButton JBcadastrar;
    private javax.swing.JButton JBsair;
    private javax.swing.JPanel JPmenu;
    private javax.swing.JTextField JTFnome;
    private javax.swing.JTextField JTFtelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAmigo;
    // End of variables declaration//GEN-END:variables
}
