package JeuInterfaceGraphique;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/** Elle permet au joueur de comprendre les règles et de retourner au menu principal
 *
 * @author baptistebrillet batchourine sacha
 */
public class RegleDuJeu extends javax.swing.JFrame {

    /** 
     * Creation de la fenetre regle du jeu 
     */
    public RegleDuJeu() {
        initComponents();
        
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Regle = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 675));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setText("Présentation des règles de LightOff");
        jTextField1.setAutoscrolls(false);
        jTextField1.setFocusTraversalKeysEnabled(false);
        jTextField1.setFocusable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField1, new java.awt.GridBagConstraints());

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 800, 30));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Retour MENU");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 140, 40));

        Regle.setEditable(false);
        Regle.setBackground(new java.awt.Color(204, 204, 204));
        Regle.setColumns(20);
        Regle.setRows(5);
        Regle.setText("               Le jeu se joue sur une grille composée de plusieurs lignes et colonnes\n\n              Chaque case de la grille est une lumière qui peut être allumée ou éteinte\n\n                        Certaines cases commencent allumées et d’autres éteintes\n\n\n              À chaque tour, le joueur choisit soit une ligne, soit une colonne de la grille\n\n                 Toutes les lumières dans cette ligne ou colonne vont changer d’état :\n\n• Si une lumière est allumée (couleur Jaune) , elle devient éteinte (couleur Gris).\n• Si une lumière est éteinte (couleur Gris), elle devient allumée (couleur Jaune).\n\n\n\n\t      L’objectif est d’éteindre toutes les lumières de la grille");
        Regle.setAutoscrolls(false);
        Regle.setFocusTraversalKeysEnabled(false);
        Regle.setFocusable(false);
        jScrollPane1.setViewportView(Regle);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 560, 320));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 680, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /** Ce champs est desactivé
     * 
     * @param evt 
     */
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    /** Ouvre la fenetre debut de partie et ferme la fenetre actuelle
     * 
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            DebutPartie  d = new DebutPartie();
            d.setVisible(true);
            this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /** Executer les fenetres de maniere autonome
     * @param args les arguments de la ligne de commande
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(RegleDuJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegleDuJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegleDuJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegleDuJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegleDuJeu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Regle;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
