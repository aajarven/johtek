package fi.helsinki.cs.reittiopas;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class Reittiopas {

    /**
     * Toteuta leveyssuuntainen haku. Palauta reitti taaksepäin linkitettynä
     * listana Tila-olioita, joista ensimmäinen osoittaa maalipysäkkiin ja
     * jokainen tuntee pysäkin ja tilan, josta kyseiseen tilaan päästiin
     * (viimeisen solmun Pysäkki on lähtöpysäkki ja edellinen tila on null).
     *
     * Voit selvittää pysäkin naapuripysäkit, eli pysäkit joihin pysäkiltä on
     * suora yhteys, kutsumalla pysäkin getNaapurit() -metodia.
     *
     * @param lahto Lahtopysakin koodi
     * @param maali Maalipysakin koodi
     * @return Tila-olioista koostuva linkitetty lista maalista lähtötilaan
     */
    public Tila haku(Pysakki lahto, Pysakki maali) {
        ArrayDeque<Pysakki> solmulista = new ArrayDeque<Pysakki>();
        ArrayList<Pysakki> kasitellyt = new ArrayList<Pysakki>();
        HashMap<Pysakki, Tila> reitit = new HashMap<Pysakki, Tila>();
        reitit.put(lahto, new Tila(lahto, null));
        solmulista.add(lahto);
        
        while(!solmulista.isEmpty()){
            Pysakki tutkittava = solmulista.pop();
            if (!kasitellyt.contains(tutkittava)){
                kasitellyt.add(tutkittava);
                Tila nykytila = reitit.get(tutkittava);
                if (tutkittava.equals(maali)){
                    return nykytila;
                }
                for (Pysakki pysakki: tutkittava.getNaapurit()){
                    solmulista.add(pysakki);
                    reitit.put(pysakki, new Tila(pysakki, nykytila));
                }
            }
        }
        return null;
    }
}
