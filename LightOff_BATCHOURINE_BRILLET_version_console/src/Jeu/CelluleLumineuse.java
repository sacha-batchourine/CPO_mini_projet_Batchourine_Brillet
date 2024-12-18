/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jeu;

/**
 * Classe représentant une cellule lumineuse.
 * Une cellule peut être allumée ou éteinte.
 */
public class CelluleLumineuse {
    private boolean etat; // true = allumé, false = éteint

    /** Constructeur par défaut 
     *  Initialise une cellule éteinte. 
     */
    public CelluleLumineuse() {
        this.etat = false;
    }

    /** Inverse l'état de la cellule. */
    public void activerCellule() {
        this.etat = !this.etat;
    }

    /** Éteint la cellule. */
    public void eteindreCellule() {
        this.etat = false;
    }

    /** Vérifie si la cellule est éteinte. */
    public boolean estEteint() {
        return !this.etat;
    }

    /** Renvoie l'état actuel de la cellule. */
    public boolean getEtat() {
        return this.etat;
    }
    
    /**
     * Chaque cellule est affichée avec son état actuel (allumée ou éteinte).
     * @return Une chaîne représentant la grille de cellules sous forme textuelle.
     */
    @Override
    public String toString() {
        return this.etat ? "X" : "O"; // X = allumé, O = éteint
    }

}
