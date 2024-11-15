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
        System.out.println("---Welcome to the Northcoder Mars Rover Launch!---");
        System.out.println();
        System.out.println("You will soon be prompted to enter three piece of information:");
        System.out.println("  - the size of the plateau on which your rover will operate");
        System.out.println("  - the initial position of the rover on the plateau");
        System.out.println("  - the instructions you wish to pass to the rover");
        System.out.println();
        System.out.println("Let's begin!");
        System.out.println();
        System.out.println("-------------------------");
        System.out.println();

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