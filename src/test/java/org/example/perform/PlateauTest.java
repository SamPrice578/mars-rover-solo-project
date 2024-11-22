package org.example.perform;

import static org.junit.jupiter.api.Assertions.*;

import org.example.parse.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class PlateauTest {

    @Test
    @DisplayName("addRoverToPlateau makes no update when rover is null")
    void testAddRoverToPlateauNullRover() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);
        Rover testRover = null;
        Position testPosition = new Position(1,2, Direction.N);

        Plateau expectedPlateau = new Plateau(testPlateauSize);

        //Act
        testPlateau.addRoverToPlateau(testRover, testPosition);

        //Assert
        assertEquals(expectedPlateau.getPlateauRoverPositions(), testPlateau.getPlateauRoverPositions());
    }

    @Test
    @DisplayName("addRoverToPlateau makes no update when position is null")
    void testAddRoverToPlateauNullPosition() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);
        Rover testRover = new Rover();
        Position testPosition = null;

        Plateau expectedPlateau = new Plateau(testPlateauSize);

        //Act
        testPlateau.addRoverToPlateau(testRover, testPosition);

        //Assert
        assertEquals(expectedPlateau.getPlateauRoverPositions(), testPlateau.getPlateauRoverPositions());
    }

    @Test
    @DisplayName("addRoverToPlateau updates correctly when passed appropriate rover and position")
    void testAddRoverToPlateauAppropriateRoverAndPosition() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);
        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        //Act
        testPlateau.addRoverToPlateau(testRover, testPosition);

        //Assert
        assertEquals(testPlateau.getPlateauRoverPositions().get(testRover), testPosition);
    }


    @Test
    @DisplayName("addRoverToPlateau updates correctly when passed same rover with different positions consecutively")
    void testAddRoverToPlateauSameRoverDiffferentPositionsConsecutive() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();

        Position testPosition1 = new Position(1,2, Direction.N);
        Position testPosition2 = new Position(2,3, Direction.N);
        Position testPosition3 = new Position(3,4, Direction.N);

        //Act
        testPlateau.addRoverToPlateau(testRover, testPosition1);
        testPlateau.addRoverToPlateau(testRover, testPosition2);
        testPlateau.addRoverToPlateau(testRover, testPosition3);

        //Assert
        assertEquals(testPlateau.getPlateauRoverPositions().get(testRover), testPosition3);
    }

    @Test
    @DisplayName("addRoverToPlateau updates correctly when passed different rovers and positions consecutively")
    void testAddRoverToPlateauDifferentRoversAndPositionsConsecutive() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Rover testRover2 = new Rover();
        Rover testRover3 = new Rover();

        Position testPosition1 = new Position(1,2, Direction.N);
        Position testPosition2 = new Position(2,3, Direction.N);
        Position testPosition3 = new Position(3,4, Direction.N);

        //Act
        testPlateau.addRoverToPlateau(testRover1, testPosition1);
        testPlateau.addRoverToPlateau(testRover2, testPosition2);
        testPlateau.addRoverToPlateau(testRover3, testPosition3);

        //Assert
        assertEquals(testPlateau.getPlateauRoverPositions().get(testRover1), testPosition1);
        assertEquals(testPlateau.getPlateauRoverPositions().get(testRover2), testPosition2);
        assertEquals(testPlateau.getPlateauRoverPositions().get(testRover3), testPosition3);
    }

