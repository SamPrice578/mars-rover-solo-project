package org.example;

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
            System.out.println("Cannot add null rover to plateau");
            return;
        }
        if (position == null) {
            System.out.println("Cannot add rover at null position on plateau");
            return;
        }
        if (position.getX() > this.plateauSize.getX() || position.getY() > this.plateauSize.getY()) {
            System.out.println("Cannot add rover to plateau because the position is beyond the " +
                    "limits of the plateau.  Plateau size is: " + this.plateauSize +
                    " and the specified position for the rover is: " + position);
        }

        this.plateauRoverPositions.put(rover, position);
    }

    public void updateRoverXCoordinate(Rover rover, int newX) {}

    public void updateRoverYCoordinate(Rover rover, int newY) {}

    public void updateRoverDirection(Rover rover, Direction newDirection) {}

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
}
