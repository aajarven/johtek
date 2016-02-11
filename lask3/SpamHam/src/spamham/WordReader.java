/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spamham;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author anni
 */
public class WordReader {

    public WordReader() {
    }
    
    public HashMap<String, Integer> lueSanalista(String tiedostonimi){
        File f;
        Scanner scanner = null;
        
        try {
            f = new File(tiedostonimi);
            scanner = new Scanner (f);
        } catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        
        HashMap<String, Integer> counts = new HashMap<String, Integer>();
        
        while(scanner.hasNextLine()){
            String rivi = scanner.nextLine();
            rivi = rivi.trim();
            String[] palat = rivi.split(" ");

            if (palat.length == 2){
                counts.put(palat[1], Integer.parseInt(palat[0]));
            }
        }
        
        return counts;
    }
    
    public String lueTiedosto(String tiedostonimi){
        File f;
        Scanner scanner = null;
        
        try {
            f = new File(tiedostonimi);
            scanner = new Scanner(f);
        } catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        
        StringBuilder sisalto = new StringBuilder();
        while (scanner.hasNextLine()){
            sisalto.append(scanner.nextLine());
        }
        
        return sisalto.toString();
    }
}
