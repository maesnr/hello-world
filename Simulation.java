/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feu_foret_sannier_hecher;

/**
 *
 * @author bhecher
 */
public class Simulation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      
        int humidite=0;
        int force=0;
        int direction=0;
        int ligne=0;
        int colonne=0;
        int probaHumidite=0;
        
        
        
        Vent v = new Vent(force); //génerer un vent
        v.forcevent(); //demander la force du vent
        v.directionvent(); //puis la direction
        
        Terrain t = new Terrain(humidite); //génerer un terrain
        t.humidite(); //choisir humidité du terrain 
        t.probaHumidite(); //donne la probad d'humidité
        t.nbCasesInfla(); //nbr de cases inflam en fonction du terrain choisi

        t.initMatrice(); //créer le tableau
        t.feu(humidite); //demarrer le feu sur une case aléatoire
        
        t.ligneOrigine(); //on récupere la ligne du repere d'origine
        t.colonneOrigine(); //on récupere la colonne du repere d'origine
     
        t.afficher(); //ETAT INITIAL ON LANCE LE FEU
        System.out.println("\n________________\n");
        
        System.out.print("humidite: "+humidite+" probahumidite: "+probaHumidite+" force: "+force+" direction: "+direction+" ligne: "+ligne+" colonne: "+colonne);
        
        //LANCEMENT DE LA SIMULATION :
        
//        for (int temps = 0; temps < 10; temps++) { //10 itérations
//
//            t.gererEtatetBrandons(force, probaHumidite); //actualisation du degré de combustion et de l'envoi des brandons
//            t.ProbaReceptionBrandons(force,direction,ligne,colonne);
//            t.afficher(); //affiche la matrice
//            System.out.println("\n\n\n");
//        }
        
    }
}
