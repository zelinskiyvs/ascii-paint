package org.paint.ascii.model;

public class Line implements Figure {
    private final int xStart;
    private final int yStart;
    private final int xEnd;
    private final int yEnd;

    public Line(int xStart, int yStart, int xEnd, int yEnd) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    public int getxStart() {
        return xStart;
    }

    public int getyStart() {
        return yStart;
    }

    public int getxEnd() {
        return xEnd;
    }

    public int getyEnd() {
        return yEnd;
    }

    public float getTg() {
        return ((float) (yEnd - yStart)) / (xEnd - xStart);
    }

    @Override
    public String toString() {
        return "Line{" +
                "xStart=" + xStart +
                ", yStart=" + yStart +
                ", xEnd=" + xEnd +
                ", yEnd=" + yEnd +
                '}';
    }
}
