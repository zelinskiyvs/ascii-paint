package org.paint.ascii.render;

import org.paint.ascii.exceptions.NotValidCoordinatesException;
import org.paint.ascii.model.Line;
import org.paint.ascii.model.Rectangle;

import java.util.Arrays;

public class FigureParser {

    public static Line parseLine(String[] cmd) throws NotValidCoordinatesException {
        try {
            int xStart = Integer.parseInt(cmd[1]);
            int yStart = Integer.parseInt(cmd[2]);
            int xEnd = Integer.parseInt(cmd[3]);
            int yEnd = Integer.parseInt(cmd[4]);
            return new Line(xStart, yStart, xEnd, yEnd);
        } catch (Exception e) {
            throw new NotValidCoordinatesException("Failed to create line with coordinates"
                    + Arrays.toString(cmd), e);
        }
    }

    public static Rectangle parseRectangle(String[] cmd) throws NotValidCoordinatesException {
        try {
            int x1 = Integer.parseInt(cmd[1]);
            int y1 = Integer.parseInt(cmd[2]);
            int x2 = Integer.parseInt(cmd[3]);
            int y2 = Integer.parseInt(cmd[4]);
            return new Rectangle(x1, y1, x2, y2);
        } catch (Exception e) {
            throw new NotValidCoordinatesException("Failed to create rectangle with coordinates"
                    + Arrays.toString(cmd), e);
        }
    }
}
