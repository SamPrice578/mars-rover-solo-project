package org.example.perform;

import org.example.parse.Direction;

public class Rover implements Instructable {

    public void move(Plateau plateau) {

        Position roverPosition = plateau.getPlateauInstructablesPositions().get(this);

        if (roverPosition == null) {
            System.out.println("Rover cannot move: Rover position cannot be null.");
            return;
        }

        Direction roverDirection = roverPosition.getDirection();

        switch (roverDirection) {
            case N:
                plateau.updateRoverYCoordinate(this, 1);
                break;
            case E:
                plateau.updateRoverXCoordinate(this, 1);
                break;
            case S:
                plateau.updateRoverYCoordinate(this, -1);
                break;
            case W:
                plateau.updateRoverXCoordinate(this, -1);
                break;
            default:
                break;
        }
    }

    public void turnLeft(Plateau plateau) {
        Position roverPosition = plateau.getPlateauInstructablesPositions().get(this);

        if (roverPosition == null) {
            System.out.println("Rover cannot move: Rover position cannot be null.");
            return;
        }

        Direction roverDirection = roverPosition.getDirection();

        switch (roverDirection) {
            case N:
                plateau.updateRoverDirection(this, Direction.W);
                break;
            case E:
                plateau.updateRoverDirection(this, Direction.N);
                break;
            case S:
                plateau.updateRoverDirection(this, Direction.E);
                break;
            case W:
                plateau.updateRoverDirection(this, Direction.S);
                break;
            default:
                break;
        }
    }

    public void turnRight(Plateau plateau) {
        Position roverPosition = plateau.getPlateauInstructablesPositions().get(this);

        if (roverPosition == null) {
            System.out.println("Rover cannot move: Rover position cannot be null.");
            return;
        }

        Direction roverDirection = roverPosition.getDirection();

        switch (roverDirection) {
            case N:
                plateau.updateRoverDirection(this, Direction.E);
                break;
            case E:
                plateau.updateRoverDirection(this, Direction.S);
                break;
            case S:
                plateau.updateRoverDirection(this, Direction.W);
                break;
            case W:
                plateau.updateRoverDirection(this, Direction.N);
                break;
            default:
                break;
        }
    }
}
