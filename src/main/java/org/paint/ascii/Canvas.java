package org.paint.ascii;


import org.paint.ascii.model.Point;

import java.util.Collection;

public abstract class Canvas {
    private final int wight;
    private final int height;

    public Canvas(int wight, int height) {
        this.wight = wight;
        this.height = height;
    }

    public int getWight() {
        return wight;
    }

    public int getHeight() {
        return height;
    }

    public abstract void addPoints(Collection<Point> points);

    @Override
    public String toString() {
        return "Canvas{" +
                "wight=" + wight +
                ", height=" + height +
                '}';
    }
}
