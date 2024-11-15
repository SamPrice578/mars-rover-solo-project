package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


class PlateauTest {

    @Test
    @DisplayName("makes no update when item is null")
    void testAddItemToPlateauNullItem() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);
        Rover testRover = null;
        Position testPosition = new Position(1,2, Direction.N);

        Plateau expectedPlateau = new Plateau(testPlateauSize);

        //Act
        testPlateau.addItemToPlateau(testRover, testPosition);

        //Assert
        assertEquals(expectedPlateau.getPlateauItems(), testPlateau.getPlateauItems());
    }

    @Test
    @DisplayName("makes no update when position is null")
    void testAddItemToPlateauNullPosition() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);
        Rover testRover = new Rover();
        Position testPosition = null;

        Plateau expectedPlateau = new Plateau(testPlateauSize);

        //Act
        testPlateau.addItemToPlateau(testRover, testPosition);

        //Assert
        assertEquals(expectedPlateau.getPlateauItems(), testPlateau.getPlateauItems());
    }

    @Test
    @DisplayName("updates correctly when passed appropriate item and position")
    void testAddItemToPlateauAppropriateItemAndPosition() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);
        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        //Act
        testPlateau.addItemToPlateau(testRover, testPosition);

        //Assert
        assertEquals(testPlateau.getPlateauItems().get(testRover), testPosition);
    }


    @Test
    @DisplayName("updates correctly when passed same item with different positions consecutively")
    void testAddItemToPlateausameItemsDiffferentPositionsConsecutive() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();

        Position testPosition1 = new Position(1,2, Direction.N);
        Position testPosition2 = new Position(2,3, Direction.N);
        Position testPosition3 = new Position(3,4, Direction.N);

        //Act
        testPlateau.addItemToPlateau(testRover, testPosition1);
        testPlateau.addItemToPlateau(testRover, testPosition2);
        testPlateau.addItemToPlateau(testRover, testPosition3);

        //Assert
        assertEquals(testPlateau.getPlateauItems().get(testRover), testPosition3);
    }

    @Test
    @DisplayName("updates correctly when passed different items and positions consecutively")
    void testAddItemToPlateauDifferentItemsAndPositionsConsecutive() {
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
        testPlateau.addItemToPlateau(testRover1, testPosition1);
        testPlateau.addItemToPlateau(testRover2, testPosition2);
        testPlateau.addItemToPlateau(testRover3, testPosition3);

        //Assert
        assertEquals(testPlateau.getPlateauItems().get(testRover1), testPosition1);
        assertEquals(testPlateau.getPlateauItems().get(testRover2), testPosition2);
        assertEquals(testPlateau.getPlateauItems().get(testRover3), testPosition3);
    }

//    removeItemFromPlateau

    @Test
    @DisplayName("makes no update when item is null")
    void testRemoveItemFromPlateauNullItem() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        Rover nullRover = null;

        Plateau expectedPlateau = new Plateau(testPlateauSize);
        expectedPlateau.addItemToPlateau(testRover, testPosition);

        testPlateau.addItemToPlateau(testRover, testPosition);

        //Act
        testPlateau.removeItemFromPlateau(nullRover);

        //Assert
        assertEquals(expectedPlateau.getPlateauItems(), testPlateau.getPlateauItems());
    }

    @Test
    @DisplayName("makes no update if item does not exist in plateauItems")
    void testRemoveItemFromPlateauNonExistentItemItem() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1,2, Direction.N);

        Rover testRover2 = new Rover();

        Plateau expectedPlateau = new Plateau(testPlateauSize);
        expectedPlateau.addItemToPlateau(testRover1, testPosition1);

        testPlateau.addItemToPlateau(testRover1, testPosition1);

        //Act
        testPlateau.removeItemFromPlateau(testRover2);

        //Assert
        assertEquals(expectedPlateau.getPlateauItems(), testPlateau.getPlateauItems());
    }

    @Test
    @DisplayName("updates correctly when passed appropriate item")
    void testRemoveItemFromPlateauAppropriateItem() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1,2, Direction.N);

        Rover testRover2 = new Rover();
        Position testPosition2 = new Position(3,4, Direction.N);

        Plateau expectedPlateau = new Plateau(testPlateauSize);
        expectedPlateau.addItemToPlateau(testRover1, testPosition1);

        testPlateau.addItemToPlateau(testRover1, testPosition1);
        testPlateau.addItemToPlateau(testRover2, testPosition2);

        //Act
        testPlateau.removeItemFromPlateau(testRover2);

        //Assert
        assertEquals(expectedPlateau.getPlateauItems(), testPlateau.getPlateauItems());
    }


    @Test
    @DisplayName("updates first time, but not subsequent times when passed same item with different consecutively")
    void testRemoveItemFromPlateauSameConsecutive() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1,2, Direction.N);

        Rover testRover2 = new Rover();
        Position testPosition2 = new Position(3,4, Direction.N);

        Plateau expectedPlateau = new Plateau(testPlateauSize);
        expectedPlateau.addItemToPlateau(testRover1, testPosition1);

        testPlateau.addItemToPlateau(testRover1, testPosition1);
        testPlateau.addItemToPlateau(testRover2, testPosition2);

        //Act
        testPlateau.removeItemFromPlateau(testRover2);
        testPlateau.removeItemFromPlateau(testRover2);
        testPlateau.removeItemFromPlateau(testRover2);

        //Assert
        assertEquals(expectedPlateau.getPlateauItems(), testPlateau.getPlateauItems());
    }

    @Test
    @DisplayName("updates correctly when passed different items consecutively")
    void testRemoveItemFromPlateauDifferentConsecutive() {
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
        expectedPlateau.addItemToPlateau(testRover1, testPosition1);

        testPlateau.addItemToPlateau(testRover1, testPosition1);
        testPlateau.addItemToPlateau(testRover2, testPosition2);
        testPlateau.addItemToPlateau(testRover3, testPosition3);
        testPlateau.addItemToPlateau(testRover4, testPosition4);

        //Act
        testPlateau.removeItemFromPlateau(testRover2);
        testPlateau.removeItemFromPlateau(testRover3);
        testPlateau.removeItemFromPlateau(testRover4);

        //Assert
        assertEquals(expectedPlateau.getPlateauItems(), testPlateau.getPlateauItems());
    }

