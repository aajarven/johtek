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
//        ArrayList<Monikko> autonMonikot = new ArrayList<>();
//        for (int i=0; i<1000000; i++){
//            autonMonikot.add(new AutonMonikko());
//        }
//        
//        // 1bi)
//        int a = 0;
//        int rbnk = 0;
//        int[] verrokki = new int[]{-1, 1, -1, 1, 0, -1};
//        for (Monikko m: autonMonikot){
//            if (m.vastaaTilaa(verrokki)){
//                rbnk++;
//                if(m.getTila()[0]){
//                    a++;
//                }
//            }
//        }
//        System.out.println("P(A|R,B,nK) = "+((double) a/rbnk));
//        
//        // 1bii)
//        int k = 0;
//        int rsb = 0;
//        verrokki = new int[]{-1, 1, 1, 1, -1, -1};
//        for (Monikko m: autonMonikot){
//            if (m.vastaaTilaa(verrokki)){
//                rsb++;
//                if(m.getTila()[4]){
//                    k++;
//                }
//            }
//        }
//        System.out.println("P(K|R,S,B) = "+((double) k/rsb));
//        
//        // 1bii)
//        k = 0;
//        int nrsb = 0;
//        verrokki = new int[]{-1, 0, 1, 1, -1, -1};
//        for (Monikko m: autonMonikot){
//            if (m.vastaaTilaa(verrokki)){
//                nrsb++;
//                if(m.getTila()[4]){
//                    k++;
//                }
//            }
//        }
//        System.out.println("P(K|nR,S,B) = "+((double) k/nrsb));
        
        
        // 1c
        ArrayList<Monikko> maanjaristysMonikot = new ArrayList<>();
        for (int i=0; i<10000000; i++){
            maanjaristysMonikot.add(new MaanjaristysMonikko());
        }
        
        int h = 0;
        int vh = 0;
        int[] verrokki = new int[]{-1, -1, 1};
        for (Monikko m: maanjaristysMonikot){
            if (m.vastaaTilaa(verrokki)){
                vh++;
                if (m.getTila()[1]){
                    h++;
                }
            }
        }
        System.out.println("P(V|H) = "+((double)h/vh));
        
        int v = 0;
        int hm = 0;
        verrokki = new int[]{1, 0, 1};
        for (Monikko m: maanjaristysMonikot){
            if (m.vastaaTilaa(verrokki)){
                hm++;
//                System.out.println(m);
                if (m.getTila()[1]){
                    v++;
//                    System.out.println("oli v");
                }
            }
        }
        System.out.println("P(V|H,M) = "+((double) v/hm));
        
    }
    
}
