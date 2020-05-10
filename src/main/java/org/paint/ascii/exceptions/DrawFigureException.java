package org.paint.ascii.exceptions;

public class DrawFigureException extends Exception {

    public DrawFigureException(String s) {
        super(s);
    }

    public DrawFigureException(String s, Exception e) {
        super(s, e);
    }
}
