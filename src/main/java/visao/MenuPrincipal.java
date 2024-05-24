package visao;

public class MenuPrincipal extends javax.swing.JFrame {

    private int xMouse, yMouse;
    
    public MenuPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        JBamigo = new javax.swing.JButton();
        JBferramenta = new javax.swing.JButton();
        JBemprestimo = new javax.swing.JButton();
        JPmenu = new javax.swing.JPanel();
        JBsair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 0, 0));

        JBamigo.setBackground(new java.awt.Color(102, 153, 255));
        JBamigo.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        JBamigo.setForeground(new java.awt.Color(255, 255, 255));
        JBamigo.setText("Amigo");
        JBamigo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBamigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBamigoActionPerformed(evt);
            }
        });

        JBferramenta.setBackground(new java.awt.Color(102, 153, 255));
        JBferramenta.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        JBferramenta.setForeground(new java.awt.Color(255, 255, 255));
        JBferramenta.setText("Ferramenta");
        JBferramenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBferramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBferramentaActionPerformed(evt);
            }
        });

        JBemprestimo.setBackground(new java.awt.Color(102, 153, 255));
        JBemprestimo.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        JBemprestimo.setForeground(new java.awt.Color(255, 255, 255));
        JBemprestimo.setText("Empréstimo");
        JBemprestimo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBemprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBemprestimoActionPerformed(evt);
            }
        });

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

        jLabel1.setBackground(new java.awt.Color(204, 255, 204));
        jLabel1.setFont(new java.awt.Font("Ubuntu Mono", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menu Principal");

        javax.swing.GroupLayout JPmenuLayout = new javax.swing.GroupLayout(JPmenu);
        JPmenu.setLayout(JPmenuLayout);
        JPmenuLayout.setHorizontalGroup(
            JPmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPmenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBsair, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JPmenuLayout.setVerticalGroup(
            JPmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPmenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(JPmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBsair, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBemprestimo)
                    .addComponent(JBferramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBamigo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(JPmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(JBamigo)
                .addGap(18, 18, 18)
                .addComponent(JBferramenta)
                .addGap(18, 18, 18)
                .addComponent(JBemprestimo)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JBamigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBamigoActionPerformed

    }//GEN-LAST:event_JBamigoActionPerformed

    private void JBferramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBferramentaActionPerformed

    }//GEN-LAST:event_JBferramentaActionPerformed

    private void JBemprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBemprestimoActionPerformed

    }//GEN-LAST:event_JBemprestimoActionPerformed

    private void JBsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBsairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_JBsairActionPerformed

    private void JPmenuMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPmenuMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_JPmenuMouseDragged

    private void JPmenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPmenuMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_JPmenuMousePressed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBamigo;
    private javax.swing.JButton JBemprestimo;
    private javax.swing.JButton JBferramenta;
    private javax.swing.JButton JBsair;
    private javax.swing.JPanel JPmenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
