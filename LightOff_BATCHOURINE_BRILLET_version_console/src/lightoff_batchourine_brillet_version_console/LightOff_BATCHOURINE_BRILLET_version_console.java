/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lightoff_batchourine_brillet_version_console;

import Jeu.Partie;

/**
 * Classe principale pour le lancement du jeu LightOff en version console.
 * Fonctionnement :
 * - Le jeu LightOff est lancé via cette classe.
 * - Elle crée une instance de la classe `Partie`, qui gère l'intégralité du jeu.
 * @author sachabatchourine
 */
public class LightOff_BATCHOURINE_BRILLET_version_console {

    /** 
     * Point d'entrée principal de l'application.
     * Cette méthode lance le menu principal du jeu via l'instanciation de la classe `Partie`.
     * @param args Arguments de ligne de commande.
     */
    public static void main(String[] args) {
        new Partie(); 
    }
}
