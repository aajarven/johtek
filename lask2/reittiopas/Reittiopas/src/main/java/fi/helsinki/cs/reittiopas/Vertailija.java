package fi.helsinki.cs.reittiopas;

import fi.helsinki.cs.reittiopas.logiikka.Pysakki;
import fi.helsinki.cs.reittiopas.logiikka.Tila;
import java.util.Comparator;

/**
 *
 * @author kumikumi
 */
public class Vertailija implements Comparator<Tila> {

    private final Pysakki maali;

    public Vertailija(Pysakki maaliPysakki) {
        this.maali = maaliPysakki;
    }

    /**
     * Toteuta metodi heuristiikka siten, että se palauttaa parametrina annetun
     * pysäkin ja tämän luokan sisällä määritellyn maalipysäkin koordinaattien
     * välisen euklidisen etäisyyden jaettuna luvulla 260. Oletamme siis, että
     * ratikka liikkuu keskimäärin 260 koordinaattipistettä minuutissa, ja
     * arvioimme tässä metodissa maalipisteeseen jäljellä olevan ajan.
     *
     * @param pysakki
     * @return Arvioitu jäljelläoleva aika
     */
    public double heuristiikka(Pysakki pysakki) {
        return Math.sqrt(Math.pow(pysakki.getX()-maali.getX(), 2) + Math.pow(pysakki.getY()-maali.getY(), 2))/260;
    }

    /**
     * Toteuta metodi compare siten, että se palauttaa jonkin positiivisen luvun
     * silloin kun Tilan t1 aika+heuristiikka on suurempi kuin Tilan t2
     * aika+heuristiikka, ja vastaavasti jonkin negatiivisen luvun, kun Tilan t2
     * aika+heuristiikka on suurempi kuin Tilalla t1. Palauta 0 jos molemmilla
     * solmuista aika+heuristiikka on yhtä suuri.
     *
     * Tätä metodia käytetään tilojen järjestämiseen A*-haussa käytettävän
     * prioriteettijonon sisällä, jolloin jonosta saadaan ulos aina se tila,
     * joka todennäköisimmin on osa lyhintä reittiä maaliin.
     *
     * @param t1
     * @param t2
     * @return vertailun tulos
     */
    @Override
    public int compare(Tila t1, Tila t2) {
        double ero = t1.getNykyinenAika() + heuristiikka(t1.getPysakki()) - t2.getNykyinenAika() - heuristiikka(t2.getPysakki());
        if (ero < 0) return -1;
        else if (ero == 0) return 0;
        else return 1;
    }

}
