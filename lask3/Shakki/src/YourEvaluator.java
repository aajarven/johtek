
public class YourEvaluator extends Evaluator {

    /**
     * kerroin, jolla nappulan liikuttavissa olevien ruutujen määrä kerrotaan ennen hyvyyttä arvioivaan lukuun lisäämistä
     */
    private final double liikkuvuuskerroin = 0.05;
    
    public double eval(Position p) {
        double ret = 0;
        for (int x = 0; x < p.board.length; ++x) {
            for (int y = 0; y < p.board[x].length; ++y) {
                if (p.board[x][y] == Position.Empty) {
                    continue;
                } else if (p.board[x][y] == Position.WKing) {
                    ret += 1e9;
                } else if (p.board[x][y] == Position.WQueen) {
                    ret += 9;
                    ret += goodnessQueen(p, x, y);
                } else if (p.board[x][y] == Position.WRook) {
                    ret += 5.25;
                    ret += goodnessRook(p, x, y);
                } else if (p.board[x][y] == Position.WBishop) {
                    ret += 3.25;
                    ret += goodnessBishop(p, x, y);
                } else if (p.board[x][y] == Position.WKnight) {
                    ret += 3;
                    ret += goodnessBishop(p, x, y);
                } else if (p.board[x][y] == Position.WPawn) {
                    ret += 1;
                } else if (p.board[x][y] == Position.BKing) {
                    ret -= 1e9;
                } else if (p.board[x][y] == Position.BQueen) {
                    ret -= 9;
                } else if (p.board[x][y] == Position.BRook) {
                    ret -= 5.25;
                } else if (p.board[x][y] == Position.BBishop) {
                    ret -= 3.25;
                } else if (p.board[x][y] == Position.BKnight) {
                    ret -= 3;
                } else if (p.board[x][y] == Position.BPawn) {
                    ret -= 1;
                }
            }
        }
        return ret;
    }

    private double goodnessBishop(Position p, int x, int y){
        return liikkuvuuskerroin*mobilityBishop(p, x, y);
    }
    
    private double goodnessRook(Position p, int x, int y){
        return liikkuvuuskerroin*mobilityRook(p, x, y);
    }
    
    private double goodnessQueen(Position p, int x, int y){
        return liikkuvuuskerroin*mobilityQueen(p, x, y);
    }
    
    private double goonessRook(Position p, int x, int y){
        return liikkuvuuskerroin*mobilityBishop(p, x, y);
    }
    
    /**
     * Laskee ruudut, joihin lähetin on mahdollista liikkua yhdellä siirrolla.
     *
     * @param p tutkittava laudan asento
     * @param x lähtöpaikan x-koordinaatti laudalla
     * @param y lähtöpaikan y-koordinaatti laudalla
     * @return yhdellä siirrolla liikuttavissa olevien ruutujen määrä
     */
    private int mobilityBishop(Position p, int x, int y) {
        int ret = 0;
        for (int d = 1; d + x < Position.bCols && d + y < Position.bRows; d++) {
            if (onTyhja(p, x+d, y+d)) {
                ret++;
            } else {
                break;
            }
        }
        for (int d = 1; x - d >= 0 && d + y < Position.bRows; d++) {
            if (onTyhja(p, x-d, y+d)) {
                ret++;
            } else {
                break;
            }
        }
        for (int d = 1; x - d >= 0 && y - d >= 0; d++) {
            if (onTyhja(p, x-d, y-d)) {
                ret++;
            } else {
                break;
            }
        }
        for (int d = 1; x + d < Position.bCols && y - d >= 0; d++) {
            if (onTyhja(p, x+d, y-d)) {
                ret++;
            } else {
                break;
            }
        }
        return ret;
    }

    /**
     * Laskee ruudut, joihin tornin on mahdollista liikkua yhdellä siirrolla.
     *
     * @param p tutkittava laudan asento
     * @param x lähtöpaikan x-koordinaatti laudalla
     * @param y lähtöpaikan y-koordinaatti laudalla
     * @return yhdellä siirrolla liikuttavissa olevien ruutujen määrä
     */
    private int mobilityRook(Position p, int x, int y) {
        int ret = 0;
        for (int d = 0; d + x < Position.bCols; d++) {
            if (onTyhja(p, x+d, y)) {
                ret++;
            } else {
                break;
            }
        }
        for (int d = 0; x - d >= 0; d++) {
            if (onTyhja(p, x-d, y)) {
                ret++;
            } else {
                break;
            }
        }
        for (int d = 0; y - d >= 0; d++) {
            if (onTyhja(p, x, y-d)) {
                ret++;
            } else {
                break;
            }
        }
        for (int d = 0; y + d < Position.bRows; d++) {
            if (onTyhja(p, x, y+d)) {
                ret++;
            } else {
                break;
            }
        }
        return ret;
    }
    
    /**
     * Laskee ruudut, joihin kuningattaren on mahdollista liikkua yhdellä siirrolla.
     *
     * @param p tutkittava laudan asento
     * @param x lähtöpaikan x-koordinaatti laudalla
     * @param y lähtöpaikan y-koordinaatti laudalla
     * @return yhdellä siirrolla liikuttavissa olevien ruutujen määrä
     */
    private int mobilityQueen(Position p, int x, int y){
        return mobilityBishop(p, x, y) + mobilityRook(p, x, y);
    }
    
    /**
     * Laskee ruudut, joihin hevosen on mahdollista liikkua yhdellä siirrolla.
     *
     * @param p tutkittava laudan asento
     * @param x lähtöpaikan x-koordinaatti laudalla
     * @param y lähtöpaikan y-koordinaatti laudalla
     * @return yhdellä siirrolla liikuttavissa olevien ruutujen määrä
     */
    private int mobilityKnight(Position p, int x, int y){
        int ret = 0;
        if (x+2<Position.bCols){
            if (y+1<Position.bRows){
                if (onTyhja(p, x+2, y+1)){
                    ret++;
                }
            }
            if (y-1>=0){
                if (onTyhja(p, x+2, y-1)){
                    ret++;
                }
            }
        }
        if (x-2>=0){
            if (y+1<Position.bRows){
                if (onTyhja(p, x-2, y+1)){
                    ret++;
                }
            }
            if (y-1>=0){
                if (onTyhja(p, x-2, y-1)){
                    ret++;
                }
            }
        }
        if (x+1<Position.bCols){
            if (y+2<Position.bRows){
                if (onTyhja(p, x+1, y+2)){
                    ret++;
                }
            }
            if (y-1>=0){
                if (onTyhja(p, x+1, y-2)){
                    ret++;
                }
            }
        }
        if (x-1>=0){
            if (y+2<Position.bRows){
                if (onTyhja(p, x-1, y+2)){
                    ret++;
                }
            }
            if (y-2>=0){
                if (onTyhja(p, x-1, y-2)){
                    ret++;
                }
            }
        }
        return ret;
    }
    
    private boolean onTyhja(Position p, int x, int y){
        return (p.board[x][y] == Position.Empty);
    }
}
