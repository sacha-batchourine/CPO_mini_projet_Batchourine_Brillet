package Jeu;


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
 * Classe représentant une cellule graphique dans l'interface utilisateur.
 * @author baptistebrillet
 */
public class CelluleGraphique extends JButton {
int largeur; // largeur en pixel de la cellule
int hauteur; // hauteur en pixel de la cellule
CelluleLumineuse celluleLumineuseAssociee;

    /**
     * Constructeur de la cellule graphique.
     * 
     * @param celluleLumineuseAssociee La cellule lumineuse associée à cette cellule graphique.
     * @param l La largeur en pixels de la cellule graphique.
     * @param h La hauteur en pixels de la cellule graphique.
     */
    public CelluleGraphique(CelluleLumineuse celluleLumineuseAssociee, int l,int h) {
        this.largeur = l;
        this.hauteur = h;
        this.celluleLumineuseAssociee = celluleLumineuseAssociee;
    }
    /**
     * Méthode qui gère le dessin de la cellule graphique.
     * @param g L'objet `Graphics` utilisé pour dessiner la cellule.
     */
    @Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    Color color = null;
        if (celluleLumineuseAssociee.estEteint()) {            
                color = Color.GRAY; // Si la cellule est éteinte, on la dessine en gris
        }
        else{          
                color= Color.YELLOW; // Si la cellule est allumée, on la dessine en jaune
        }
    g2d.setColor(color);
    g2d.fillRect(3, 3, getWidth()-3, getHeight()-3);
}
}