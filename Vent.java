/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feu_foret_sannier_hecher;

import java.util.Scanner;

/**
 *
 * @author bhecher
 */
public class Vent {

    private int force = 0;

    public Vent(int force) {
        this.force = force;
    }

    public int forcevent() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Veuillez choisir la force du vent. 0: Nul, "
                + "1: Modéré, 2: Fort ou 3: Violent"); //choix de la force du vent
        int force = sc.nextInt();
        if (force != 0 && force != 1 && force != 2 && force != 3) {
            System.out.println("Réessayez");
            forcevent(); //si la personne se trompe
        }

        return force;
    }

    public int directionvent() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Veuillez choisir la direction du vent. 0: Nord, "
                + "1: Sud, 2: Est ou 3: Ouest"); //choix de la direction du vent
        int direction = sc.nextInt();
        if (direction != 0 && direction != 1 && direction != 2 && direction != 3) {
            System.out.println("Réessayez");
            directionvent(); //si la personne se trompe
        }

        return direction;
    }
    
    public void ventNord(int force){  
    }
    public void ventSud(int force){  
    }
    public void ventEst(int force){  
    }
    public void ventOuest(int force){  
    }
    
    public void declencherVent(int force, int direction){
        if (direction==0){
            ventNord(force);
        }
        if (direction==1){
            ventSud(force);
        }
        if (direction==2){
            ventEst(force);
        }
        if (direction==3){
            ventOuest(force);
        }
    }
    
    
    
    
    
    @Override
    public String toString() {
        return "Vent{" + "force=" + force + '}';
    }

}
