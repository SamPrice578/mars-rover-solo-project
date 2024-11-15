package org.example;

import org.example.UI.UI;
import org.example.mapping.Plateau;
import org.example.rovers.Rover;
import org.example.parsing.*;
import org.example.setup.PlateauInitialiser;
import org.example.instruction.RoverInstructor;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UI.introductoryMessage();

        String initialPlateauDimensionsInput = UI.inputInitialDimensions(scanner);

        String initialRoverPositionInput = UI.inputInitialRoverPosition(scanner);

        String roverInstructionsinput = UI.inputRoverInstructions(scanner);

        int initialXDimension = PlateauInitialisationParser.extractXDimension(initialPlateauDimensionsInput);
        int initialYDimension = PlateauInitialisationParser.extractYDimension(initialPlateauDimensionsInput);

        int initialXCoordinate = RoverInitialPositionParser.extractXCoordinate(initialRoverPositionInput);
        int initialYCoordinate = RoverInitialPositionParser.extractYCoordinate(initialRoverPositionInput);
        Direction initialDirection = RoverInitialPositionParser.extractDirection(initialRoverPositionInput);

        ArrayList<Instruction> instructions = RoverInstructionParser.parseRoverInstruction(roverInstructionsinput);

        Plateau plateau = PlateauInitialiser.initialisePlateau(initialXDimension, initialYDimension);
        Rover rover = PlateauInitialiser.addRoverToPlateau(plateau, initialXCoordinate, initialYCoordinate, initialDirection);

        RoverInstructor.instructRover(rover, plateau, instructions);

        UI.concludingMessage();

        scanner.close();
    }
}