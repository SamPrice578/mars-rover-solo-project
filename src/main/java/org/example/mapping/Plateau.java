package org.example.mapping;

import org.example.parsing.Direction;
import org.example.rovers.Rover;

import java.util.HashMap;
import java.util.Map;

public class Plateau {
    private final PlateauSize plateauSize;
    private Map<Rover, Position> plateauRoverPositions = new HashMap<>();

    public Plateau(PlateauSize plateauSize) {
        this.plateauSize = plateauSize;
    }

    public void addRoverToPlateau(Rover rover, Position position) {
        if (rover == null) {
            System.out.println("Rover not added to Plateau: null Rover cannot be added.");
            return;
        }
        if (position == null) {
            System.out.println("Rover not added to Plateau: Rover cannot be added at null position.");
            return;
        }
        if (position.getX() > this.plateauSize.getX() || position.getY() > this.plateauSize.getY()) {
            System.out.println("Rover not added to Plateau: position is beyond the " +
                    "limits of the plateau.  Plateau size is: " + this.plateauSize +
                    " and the input position for the rover is: " + position);
            return;
        }

        this.plateauRoverPositions.put(rover, position);

        System.out.println("Rover added to Plateau");
    }

    public void updateRoverXCoordinate(Rover rover, int newX) {
        if (rover == null) {
            System.out.println("Rover position not updated: input Rover cannot be null.");
            return;
        }

        if (newX < 0) {
            System.out.println("Rover position not updated: X coordinate cannot be negative.");
            return;
        }

        if (newX > plateauSize.getX()) {
            System.out.println("Rover position not updated: Rover X coordinate cannot be updated to number beyond" +
                    "the limits of the plateau.  Plateau size is: " + this.plateauSize +
                    " and the input x coordinate is: " + newX);
            return;
        }

        if (!plateauRoverPositions.containsKey(rover)) {
            System.out.println("Rover position not updated: Rover cannot be found on the Plateau.");
            return;
        }

        plateauRoverPositions.get(rover).setX(newX);
        System.out.println("Updated Rover position: " + this.plateauRoverPositions.get(rover));
    }

    public void updateRoverYCoordinate(Rover rover, int newY) {
        if (rover == null) {
            System.out.println("Rover position not updated: input Rover cannot be null.");
            return;
        }

        if (newY < 0) {
            System.out.println("Rover position not updated: Y coordinate cannot be negative.");
            return;
        }

        if (newY > plateauSize.getY()) {
            System.out.println("Rover position not updated: Y coordinate cannot be beyond" +
                    "the limits of the plateau.  Plateau size is: " + this.plateauSize +
                    " and the input y coordinate is: " + newY);
            return;
        }

        if (!plateauRoverPositions.containsKey(rover)) {
            System.out.println("Rover position not updated: Rover cannot be found on the Plateau.");
            return;
        }

        plateauRoverPositions.get(rover).setY(newY);

        System.out.println("Updated Rover position: " + this.plateauRoverPositions.get(rover));
    }

    public void updateRoverDirection(Rover rover, Direction newDirection) {
        if (rover == null) {
            System.out.println("Rover position not updated: input Rover cannot be null.");
            return;
        }

        if (newDirection == null) {
            System.out.println("Rover position not updated: input direction cannot be null.");
            return;
        }

        if (!plateauRoverPositions.containsKey(rover)) {
            System.out.println("Rover position not updated: Rover cannot be found on the Plateau.");
            return;
        }

        plateauRoverPositions.get(rover).setDirection(newDirection);

        System.out.println("Updated Rover position: " + this.plateauRoverPositions.get(rover));
    }

    public void removeRoverFromPlateau(Rover rover) {
        if (rover == null) {
            System.out.println("Cannot remove null rover from plateau");
            return;
        }
        if (this.plateauRoverPositions.containsKey(rover)) {
            this.plateauRoverPositions.remove(rover);
        } else {
            System.out.println("cannot remove rover because it does not exist on the plateau");
        }
    }

    public Map<Rover, Position> getPlateauRoverPositions() {
        return plateauRoverPositions;
    }

    public PlateauSize getPlateauSize() {
        return plateauSize;
    }
}
