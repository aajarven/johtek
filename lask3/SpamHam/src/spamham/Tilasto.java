/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spamham;

import java.util.HashMap;

/**
 *
 * @author anni
 */
public class Tilasto {
    
    public static int sanamaara(HashMap<String, Integer> sanat){
        int sanamaara = 0;
        for (Integer i: sanat.values()){
            sanamaara += i;
        }
        return sanamaara;
    }
    
    public static HashMap<String, Double> Psana(HashMap<String, Integer> sanat){
        HashMap<String, Double> palautus = new HashMap<String, Double>();
        int sanamaara = sanamaara(sanat);
        for(String s: sanat.keySet()){
            palautus.put(s, ((double) sanat.get(s))/sanamaara);
        }
        return palautus;
    }
}
