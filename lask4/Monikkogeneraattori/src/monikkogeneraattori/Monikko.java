/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monikkogeneraattori;

/**
 *
 * @author anni
 */
public abstract class Monikko {
    public boolean[] tila;

    /**
     * 
     * @param t2 0 = false kys. indeksissä, 1 = true, muut arvot = kumpi tahansa
     * @return true jos jokaisessa on false missä 0 ja jokaisessa true missä 1
     */
    public boolean vastaaTilaa(int[] t2){
        if (t2.length != tila.length) {
            return false;
        }
        for (int i=0; i<tila.length; i++){
            if (t2[i] == 0 && tila[i] != false){
                return false;
            } else if (t2[i] == 1 && tila[i] != true){
                return false;
            }
        }
        return true;
    }
    public boolean[] getTila(){
        return tila;
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder("[ ");
        for(boolean b : tila){
            s.append(b);
            s.append(" ");
        }
        s.append("]");
        return s.toString();
    }
}
