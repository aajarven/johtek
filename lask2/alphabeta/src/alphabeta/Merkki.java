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
public enum Merkki {
    X, O, TYHJA;
    
    @Override    
    public String toString() {
        switch (this) {
            case X:
                return "X";
            case O:
                return "O";
            default:
                return "-";
        }
    }
}
