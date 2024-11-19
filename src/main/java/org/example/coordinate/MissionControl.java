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

        //Introductory message
        System.out.println();
        System.out.println("---Welcome to the Northcoders Mars Rover Launch!---");
        System.out.println();
        System.out.println("You will soon be prompted to enter three pieces of information:");
        System.out.println("  - the size of the plateau on which your Rover will operate");
        System.out.println("  - the initial position of the rover on the plateau");
        System.out.println("  - the instructions you wish to pass to the Rover");
        System.out.println();
        System.out.println("After submission, your inputs will be processed so they can be interpreted by the mission computer");
        System.out.println();
        System.out.println("After processing, the mission will be launched:");
        System.out.println("  - the plateau dimensions will be set");
        System.out.println("  - the Rover will be placed in its initial position");
        System.out.println("  - the instructions will be sent to the Rover");
        System.out.println();
        System.out.println("A log will be printed of all the instructions sent to the rover, and the rover's updated position following completion of this instruction.");
        System.out.println("The final position of the rover will then be printed.");
        System.out.println();
        System.out.println("Let's begin!");
        System.out.println();

        //Data input
        System.out.println("---Initiating data input---");

        Scanner scanner = new Scanner(System.in);

        String initialPlateauDimensionsInput = UI.inputInitialDimensions(scanner);
        String initialRoverPositionInput = UI.inputInitialRoverPosition(scanner);
        String roverInstructionsinput = UI.inputRoverInstructions(scanner);

        scanner.close();

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

        System.out.println("---Input processing complete---");
        System.out.println();

        //Deliver instructions
        System.out.println("---Launching mission---");

        Plateau plateau = PlateauInitialiser.initialisePlateau(initialXDimension, initialYDimension);
        Rover rover = PlateauInitialiser.addRoverToPlateau(plateau, initialXCoordinate, initialYCoordinate, initialDirection);
        RoverInstructor.instructRover(rover, plateau, instructions);

        System.out.println("---Mission complete---");
        System.out.println();


    }

}