//    updateItemXCoordinate
    // Cannot test if item is null, or position is null, as addItemToPlateau will not allow null items or
    // positions to be added

    @Test
    @DisplayName("makes no update when item is null")
    void testUpdateItemXCoordinateNullItem() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addItemToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateItemXCoordinate(null, 2);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauItems().get(testRover).getX()),
                () -> assertEquals(2, testPlateau.getPlateauItems().get(testRover).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauItems().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("makes no update when item is not in plateauItems")
    void testUpdateItemXCoordinateMissingItem() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1,2, Direction.N);

        Rover testRover2 = new Rover();

        Map<Plateauable, Position> expectedHashMap = new HashMap<>();
        expectedHashMap.put(testRover1, testPosition1);

        //Act
        testPlateau.updateItemXCoordinate(testRover2, 2);

        //Assert
        assertEquals(expectedHashMap, testPlateau.getPlateauItems());
    }

    @Test
    @DisplayName("makes no update when passed y coordinate which is the same as the current y coordinate for the item")
    void testUpdateItemXCoordinateSame() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addItemToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateItemXCoordinate(testRover, 1);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauItems().get(testRover).getX()),
                () -> assertEquals(2, testPlateau.getPlateauItems().get(testRover).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauItems().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("updates correctly when passed appropriate item and coordinate")
    void testUpdateItemXCoordinateAppropriateItemAndCoordinate() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addItemToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateItemXCoordinate(testRover, 2);

        //Assert
        assertAll(
                () -> assertEquals(2, testPlateau.getPlateauItems().get(testRover).getX()),
                () -> assertEquals(2, testPlateau.getPlateauItems().get(testRover).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauItems().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("updates correctly when passed consecutively updates")
    void testUpdateItemXCoordinateConsecutive() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addItemToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateItemXCoordinate(testRover, 2);
        testPlateau.updateItemXCoordinate(testRover, 3);
        testPlateau.updateItemXCoordinate(testRover, 4);

        //Assert
        assertAll(
                () -> assertEquals(4, testPlateau.getPlateauItems().get(testRover).getX()),
                () -> assertEquals(2, testPlateau.getPlateauItems().get(testRover).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauItems().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("does not update when passed coordinate which would take the Rover off the Plateau")
    void testUpdateItemXCoordinateOffPlateau() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1,2, Direction.N);

        Rover testRover2 = new Rover();
        Position testPosition2 = new Position(3,3, Direction.S);

        testPlateau.addItemToPlateau(testRover1, testPosition1);
        testPlateau.addItemToPlateau(testRover2, testPosition2);

        //Act
        testPlateau.updateItemXCoordinate(testRover1, 6);
        testPlateau.updateItemXCoordinate(testRover2, -1);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauItems().get(testRover1).getX()),
                () -> assertEquals(2, testPlateau.getPlateauItems().get(testRover1).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauItems().get(testRover1).getDirection()),

                () -> assertEquals(3, testPlateau.getPlateauItems().get(testRover2).getX()),
                () -> assertEquals(3, testPlateau.getPlateauItems().get(testRover2).getY()),
                () -> assertEquals(Direction.S, testPlateau.getPlateauItems().get(testRover2).getDirection())
        );
    }

//    updateItemYCoordinate
    // Cannot test if item is null, or position is null, as addItemToPlateau will not allow null items or
    // positions to be added

    @Test
    @DisplayName("makes no update when item is null")
    void testUpdateItemYCoordinateNullItem() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addItemToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateItemYCoordinate(null, 2);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauItems().get(testRover).getX()),
                () -> assertEquals(2, testPlateau.getPlateauItems().get(testRover).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauItems().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("makes no update when item is not in plateauItems")
    void testUpdateItemYCoordinateMissingItem() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1,2, Direction.N);

        Rover testRover2 = new Rover();

        Map<Plateauable, Position> expectedHashMap = new HashMap<>();
        expectedHashMap.put(testRover1, testPosition1);

        //Act
        testPlateau.updateItemYCoordinate(testRover2, 2);

        //Assert
        assertEquals(expectedHashMap, testPlateau.getPlateauItems());
    }

    @Test
    @DisplayName("makes no update when passed y coordinate which is the same as the current y coordinate for the item")
    void testUpdateItemYCoordinateSame() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addItemToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateItemYCoordinate(testRover, 2);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauItems().get(testRover).getX()),
                () -> assertEquals(2, testPlateau.getPlateauItems().get(testRover).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauItems().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("updates correctly when passed appropriate item and coordinate")
    void testUpdateItemYCoordinateAppropriateItemAndCoordinate() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addItemToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateItemYCoordinate(testRover, 3);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauItems().get(testRover).getX()),
                () -> assertEquals(3, testPlateau.getPlateauItems().get(testRover).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauItems().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("updates correctly when passed consecutively updates")
    void testUpdateItemYCoordinateConsecutive() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addItemToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateItemYCoordinate(testRover, 3);
        testPlateau.updateItemYCoordinate(testRover, 4);
        testPlateau.updateItemYCoordinate(testRover, 5);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauItems().get(testRover).getX()),
                () -> assertEquals(5, testPlateau.getPlateauItems().get(testRover).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauItems().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("does not update when passed coordinate which would take the Rover off the Plateau")
    void testUpdateItemYCoordinateOffPlateau() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1,2, Direction.N);

        Rover testRover2 = new Rover();
        Position testPosition2 = new Position(3,3, Direction.S);

        testPlateau.addItemToPlateau(testRover1, testPosition1);
        testPlateau.addItemToPlateau(testRover2, testPosition2);

        //Act
        testPlateau.updateItemYCoordinate(testRover1, 6);
        testPlateau.updateItemYCoordinate(testRover2, -1);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauItems().get(testRover1).getX()),
                () -> assertEquals(2, testPlateau.getPlateauItems().get(testRover1).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauItems().get(testRover1).getDirection()),

                () -> assertEquals(3, testPlateau.getPlateauItems().get(testRover2).getX()),
                () -> assertEquals(3, testPlateau.getPlateauItems().get(testRover2).getY()),
                () -> assertEquals(Direction.S, testPlateau.getPlateauItems().get(testRover2).getDirection())
        );
    }

