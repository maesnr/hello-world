/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feu_foret_sannier_hecher;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author bhecher
 */
public class Terrain {

    private int humidite;
    private String nomFichier;
    private Case[][] matrice;
    private int nbCasesInfla;

    public Terrain(int humidite, String nomFichier) {
        this.humidite = humidite;
        this.nomFichier = nomFichier;
        this.matrice = new Case[20][20];
        initMatrice();
    }

    public Terrain(int humidite) {
        this.humidite = humidite;
        this.matrice = new Case[20][20];
        initMatrice();
    }

    public int humidite() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Veuillez choisir l'humidité du terrain. "
                + " 0: Humide, 1: Normal, 2: Sec,"
                + " 3: Très Sec");
        humidite = sc.nextInt();
        
        if (humidite == 0) {
            System.out.println("Vous avez choisi un terrain humide" + "\n");
        }
        if (humidite == 1) { 
            System.out.println("Vous avez choisi un terrain normal" + "\n");
        }
        if (humidite == 2) {
            System.out.println("Vous avez choisi un terrain sec" + "\n");
        }
        if (humidite == 3) {
            System.out.println("Vous avez choisi un terrain très sec" + "\n");
        }
        if (humidite != 0 && humidite != 1 && humidite != 2 && humidite != 3) {
            System.out.println("Réessayez");
            humidite(); //si la personne se trompe
        }
        return humidite; 
    }
    
    public int probaHumidite(){
        int probaHumidite=0;
        if (humidite == 0) {
            probaHumidite = 10;
        }
        if (humidite == 1) {
            probaHumidite = 35;
        }
        if (humidite == 2) {
            probaHumidite = 60;
        }
        if (humidite == 3) {
            probaHumidite = 90;
        }
        return probaHumidite;
    }
    

    public void nbCasesInfla() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez choisir le type de terrain."
                + "0: Clairesemé, 1: Espacé,"
                + " 2: Touffu, 3: Continu ");
        int x = sc.nextInt();
        if (x == 0) {
            nbCasesInfla = (int) (0.5 * matrice.length * matrice[0].length);

            System.out.println("Vous avez choisi un terrain Clairesemé"
                    + "\n");
        }
        if (x == 1) {
            nbCasesInfla = (int) (0.75 * matrice.length * matrice[0].length);
            System.out.println("Vous avez choisi un terrain Espacé" + "\n");
        }

        if (x == 2) {
            nbCasesInfla = (int) (0.90 * matrice.length * matrice[0].length);
            System.out.println("Vous avez choisi un terrain Touffu" + "\n");
        }
        if (x == 3) {
            nbCasesInfla = (int) (matrice.length * matrice[0].length);
            System.out.println("Vous avez choisi un terrain Continu" + "\n");
        }
        if (x != 0 && x != 1 && x != 2 && x != 3) {
            System.out.println("Réessayez");
            nbCasesInfla(); //si la personne se trompe
        }

    }

    public void initMatrice() {

        int y = 0;
        for (int i = 0; i < matrice.length; i++) { //sur les lignes
            for (int j = 0; j < matrice[0].length; j++) { //sur les colonnes
                if (y < nbCasesInfla) {
                    matrice[i][j] = new inflammable("type", 0, 0, 0); //on rempli de cases inflammables
                    matrice[i][j].type();
                    y++;
                } else {
                    matrice[i][j] = new noninflammable("type", 0, 0, 0); //puis le reste de cases non inflammables
                    matrice[i][j].type();
                }
            }
        }
        Case temp;
        for (int permut = 0; permut < 1000; permut++) { //on effectue 1000 permutations pour mélanger
            int i1 = (int) (Math.random() * (matrice.length));
            int j1 = (int) (Math.random() * (matrice[0].length));
            int i2 = (int) (Math.random() * (matrice.length));
            int j2 = (int) (Math.random() * (matrice[0].length));
            temp = matrice[i1][j1];
            matrice[i1][j1] = matrice[i2][j2];
            matrice[i2][j2] = temp;
        }
        for (int i = 0; i < matrice.length; i++) { //on attribue les positions finales
            for (int j = 0; j < matrice[0].length; j++) {
                matrice[i][j].ligne = i;
                matrice[i][j].colonne = j;
            }
        }
    }

    public void feu(int probaHumidite) { //2 cases doivent prendre feu...
        int i = 0, j = 0;
        ArrayList<Integer> position = new ArrayList<>(); //liste avec la position de la cellule FEU
        int min = 0, max1 = matrice.length, max2 = matrice[0].length;
        do {
            i = (int) (Math.random() * (max1 - min) + min); //entre 0 et le nombre de lignes
            j = (int) (Math.random() * (max2 - min) + min); //entre 0 et nbr de colonnes

            matrice[i][j].demarrerFeu(probaHumidite); //On lance le feu sur la case aléatoire

        } while (matrice[i][j].getEtat().compareTo("infla") == 1); //la case est bien inflammable
    }

    public int ligneOrigine() { //Afin d'obtenir la ligne du repere d'origine (case en feu)
        int ligne = 0;
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                if (matrice[i][j].getEtat().compareTo("feu!") == 1) {
                    ligne = matrice[i][j].getLigne();
                }
            }
        }
        return ligne;
    }
    
    public int colonneOrigine() { //Afin d'obtenir la colonne du repere d'origine (case en feu)
        int colonne = 0;
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                if (matrice[i][j].getEtat().compareTo("feu!") == 1) {
                    colonne = matrice[i][j].getColonne();
                }
            }
        }
        return colonne;
    }

    public void gererEtatetBrandons(double force, int probaHumidite) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                matrice[i][j].gererEtatetBrandons(force, probaHumidite);
            }
        }
    }

    public void afficher() {

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                System.out.print("|" + matrice[i][j] + "|\t");
            }
            System.out.println();

        }
    }

