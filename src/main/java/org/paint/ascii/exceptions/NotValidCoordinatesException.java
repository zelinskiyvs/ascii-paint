package org.paint.ascii.exceptions;

public class NotValidCoordinatesException extends DrawFigureException {

    public NotValidCoordinatesException(String s) {
        super(s);
    }

    public NotValidCoordinatesException(String s, Exception e) {
        super(s, e);
    }
}