//    updateItemDirection
    // Cannot test if item is null, or position is null, as addItemToPlateau will not allow null items or
    // positions to be added

    @Test
    @DisplayName("makes no update when item is null")
    void testUpdateItemDirectionNullItem() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addItemToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateItemDirection(null, Direction.S);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauItems().get(testRover).getX()),
                () -> assertEquals(2, testPlateau.getPlateauItems().get(testRover).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauItems().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("makes no update when Direction is null")
    void testUpdateItemDirectionNullDirection() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addItemToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateItemDirection(testRover, null);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauItems().get(testRover).getX()),
                () -> assertEquals(2, testPlateau.getPlateauItems().get(testRover).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauItems().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("makes no update when item is not in plateauItems")
    void testUpdateItemDirectionMissingItem() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1,2, Direction.N);

        Rover testRover2 = new Rover();

        Map<Plateauable, Position> expectedHashMap = new HashMap<>();
        expectedHashMap.put(testRover1, testPosition1);

        //Act
        testPlateau.updateItemDirection(testRover2, Direction.E);

        //Assert
        assertEquals(expectedHashMap, testPlateau.getPlateauItems());
    }

    @Test
    @DisplayName("makes no update when passed y coordinate which is the same as the current y coordinate for the item")
    void testUpdateItemDirectionSame() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addItemToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateItemDirection(testRover, Direction.N);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauItems().get(testRover).getX()),
                () -> assertEquals(2, testPlateau.getPlateauItems().get(testRover).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauItems().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("updates correctly when passed appropriate item and coordinate")
    void testUpdateItemDirectionAppropriateItemAndDirection() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addItemToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateItemDirection(testRover, Direction.S);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauItems().get(testRover).getX()),
                () -> assertEquals(3, testPlateau.getPlateauItems().get(testRover).getY()),
                () -> assertEquals(Direction.S, testPlateau.getPlateauItems().get(testRover).getDirection())
        );
    }

    @Test
    @DisplayName("updates correctly when passed consecutively updates")
    void testUpdateItemDirectionConsecutive() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover();
        Position testPosition = new Position(1,2, Direction.N);

        testPlateau.addItemToPlateau(testRover, testPosition);

        //Act
        testPlateau.updateItemDirection(testRover, Direction.E);
        testPlateau.updateItemDirection(testRover, Direction.W);
        testPlateau.updateItemDirection(testRover, Direction.S);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauItems().get(testRover).getX()),
                () -> assertEquals(2, testPlateau.getPlateauItems().get(testRover).getY()),
                () -> assertEquals(Direction.S, testPlateau.getPlateauItems().get(testRover).getDirection())
        );
    }

}