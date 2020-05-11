package org.paint.ascii.render;

import org.paint.ascii.model.Point;
import org.paint.ascii.model.Rectangle;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public enum RectangleRenderer implements FigureRenderer<Rectangle> {

    INSTANCE;
    @Override
    public Set<Point> render(Rectangle rectangle) {
        Set<Point> points = new HashSet<>();
        int xEnd = max(rectangle.getX1(), rectangle.getX2());
        int xStart = min(rectangle.getX1(), rectangle.getX2());
        for (int x = xStart; x <= xEnd; x++) {
            points.add(new Point(x, rectangle.getY1()));
            points.add(new Point(x, rectangle.getY2()));
        }

        int yEnd = max(rectangle.getY1(), rectangle.getY2());
        int yStart = min(rectangle.getY1(), rectangle.getY2());
        for (int y = yStart; y <= yEnd; y++) {
            points.add(new Point(rectangle.getX1(), y));
            points.add(new Point(rectangle.getX2(), y));
        }
        return points;
    }
}
