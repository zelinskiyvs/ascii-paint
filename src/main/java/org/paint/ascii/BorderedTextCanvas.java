package org.paint.ascii;

import java.util.ArrayList;
import java.util.List;

public class BorderedTextCanvas extends TextCanvas {
    public static final String V_BORDER_SYMBOL = "|";
    public static final char H_BORDER_SYMBOL = '-';

    public BorderedTextCanvas(int wight, int height, char filledSymbol, char notFilledSymbol) {
        super(wight, height, filledSymbol, notFilledSymbol);
    }

    @Override
    public List<String> getPalletLines() {
        List<String> palletLines = super.getPalletLines();
        List<String> lines = new ArrayList<>();
        String horizontalLine = new String(new char[getWight() + 2]).replace('\0', H_BORDER_SYMBOL);
        lines.add(horizontalLine);
        palletLines
                .stream()
                .map(line -> V_BORDER_SYMBOL + line + V_BORDER_SYMBOL)
                .forEach(lines::add);
        lines.add(horizontalLine);

        return lines;
    }
}
