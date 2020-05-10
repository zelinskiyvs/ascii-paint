package org.paint.ascii;

import org.paint.ascii.exceptions.DrawFigureException;
import org.paint.ascii.exceptions.FigureNotFitsIntoCanvasException;
import org.paint.ascii.exceptions.NotValidCoordinatesException;
import org.paint.ascii.model.Line;
import org.paint.ascii.model.Rectangle;

public enum FigureValidator {
    INSTaNCE;

    public void validate(Canvas canvas, Line line) throws DrawFigureException {
        if (line.getxStart() <= 0 || line.getyStart() <= 0 || line.getxEnd() <= 0 || line.getyEnd() <= 0) {
            throw new NotValidCoordinatesException("Line coordinates are not valid: " + line);
        }
        if (line.getyStart() > canvas.getHeight() || line.getyEnd() > canvas.getHeight() ||
                line.getxStart() > canvas.getWight() || line.getxEnd() > canvas.getWight()) {
            throw new FigureNotFitsIntoCanvasException("Line " + line + " doesn't fits into canvas: " + canvas);
        }
    }

    public void validate(Canvas canvas, Rectangle rectangle) throws NotValidCoordinatesException, FigureNotFitsIntoCanvasException {
        if (rectangle.getX1() <= 0 || rectangle.getY1() <= 0 || rectangle.getX2() <= 0 || rectangle.getY2() <= 0) {
            throw new NotValidCoordinatesException("Rectangle coordinates are not valid: " + rectangle);
        }

        if (rectangle.getY1() > canvas.getHeight() || rectangle.getY2() > canvas.getHeight() ||
                rectangle.getX1() > canvas.getWight() || rectangle.getX2() > canvas.getWight()) {
            throw new FigureNotFitsIntoCanvasException("Rectangle " + rectangle
                    + " doesn't fits into canvas: " + canvas);
        }
    }

}
