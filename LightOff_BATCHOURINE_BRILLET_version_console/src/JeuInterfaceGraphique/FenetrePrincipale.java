package JeuInterfaceGraphique;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import Jeu.CelluleGraphique;
import Jeu.GrilleDeCellules;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.SwingUtilities;

/** 
 * Cette classe represente la fenetre principal du jeu 
 * elle gre l'interface graphique, le chronometre, les actions de jeu et les évenements (victoire, défaite)
 * baptistebrillet sachabatchourine
 * @author
 */
public class FenetrePrincipale extends javax.swing.JFrame {
    GrilleDeCellules grille;
    int nbCoups;
    Timer timer;
    int timeRemaining;
    /**
     * Constructeur de la class fenetre principal 
     * initilaise la fenetre principal en fonction de la difficulté choisie
     */
    public FenetrePrincipale(int taille) {
    initComponents();
    
    // Initialiser le chronomètre à 1 minute (60 secondes)
    switch (taille) {
            case 5:
                timeRemaining = 3 * 60; // 3 minutes
                break;
            case 7:
                timeRemaining = 5 * 60; // 5 minutes
                break;
            case 10:
                timeRemaining = 7 * 60; // 7 minutes
                break;
    } 
    startTimer();
    
    
        // Adapter le panneau des colonnes
        jPanel1.removeAll();
        jPanel1.setLayout(new GridLayout(1, taille));
        for (int i = 0; i < taille; i++) {
            JButton btnColonne = new JButton("C" + (i + 1));
            int colIndex = i;
            btnColonne.addActionListener(evt -> {
                grille.activerColonneDeCellules(colIndex);
                repaint();
                verifierVictoire(); // Vérifie après l'action
            });
            jPanel1.add(btnColonne);
        }

        // Adapter le panneau des lignes
        jPanel2.removeAll();
        jPanel2.setLayout(new GridLayout(taille, 1));
        for (int i = 0; i < taille; i++) {
            JButton btnLigne = new JButton("L" + (i + 1));
            int rowIndex = i;
            btnLigne.addActionListener(evt -> {
                grille.activerLigneDeCellules(rowIndex);
                repaint();
                verifierVictoire(); // Vérifie après l'action
            });
            jPanel2.add(btnLigne);
        }
        
        // Adapter le panneau de la grille principale
        PanneauGrille.removeAll();
        PanneauGrille.setLayout(new GridLayout(taille, taille));

        // Créer une nouvelle grille et mélanger
        this.grille = new GrilleDeCellules(taille, taille);
        grille.melangerMatriceAleatoirement(10);

        // Ajouter les cellules au panneau
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                CelluleGraphique boutonCellule = new CelluleGraphique(grille.matriceCellules[i][j], 36, 36);
                PanneauGrille.add(boutonCellule);
            }
        }

        // Rafraîchir les composants
        jPanel1.revalidate();
        jPanel1.repaint();
        jPanel2.revalidate();
        jPanel2.repaint();
        PanneauGrille.revalidate();
        PanneauGrille.repaint();
}  
    /** 
    * demarre le chronometre et met a jour l'affichage toute les seconde
    */ 
    private void startTimer() {
    timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            if (timeRemaining > 0) {
                timeRemaining--;
                // Met à jour le JLabel dans le thread Swing
                SwingUtilities.invokeLater(() -> {
                    Chrono.setText("Temps restant : " + timeRemaining + " secondes");
                });
            } else {
                timer.cancel();
                SwingUtilities.invokeLater(() -> {
                    FenetreDefaite fenetreDefaite = new FenetreDefaite();
                    fenetreDefaite.setVisible(true);
                    dispose();
                });
            }
        }
    }, 0, 1000);
    }
    /** Calcule le score final en fonction du temps restant et de la difficulté 
     * 
     * @return : le score finale
     */
    private int calculerScore() {
        double multiplicateur = 1.0;
    switch (grille.getNbLignes()) { // Taille de la grille
        case 5:
            multiplicateur = 1.0; // Pas de changement
            break;
        case 7:
            multiplicateur = 1.5; // Multiplicateur x1.5
            break;
        case 10:
            multiplicateur = 2.0; // Multiplicateur x2
            break;
    }
    return (int) (timeRemaining * multiplicateur); // Calcul du score final
    }
    /** Verifie si toutes les cellules de la grille sont eteintes
     * 
     * @return : true si elle sont éteintes sinon false
     */
    private boolean estVictoire() {
        for (int i = 0; i < grille.getNbLignes(); i++) {
            for (int j = 0; j < grille.getNbColonnes(); j++) {
                if (!grille.matriceCellules[i][j].estEteint()) {
                    return false;
                }
            }
        }
        return true;
    }

    /** 
     * Verifie la condition de victoire et renvoie vers la fenetre : FenetreVictoire
     */
    private void verifierVictoire() {
    if (estVictoire()) {
        timer.cancel(); // Stoppe le chronomètre
        int score = calculerScore(); // Calcule le score
        FenetreVictoire fenetreVictoire = new FenetreVictoire(score);
        fenetreVictoire.setVisible(true);
        dispose();
    }
}


    /** 
     * 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        PanneauGrille = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnColonne0 = new javax.swing.JButton();
        btnColonne1 = new javax.swing.JButton();
        btnColonne2 = new javax.swing.JButton();
        btnColonne3 = new javax.swing.JButton();
        btnColonne4 = new javax.swing.JButton();
        btnColonne5 = new javax.swing.JButton();
        btnColonne6 = new javax.swing.JButton();
        btnColonne7 = new javax.swing.JButton();
        btnColonne8 = new javax.swing.JButton();
        btnColonne9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnLigne0 = new javax.swing.JButton();
        btnLigne1 = new javax.swing.JButton();
        btnLigne2 = new javax.swing.JButton();
        btnLigne3 = new javax.swing.JButton();
        btnLigne4 = new javax.swing.JButton();
        btnLigne5 = new javax.swing.JButton();
        btnLigne6 = new javax.swing.JButton();
        btnLigne7 = new javax.swing.JButton();
        btnLigne8 = new javax.swing.JButton();
        btnLigne9 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        Chrono = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        DiagonaleM = new javax.swing.JButton();
        DiagonaleD = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 675));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanneauGrille.setBackground(new java.awt.Color(0, 0, 0));
        PanneauGrille.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanneauGrille.setToolTipText("");
        PanneauGrille.setAutoscrolls(true);

        javax.swing.GroupLayout PanneauGrilleLayout = new javax.swing.GroupLayout(PanneauGrille);
        PanneauGrille.setLayout(PanneauGrilleLayout);
        PanneauGrilleLayout.setHorizontalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );
        PanneauGrilleLayout.setVerticalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );

        getContentPane().add(PanneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 600, 410));

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        btnColonne0.setText("C1");
        btnColonne0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColonne0ActionPerformed(evt);
            }
        });
        jPanel1.add(btnColonne0);

        btnColonne1.setText("C2");
        btnColonne1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColonne1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnColonne1);

        btnColonne2.setText("C3");
        btnColonne2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColonne2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnColonne2);

        btnColonne3.setText("C4");
        btnColonne3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColonne3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnColonne3);

        btnColonne4.setText("C5");
        btnColonne4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColonne4ActionPerformed(evt);
            }
        });
        jPanel1.add(btnColonne4);

        btnColonne5.setText("C6");
        btnColonne5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColonne5ActionPerformed(evt);
            }
        });
        jPanel1.add(btnColonne5);

        btnColonne6.setText("C7");
        btnColonne6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColonne6ActionPerformed(evt);
            }
        });
        jPanel1.add(btnColonne6);

        btnColonne7.setText("C8");
        btnColonne7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColonne7ActionPerformed(evt);
            }
        });
        jPanel1.add(btnColonne7);

        btnColonne8.setText("C9");
        btnColonne8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColonne8ActionPerformed(evt);
            }
        });
        jPanel1.add(btnColonne8);

        btnColonne9.setText("C10");
        btnColonne9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColonne9ActionPerformed(evt);
            }
        });
        jPanel1.add(btnColonne9);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 600, 60));

        jPanel2.setLayout(new java.awt.GridLayout(10, 0));

        btnLigne0.setText("Ligne 1");
        btnLigne0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigne0ActionPerformed(evt);
            }
        });
        jPanel2.add(btnLigne0);

        btnLigne1.setText("Ligne 2");
        btnLigne1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigne1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnLigne1);

        btnLigne2.setText("Ligne 3");
        btnLigne2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigne2ActionPerformed(evt);
            }
        });
        jPanel2.add(btnLigne2);

        btnLigne3.setText("Ligne 4");
        btnLigne3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigne3ActionPerformed(evt);
            }
        });
        jPanel2.add(btnLigne3);

        btnLigne4.setText("Ligne 5");
        btnLigne4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigne4ActionPerformed(evt);
            }
        });
        jPanel2.add(btnLigne4);

        btnLigne5.setText("Ligne 6");
        btnLigne5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigne5ActionPerformed(evt);
            }
        });
        jPanel2.add(btnLigne5);

        btnLigne6.setText("Ligne 7");
        btnLigne6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigne6ActionPerformed(evt);
            }
        });
        jPanel2.add(btnLigne6);

        btnLigne7.setText("Ligne 8");
        btnLigne7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigne7ActionPerformed(evt);
            }
        });
        jPanel2.add(btnLigne7);

        btnLigne8.setText("Ligne 9");
        btnLigne8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigne8ActionPerformed(evt);
            }
        });
        jPanel2.add(btnLigne8);

        btnLigne9.setText("Ligne 10");
        btnLigne9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigne9ActionPerformed(evt);
            }
        });
        jPanel2.add(btnLigne9);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 110, 410));

        jPanel8.setBackground(new java.awt.Color(153, 153, 153));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton7.setText("Retour MENU");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 150, 50));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 530, 250, 90));

        jPanel4.setBackground(new java.awt.Color(255, 255, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Chrono.setText("Chrono");
        jPanel4.add(Chrono, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 220, 40));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 530, 280, 90));

        jPanel5.setLayout(new java.awt.GridLayout(2, 0));

        DiagonaleM.setText("Diagonale M");
        DiagonaleM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiagonaleMActionPerformed(evt);
            }
        });
        jPanel5.add(DiagonaleM);

        DiagonaleD.setText("Diagonale D");
        DiagonaleD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiagonaleDActionPerformed(evt);
            }
        });
        jPanel5.add(DiagonaleD);

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 110, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLigne0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigne0ActionPerformed
        this.grille.activerLigneDeCellules(0);
    repaint();
    }//GEN-LAST:event_btnLigne0ActionPerformed

    private void btnLigne1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigne1ActionPerformed
        this.grille.activerLigneDeCellules(1);
    repaint();
    }//GEN-LAST:event_btnLigne1ActionPerformed

    private void btnLigne2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigne2ActionPerformed
        this.grille.activerLigneDeCellules(2);
    repaint();
    }//GEN-LAST:event_btnLigne2ActionPerformed

    private void btnLigne3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigne3ActionPerformed
        this.grille.activerLigneDeCellules(3);
    repaint();
    }//GEN-LAST:event_btnLigne3ActionPerformed

    private void btnLigne4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigne4ActionPerformed
        this.grille.activerLigneDeCellules(4);
    repaint();// TODO add your handling code here:
    }//GEN-LAST:event_btnLigne4ActionPerformed

    private void btnLigne5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigne5ActionPerformed
        this.grille.activerLigneDeCellules(5);
    repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_btnLigne5ActionPerformed

    private void btnLigne6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigne6ActionPerformed
        this.grille.activerLigneDeCellules(6);
    repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_btnLigne6ActionPerformed

    private void btnLigne7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigne7ActionPerformed
        this.grille.activerLigneDeCellules(7);
    repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_btnLigne7ActionPerformed

    private void btnLigne8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigne8ActionPerformed
        this.grille.activerLigneDeCellules(8);
    repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_btnLigne8ActionPerformed

    private void btnLigne9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigne9ActionPerformed
        this.grille.activerLigneDeCellules(9);
    repaint();// TODO add your handling code here:
    }//GEN-LAST:event_btnLigne9ActionPerformed

    private void btnColonne0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColonne0ActionPerformed
        this.grille.activerColonneDeCellules(0);
    repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_btnColonne0ActionPerformed

    private void btnColonne1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColonne1ActionPerformed
        this.grille.activerColonneDeCellules(1);
    repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_btnColonne1ActionPerformed

    private void btnColonne2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColonne2ActionPerformed
        this.grille.activerColonneDeCellules(2);
    repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_btnColonne2ActionPerformed

    private void btnColonne3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColonne3ActionPerformed
        this.grille.activerColonneDeCellules(3);
    repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_btnColonne3ActionPerformed

    private void btnColonne4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColonne4ActionPerformed
        this.grille.activerColonneDeCellules(4);
    repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_btnColonne4ActionPerformed

    private void btnColonne5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColonne5ActionPerformed
        this.grille.activerColonneDeCellules(5);
    repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_btnColonne5ActionPerformed

    private void btnColonne6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColonne6ActionPerformed
        this.grille.activerColonneDeCellules(6);
    repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_btnColonne6ActionPerformed

    private void btnColonne7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColonne7ActionPerformed
        this.grille.activerColonneDeCellules(7);
    repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_btnColonne7ActionPerformed

    private void btnColonne8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColonne8ActionPerformed
        this.grille.activerColonneDeCellules(8);
    repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_btnColonne8ActionPerformed

    private void btnColonne9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColonne9ActionPerformed
        this.grille.activerColonneDeCellules(9);
    repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_btnColonne9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
            DebutPartie  b = new DebutPartie();
            b.setVisible(true);
            this.dispose();        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed
    /**
     * Permet de changer l'état des cellules de la diagonale Montante
     * @param evt 
     */
    private void DiagonaleMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiagonaleMActionPerformed
        this.grille.activerDiagonaleMontante();
        repaint();
        verifierVictoire();
    }//GEN-LAST:event_DiagonaleMActionPerformed
    /**
     * Permet de changer l'état des cellules de la diagonale Descendante
     * @param evt 
     */
    private void DiagonaleDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiagonaleDActionPerformed
        this.grille.activerDiagonaleDescendante();
        repaint();
        verifierVictoire();      
    }//GEN-LAST:event_DiagonaleDActionPerformed

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }
    /** Initialise la partie en mélangeant les cellules de la grille
     * 
     */
    public void initialiserPartie() {
    grille.eteindreToutesLesCellules();
    grille.melangerMatriceAleatoirement(10);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Chrono;
    private javax.swing.JButton DiagonaleD;
    private javax.swing.JButton DiagonaleM;
    private javax.swing.JPanel PanneauGrille;
    private javax.swing.JButton btnColonne0;
    private javax.swing.JButton btnColonne1;
    private javax.swing.JButton btnColonne2;
    private javax.swing.JButton btnColonne3;
    private javax.swing.JButton btnColonne4;
    private javax.swing.JButton btnColonne5;
    private javax.swing.JButton btnColonne6;
    private javax.swing.JButton btnColonne7;
    private javax.swing.JButton btnColonne8;
    private javax.swing.JButton btnColonne9;
    private javax.swing.JButton btnLigne0;
    private javax.swing.JButton btnLigne1;
    private javax.swing.JButton btnLigne2;
    private javax.swing.JButton btnLigne3;
    private javax.swing.JButton btnLigne4;
    private javax.swing.JButton btnLigne5;
    private javax.swing.JButton btnLigne6;
    private javax.swing.JButton btnLigne7;
    private javax.swing.JButton btnLigne8;
    private javax.swing.JButton btnLigne9;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables
}
