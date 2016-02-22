package johtek.nlp;

import java.util.ArrayDeque;
import opennlp.tools.parser.Parse;

public class Extractor {

    /**
     * Löytää lauseen subjektin jäsennyspuusta.
     *
     * @param root jäsennyspuun juuri (S)
     * @return subjekti String-oliona
     */
    public static String extractSubject(Parse root) {
        // Toteuta subjektin löytäminen jäsennyspuusta seuraavasti:
        // Valitse juuren (root) lapsista solmu, jonka POS-tag on NP
        // Suorita kyseisestä solmusta BFS-haku sen alipuussa
        // Subjekti on ensimmäisessä löydetyssä solmussa, jonka POS-tag on substantiivi
        // Substantiiveja ovat solmut, joiden POS-tag on NN, NNP, NNS tai NNPS
        // Jos substantiivia ei löydy, palauta null

        // tarvittavat Parse-olion metodit:
        // solmu.getChildren() palauttaa Parse[] taulukon lapsista
        // solmu.getType() palauttaa String-oliona solmun POS-tagin, esim. NP tai VP
        // solmu.getCoveredText() palauttaa kyseiseen solmuun liittyvän osan alkuperäisestä tekstistä
        if (root != null) {
            for (Parse lapsi : root.getChildren()) {
                if (lapsi.getType().equals("NP")) {
                    ArrayDeque<Parse> tutkittavat = new ArrayDeque<>();
                    tutkittavat.add(lapsi);
                    while (!tutkittavat.isEmpty()) {
                        Parse tutkittava = tutkittavat.pop();
                        if (tutkittava.getType().equals("NN") || tutkittava.getType().equals("NNP") || tutkittava.getType().equals("NNPS") || tutkittava.getType().equals("NNS")) {
                            return tutkittava.getCoveredText();
                        }
                        for (Parse tutkittavanLapsi : tutkittava.getChildren()) {
                            tutkittavat.add(tutkittavanLapsi);
                        }
                    }
                    return null;

                }
            }
        }
        return null;
    }

}
