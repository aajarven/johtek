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
public class AlphaBeta {
    
    public static int alphaBetaArvo(Ruudukko ruudukko){
        return (maxArvo(ruudukko,-1,1));
    }
    
    public static int maxArvo(Ruudukko ruudukko, int alpha, int beta){
        if (ruudukko.lopputila()){
            return ruudukko.arvo();
        }
        int v = Integer.MIN_VALUE;
        for (Ruudukko lapsi : ruudukko.lapset(Merkki.X)){
            //System.out.println(lapsi);
            int miniArvo = minArvo(lapsi, alpha, beta);
            v = (v > miniArvo)? v : miniArvo;
            if (v >= beta) return v;
            alpha = (v > alpha)? v : alpha;
        }
        return v;
    }
    
    public static int minArvo(Ruudukko ruudukko, int alpha, int beta){
        if (ruudukko.lopputila()){
            return ruudukko.arvo();
        }
        int v = Integer.MAX_VALUE;
        for (Ruudukko lapsi : ruudukko.lapset(Merkki.O)){
            //System.out.println(lapsi);
            int maxiArvo = maxArvo(lapsi, alpha, beta);
            v = (v < maxiArvo)? v : maxiArvo;
            if (v <= alpha) return v;
            alpha = (v < beta)? v : beta;
        }
        return v;
    }
}
