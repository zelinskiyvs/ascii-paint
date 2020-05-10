package org.paint.ascii;

import org.paint.ascii.model.Point;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class TextCanvas extends Canvas {

    private final char filledSymbol;
    private final char notFilledSymbol;
    private final char[][] pallet;

    public TextCanvas(int wight, int height, char filledSymbol, char notFilledSymbol) {
        super(wight, height);
        this.filledSymbol = filledSymbol;
        this.notFilledSymbol = notFilledSymbol;
        this.pallet = new char[height][wight];
    }

    public void addPoints(Collection<Point> points) {
        points.forEach(p -> pallet[p.getY()-1][p.getX() -1] = filledSymbol);
    }

    public List<String> getPalletLines() {
        List<String> lines = new ArrayList<>(pallet.length);
        for (char[] line : pallet) {
            lines.add(new String(line).replace('\0', notFilledSymbol));
        }
        return lines;
    }
}
