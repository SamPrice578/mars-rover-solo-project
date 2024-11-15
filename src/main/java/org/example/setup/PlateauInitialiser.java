package org.example.setup;

import org.example.mapping.Plateau;
import org.example.mapping.PlateauSize;
import org.example.mapping.Position;
import org.example.rovers.Rover;
import org.example.parsing.Direction;

public class PlateauInitialiser {
    public static Plateau initialisePlateau (int xDimension, int yDimension) {
        System.out.println("Initialising Plateau...");

        PlateauSize plateauSize = new PlateauSize(xDimension, yDimension);
        Plateau plateau = new Plateau(plateauSize);

        System.out.println("Plateau initialised");
        System.out.println();
        return plateau;
    }

    public static Rover addRoverToPlateau (Plateau plateau, int xCoordinate, int yCoordinate, Direction direction) {
        System.out.println("Placing Rover on Plateau...");

        Rover rover = new Rover();
        Position position = new Position(xCoordinate, yCoordinate, direction);
        plateau.addRoverToPlateau(rover, position);

        System.out.println("Rover successfully landed");
        System.out.println();
        return rover;
    }
}
