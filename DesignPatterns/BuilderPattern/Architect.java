package DesignPatterns.BuilderPattern;

import java.awt.*;

public class Architect {
    public static void main(String[] args) {
        Bedroom room = new Bedroom(1, 2, 3, 4, 5, Color.BLACK);

        Bedroom room1 = new BedRoomBuilder().setBreadth(1).setHeight(3).setNumberOfDoors(3).setNumberOfWindows(4).createBedroom();
    }
}
