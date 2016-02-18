/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lahinnaapuri;

import java.util.List;

/**
 *
 * @author Anni Järvenpää
 */
public class LahinNaapuri {
    private final List<Image> images;
    
    public LahinNaapuri(List<Image> images){
        this.images = images;
    }
    
    public int luokittele(Image kuva){
        double pieninEro = Double.POSITIVE_INFINITY;
        int parasLuokitus = -1;
        for (Image i: images){
            double ero = ero(i, kuva);
            if (pieninEro > ero){
               pieninEro = ero;
               parasLuokitus = i.characterClass;
            }
        }
        return parasLuokitus;
    }

    private double ero(Image i1, Image i2) {
        double ero=0;
        for (int i=0; i<i1.vec.length; i++){
            ero += Math.abs(i1.vec[i]-i2.vec[i]);
        }
        return ero;
    }
}
