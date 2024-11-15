package org.example.mapping;

public class PlateauSize {
    private int x;
    private int y;

    public PlateauSize(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "PlateauSize{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}