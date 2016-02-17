/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monikkogeneraattori;

import java.util.Random;

/**
 *
 * @author anni
 */
public class Monikko {

    private boolean[] tila;

    public Monikko() {
        generoi();
    }

    private void generoi() {
        tila = new boolean[6];

        Random r = new Random();
        if (r.nextDouble() < 0.9) {
            tila[0] = true;
        } // default false

        if (tila[0] && r.nextDouble() < 0.9) {
            tila[1] = true;
        }

        if (tila[0] && r.nextDouble() < 0.95) {
            tila[2] = true;
        }

        if (r.nextDouble() < 0.95) {
            tila[3] = true;
        }

        if (tila[3] && r.nextDouble() < 0.99) {
            tila[4] = true;
        }

        if (tila[4] && r.nextDouble() < 0.99) {
            tila[5] = true;
        }
    }

    public boolean[] getTila() {
        return tila;
    }
    
    

    /**
     * 
     * @param t2 0 = false kys. indeksissä, 1 = true, muut arvot = kumpi tahansa
     * @return true jos jokaisessa on false missä 0 ja jokaisessa true missä 1
     */
    public boolean vastaaTilaa(int[] t2) {
        if (t2.length != tila.length) {
            return false;
        }
        for (int i=0; i<tila.length; i++){
            if (t2[i] == 0 && tila[i] != false){
                return false;
            } else if (t2[i] == 1 && tila[1] != true){
                return false;
            }
        }
        return true;
    }

}
