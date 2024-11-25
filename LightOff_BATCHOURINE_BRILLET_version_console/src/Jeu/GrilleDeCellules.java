/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jeu;
import java.util.Random;
/**
 *Classe qui représente la GrilleDeCellules
 * @author baptistebrillet
 */
public class GrilleDeCellules {
    private final CelluleLumineuse[][] matriceCellules;
    private final int nbLignes;
    private final int nbColonnes;

    /** Constructeur de la grille avec des dimensions spécifiées.
     * @param p_nbLignes
     * @param p_nbColonnes */
    public GrilleDeCellules(int p_nbLignes, int p_nbColonnes) {
        this.nbLignes = p_nbLignes;
        this.nbColonnes = p_nbColonnes;
        this.matriceCellules = new CelluleLumineuse[nbLignes][nbColonnes];

        // Initialisation des cellules à l'état éteint.
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j] = new CelluleLumineuse();
            }
        }
    }

    /** Méthodes pour obtenir le nombre de lignes et de colonnes. */
    public int getNbLignes() {
        return nbLignes;
    }

    public int getNbColonnes() {
        return nbColonnes;
    }

    /** Éteint toutes les cellules de la grille. */
    public void eteindreToutesLesCellules() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j].eteindreCellule();
            }
        }
    }

    /** Active une ligne de cellules.
     * @param idLigne */
    public void activerLigneDeCellules(int idLigne) {
        for (int j = 0; j < nbColonnes; j++) {
            matriceCellules[idLigne][j].activerCellule();
        }
    }

    /** Active une colonne de cellules.
     * @param idColonne */
    public void activerColonneDeCellules(int idColonne) {
        for (int i = 0; i < nbLignes; i++) {
            matriceCellules[i][idColonne].activerCellule();
        }
    }

    /** Active la diagonale descendante. */
    public void activerDiagonaleDescendante() {
        for (int i = 0; i < Math.min(nbLignes, nbColonnes); i++) {
            matriceCellules[i][i].activerCellule();
        }
    }

    /** Active la diagonale montante. */
    public void activerDiagonaleMontante() {
        for (int i = 0; i < Math.min(nbLignes, nbColonnes); i++) {
            matriceCellules[i][nbColonnes - 1 - i].activerCellule();
        }
    }

    /** Mélange la grille en activant des lignes, colonnes ou diagonales aléatoires.
     * @param nbTours */
    public void melangerMatriceAleatoirement(int nbTours) {
        Random rand = new Random();
        eteindreToutesLesCellules();

        for (int i = 0; i < nbTours; i++) {
            int choix = rand.nextInt(3);
            switch (choix) {
                case 0 -> activerLigneDeCellules(rand.nextInt(nbLignes));
                case 1 -> activerColonneDeCellules(rand.nextInt(nbColonnes));
                default -> {
                    if (rand.nextBoolean()) {
                        activerDiagonaleDescendante();
                    } else {
                        activerDiagonaleMontante();
                    }
                }
            }
        }
    }

    /** Vérifie si toutes les cellules sont éteintes.
     * @return  */
    public boolean cellulesToutesEteintes() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (!matriceCellules[i][j].estEteint()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("   ");
        for (int j = 0; j < nbColonnes; j++) {
            sb.append(j).append(" ");
        }
        sb.append("\n");

        for (int i = 0; i < nbLignes; i++) {
            sb.append("  ").append("-".repeat(nbColonnes * 2)).append("\n");
            sb.append(i).append(" | ");
            for (int j = 0; j < nbColonnes; j++) {
                sb.append(matriceCellules[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}