//    removeRoverFromPlateau

    @Test
    @DisplayName("removeRoverFromPlateau makes no update when rover is null")
    void testRemoveRoverFromPlateauNullRover() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        Rover nullRover = null;

        Plateau expectedPlateau = new Plateau(testPlateauSize);
        expectedPlateau.addRoverToPlateau(testRover, testPosition);

        testPlateau.addRoverToPlateau(testRover, testPosition);

        //Act
        testPlateau.removeRoverFromPlateau(nullRover);

        //Assert
        assertEquals(expectedPlateau.getPlateauRoverPositions(), testPlateau.getPlateauRoverPositions());
    }

    @Test
    @DisplayName("removeRoverFromPlateau makes no update if rover does not exist in plateauRoverPositions")
    void testRemoveRoverFromPlateauMissingRover() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1,2, Direction.N);

        Rover testRover2 = new Rover();

        Plateau expectedPlateau = new Plateau(testPlateauSize);
        expectedPlateau.addRoverToPlateau(testRover1, testPosition1);

        testPlateau.addRoverToPlateau(testRover1, testPosition1);

        //Act
        testPlateau.removeRoverFromPlateau(testRover2);

        //Assert
        assertEquals(expectedPlateau.getPlateauRoverPositions(), testPlateau.getPlateauRoverPositions());
    }

    @Test
    @DisplayName("removeRoverFromPlateau updates correctly when passed appropriate rover")
    void testRemoveRoverFromPlateauAppropriateRover() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1,2, Direction.N);

        Rover testRover2 = new Rover();
        Position testPosition2 = new Position(3,4, Direction.N);

        Plateau expectedPlateau = new Plateau(testPlateauSize);
        expectedPlateau.addRoverToPlateau(testRover1, testPosition1);

        testPlateau.addRoverToPlateau(testRover1, testPosition1);
        testPlateau.addRoverToPlateau(testRover2, testPosition2);

        //Act
        testPlateau.removeRoverFromPlateau(testRover2);

        //Assert
        assertEquals(expectedPlateau.getPlateauRoverPositions(), testPlateau.getPlateauRoverPositions());
    }


    @Test
    @DisplayName("removeRoverFromPlateau updates first time, but not subsequent times when passed same rover with different positions consecutively")
    void testRemoveRoverFromPlateauSameConsecutive() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1,2, Direction.N);

        Rover testRover2 = new Rover();
        Position testPosition2 = new Position(3,4, Direction.N);

        Plateau expectedPlateau = new Plateau(testPlateauSize);
        expectedPlateau.addRoverToPlateau(testRover1, testPosition1);

        testPlateau.addRoverToPlateau(testRover1, testPosition1);
        testPlateau.addRoverToPlateau(testRover2, testPosition2);

        //Act
        testPlateau.removeRoverFromPlateau(testRover2);
        testPlateau.removeRoverFromPlateau(testRover2);
        testPlateau.removeRoverFromPlateau(testRover2);

        //Assert
        assertEquals(expectedPlateau.getPlateauRoverPositions(), testPlateau.getPlateauRoverPositions());
    }

    @Test
    @DisplayName("removeRoverFromPlateau updates correctly when passed different rovers consecutively")
    void testRemoveRoverFromPlateauDifferentConsecutive() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1,2, Direction.N);

        Rover testRover2 = new Rover();
        Position testPosition2 = new Position(3,4, Direction.N);

        Rover testRover3 = new Rover();
        Position testPosition3 = new Position(3,4, Direction.N);

        Rover testRover4 = new Rover();
        Position testPosition4 = new Position(3,4, Direction.N);

        Plateau expectedPlateau = new Plateau(testPlateauSize);
        expectedPlateau.addRoverToPlateau(testRover1, testPosition1);

        testPlateau.addRoverToPlateau(testRover1, testPosition1);
        testPlateau.addRoverToPlateau(testRover2, testPosition2);
        testPlateau.addRoverToPlateau(testRover3, testPosition3);
        testPlateau.addRoverToPlateau(testRover4, testPosition4);

        //Act
        testPlateau.removeRoverFromPlateau(testRover2);
        testPlateau.removeRoverFromPlateau(testRover3);
        testPlateau.removeRoverFromPlateau(testRover4);

        //Assert
        assertEquals(expectedPlateau.getPlateauRoverPositions(), testPlateau.getPlateauRoverPositions());
    }

