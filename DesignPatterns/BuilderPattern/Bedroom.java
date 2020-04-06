package DesignPatterns.BuilderPattern;

import java.awt.*;

public class Bedroom {
    private long length;
    private long breadth;
    private long height;
    private int numberOfDoors;
    private int numberOfWindows;
    private Color wallColor;

    public Bedroom(long length, long breadth, long height, int numberOfDoors, int numberOfWindows, Color wallColor) {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
        this.numberOfDoors = numberOfDoors;
        this.numberOfWindows = numberOfWindows;
        this.wallColor = wallColor;
    }

}
