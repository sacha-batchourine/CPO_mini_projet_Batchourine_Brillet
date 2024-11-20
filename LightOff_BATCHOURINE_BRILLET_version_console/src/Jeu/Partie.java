/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jeu;
import java.util.Scanner;
/**
 *Classe représentant une partie du jeu LightOff.
 * @author baptistebrillet
 */
public class Partie {
    private GrilleDeCellules grille;
    private int nbCoups;

    /** Constructeur par défaut. */
    public Partie() {
        this.grille = new GrilleDeCellules(5, 5); // Par défaut, une grille 5x5
        this.nbCoups = 0;
    }

    /** Initialise la partie en mélangeant la grille. */
    public void initialiserPartie() {
        grille.melangerMatriceAleatoirement(10); // Mélange avec 10 activations aléatoires
    }

    /** Lance une partie interactive. */
    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue dans LightOff !");
        System.out.println(grille);

        while (!grille.cellulesToutesEteintes()) {
            System.out.println("Choisissez une action : ");
            System.out.println("1: Activer une ligne, 2: Activer une colonne, 3: Activer une diagonale");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1 -> {
                    System.out.print("Entrez le numéro de la ligne : ");
                    int ligne = scanner.nextInt();
                    grille.activerLigneDeCellules(ligne);
                }
                case 2 -> {
                    System.out.print("Entrez le numéro de la colonne : ");
                    int colonne = scanner.nextInt();
                    grille.activerColonneDeCellules(colonne);
                }
                case 3 -> {
                    System.out.println("1: Diagonale descendante, 2: Diagonale montante");
                    int diag = scanner.nextInt();
                    if (diag == 1) {
                        grille.activerDiagonaleDescendante();
                    } else {
                        grille.activerDiagonaleMontante();
                    }
                }
                default -> System.out.println("Choix invalide.");
            }

            nbCoups++;
            System.out.println("Grille actuelle :");
            System.out.println(grille);
        }

        System.out.println("Félicitations ! Vous avez éteint toutes les lumières en " + nbCoups + " coups !");
    }
}