//    updateRoverXCoordinate
    // Cannot test if rover is null, or position is null, as addRoverToPlateau will not allow null rovers or
    // positions to be added

    @Test
    @DisplayName("updateRoverXCoordinate makes no update when rover is null")
    void testUpdateRoverXCoordinateNullRover() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addRoverToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateRoverXCoordinate(null, 2);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("updateRoverXCoordinate makes no update when rover is not in plateauRoverPositions")
    void testUpdateRoverXCoordinateMissingRover() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1,2, Direction.N);

        testPlateau.addRoverToPlateau(testRover1, testPosition1);
        Rover testRover2 = new Rover();

        //Act
        testPlateau.updateRoverXCoordinate(testRover2, 2);

        //Assert
        assertAll(
                () -> assertNull(testPlateau.getPlateauRoverPositions().get(testRover2)),
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover1).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover1).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover1).getDirection())
        );
    }

    @Test
    @DisplayName("updateRoverXCoordinate updates correctly when passed appropriate rover and positive increment")
    void testUpdateRoverXCoordinateAppropriateRoverAndPositiveIncrement() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addRoverToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateRoverXCoordinate(testRover, 2);

        //Assert
        assertAll(
                () -> assertEquals(3, testPlateau.getPlateauRoverPositions().get(testRover).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("updateRoverXCoordinate updates correctly when passed appropriate rover and negative increment")
    void testUpdateRoverXCoordinateAppropriateRoverAndNegativeIncrement() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(5,2, Direction.N);

        testPlateau.addRoverToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateRoverXCoordinate(testRover, -3);

        //Assert
        assertAll(
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("updateRoverXCoordinate updates correctly when passed consecutively updates")
    void testUpdateRoverXCoordinateConsecutive() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(20,20);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addRoverToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateRoverXCoordinate(testRover, 3);
        testPlateau.updateRoverXCoordinate(testRover, 4);
        testPlateau.updateRoverXCoordinate(testRover, -1);
        testPlateau.updateRoverXCoordinate(testRover, -2);


        //Assert
        assertAll(
                () -> assertEquals(5, testPlateau.getPlateauRoverPositions().get(testRover).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("updateRoverXCoordinate does not update when increment would take the Rover off the Plateau")
    void testUpdateRoverXIncrementOffPlateau() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1,2, Direction.N);

        Rover testRover2 = new Rover();
        Position testPosition2 = new Position(3,3, Direction.S);

        testPlateau.addRoverToPlateau(testRover1, testPosition1);
        testPlateau.addRoverToPlateau(testRover2, testPosition2);

        //Act
        testPlateau.updateRoverXCoordinate(testRover1, 6);
        testPlateau.updateRoverXCoordinate(testRover2, -4);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover1).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover1).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover1).getDirection()),

                () -> assertEquals(3, testPlateau.getPlateauRoverPositions().get(testRover2).getX()),
                () -> assertEquals(3, testPlateau.getPlateauRoverPositions().get(testRover2).getY()),
                () -> assertEquals(Direction.S, testPlateau.getPlateauRoverPositions().get(testRover2).getDirection())
        );
    }

