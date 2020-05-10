package org.paint.ascii.render;

import org.junit.Test;
import org.paint.ascii.exceptions.NotValidCoordinatesException;

public class FigureParserTest {

    @Test(expected = NotValidCoordinatesException.class)
    public void testNotValidLineNumbers () throws NotValidCoordinatesException {
        String[] line = {"L", "w", "1", "3", "3"};
        FigureParser.parseLine(line);
    }

    @Test(expected = NotValidCoordinatesException.class)
    public void testNotValidRectangleNumbers () throws NotValidCoordinatesException {
        String[] rectangle = {"R", "w", "1", "3", "3"};
        FigureParser.parseLine(rectangle);
    }

    @Test(expected = NotValidCoordinatesException.class)
    public void testNotEnoughLineNumbers () throws NotValidCoordinatesException {
        String[] line = {"L", "1", "3", "3"};
        FigureParser.parseLine(line);
    }

    @Test(expected = NotValidCoordinatesException.class)
    public void testNotEnoughRectangleNumbers () throws NotValidCoordinatesException {
        String[] rectangle = {"R", "1", "3", "3"};
        FigureParser.parseLine(rectangle);
    }


}