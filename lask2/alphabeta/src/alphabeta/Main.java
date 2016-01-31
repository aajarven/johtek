/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphabeta;

/**
 *
 * @author anni
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Ruudukko alku = new Ruudukko(new Merkki[][]{{Merkki.O, Merkki.X, Merkki.O},{Merkki.X, Merkki.TYHJA, Merkki.X},{Merkki.TYHJA, Merkki.O, Merkki.TYHJA}});
        //Ruudukko alku = new Ruudukko();
        Ruudukko alku = new Ruudukko(new Merkki[][]{{Merkki.O, Merkki.X, Merkki.O},{Merkki.X, Merkki.O, Merkki.X},{Merkki.TYHJA, Merkki.O, Merkki.TYHJA}});
        System.out.println(alku);
        //System.out.println(alku.arvo());
        System.out.println(AlphaBeta.alphaBetaArvo(alku));
    }
    
    
}
