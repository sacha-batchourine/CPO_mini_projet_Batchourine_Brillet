/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lightoff_batchourine_brillet_version_console;

/**
 *
 * @author sachabatchourine
 */
public class LightOff_BATCHOURINE_BRILLET_version_console {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Création de deux cellules lumineuses
        CelluleLumineuse cellule1 = new CelluleLumineuse();
        CelluleLumineuse cellule2 = new CelluleLumineuse();

        // Affichage de l'état initial
        System.out.println("État initial de cellule1 : " + cellule1); // Devrait afficher "O"
        System.out.println("État initial de cellule2 : " + cellule2); // Devrait afficher "O"

        // Activation de cellule1
        cellule1.activerCellule();
        System.out.println("Après activation de cellule1 : " + cellule1); // Devrait afficher "X"

        // Éteindre cellule2 (déjà éteinte)
        cellule2.eteindreCellule();
        System.out.println("Après tentative d'extinction de cellule2 : " + cellule2); // Devrait afficher "O"

        // Vérification de l'état
        System.out.println("Cellule1 est éteinte ? " + cellule1.estEteint()); // Devrait afficher false
        System.out.println("Cellule2 est éteinte ? " + cellule2.estEteint()); // Devrait afficher true

        // Réactivation et vérification
        cellule1.activerCellule();
        System.out.println("Après réactivation de cellule1 : " + cellule1); // Devrait afficher "O"
    }
}
    

