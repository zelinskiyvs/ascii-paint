package org.paint.ascii;

import java.util.function.Consumer;

public class TextPainter {
    public static final String NEW_LINE_SYMBOL = "\n";

    private final Consumer<String> printer;

    public TextPainter(Consumer<String> printer) {
        this.printer = printer;
    }

    public void printCanvas(TextCanvas canvas) {
        canvas.getPalletLines().forEach(line -> printer.accept(line + NEW_LINE_SYMBOL));
    }
}
