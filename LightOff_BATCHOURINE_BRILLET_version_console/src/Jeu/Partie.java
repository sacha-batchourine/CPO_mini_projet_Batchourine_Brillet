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
    private int niveauDifficulte;

    public Partie() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choisissez un niveau de difficulté :");
        System.out.println("1: Facile (grille 5x5, 10 mélanges)");
        System.out.println("2: Moyen (grille 7x7, 15 mélanges)");
        System.out.println("3: Difficile (grille 10x10, 25 mélanges)");
        niveauDifficulte = scanner.nextInt();

        switch (niveauDifficulte) {
            case 1 -> this.grille = new GrilleDeCellules(5, 5);
            case 2 -> this.grille = new GrilleDeCellules(7, 7);
            case 3 -> this.grille = new GrilleDeCellules(10, 10);
            default -> {
                System.out.println("Choix invalide, par défaut : niveau Moyen");
                this.grille = new GrilleDeCellules(7, 7);
                niveauDifficulte = 2;
            }
        }
        this.nbCoups = 0;
    }

    public void initialiserPartie() {
        int nbMelanges = switch (niveauDifficulte) {
            case 1 -> 10;
            case 2 -> 15;
            case 3 -> 25;
            default -> 15;
        };
        grille.melangerMatriceAleatoirement(nbMelanges);
    }

    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);
        boolean rejouer;

        do {
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
            System.out.println("Voulez-vous rejouer ? (true/false)");
            rejouer = scanner.nextBoolean();

            if (rejouer) {
                this.initialiserPartie();
                nbCoups = 0;
            }

        } while (rejouer);

        System.out.println("Merci d'avoir joué !");
    }
}