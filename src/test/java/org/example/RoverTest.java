package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    @DisplayName("move update position if used singly")
    void testMoveSingly() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5, 5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1, 1, Direction.N);
        Rover testRover2 = new Rover();
        Position testPosition2 = new Position(4, 1, Direction.E);
        Rover testRover3 = new Rover();
        Position testPosition3 = new Position(2, 2, Direction.S);
        Rover testRover4 = new Rover();
        Position testPosition4 = new Position(5, 2, Direction.W);

        testPlateau.addRoverToPlateau(testRover1, testPosition1);
        testPlateau.addRoverToPlateau(testRover2, testPosition2);
        testPlateau.addRoverToPlateau(testRover3, testPosition3);
        testPlateau.addRoverToPlateau(testRover4, testPosition4);

        //Act
        testRover1.move(testPlateau);
        testRover2.move(testPlateau);
        testRover3.move(testPlateau);
        testRover4.move(testPlateau);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover1).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover1).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover1).getDirection()),

                () -> assertEquals(5, testPlateau.getPlateauRoverPositions().get(testRover2).getX()),
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover2).getY()),
                () -> assertEquals(Direction.E, testPlateau.getPlateauRoverPositions().get(testRover2).getDirection()),

                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover3).getX()),
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover3).getY()),
                () -> assertEquals(Direction.S, testPlateau.getPlateauRoverPositions().get(testRover3).getDirection()),

                () -> assertEquals(4, testPlateau.getPlateauRoverPositions().get(testRover4).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover4).getY()),
                () -> assertEquals(Direction.W, testPlateau.getPlateauRoverPositions().get(testRover4).getDirection())
        );
    }

    @Test
    @DisplayName("move update position if used multiple times")
    void testMoveMultiple() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(10, 10);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1, 1, Direction.N);
        Rover testRover2 = new Rover();
        Position testPosition2 = new Position(2, 2, Direction.E);
        Rover testRover3 = new Rover();
        Position testPosition3 = new Position(3, 8, Direction.S);
        Rover testRover4 = new Rover();
        Position testPosition4 = new Position(7, 3, Direction.W);

        testPlateau.addRoverToPlateau(testRover1, testPosition1);
        testPlateau.addRoverToPlateau(testRover2, testPosition2);
        testPlateau.addRoverToPlateau(testRover3, testPosition3);
        testPlateau.addRoverToPlateau(testRover4, testPosition4);

        //Act
        testRover1.move(testPlateau);
        testRover1.move(testPlateau);

        testRover2.move(testPlateau);
        testRover2.move(testPlateau);
        testRover2.move(testPlateau);

        testRover3.move(testPlateau);
        testRover3.move(testPlateau);
        testRover3.move(testPlateau);
        testRover3.move(testPlateau);

        testRover4.move(testPlateau);
        testRover4.move(testPlateau);
        testRover4.move(testPlateau);
        testRover4.move(testPlateau);
        testRover4.move(testPlateau);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover1).getX()),
                () -> assertEquals(3, testPlateau.getPlateauRoverPositions().get(testRover1).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover1).getDirection()),

                () -> assertEquals(5, testPlateau.getPlateauRoverPositions().get(testRover2).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover2).getY()),
                () -> assertEquals(Direction.E, testPlateau.getPlateauRoverPositions().get(testRover2).getDirection()),

                () -> assertEquals(3, testPlateau.getPlateauRoverPositions().get(testRover3).getX()),
                () -> assertEquals(4, testPlateau.getPlateauRoverPositions().get(testRover3).getY()),
                () -> assertEquals(Direction.S, testPlateau.getPlateauRoverPositions().get(testRover3).getDirection()),

                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover4).getX()),
                () -> assertEquals(3, testPlateau.getPlateauRoverPositions().get(testRover4).getY()),
                () -> assertEquals(Direction.W, testPlateau.getPlateauRoverPositions().get(testRover4).getDirection())
        );
    }

    @Test
    @DisplayName("move does not update position beyond edge of the plateau")
    void testMoveBeyondEdge() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(10, 10);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1, 10, Direction.N);
        Rover testRover2 = new Rover();
        Position testPosition2 = new Position(9, 2, Direction.E);
        Rover testRover3 = new Rover();
        Position testPosition3 = new Position(8, 2, Direction.S);
        Rover testRover4 = new Rover();
        Position testPosition4 = new Position(2, 3, Direction.W);

        testPlateau.addRoverToPlateau(testRover1, testPosition1);
        testPlateau.addRoverToPlateau(testRover2, testPosition2);
        testPlateau.addRoverToPlateau(testRover3, testPosition3);
        testPlateau.addRoverToPlateau(testRover4, testPosition4);

        //Act
        testRover1.move(testPlateau);

        testRover2.move(testPlateau);
        testRover2.move(testPlateau);

        testRover3.move(testPlateau);
        testRover3.move(testPlateau);
        testRover3.move(testPlateau);

        testRover4.move(testPlateau);
        testRover4.move(testPlateau);
        testRover4.move(testPlateau);
        testRover4.move(testPlateau);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover1).getX()),
                () -> assertEquals(10, testPlateau.getPlateauRoverPositions().get(testRover1).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover1).getDirection()),

                () -> assertEquals(10, testPlateau.getPlateauRoverPositions().get(testRover2).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover2).getY()),
                () -> assertEquals(Direction.E, testPlateau.getPlateauRoverPositions().get(testRover2).getDirection()),

                () -> assertEquals(8, testPlateau.getPlateauRoverPositions().get(testRover3).getX()),
                () -> assertEquals(0, testPlateau.getPlateauRoverPositions().get(testRover3).getY()),
                () -> assertEquals(Direction.S, testPlateau.getPlateauRoverPositions().get(testRover3).getDirection()),

                () -> assertEquals(0, testPlateau.getPlateauRoverPositions().get(testRover4).getX()),
                () -> assertEquals(3, testPlateau.getPlateauRoverPositions().get(testRover4).getY()),
                () -> assertEquals(Direction.W, testPlateau.getPlateauRoverPositions().get(testRover4).getDirection())
        );
    }

    @Test
    @DisplayName("turnLeft update direction if used singly")
    void testTurnLeftSingly() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5, 5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1, 1, Direction.N);
        Rover testRover2 = new Rover();
        Position testPosition2 = new Position(2, 2, Direction.E);
        Rover testRover3 = new Rover();
        Position testPosition3 = new Position(3, 3, Direction.S);
        Rover testRover4 = new Rover();
        Position testPosition4 = new Position(4, 4, Direction.W);

        testPlateau.addRoverToPlateau(testRover1, testPosition1);
        testPlateau.addRoverToPlateau(testRover2, testPosition2);
        testPlateau.addRoverToPlateau(testRover3, testPosition3);
        testPlateau.addRoverToPlateau(testRover4, testPosition4);

        //Act
        testRover1.turnLeft(testPlateau);
        testRover2.turnLeft(testPlateau);
        testRover3.turnLeft(testPlateau);
        testRover4.turnLeft(testPlateau);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover1).getX()),
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover1).getY()),
                () -> assertEquals(Direction.W, testPlateau.getPlateauRoverPositions().get(testRover1).getDirection()),

                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover2).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover2).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover2).getDirection()),

                () -> assertEquals(3, testPlateau.getPlateauRoverPositions().get(testRover3).getX()),
                () -> assertEquals(3, testPlateau.getPlateauRoverPositions().get(testRover3).getY()),
                () -> assertEquals(Direction.E, testPlateau.getPlateauRoverPositions().get(testRover3).getDirection()),

                () -> assertEquals(4, testPlateau.getPlateauRoverPositions().get(testRover4).getX()),
                () -> assertEquals(4, testPlateau.getPlateauRoverPositions().get(testRover4).getY()),
                () -> assertEquals(Direction.S, testPlateau.getPlateauRoverPositions().get(testRover4).getDirection())
        );
    }

    @Test
    @DisplayName("turnLeft update direction if used multiple times")
    void testTurnLeftMultiple() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5, 5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1, 1, Direction.N);
        Rover testRover2 = new Rover();
        Position testPosition2 = new Position(2, 2, Direction.E);
        Rover testRover3 = new Rover();
        Position testPosition3 = new Position(3, 3, Direction.S);
        Rover testRover4 = new Rover();
        Position testPosition4 = new Position(4, 4, Direction.W);

        testPlateau.addRoverToPlateau(testRover1, testPosition1);
        testPlateau.addRoverToPlateau(testRover2, testPosition2);
        testPlateau.addRoverToPlateau(testRover3, testPosition3);
        testPlateau.addRoverToPlateau(testRover4, testPosition4);

        //Act
        testRover1.turnLeft(testPlateau);
        testRover1.turnLeft(testPlateau);

        testRover2.turnLeft(testPlateau);
        testRover2.turnLeft(testPlateau);
        testRover2.turnLeft(testPlateau);

        testRover3.turnLeft(testPlateau);
        testRover3.turnLeft(testPlateau);
        testRover3.turnLeft(testPlateau);
        testRover3.turnLeft(testPlateau);

        testRover4.turnLeft(testPlateau);
        testRover4.turnLeft(testPlateau);
        testRover4.turnLeft(testPlateau);
        testRover4.turnLeft(testPlateau);
        testRover4.turnLeft(testPlateau);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover1).getX()),
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover1).getY()),
                () -> assertEquals(Direction.S, testPlateau.getPlateauRoverPositions().get(testRover1).getDirection()),

                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover2).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover2).getY()),
                () -> assertEquals(Direction.S, testPlateau.getPlateauRoverPositions().get(testRover2).getDirection()),

                () -> assertEquals(3, testPlateau.getPlateauRoverPositions().get(testRover3).getX()),
                () -> assertEquals(3, testPlateau.getPlateauRoverPositions().get(testRover3).getY()),
                () -> assertEquals(Direction.S, testPlateau.getPlateauRoverPositions().get(testRover3).getDirection()),

                () -> assertEquals(4, testPlateau.getPlateauRoverPositions().get(testRover4).getX()),
                () -> assertEquals(4, testPlateau.getPlateauRoverPositions().get(testRover4).getY()),
                () -> assertEquals(Direction.S, testPlateau.getPlateauRoverPositions().get(testRover4).getDirection())
        );
    }

    @Test
    @DisplayName("turnRight update direction if used singly")
    void testTurnRightSingly() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5, 5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1, 1, Direction.N);
        Rover testRover2 = new Rover();
        Position testPosition2 = new Position(2, 2, Direction.E);
        Rover testRover3 = new Rover();
        Position testPosition3 = new Position(3, 3, Direction.S);
        Rover testRover4 = new Rover();
        Position testPosition4 = new Position(4, 4, Direction.W);

        testPlateau.addRoverToPlateau(testRover1, testPosition1);
        testPlateau.addRoverToPlateau(testRover2, testPosition2);
        testPlateau.addRoverToPlateau(testRover3, testPosition3);
        testPlateau.addRoverToPlateau(testRover4, testPosition4);

        //Act
        testRover1.turnRight(testPlateau);
        testRover2.turnRight(testPlateau);
        testRover3.turnRight(testPlateau);
        testRover4.turnRight(testPlateau);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover1).getX()),
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover1).getY()),
                () -> assertEquals(Direction.E, testPlateau.getPlateauRoverPositions().get(testRover1).getDirection()),

                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover2).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover2).getY()),
                () -> assertEquals(Direction.S, testPlateau.getPlateauRoverPositions().get(testRover2).getDirection()),

                () -> assertEquals(3, testPlateau.getPlateauRoverPositions().get(testRover3).getX()),
                () -> assertEquals(3, testPlateau.getPlateauRoverPositions().get(testRover3).getY()),
                () -> assertEquals(Direction.W, testPlateau.getPlateauRoverPositions().get(testRover3).getDirection()),

                () -> assertEquals(4, testPlateau.getPlateauRoverPositions().get(testRover4).getX()),
                () -> assertEquals(4, testPlateau.getPlateauRoverPositions().get(testRover4).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover4).getDirection())
        );
    }

    @Test
    @DisplayName("turnRight update direction if used multiple times")
    void testTurnRightMultiple() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5, 5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1, 1, Direction.N);
        Rover testRover2 = new Rover();
        Position testPosition2 = new Position(2, 2, Direction.E);
        Rover testRover3 = new Rover();
        Position testPosition3 = new Position(3, 3, Direction.S);
        Rover testRover4 = new Rover();
        Position testPosition4 = new Position(4, 4, Direction.W);

        testPlateau.addRoverToPlateau(testRover1, testPosition1);
        testPlateau.addRoverToPlateau(testRover2, testPosition2);
        testPlateau.addRoverToPlateau(testRover3, testPosition3);
        testPlateau.addRoverToPlateau(testRover4, testPosition4);

        //Act
        testRover1.turnRight(testPlateau);
        testRover1.turnRight(testPlateau);

        testRover2.turnRight(testPlateau);
        testRover2.turnRight(testPlateau);
        testRover2.turnRight(testPlateau);

        testRover3.turnRight(testPlateau);
        testRover3.turnRight(testPlateau);
        testRover3.turnRight(testPlateau);
        testRover3.turnRight(testPlateau);

        testRover4.turnRight(testPlateau);
        testRover4.turnRight(testPlateau);
        testRover4.turnRight(testPlateau);
        testRover4.turnRight(testPlateau);
        testRover4.turnRight(testPlateau);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover1).getX()),
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover1).getY()),
                () -> assertEquals(Direction.S, testPlateau.getPlateauRoverPositions().get(testRover1).getDirection()),

                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover2).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover2).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover2).getDirection()),

                () -> assertEquals(3, testPlateau.getPlateauRoverPositions().get(testRover3).getX()),
                () -> assertEquals(3, testPlateau.getPlateauRoverPositions().get(testRover3).getY()),
                () -> assertEquals(Direction.S, testPlateau.getPlateauRoverPositions().get(testRover3).getDirection()),

                () -> assertEquals(4, testPlateau.getPlateauRoverPositions().get(testRover4).getX()),
                () -> assertEquals(4, testPlateau.getPlateauRoverPositions().get(testRover4).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover4).getDirection())
        );
    }
}