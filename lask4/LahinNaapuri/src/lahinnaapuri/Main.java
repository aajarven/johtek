/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lahinnaapuri;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Anni Järvenpää
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Image> images = readImages();
        
        LahinNaapuri ln = new LahinNaapuri(images.subList(0, 5000));
        
        int[] tutkitutTaulukko = new int[10];
        int[] vaarinTaulukko = new int[10];
        for (int i=5000; i<images.size(); i++){
            int luokitus = ln.luokittele(images.get(i));
            tutkitutTaulukko[images.get(i).characterClass]++;
            if (luokitus != images.get(i).characterClass){
                vaarinTaulukko[images.get(i).characterClass]++;
            }
        }
        
        System.out.println("Väärin luokitelltujen lukujen osuus:");
        for (int i=0; i<tutkitutTaulukko.length; i++){
            System.out.println(i+": "+ 100.0*vaarinTaulukko[i]/tutkitutTaulukko[i] + " %");
        }
    }
    
    
        // lukee x- ja y-tiedostot
    static List<Image> readImages() {
        String xfilename = "mnist-x.data";
        String yfilename = "mnist-y.data";
        List<Image> images = new ArrayList<Image>();
        try {
//            File xfile = new File(Perceptron.class.getClassLoader().getResource(xfilename).getFile());
//            File yfile = new File(Perceptron.class.getClassLoader().getResource(yfilename).getFile());
            Scanner xscanner = new Scanner(new File(xfilename));
            Scanner yscanner = new Scanner(new File(yfilename));
//            Scanner xscanner = new Scanner(xfile);
//            Scanner yscanner = new Scanner(yfile);
            while (xscanner.hasNextLine()) {
                Image i = new Image();
                String line = xscanner.nextLine();
                int characterClass = yscanner.nextInt();
                String splitarr[] = line.split(",");
                i.vec = new double[28 * 28];
                int j = 0;
                for (String s : splitarr) {
                    if (s.equals("1")) {
                        i.vec[j++] = 1.0;
                    } else {
                        i.vec[j++] = -1.0;
                    }
                }
                i.characterClass = characterClass;
                images.add(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return images;
    }
}
