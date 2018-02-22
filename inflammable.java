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
public class inflammable extends Case {

    private String etat = "intacte"; //degré de combustion
    private String Envoibrandon = "non"; //envoi de brandons //"non" à l'état de base
    private int probaSenflammer = 0;

    @Override
    public String getEtat() {
        return etat;
    }

    @Override
    public String getBrandon() {
        return Envoibrandon;
    }

    public inflammable(String type, int ligne, int colonne, int proba) {
        super(type, ligne, colonne, proba);
    }

    @Override
    public void type() { //type entre : maison, foret, prairie
        int min = 1, max = 3;
        int random = (int) (Math.random() * (max - min + 1)) + min;
        switch (random) {
            case 1:
                type = "maison";
                break;
            case 2:
                type = "foret";
                break;
            case 3:
                type = "prairie";
                break;
            default:
                break;
        }
    }

    @Override
    public void demarrerFeu(int probaHumidite) {
        etat = "feu!";
        Envoibrandon = "non";
        probaSenflammer = (probaReceptionBrandon * probaHumidite) / 100;
    }

    @Override
    public void gererEtatetBrandons(double force, int probaHumidite) {
        switch (etat) {
            case "intacte":
                Envoibrandon = "non";
                probaSenflammer=(probaReceptionBrandon * probaHumidite) / 100;
            case "feu!":
                etat = "enflammé1";
                Envoibrandon = "oui"; //une case enflammée envoie des brandons à 
                probaSenflammer=100;           //100%. mais à qui? dépend des probas

                break;
            case "enflammé1":
                etat = "enflammé2";
                Envoibrandon = "oui";
                probaSenflammer=100;
                break;

            case "enflammé2":
                etat = "bruléChaud1";
                int k = (int) (Math.random() * 100); // % de chance d'envoyer brandons
                double probab = 0.5 * (1 + 2 * force); //formule donnée
                if (k < probab) {
                    Envoibrandon = "oui";
                } else {
                    Envoibrandon = "non";
                }
                
                
                probaSenflammer = (probaReceptionBrandon * probaHumidite) / 100;
                int l = (int) (Math.random() * 100);
                if (l < probaSenflammer) {
                    etat = "enflammé1";
                }
                break;

            case "bruléChaud1":
                etat = "bruléChaud2";
                int i = (int) (Math.random() * 100); // % de chance d'envoyer brandons
                probab = 0.5 * (1 + 2 * force);
                if (i < probab) {
                    Envoibrandon = "oui";
                } else {
                    Envoibrandon = "non";
                }
                
                probaSenflammer = (probaReceptionBrandon * probaHumidite) / 100;
                int m = (int) (Math.random() * 100);
                if (m < probaSenflammer) {
                    etat = "enflammé1";
                }
                break;
                
            case "bruléChaud2":
                int j = (int) (Math.random() * 100); // 40% de chance de passer 
                if (j < 40) {                           //en brûlé froid
                    etat = "bruléFroid";
                    Envoibrandon = "non";
                    break;
                }

            case "bruléFroid":
                etat = "bruléFroid2";
                Envoibrandon = "non";
                probaSenflammer=0;
                break;
            case "bruléFroid2":
                etat = "bruléFroid3";
                Envoibrandon = "non";
                probaSenflammer=0;
                break;
            case "bruléFroid3":
                etat = "cendre4ever";
                Envoibrandon = "non";
                probaSenflammer=0;
                break;

        }
        

    }

    public void receptionBrandon() {
        //la case reçoit des brandons en fonction de sa position par rapport à la case enflammée.
        //

    }

    @Override
    public String toString() {
        return "1{" + "etat=" + etat + ", B=" + Envoibrandon + ", "
                + super.toString() + '}';
    }

}

// SI ELLE ST ENFLAMMEE prob d'envoyer des brandons : celles dans les cases  
// SI ELLE ST BRULEE CHAUD 0,5* ........ 
