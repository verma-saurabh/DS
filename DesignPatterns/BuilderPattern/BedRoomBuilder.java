package DesignPatterns.BuilderPattern;

import java.awt.*;

public class BedRoomBuilder implements Builder {
    private long length;
    private long breadth;
    private long height;
    private int numberOfDoors;
    private int numberOfWindows;
    private Color wallColor;

    @Override
    public BedRoomBuilder setLength(long length) {
        this.length = length;
        return this;
    }

    @Override
    public BedRoomBuilder setBreadth(long breadth) {
        this.breadth = breadth;
        return this;
    }

    @Override
    public BedRoomBuilder setHeight(long height) {
        this.height = height;
        return this;
    }

    public BedRoomBuilder setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
        return this;
    }

    public BedRoomBuilder setNumberOfWindows(int numberOfWindows) {
        this.numberOfWindows = numberOfWindows;
        return this;
    }

    public BedRoomBuilder setWallColor(Color wallColor) {
        this.wallColor = wallColor;
        return this;
    }

    public Bedroom createBedroom() {
        return new Bedroom(length, breadth, height, numberOfDoors, numberOfWindows, wallColor);
    }

}
