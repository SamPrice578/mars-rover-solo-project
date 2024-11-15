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

        PlateauInitialisationParser plateauInitialisationParser = new PlateauInitialisationParser();
        RoverInitialPositionParser roverInitialPositionParser = new RoverInitialPositionParser();
        RoverInstructionParser roverInstructionParser = new RoverInstructionParser();

        int initialXDimension = plateauInitialisationParser.extractXDimension(initialPlateauDimensionsInput);
        int initialYDimension = plateauInitialisationParser.extractYDimension(initialPlateauDimensionsInput);

        System.out.println("Placing Rover on Plateau...");

        int initialXCoordinate = roverInitialPositionParser.extractXCoordinate(initialRoverPositionInput);
        int initialYCoordinate = roverInitialPositionParser.extractYCoordinate(initialRoverPositionInput);
        Direction initialDirection = roverInitialPositionParser.extractDirection(initialRoverPositionInput);

        System.out.println("Processing Rover instructions...");

        ArrayList<Instruction> instructions = roverInstructionParser.parseRoverInstruction(roverInstructionsinput);

        PlateauInitialiser plateauInitialiser = new PlateauInitialiser();
        RoverInstructor roverInstructor = new RoverInstructor();

        Plateau plateau = plateauInitialiser.initialisePlateau(initialXDimension, initialYDimension);
        Rover rover = plateauInitialiser.addRoverToPlateau(plateau, initialXCoordinate, initialYCoordinate, initialDirection);

        System.out.println("Instructing Rover...");
        System.out.println(instructions);
        System.out.println("Rover initial position: " + plateau.getPlateauRoverPositions().get(rover));

        roverInstructor.instructRover(rover, plateau, instructions);

        System.out.println("Rover final position: " + plateau.getPlateauRoverPositions().get(rover));

        scanner.close();
    }
}