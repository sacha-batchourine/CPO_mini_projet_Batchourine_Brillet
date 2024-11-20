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
    private int niveauDifficulteTaille;
    private int niveauDifficulteTemps;

    public Partie() {
        afficherMenuPrincipal();
    }

    public void afficherMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        boolean quitter = false;

        while (!quitter) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1: Nouvelle Partie");
            System.out.println("2: Quitter");
            System.out.print("Choix : ");

            int choix = lireEntier(scanner, 1, 2);
            switch (choix) {
                case 1 -> {
                    configurerPartie();
                    initialiserPartie();
                    lancerPartie();
                }
                case 2 -> {
                    System.out.println("Merci d'avoir joué ! À bientôt !");
                    quitter = true;
                }
                default -> System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    public void configurerPartie() {
        Scanner scanner = new Scanner(System.in);

        // Choisir la taille de la grille
        System.out.println("\nChoisissez un niveau de difficulté pour la taille :");
        System.out.println("1: Facile (5x5)");
        System.out.println("2: Moyen (7x7)");
        System.out.println("3: Difficile (10x10)");
        System.out.print("Choix : ");
        niveauDifficulteTaille = lireEntier(scanner, 1, 3);

        switch (niveauDifficulteTaille) {
            case 1 -> this.grille = new GrilleDeCellules(5, 5);
            case 2 -> this.grille = new GrilleDeCellules(7, 7);
            case 3 -> this.grille = new GrilleDeCellules(10, 10);
            default -> {
                System.out.println("Choix invalide, par défaut : taille Moyenne");
                this.grille = new GrilleDeCellules(7, 7);
                niveauDifficulteTaille = 2;
            }
        }

        // Choisir le chronomètre
        System.out.println("\nChoisissez un niveau de difficulté pour le temps :");
        System.out.println("1: 5 minutes");
        System.out.println("2: 4 minutes");
        System.out.println("3: 3 minutes");
        System.out.print("Choix : ");
        niveauDifficulteTemps = lireEntier(scanner, 1, 3);
    }

    public void initialiserPartie() {
        int nbMelanges = switch (niveauDifficulteTaille) {
            case 1 -> 5;  // Facile
            case 2 -> 10; // Moyen
            case 3 -> 20; // Difficile
            default -> 10;
        };
        grille.melangerMatriceAleatoirement(nbMelanges);
    }

    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);
        long tempsMax = switch (niveauDifficulteTemps) {
            case 1 -> 5 * 60 * 1000L; // 5 minutes
            case 2 -> 4 * 60 * 1000L; // 4 minutes
            case 3 -> 3 * 60 * 1000L; // 3 minutes
            default -> 4 * 60 * 1000L;
        };

        long debut = System.currentTimeMillis();

        System.out.println("\n=== Début de la Partie ===");
        System.out.println(grille);

        while (!grille.cellulesToutesEteintes()) {
            long tempsEcoule = System.currentTimeMillis() - debut;
            if (tempsEcoule > tempsMax) {
                System.out.println("Temps écoulé ! Vous avez perdu.");
                return;
            }

            System.out.println("Temps restant : " + (tempsMax - tempsEcoule) / 1000 + " secondes");
            System.out.println("Choisissez une action : ");
            System.out.println("1: Activer une ligne");
            System.out.println("2: Activer une colonne");
            System.out.println("3: Activer une diagonale");
            System.out.println("4: Arrêter et revenir au menu principal");
            System.out.print("Votre choix : ");

            int choix = lireEntier(scanner, 1, 4);
            if (choix == 4) {
                System.out.println("Vous avez quitté la partie.");
                return; // Quitte la partie et retourne au menu
            }

            switch (choix) {
                case 1 -> {
                    System.out.print("Entrez le numéro de la ligne (entre 0 et " + (grille.getNbLignes() - 1) + ") : ");
                    int ligne = lireEntier(scanner, 0, grille.getNbLignes() - 1);
                    grille.activerLigneDeCellules(ligne);
                }
                case 2 -> {
                    System.out.print("Entrez le numéro de la colonne (entre 0 et " + (grille.getNbColonnes() - 1) + ") : ");
                    int colonne = lireEntier(scanner, 0, grille.getNbColonnes() - 1);
                    grille.activerColonneDeCellules(colonne);
                }
                case 3 -> {
                    System.out.println("1: Diagonale descendante, 2: Diagonale montante");
                    int diag = lireEntier(scanner, 1, 2);
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

    private int lireEntier(Scanner scanner, int min, int max) {
        int valeur;
        while (true) {
            if (scanner.hasNextInt()) {
                valeur = scanner.nextInt();
                if (valeur >= min && valeur <= max) {
                    return valeur;
                } else {
                    System.out.println("Veuillez entrer un nombre entre " + min + " et " + max + ".");
                }
            } else {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                scanner.next(); // Consomme l'entrée incorrecte
            }
        }
    }
}