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
public class Nord extends Vent {

    public Nord(int force) {
        super(force);
    }
    

    @Override
    public void ventNord(int force) {
        int i, j;
        int matrice[][] = new int[4][3]; //tableau 2 dimensions taille 10x10
        switch (force) {
            case 0: //pour une force de vent nulle

                for (i = 0; i <= 4; i++) {
                    for (j = 0; j <= 3; j++) { //parcourt le tableau et associe 
                        matrice[i - 2][j - 1] = 1;     //les cases aux probabilités 
                        matrice[i - 2][j] = 1;                //données
                        matrice[i - 2][j + 1] = 1;
                        matrice[i - 1][j - 2] = 1;
                        matrice[i - 1][j - 1] = 20;
                        matrice[i - 1][j] = 30;
                        matrice[i - 1][j + 1] = 20;
                        matrice[i - 1][j + 2] = 1;
                        matrice[i][j - 2] = 1;
                        matrice[i][j - 1] = 30;
                        matrice[i][j + 1] = 30;
                        matrice[i][j + 2] = 1;
                        matrice[i + 1][j - 2] = 1;
                        matrice[i + 1][j - 1] = 20;
                        matrice[i + 1][j] = 30;
                        matrice[i + 1][j + 1] = 20;
                        matrice[i + 1][j + 2] = 1;
                        matrice[i + 2][j - 1] = 1;
                        matrice[i + 2][j] = 1;
                        matrice[i + 2][j + 1] = 1;
                    }
                }
            case 1: //vent modéré
                for (i = 0; i <= 4; i++) {
                    for (j = 0; j <= 3; j++) {
                        matrice[i - 1][j - 1] = 10;
                        matrice[i - 1][j] = 30;
                        matrice[i - 1][j + 1] = 30;
                        matrice[i - 1][j + 2] = 2;
                        matrice[i][j - 1] = 20;
                        matrice[i][j + 1] = 40;
                        matrice[i][j + 2] = 5;
                        matrice[i + 1][j - 1] = 10;
                        matrice[i + 1][j] = 30;
                        matrice[i + 1][j + 1] = 30;
                        matrice[i + 1][j + 2] = 2;

                    }
                }
            case 2: //vent fort
                for (i = 0; i <= 4; i++) {
                    for (j = 0; j <= 3; j++) {
                        matrice[i - 1][j - 1] = 5;
                        matrice[i - 1][j] = 25;
                        matrice[i - 1][j + 1] = 40;
                        matrice[i - 1][j + 2] = 5;
                        matrice[i][j - 1] = 10;
                        matrice[i][j + 1] = 50;
                        matrice[i][j + 2] = 10;
                        matrice[i][j + 3] = 1;
                        matrice[i + 1][j - 1] = 5;
                        matrice[i + 1][j] = 25;
                        matrice[i + 1][j + 1] = 40;
                        matrice[i + 1][j + 2] = 5;
                    }
                }
            case 3: //vent violent
                for (i = 0; i <= 4; i++) {
                    for (j = 0; j <= 3; j++) {
                        matrice[i - 1][j] = 10;
                        matrice[i - 1][j + 1] = 50;
                        matrice[i - 1][j + 2] = 20;
                        matrice[i - 1][j + 3] = 10;
                        matrice[i][j + 1] = 70;
                        matrice[i][j + 2] = 30;
                        matrice[i][j + 3] = 5;
                        matrice[i + 1][j] = 10;
                        matrice[i + 1][j + 1] = 50;
                        matrice[i + 1][j + 2] = 20;
                        matrice[i + 1][j + 3] = 1;
                    }
                }    
        }
    }
}