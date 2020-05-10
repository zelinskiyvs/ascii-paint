package org.paint.ascii.render;

import junit.framework.TestCase;
import org.junit.Test;
import org.paint.ascii.Canvas;
import org.paint.ascii.TextCanvas;
import org.paint.ascii.exceptions.DrawFigureException;
import org.paint.ascii.exceptions.FigureNotFitsIntoCanvasException;
import org.paint.ascii.exceptions.NotValidCoordinatesException;

public class CanvasRendererTest  {

    @Test(expected = FigureNotFitsIntoCanvasException.class)
    public void testToBigLineCanvas() throws DrawFigureException {
        String[] line = {"L", "1", "1", "5", "6"};
        Canvas canvas = new TextCanvas(5,5, 'x', ' ');
        CanvasRenderer.render(canvas, line);
    }

    @Test(expected = FigureNotFitsIntoCanvasException.class)
    public void testToBigRectangleCanvas() throws DrawFigureException {
        String[] line = {"R", "1", "1", "5", "6"};
        Canvas canvas = new TextCanvas(5,5, 'x', ' ');
        CanvasRenderer.render(canvas, line);
    }

    @Test(expected = NotValidCoordinatesException.class)
    public void testInvalidLineCanvas() throws DrawFigureException {
        String[] line = {"L", "1", "1", "-5", "6"};
        Canvas canvas = new TextCanvas(5,5, 'x', ' ');
        CanvasRenderer.render(canvas, line);
    }

    @Test(expected = NotValidCoordinatesException.class)
    public void testInvalidRectangleCanvas() throws DrawFigureException {
        String[] line = {"R", "1", "1", "5", "-6"};
        Canvas canvas = new TextCanvas(5,5, 'x', ' ');
        CanvasRenderer.render(canvas, line);
    }


}