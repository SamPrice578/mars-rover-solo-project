package org.example;

import org.example.parsing.PlateauInitialisationParser;
import org.example.parsing.RoverInitialPositionParser;
import org.example.parsing.RoverInstructionParser;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String initialPlateauDimensionsInput = UI.inputInitialDimensions(scanner);

        String initialRoverPositionInput = UI.inputInitialRoverPosition(scanner);

        String roverInstructionsinput = UI.inputRoverInstructions(scanner);

        System.out.println("Initialising Plateau...");

        int initialXDimension = PlateauInitialisationParser.extractXDimension(initialPlateauDimensionsInput);
        int initialYDimension = PlateauInitialisationParser.extractYDimension(initialPlateauDimensionsInput);

        System.out.println("Placing Rover on Plateau...");

        int initialXCoordinate = RoverInitialPositionParser.extractXCoordinate(initialRoverPositionInput);
        int initialYCoordinate = RoverInitialPositionParser.extractYCoordinate(initialRoverPositionInput);
        Direction initialDirection = RoverInitialPositionParser.extractDirection(initialRoverPositionInput);

        System.out.println("Processing Rover instructions...");

        ArrayList<Instruction> instructions = RoverInstructionParser.parseRoverInstruction(roverInstructionsinput);

        Plateau plateau = PlateauInitialiser.initialisePlateau(initialXDimension, initialYDimension);
        Rover rover = PlateauInitialiser.addRoverToPlateau(plateau, initialXCoordinate, initialYCoordinate, initialDirection);

        System.out.println("Instructing Rover...");
        System.out.println(instructions);
        System.out.println();
        System.out.println("Rover initial position: " + plateau.getPlateauRoverPositions().get(rover));

        RoverInstructor.instructRover(rover, plateau, instructions);
        System.out.println();

        System.out.println("Rover final position: " + plateau.getPlateauRoverPositions().get(rover));
        System.out.println("Mission complete!");
        scanner.close();
    }
}