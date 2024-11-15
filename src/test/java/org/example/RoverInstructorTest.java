package org.example;

import org.example.mapping.Plateau;
import org.example.mapping.PlateauSize;
import org.example.mapping.Position;
import org.example.rovers.Rover;
import org.example.parsing.Direction;
import org.example.parsing.Instruction;
import org.example.instruction.RoverInstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RoverInstructorTest {

    @Test
    @DisplayName("instructRover moves rover appropriately when passed one instruction")
    void testInstructRoverSingleInstruction() {
        //Arrange
        RoverInstructor testRoverInstructor = new RoverInstructor();

        PlateauSize testPlateauSize = new PlateauSize(5, 5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1, 1, Direction.N);

        testPlateau.addRoverToPlateau(testRover1, testPosition1);

        ArrayList<Instruction> testInstructions = new ArrayList<>();
        testInstructions.add(Instruction.M);

        //Act
        testRoverInstructor.instructRover(testRover1, testPlateau, testInstructions);

        //Assert
        assertAll(
                () -> assertEquals(1, testPlateau.getPlateauRoverPositions().get(testRover1).getX()),
                () -> assertEquals(2, testPlateau.getPlateauRoverPositions().get(testRover1).getY()),
                () -> assertEquals(Direction.N, testPlateau.getPlateauRoverPositions().get(testRover1).getDirection())
        );
    }

    @Test
    @DisplayName("instructRover moves rover appropriately when passed multiple instructions")
    void testInstructRoverMultipleInstruction() {
        //Arrange
        RoverInstructor testRoverInstructor = new RoverInstructor();

        PlateauSize testPlateauSize = new PlateauSize(5, 5);
        Plateau testPlateau = new Plateau(testPlateauSize);

        Rover testRover1 = new Rover();
        Position testPosition1 = new Position(1, 1, Direction.N);

        testPlateau.addRoverToPlateau(testRover1, testPosition1);

        ArrayList<Instruction> testInstructions = new ArrayList<>();
        testInstructions.add(Instruction.M);
        testInstructions.add(Instruction.M);
        testInstructions.add(Instruction.R);
        testInstructions.add(Instruction.M);
        testInstructions.add(Instruction.M);

        //Act
        testRoverInstructor.instructRover(testRover1, testPlateau, testInstructions);

        //Assert
        assertAll(
                () -> assertEquals(3, testPlateau.getPlateauRoverPositions().get(testRover1).getX()),
                () -> assertEquals(3, testPlateau.getPlateauRoverPositions().get(testRover1).getY()),
                () -> assertEquals(Direction.E, testPlateau.getPlateauRoverPositions().get(testRover1).getDirection())
        );
    }

}