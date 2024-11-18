package org.example.perform;

import org.example.parse.Direction;

public class Rover {

    public void move(Plateau plateau) {

        Position roverPosition = plateau.getPlateauRoverPositions().get(this);

        if (roverPosition == null) {
            System.out.println("Rover cannot move: Rover position cannot be null.");
            return;
        }

        Direction roverDirection = roverPosition.getDirection();

        int newY;
        int newX;

        switch (roverDirection) {
            case N:
                newY = roverPosition.getY() + 1;
                plateau.updateRoverYCoordinate(this, newY);
                break;
            case E:
                newX = roverPosition.getX() + 1;
                plateau.updateRoverXCoordinate(this, newX);
                break;
            case S:
                newY = roverPosition.getY() - 1;
                plateau.updateRoverYCoordinate(this, newY);
                break;
            case W:
                newX = roverPosition.getX() - 1;
                plateau.updateRoverXCoordinate(this, newX);
                break;
            default:
                break;
        }
    }

    public void turnLeft(Plateau plateau) {
        Position roverPosition = plateau.getPlateauRoverPositions().get(this);

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
        Position roverPosition = plateau.getPlateauRoverPositions().get(this);

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
