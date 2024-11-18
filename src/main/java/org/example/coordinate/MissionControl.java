package org.example.coordinate;

import org.example.deliver.PlateauInitialiser;
import org.example.deliver.RoverInstructor;
import org.example.input.UI;
import org.example.parse.*;
import org.example.perform.Plateau;
import org.example.perform.Rover;

import java.util.ArrayList;
import java.util.Scanner;

public class MissionControl {
    public static void launch() {
        Scanner scanner = new Scanner(System.in);

        //Introductory message
        System.out.println("---Welcome to the Northcoder Mars Rover Launch!---");
        System.out.println();
        System.out.println("You will soon be prompted to enter three piece of information:");
        System.out.println("  - the size of the plateau on which your rover will operate");
        System.out.println("  - the initial position of the rover on the plateau");
        System.out.println("  - the instructions you wish to pass to the rover");
        System.out.println();
        System.out.println("Once you have confirmed your inputs, the mission will launched:");
        System.out.println("  - the plateau dimensions will be set");
        System.out.println("  - the rover will be placed in its initial position");
        System.out.println("  - the instructions will be sent to the rover");
        System.out.println();
        System.out.println("A log will be printed of all the instructions sent to the rover, and the rover's updated position having completed this instruction.");
        System.out.println("The final position of the rover will then be printed.");
        System.out.println();
        System.out.println("Let's begin!");
        System.out.println();
        System.out.println("-------------------------");
        System.out.println();

        //Data input
        System.out.println("---Initiating data input---");

        String initialPlateauDimensionsInput = UI.inputInitialDimensions(scanner);

        String initialRoverPositionInput = UI.inputInitialRoverPosition(scanner);

        String roverInstructionsinput = UI.inputRoverInstructions(scanner);

        System.out.println("---Data input complete---");
        System.out.println();

        //Parse inputs
        System.out.println("---Processing inputs---");

        int initialXDimension = PlateauInitialisationParser.extractXDimension(initialPlateauDimensionsInput);
        int initialYDimension = PlateauInitialisationParser.extractYDimension(initialPlateauDimensionsInput);

        int initialXCoordinate = RoverInitialPositionParser.extractXCoordinate(initialRoverPositionInput);
        int initialYCoordinate = RoverInitialPositionParser.extractYCoordinate(initialRoverPositionInput);
        Direction initialDirection = RoverInitialPositionParser.extractDirection(initialRoverPositionInput);

        ArrayList<Instruction> instructions = RoverInstructionParser.parseRoverInstruction(roverInstructionsinput);

        System.out.println("---Inputs processed---");
        System.out.println();

        //Deliver instructions
        System.out.println("---Delivering instructions---");

        Plateau plateau = PlateauInitialiser.initialisePlateau(initialXDimension, initialYDimension);
        Rover rover = PlateauInitialiser.addRoverToPlateau(plateau, initialXCoordinate, initialYCoordinate, initialDirection);

        RoverInstructor.instructRover(rover, plateau, instructions);

        System.out.println("---Instructions delivered---");
        System.out.println();

        //Mission complete
        System.out.println("Mission complete!");
        System.out.println();

        scanner.close();
    }

}
