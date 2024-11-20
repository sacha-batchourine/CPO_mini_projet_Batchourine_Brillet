package lightoff_batchourine_brillet_version_console;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *BATCHOURINE BRILLET TDC
 * @author sachabatchourine
 */
/**
 * La classe CelluleLumineuse représente une cellule allumé
 * qui peut être dans l'état "allumée" ou "éteinte".
 * Elle offre des méthodes pour gérer son état.
 */
public class CelluleLumineuse {

    /**
     * Attribut représentant l'état de la cellule.
     * true : allumée, false : éteinte.
     */
    private boolean etat;

    /**
     * Constructeur par défaut.
     * Initialise l'état de la cellule à "éteinte" (false).
     */
    public CelluleLumineuse() {
        this.etat = false; // État initial éteint
    }

    /**
     * Active ou désactive la cellule lumineuse.
     * Si la cellule est allumée, elle devient éteinte.
     * Si la cellule est éteinte, elle devient allumée.
     */
    public void activerCellule() {
        this.etat = !this.etat; // Inverse l'état
    }

    /**
     * Éteint la cellule lumineuse.
     * Si la cellule est déjà éteinte, cette méthode ne fais rien.
     */
    public void eteindreCellule() {
        this.etat = false; // Force l'état à éteint
    }

    /**
     * Vérifie si la cellule est éteinte.
     *
     * @return true si la cellule est éteinte, false si elle est allumée.
     */
    public boolean estEteint() {
        return !this.etat; // Retourne true si éteinte
    }

    /**
     * Renvoie l'état actuel de la cellule.
     *
     * @return true si la cellule est allumée, false si elle est éteinte.
     */
    public boolean getEtat() {
        return this.etat;
    }

    /**
     * Retourne une représentation visuelle de l'état de la cellule.
     *
     * @return "X" si la cellule est allumée, "O" si elle est éteinte.
     */
    @Override
    public String toString() {
        return this.etat ? "X" : "O";
    }
}

    