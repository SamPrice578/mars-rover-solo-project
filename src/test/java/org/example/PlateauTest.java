package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


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
        Rover testRover = new Rover(testPlateau);
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
        Rover testRover = new Rover(testPlateau);
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

        Rover testRover = new Rover(testPlateau);

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

        Rover testRover1 = new Rover(testPlateau);
        Rover testRover2 = new Rover(testPlateau);
        Rover testRover3 = new Rover(testPlateau);

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

    @Test
    @DisplayName("makes no update when item is null")
    void testRemoveItemFromPlateauNullItem() {
        //Arrange
        PlateauSize testPlateauSize = new PlateauSize(5,5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover = new Rover(testPlateau);
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

        Rover testRover1 = new Rover(testPlateau);
        Position testPosition1 = new Position(1,2, Direction.N);

        Rover testRover2 = new Rover(testPlateau);

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

        Rover testRover1 = new Rover(testPlateau);
        Position testPosition1 = new Position(1,2, Direction.N);

        Rover testRover2 = new Rover(testPlateau);
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

        Rover testRover1 = new Rover(testPlateau);
        Position testPosition1 = new Position(1,2, Direction.N);

        Rover testRover2 = new Rover(testPlateau);
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

        Rover testRover1 = new Rover(testPlateau);
        Position testPosition1 = new Position(1,2, Direction.N);

        Rover testRover2 = new Rover(testPlateau);
        Position testPosition2 = new Position(3,4, Direction.N);

        Rover testRover3 = new Rover(testPlateau);
        Position testPosition3 = new Position(3,4, Direction.N);

        Rover testRover4 = new Rover(testPlateau);
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
}