package org.example;

public class PlateauInitialiser {
    public static Plateau initialisePlateau (int xDimension, int yDimension) {
        PlateauSize plateauSize = new PlateauSize(xDimension, yDimension);
        Plateau plateau = new Plateau(plateauSize);
        return plateau;
    }

    public static Rover addRoverToPlateau (Plateau plateau, int xCoordinate, int yCoordinate, Direction direction) {
        Rover rover = new Rover();
        Position position = new Position(xCoordinate, yCoordinate, direction);
        plateau.addRoverToPlateau(rover, position);
        return rover;
    }
}
