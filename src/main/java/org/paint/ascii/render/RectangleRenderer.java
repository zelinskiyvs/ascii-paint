package org.paint.ascii.render;

import org.paint.ascii.model.Point;
import org.paint.ascii.model.Rectangle;

import java.util.HashSet;
import java.util.Set;

public enum RectangleRenderer implements FigureRenderer<Rectangle> {

    INSTANCE;
    @Override
    public Set<Point> render(Rectangle rectangle) {
        Set<Point> points = new HashSet<>();
        for (int x = rectangle.getX1(); x <= rectangle.getX2(); x++) {
            points.add(new Point(x, rectangle.getY1()));
            points.add(new Point(x, rectangle.getY2()));
        }

        for (int y = rectangle.getY1(); y <= rectangle.getY2(); y++) {
            points.add(new Point(rectangle.getX1(), y));
            points.add(new Point(rectangle.getX2(), y));
        }
        return points;
    }
}
