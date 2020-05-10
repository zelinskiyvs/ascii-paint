package org.paint.ascii.render;

import org.paint.ascii.model.Line;
import org.paint.ascii.model.Point;

import java.util.HashSet;
import java.util.Set;

public enum LineRenderer implements FigureRenderer<Line> {
    INSTANCE;
    @Override
    public Set<Point> render(Line line) {
        Set<Point> points = new HashSet<>();
        points.add(new Point(line.getxEnd(), line.getyEnd()));
        points.add(new Point(line.getxStart(), line.getyStart()));

        if ((line.getxEnd() - line.getxStart()) > (line.getyEnd() - line.getyStart())) {
            for (int x = line.getxStart(); x < line.getxEnd(); x++) {
                int y = line.getyStart() + Math.round((x - line.getxStart()) * line.getTg());
                if (isInInterval(y, line.getyStart(), line.getyEnd())) {
                    points.add(new Point(x, y));
                }
            }
        } else {
            for (int y = line.getyStart(); y < line.getyEnd(); y++) {
                int x = line.getxStart() + Math.round((y - line.getyStart()) / line.getTg());

                if (isInInterval(x, line.getxStart(), line.getxEnd())) {
                    points.add(new Point(x, y));
                }
            }
        }

        return points;
    }

    private boolean isInInterval(int dot, int a, int b) {
        return a <= dot && dot <= b || b <= dot && dot <= a;
    }

}
