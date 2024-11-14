package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    @DisplayName("update position if used singly")
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

        testPlateau.addItemToPlateau(testRover1, testPosition1);
        testPlateau.addItemToPlateau(testRover2, testPosition2);
        testPlateau.addItemToPlateau(testRover3, testPosition3);
        testPlateau.addItemToPlateau(testRover4, testPosition4);

        Position expectedPosition1 = new Position(1,2,Direction.N);
        Position expectedPosition2 = new Position(3,1,Direction.E);
        Position expectedPosition3 = new Position(2,1,Direction.S);
        Position expectedPosition4 = new Position(4,2,Direction.W);

        //Act
        testRover1.move(testPlateau);
        testRover2.move(testPlateau);
        testRover3.move(testPlateau);
        testRover4.move(testPlateau);

        //Assert
        assertAll(
                () -> assertEquals(expectedPosition1, testPlateau.getPlateauItems().get(testRover1)),
                () -> assertEquals(expectedPosition2, testPlateau.getPlateauItems().get(testRover2)),
                () -> assertEquals(expectedPosition3, testPlateau.getPlateauItems().get(testRover3)),
                () -> assertEquals(expectedPosition4, testPlateau.getPlateauItems().get(testRover4))
        );
    }

    @Test
    @DisplayName("update position if used multiple times")
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

        testPlateau.addItemToPlateau(testRover1, testPosition1);
        testPlateau.addItemToPlateau(testRover2, testPosition2);
        testPlateau.addItemToPlateau(testRover3, testPosition3);
        testPlateau.addItemToPlateau(testRover4, testPosition4);

        Position expectedPosition1 = new Position(1,3,Direction.N);
        Position expectedPosition2 = new Position(5,2,Direction.E);
        Position expectedPosition3 = new Position(3,4,Direction.S);
        Position expectedPosition4 = new Position(2,3,Direction.W);

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
                () -> assertEquals(expectedPosition1, testPlateau.getPlateauItems().get(testRover1)),
                () -> assertEquals(expectedPosition2, testPlateau.getPlateauItems().get(testRover2)),
                () -> assertEquals(expectedPosition3, testPlateau.getPlateauItems().get(testRover3)),
                () -> assertEquals(expectedPosition4, testPlateau.getPlateauItems().get(testRover4))
        );
    }

    @Test
    @DisplayName("does not update position beyond edge of the plateau")
    void testMoveBeyondEdge() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(10, 10);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1, 10, Direction.N);
        Rover testRover2 = new Rover();
        Position testPosition2 = new Position(9, 2, Direction.E);
        Rover testRover3 = new Rover();
        Position testPosition3 = new Position(8, 3, Direction.S);
        Rover testRover4 = new Rover();
        Position testPosition4 = new Position(2, 3, Direction.W);

        testPlateau.addItemToPlateau(testRover1, testPosition1);
        testPlateau.addItemToPlateau(testRover2, testPosition2);
        testPlateau.addItemToPlateau(testRover3, testPosition3);
        testPlateau.addItemToPlateau(testRover4, testPosition4);

        Position expectedPosition1 = new Position(1,10,Direction.N);
        Position expectedPosition2 = new Position(10,2,Direction.E);
        Position expectedPosition3 = new Position(8,4,Direction.S);
        Position expectedPosition4 = new Position(1,3,Direction.W);

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
                () -> assertEquals(expectedPosition1, testPlateau.getPlateauItems().get(testRover1)),
                () -> assertEquals(expectedPosition2, testPlateau.getPlateauItems().get(testRover2)),
                () -> assertEquals(expectedPosition3, testPlateau.getPlateauItems().get(testRover3)),
                () -> assertEquals(expectedPosition4, testPlateau.getPlateauItems().get(testRover4))
        );
    }

    @Test
    @DisplayName("update direction if used singly")
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

        testPlateau.addItemToPlateau(testRover1, testPosition1);
        testPlateau.addItemToPlateau(testRover2, testPosition2);
        testPlateau.addItemToPlateau(testRover3, testPosition3);
        testPlateau.addItemToPlateau(testRover4, testPosition4);

        Position expectedPosition1 = new Position(1,1,Direction.W);
        Position expectedPosition2 = new Position(2,2,Direction.S);
        Position expectedPosition3 = new Position(3,3,Direction.E);
        Position expectedPosition4 = new Position(4,4,Direction.N);

        //Act
        testRover1.turnLeft(testPlateau);
        testRover2.turnLeft(testPlateau);
        testRover3.turnLeft(testPlateau);
        testRover4.turnLeft(testPlateau);

        //Assert
        assertAll(
                () -> assertEquals(expectedPosition1, testPlateau.getPlateauItems().get(testRover1)),
                () -> assertEquals(expectedPosition2, testPlateau.getPlateauItems().get(testRover2)),
                () -> assertEquals(expectedPosition3, testPlateau.getPlateauItems().get(testRover3)),
                () -> assertEquals(expectedPosition4, testPlateau.getPlateauItems().get(testRover4))
        );
    }

    @Test
    @DisplayName("update direction if used multiple times")
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

        testPlateau.addItemToPlateau(testRover1, testPosition1);
        testPlateau.addItemToPlateau(testRover2, testPosition2);
        testPlateau.addItemToPlateau(testRover3, testPosition3);
        testPlateau.addItemToPlateau(testRover4, testPosition4);

        Position expectedPosition1 = new Position(1,1,Direction.S);
        Position expectedPosition2 = new Position(2,2,Direction.S);
        Position expectedPosition3 = new Position(3,3,Direction.S);
        Position expectedPosition4 = new Position(4,4,Direction.S);

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
                () -> assertEquals(expectedPosition1, testPlateau.getPlateauItems().get(testRover1)),
                () -> assertEquals(expectedPosition2, testPlateau.getPlateauItems().get(testRover2)),
                () -> assertEquals(expectedPosition3, testPlateau.getPlateauItems().get(testRover3)),
                () -> assertEquals(expectedPosition4, testPlateau.getPlateauItems().get(testRover4))
        );
    }

    @Test
    @DisplayName("update direction if used singly")
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

        testPlateau.addItemToPlateau(testRover1, testPosition1);
        testPlateau.addItemToPlateau(testRover2, testPosition2);
        testPlateau.addItemToPlateau(testRover3, testPosition3);
        testPlateau.addItemToPlateau(testRover4, testPosition4);

        Position expectedPosition1 = new Position(1,1,Direction.E);
        Position expectedPosition2 = new Position(2,2,Direction.S);
        Position expectedPosition3 = new Position(3,3,Direction.W);
        Position expectedPosition4 = new Position(4,4,Direction.N);

        //Act
        testRover1.turnRight(testPlateau);
        testRover2.turnRight(testPlateau);
        testRover3.turnRight(testPlateau);
        testRover4.turnRight(testPlateau);

        //Assert
        assertAll(
                () -> assertEquals(expectedPosition1, testPlateau.getPlateauItems().get(testRover1)),
                () -> assertEquals(expectedPosition2, testPlateau.getPlateauItems().get(testRover2)),
                () -> assertEquals(expectedPosition3, testPlateau.getPlateauItems().get(testRover3)),
                () -> assertEquals(expectedPosition4, testPlateau.getPlateauItems().get(testRover4))
        );
    }

    @Test
    @DisplayName("update direction if used multiple times")
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

        testPlateau.addItemToPlateau(testRover1, testPosition1);
        testPlateau.addItemToPlateau(testRover2, testPosition2);
        testPlateau.addItemToPlateau(testRover3, testPosition3);
        testPlateau.addItemToPlateau(testRover4, testPosition4);

        Position expectedPosition1 = new Position(1,1,Direction.S);
        Position expectedPosition2 = new Position(2,2,Direction.N);
        Position expectedPosition3 = new Position(3,3,Direction.S);
        Position expectedPosition4 = new Position(4,4,Direction.N);

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
                () -> assertEquals(expectedPosition1, testPlateau.getPlateauItems().get(testRover1)),
                () -> assertEquals(expectedPosition2, testPlateau.getPlateauItems().get(testRover2)),
                () -> assertEquals(expectedPosition3, testPlateau.getPlateauItems().get(testRover3)),
                () -> assertEquals(expectedPosition4, testPlateau.getPlateauItems().get(testRover4))
        );
    }
}