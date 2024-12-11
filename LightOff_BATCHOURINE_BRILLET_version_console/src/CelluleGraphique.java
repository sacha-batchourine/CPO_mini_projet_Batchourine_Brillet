
import Jeu.CelluleLumineuse;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JButton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author baptistebrillet
 */
public class CelluleGraphique extends JButton {
int largeur; // largeur en pixel de la cellule
int hauteur; // hauteur en pixel de la cellule
CelluleLumineuse celluleLumineuseAssociee;
// constructeur (appelé depuis FenetrePrincipale)
    public CelluleGraphique(CelluleLumineuse celluleLumineuseAssociee, int l,int h) {
        this.largeur = l;
        this.hauteur = h;
        this.celluleLumineuseAssociee = celluleLumineuseAssociee;
    }
// Methode gérant le dessin de la cellule
    @Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    Color color = null;
        if (celluleLumineuseAssociee.estEteint()) {
            
                color = Color.RED;
        }
        else{
            
                color= Color.BLACK;
        }
    g2d.setColor(color);
    g2d.fillRect(0, 0, getWidth(), getHeight());
}
}