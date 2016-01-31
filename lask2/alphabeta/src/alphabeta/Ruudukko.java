/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphabeta;

import static alphabeta.Merkki.*;
import java.util.ArrayList;

/**
 *
 * @author anni
 */
public class Ruudukko {

    Merkki[][] ruudukko;

    public Ruudukko() {
        ruudukko = new Merkki[][]{
            {TYHJA, TYHJA, TYHJA},
            {TYHJA, TYHJA, TYHJA},
            {TYHJA, TYHJA, TYHJA}
        };
    }

    public Ruudukko(Merkki[][] ruudukko) {
        this.ruudukko = ruudukko;
    }

    public void pelaa(int x, int y, Merkki m){
        if (ruudukko[x][y] == TYHJA){
            ruudukko[x][y] = m;
        }
    }
    
    public ArrayList<Ruudukko> lapset(Merkki m){
        ArrayList<Ruudukko> lapset = new ArrayList<>();
        Merkki[][] lisattava;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (ruudukko[i][j] == TYHJA){
                    lisattava = new Merkki[][]{ruudukko[0].clone(), ruudukko[1].clone(), ruudukko[2].clone()};
                    lisattava[i][j] = m;
                    lapset.add(new Ruudukko(lisattava));
                }
            }
        }
        return lapset;
    }
    
    public boolean lopputila(){
        // jompikumpi voittanut
        if (arvo() != 0){
            return true;
        }
        
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (ruudukko[i][j] == TYHJA){
                    return false; // tyhjä jäljellä
                }
            }
        }
        return true;
    }
    
    public int arvo(){
        
        // rivit
        for (int i=0; i<3; i++){
            Merkki combotettava = ruudukko[i][0];
            if (combotettava == TYHJA) {
                continue;
            }
            int combo = 0;
            for (int j=0; j<3; j++){
                if (ruudukko[i][j]==combotettava){
                    combo++;
                } else {
                    break;
                }
            }
            if (combo == 3){
                if (combotettava == X) return 1;
                else return -1;
            }
        }
        
        // sarakkeet
        for (int i=0; i<3; i++){
            Merkki combotettava = ruudukko[0][i];
            if (combotettava == TYHJA) {
                continue;
            }
            int combo = 0;
            for (int j=0; j<3; j++){
                if (ruudukko[j][i]==combotettava){
                    combo++;
                } else {
                    break;
                }
            }
            if (combo == 3){
                if (combotettava == X) return 1;
                else return -1;
            }
        }
        
        // diagonaali 1
        if (ruudukko[0][0] != TYHJA && ruudukko[0][0] == ruudukko[1][1] && ruudukko [1][1] == ruudukko[2][2]){
            if (ruudukko[0][0] == X) return 1;
            else return -1;
        }
        
        // diagonaali 2
        if (ruudukko[0][2] != TYHJA && ruudukko[0][2] == ruudukko[1][1] && ruudukko [1][1] == ruudukko[2][0]){
            if (ruudukko[0][2] == X) return 1;
            else return -1;
        }
        
        return 0;
    }

    @Override
    public String toString() {
        String palautus = "";
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                palautus += ruudukko[i][j];
                palautus += " ";
            }
            palautus += "\n";
        }
        return palautus;
    }
    
    
    
}


