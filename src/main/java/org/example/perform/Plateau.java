package org.example.perform;

import org.example.parse.Direction;

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
                    " and the input position for the Rover is: " + position);
            return;
        }

        this.plateauRoverPositions.put(rover, position);

        System.out.println("Rover added to Plateau");
    }

    private boolean roverNullOrMissing(Rover rover) {
        if (rover == null) {
            System.out.println("Rover position not updated: input Rover cannot be null.");
            return true;
        } else if (!plateauRoverPositions.containsKey(rover)) {
            System.out.println("Rover position not updated: Rover cannot be found on the plateau.");
            return true;
        } else {
            return false;
        }
    }

    public void updateRoverXCoordinate(Rover rover, int xIncrement) {
        if (roverNullOrMissing(rover)) {
            //do nothing
            return;
        }
        int currentX = plateauRoverPositions.get(rover).getX();
        int proposedX = currentX + xIncrement;

        if (proposedX > plateauSize.getX() || proposedX < 0) {
            System.out.println("Rover position not updated: Rover X coordinate cannot be updated to number outside " +
                    "the limits of the plateau.  Plateau size is: " + this.plateauSize +
                    " and the update would take the Rover to x coordinate: " + proposedX);
        } else {
            plateauRoverPositions.get(rover).setX(proposedX);
            System.out.println("Updated Rover position: " + this.plateauRoverPositions.get(rover));
        }
    }

    public void updateRoverYCoordinate(Rover rover, int yIncrement) {
        if (roverNullOrMissing(rover)) {
            //do nothing
            return;
        }
        int currentY = plateauRoverPositions.get(rover).getY();
        int proposedY = currentY + yIncrement;

        if (proposedY > plateauSize.getX() || proposedY < 0) {
            System.out.println("Rover position not updated: Rover Y coordinate cannot be updated to number outside " +
                    "the limits of the plateau.  Plateau size is: " + this.plateauSize +
                    " and the update would take the Rover to y coordinate: " + proposedY);
        } else {
            plateauRoverPositions.get(rover).setY(proposedY);
            System.out.println("Updated Rover position: " + this.plateauRoverPositions.get(rover));
        }
    }

    public void updateRoverDirection(Rover rover, Direction newDirection) {
        if (rover == null) {
            System.out.println("Rover position not updated: input Rover cannot be null.");
        } else if (newDirection == null) {
            System.out.println("Rover position not updated: input direction cannot be null.");
        } else if (!plateauRoverPositions.containsKey(rover)) {
            System.out.println("Rover position not updated: Rover cannot be found on the Plateau.");
        } else {
            plateauRoverPositions.get(rover).setDirection(newDirection);
            System.out.println("Updated Rover position: " + this.plateauRoverPositions.get(rover));
        }
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
