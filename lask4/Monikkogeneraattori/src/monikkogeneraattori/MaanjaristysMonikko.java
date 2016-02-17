/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monikkogeneraattori;

import java.util.Random;

/**
 *
 * @author anni
 */
public class MaanjaristysMonikko extends Monikko {


    public MaanjaristysMonikko() {
        generoi();
    }

    private void generoi() {
        tila = new boolean[3];
        Random r = new Random();

        if (r.nextDouble() < 0.009) {
            tila[0] = true;
        }

        if (r.nextDouble() < 0.0032) {
            tila[1] = true;
        }

        if (tila[0] && tila[1]) {
            if (r.nextDouble() < 0.97) {
                tila[2] = true;
            }
        } else if (!tila[0] && !tila[1]) {
            if (r.nextDouble() < 0.0095) {
                tila[2] = true;
            }
        } else if (tila[0]) {
            if (r.nextDouble() < 0.81){
                tila[2] = true;
            }
        } else if (tila[1]){
            if (r.nextDouble() < 0.92){
                tila[2] = true;
            }
        }
    }

}
