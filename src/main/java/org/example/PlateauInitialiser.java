package org.example;

public class PlateauInitialiser {
    public void initialisePlateau (int xDimension, int yDimension) {
        PlateauSize plateauSize = new PlateauSize(xDimension, yDimension);
        Plateau plateau = new Plateau(plateauSize);
    }

    public void addRoverToPlateau (Plateau plateau, int xCoordinate, int yCoordinate, Direction direction) {
        Rover rover = new Rover();
        Position position = new Position(xCoordinate, yCoordinate, direction);

        plateau.addRoverToPlateau(rover, position);
    }
}
