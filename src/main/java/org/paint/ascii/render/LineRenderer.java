package org.paint.ascii.render;

import org.paint.ascii.model.Line;
import org.paint.ascii.model.Point;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.abs;

public enum LineRenderer implements FigureRenderer<Line> {
    INSTANCE;
    @Override
    public Set<Point> render(Line line) {
        Set<Point> points = new HashSet<>();
        points.add(new Point(line.getxEnd(), line.getyEnd()));
        points.add(new Point(line.getxStart(), line.getyStart()));

        if (abs(line.getxEnd() - line.getxStart()) > abs(line.getyEnd() - line.getyStart())) {
            if(line.getxStart() > line.getxEnd()) {
                line = rotateLine(line);
            }
            for (int x = line.getxStart(); x < line.getxEnd(); x++) {
                int y = line.getyStart() + Math.round((x - line.getxStart()) * line.getTg());
                if (isInInterval(y, line.getyStart(), line.getyEnd())) {
                    points.add(new Point(x, y));
                }
            }
        } else {
            if(line.getyStart() > line.getyEnd()) {
                line = rotateLine(line);
            }
            for (int y = line.getyStart(); y < line.getyEnd(); y++) {
                int x = line.getxStart() + Math.round((y - line.getyStart()) / line.getTg());

                if (isInInterval(x, line.getxStart(), line.getxEnd())) {
                    points.add(new Point(x, y));
                }
            }
        }

        return points;
    }

    private Line rotateLine(Line line) {
        return new Line(line.getxEnd(), line.getyEnd(), line.getxStart(), line.getyStart());
    }

    private boolean isInInterval(int dot, int a, int b) {
        return a <= dot && dot <= b || b <= dot && dot <= a;
    }

}
