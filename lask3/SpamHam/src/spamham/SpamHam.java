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
public class SpamHam {

    private static final double defaultTodennakoisyys = 1e-5;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WordReader wr = new WordReader();
        HashMap<String, Integer> spamsanat = wr.lueSanalista("spamcount.txt");
        HashMap<String, Integer> hamsanat = wr.lueSanalista("hamcount.txt");
        
        System.out.println("Hamesim arvo: " + spamicityDouble(wr.lueTiedosto("hamesim.txt"), spamsanat, hamsanat));
        System.out.println("Spamesim arvo: " + spamicityDouble(wr.lueTiedosto("spamesim.txt"), spamsanat, hamsanat));
        System.out.println("Hamesim on spämmiä: " +spamicityBool(wr.lueTiedosto("hamesim.txt"), spamsanat, hamsanat));
        System.out.println("Spamesim on spämmiä: " +spamicityBool(wr.lueTiedosto("spamesim.txt"), spamsanat, hamsanat));
    }
    
    private static double spamicityDouble(String viesti, HashMap<String, Integer> spamsanat, HashMap<String, Integer> hamsanat){
        String[] sanat = viesti.split(" "); // oletetaan ettei välimerkkejä tms sanoihin kuulumatonta
        HashMap<String, Double> hamtodennakoisyydet = Tilasto.Psana(hamsanat);
        HashMap<String, Double> spamtodennakoisyydet = Tilasto.Psana(spamsanat);
        
        double logOdds = 0;
        for (String s: sanat){
            double Pspam;
            double Pham;
            
            if (spamtodennakoisyydet.containsKey(s)){
                Pspam = spamtodennakoisyydet.get(s);
            } else {
                Pspam = defaultTodennakoisyys;
            }
            
            if (hamtodennakoisyydet.containsKey(s)){
                Pham = hamtodennakoisyydet.get(s);
            } else {
                Pham = defaultTodennakoisyys;
            }
            
            logOdds += Math.log10(Pspam/Pham);
        }
        
        return Math.pow(10, logOdds);
    }
    
    private static boolean spamicityBool(String viesti, HashMap<String, Integer> spamsanat, HashMap<String, Integer> hamsanat){
        return spamicityDouble(viesti, spamsanat, hamsanat)>1;
    }
    
}