//    updateRoverYCoordinate
    // Cannot test if rover is null, or position is null, as addRoverToPlateau will not allow null rovers or
    // positions to be added

    @Test
    @DisplayName("updateRoverYCoordinate makes no update when rover is null")
    void testUpdateRoverYCoordinateNullRover() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addRoverToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateRoverYCoordinate(null, 2);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("updateRoverYCoordinate makes no update when rover is not in plateauRoverPositions")
    void testUpdateRoverYCoordinateMissingRover() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1,2, Direction.N);

        testPlateau.addRoverToPlateau(testRover1, testPosition1);
        Rover testRover2 = new Rover();

        //Act
        testPlateau.updateRoverYCoordinate(testRover2, 2);

        //Assert
        assertAll(
                () -> assertNull(testPlateau.getPlateauRoverPositions().get(testRover2)),
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover1).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover1).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover1).getDirection())
        );
    }

    @Test
    @DisplayName("updateRoverYCoordinate updates correctly when passed appropriate rover and positive increment")
    void testUpdateRoverYCoordinateAppropriateRoverAndPositiveIncrement() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addRoverToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateRoverYCoordinate(testRover, 3);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover).getX()),
                () -> assertEquals(5, testPlateau.getPlateauRoverPositions().get(testRover).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("updateRoverYCoordinate updates correctly when passed appropriate rover and negative increment")
    void testUpdateRoverYCoordinateAppropriateRoverAndNegativeIncrement() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addRoverToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateRoverYCoordinate(testRover, -2);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover).getX()),
                () -> assertEquals(0, testPlateau.getPlateauRoverPositions().get(testRover).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("updateRoverYCoordinate updates correctly when passed consecutively updates")
    void testUpdateRoverYCoordinateConsecutive() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(10,10);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addRoverToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateRoverYCoordinate(testRover, 3);
        testPlateau.updateRoverYCoordinate(testRover, 4);
        testPlateau.updateRoverYCoordinate(testRover, -1);
        testPlateau.updateRoverYCoordinate(testRover, -2);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover).getX()),
                () -> assertEquals(6, testPlateau.getPlateauRoverPositions().get(testRover).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("updateRoverYCoordinate does not update when passed coordinate which would take the Rover off the Plateau")
    void testUpdateRoverYCoordinateOffPlateau() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1,2, Direction.N);

        Rover testRover2 = new Rover();
        Position testPosition2 = new Position(3,3, Direction.S);

        testPlateau.addRoverToPlateau(testRover1, testPosition1);
        testPlateau.addRoverToPlateau(testRover2, testPosition2);

        //Act
        testPlateau.updateRoverYCoordinate(testRover1, 6);
        testPlateau.updateRoverYCoordinate(testRover2, -6);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover1).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover1).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover1).getDirection()),

                () -> assertEquals(3, testPlateau.getPlateauRoverPositions().get(testRover2).getX()),
                () -> assertEquals(3, testPlateau.getPlateauRoverPositions().get(testRover2).getY()),
                () -> assertEquals(Direction.S, testPlateau.getPlateauRoverPositions().get(testRover2).getDirection())
        );
    }

//    updateRoverDirection
    // Cannot test if rover is null, or position is null, as addRoverToPlateau will not allow null rovers or
    // positions to be added

    @Test
    @DisplayName("updateRoverDirection makes no update when rover is null")
    void testUpdateRoverDirectionNullRover() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addRoverToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateRoverDirection(null, Direction.S);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("updateRoverDirection makes no update when Direction is null")
    void testUpdateRoverDirectionNullDirection() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addRoverToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateRoverDirection(testRover, null);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("updateRoverDirection makes no update when rover is not in plateauRoverPositions")
    void testUpdateRoverDirectionMissingRover() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1,2, Direction.N);

        testPlateau.addRoverToPlateau(testRover1, testPosition1);
        Rover testRover2 = new Rover();

        //Act
        testPlateau.updateRoverDirection(testRover2, Direction.E);

        //Assert
        assertAll(
                () -> assertNull(testPlateau.getPlateauRoverPositions().get(testRover2)),
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover1).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover1).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover1).getDirection())
        );
    }

    @Test
    @DisplayName("updateRoverDirection makes no update when passed y coordinate which is the same as the current y coordinate for the rover")
    void testUpdateRoverDirectionSame() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addRoverToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateRoverDirection(testRover, Direction.N);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("updateRoverDirection updates correctly when passed appropriate rover and coordinate")
    void testUpdateRoverDirectionAppropriateRoverAndDirection() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addRoverToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateRoverDirection(testRover, Direction.S);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover).getY()),
                () -> assertEquals(Direction.S, testPlateau.getPlateauRoverPositions().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("updateRoverDirection updates correctly when passed consecutively updates")
    void testUpdateRoverDirectionConsecutive() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addRoverToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateRoverDirection(testRover, Direction.E);
        testPlateau.updateRoverDirection(testRover, Direction.W);
        testPlateau.updateRoverDirection(testRover, Direction.S);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover).getY()),
                () -> assertEquals(Direction.S, testPlateau.getPlateauRoverPositions().get(testRover).getDirection())
        );
    }

}