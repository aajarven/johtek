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
public class AutonMonikko extends Monikko{


    public AutonMonikko() {
        generoi();
    }

    private void generoi() {
        tila = new boolean[6];

        Random r = new Random();
        if (r.nextDouble() < 0.9) {
            tila[0] = true;
        } // default false

        if (tila[0] && r.nextDouble() < 0.9) {
            tila[1] = true;
        }

        if (tila[0] && r.nextDouble() < 0.95) {
            tila[2] = true;
        }

        if (r.nextDouble() < 0.95) {
            tila[3] = true;
        }

        if (tila[3] && r.nextDouble() < 0.99) {
            tila[4] = true;
        }

        if (tila[4] && r.nextDouble() < 0.99) {
            tila[5] = true;
        }
    }

}