//    public void ventNord(int force) {
//    }
//
//    public void ventSud(int force) {
//    }
//
//    public void ventEst(int force) {
//    }
//
//    public void ventOuest(int force) {
//    }
    public void ProbaReceptionBrandons(int force, int direction, int ligne, int colonne) {
        if (direction == 0) { //NORD
            if (force == 0) { //FORCE : VENT NUL
                matrice[ligne - 2][colonne - 1].probaReceptionBrandon = 1;
                matrice[ligne - 2][colonne].probaReceptionBrandon = 1;
                matrice[ligne - 2][colonne + 1].probaReceptionBrandon = 1;
                matrice[ligne - 1][colonne - 2].probaReceptionBrandon = 1;
                matrice[ligne - 1][colonne - 1].probaReceptionBrandon = 20;
                matrice[ligne - 1][colonne].probaReceptionBrandon = 30;
                matrice[ligne - 1][colonne + 1].probaReceptionBrandon = 20;
                matrice[ligne - 1][colonne + 2].probaReceptionBrandon = 1;
                matrice[ligne][colonne - 2].probaReceptionBrandon = 1;
                matrice[ligne][colonne - 1].probaReceptionBrandon = 30;
                matrice[ligne][colonne + 1].probaReceptionBrandon = 30;
                matrice[ligne][colonne + 2].probaReceptionBrandon = 1;
                matrice[ligne + 1][colonne - 2].probaReceptionBrandon = 1;
                matrice[ligne + 1][colonne - 1].probaReceptionBrandon = 20;
                matrice[ligne + 1][colonne].probaReceptionBrandon = 30;
                matrice[ligne + 1][colonne + 1].probaReceptionBrandon = 20;
                matrice[ligne + 1][colonne + 2].probaReceptionBrandon = 1;
                matrice[ligne + 2][colonne - 1].probaReceptionBrandon = 1;
                matrice[ligne + 2][colonne].probaReceptionBrandon = 1;
                matrice[ligne + 2][colonne + 1].probaReceptionBrandon = 1;
            }
        }
        if (direction == 1) {

        }
        if (direction == 2) {

        }
        if (direction == 3) {

        }
    }

    public void ProbaSenflammer() {

    }

    @Override
    public String toString() {
        return "Terrain {" + "humidite=" + humidite
                + ", nomFichier=" + nomFichier + ", matrice=" + matrice + ","
                + " nbCasesInfla=" + nbCasesInfla + '}';
    }

}
