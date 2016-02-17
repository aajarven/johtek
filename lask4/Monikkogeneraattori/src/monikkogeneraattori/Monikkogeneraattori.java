/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monikkogeneraattori;

import java.util.ArrayList;

/**
 *
 * @author anni
 */
public class Monikkogeneraattori {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Monikko> monikot = new ArrayList<>();
        for (int i=0; i<100000; i++){
            monikot.add(new Monikko());
        }
        
        // i)
        int a = 0;
        int rbnk = 0;
        int[] verrokki = new int[]{-1, 1, -1, 1, 0, -1};
        for (Monikko m: monikot){
            if (m.vastaaTilaa(verrokki)){
                rbnk++;
                if(m.getTila()[0]){
                    a++;
                }
            }
        }
        System.out.println("P(A|R,B,nK) = "+((double) a/rbnk));
    }
    
}
