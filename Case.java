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
public class Case {

    protected String type;
    protected int ligne;
    protected int colonne;
    protected int probaReceptionBrandon;

    public Case(String type, int ligne, int colonne, int probaReceptionBrandon) {
        this.type = type;  //type peut prendre la valeur : eau, terre, foret,
                                 //maison, chemin    
        this.ligne=ligne; //position
        this.colonne=colonne; //position
        this.probaReceptionBrandon=probaReceptionBrandon; //toute case a une probabilité de recevoir des brandons
    }
    
    public int getLigne(){
        return ligne;
    }
    public int getColonne(){
        return colonne;
    }
    public int getProbaReceptionBrandon(){
        return probaReceptionBrandon;
    }
    
    public String getType() {
        return type;
    }

    public String getEtat() {
        return "infla";
    }
    
 public String getBrandon() {
     return "brandon";
    }
 
    public void type() {
    }

    public void degre() {
    }

    public void demarrerFeu(int probaHumidite) {
    }

    public void gererEtatetBrandons(double force, int probaHumidite) {
    }
    

    @Override
    public String toString() {
        return "t=" + type + ","+ " p=" + "(" + ligne + "," + colonne +")"; // p = position
    }
}
