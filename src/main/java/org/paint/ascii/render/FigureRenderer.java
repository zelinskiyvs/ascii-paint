package org.paint.ascii.render;

import org.paint.ascii.model.Figure;
import org.paint.ascii.model.Point;

import java.util.Set;

public interface FigureRenderer<T extends Figure> {
    Set<Point> render(T line);
}
