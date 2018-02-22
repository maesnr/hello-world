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
public class noninflammable extends Case {

    public noninflammable(String type, int ligne, int colonne, int proba) {
        super(type, ligne, colonne, proba);
    }

   

    public void ajouterChemin() {

    }

    public void type() { //type entre : eau, terre 
        int min = 1, max = 2;
        int random = (int) (Math.random() * (max - min+1)) + min;
        switch (random) {
            case 1:
                type = "eau";
                break;
            case 2:
                type = "terre";
                break;
            default:
                break;
        }
    }
    
    @Override
    public int getLigne(){
        return ligne;
    }
    
    @Override
    public int getColonne(){
        return colonne;
    }

    public String toString() {
        return "0 {" + super.toString() + "}";
    }

}
