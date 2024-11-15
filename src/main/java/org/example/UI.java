package org.example;

import org.example.parsing.PlateauInitialisationParser;
import org.example.parsing.RoverInitialPositionParser;
import org.example.parsing.RoverInstructionParser;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class UI {
    public static String inputInitialDimensions(Scanner scanner) {

        PlateauInitialisationParser plateauInitialisationParser = new PlateauInitialisationParser();

        boolean inputIsConfirmed = false;

        while(!inputIsConfirmed) {
            System.out.println("Please enter your Plateau's initial dimensions in the format: " +
                    "x-dimension y-dimension e.g. 5 5");
            System.out.println("Please note: only positive integers will be accepted.  Any other value will be ignored. " +
                    "If no valid input is received, value will default to 0.");
            String provisionalInput = scanner.nextLine();
            int provisionalXDimension = plateauInitialisationParser.extractXDimension(provisionalInput);
            int provisionalYDimension = plateauInitialisationParser.extractYDimension(provisionalInput);

            System.out.println("The input will be interpreted by the parser as follows:");
            System.out.println("Plateau initial X dimension: " + provisionalXDimension);
            System.out.println("Plateau initial Y dimension: " + provisionalYDimension);
            System.out.println("If you are happy to submit these values, enter Y, otherwise enter N.  If you enter N " +
                    "You will be prompted again to enter your Plateau's initial dimensions.");

            if(confirmInput(scanner)) {
                System.out.println("Plateau initial dimensions input successfully.");
                System.out.println();
                return provisionalInput;
            } else {
            }
        }
        return "";
    }

    public static String inputInitialRoverPosition(Scanner scanner) {

        RoverInitialPositionParser roverInitialPositionParser = new RoverInitialPositionParser();

        boolean inputIsConfirmed = false;

        while(!inputIsConfirmed) {
            System.out.println("Please enter your Rover's initial position in the format: " +
                    "x-coordinate y-coordinate direction.  The available directions are N (North), E (East), " +
                    "S (South) or W (West) e.g. 2 3 W");
            System.out.println("Please note: only positive integers and valid directions will be accepted.  Any " +
                    "other value will be ignored. valid directions, will be ignored. If no valid coordinate input " +
                    "is received, value will default to 0.  If no valid direction input is " +
                    "received, direction will default to N");
            String provisionalInput = scanner.nextLine();
            int provisionalXCoordinate = roverInitialPositionParser.extractXCoordinate(provisionalInput);
            int provisionalYCoordinate = roverInitialPositionParser.extractYCoordinate(provisionalInput);
            Direction provisionalDirection = roverInitialPositionParser.extractDirection(provisionalInput);

            System.out.println("The input will be interpreted by the parser as follows:");
            System.out.println("Rover initial X coordinate: " + provisionalXCoordinate);
            System.out.println("Rover initial Y coordinate: " + provisionalYCoordinate);
            System.out.println("Rover initial direction: " + provisionalDirection);
            System.out.println("If you are happy to submit these values, enter Y, otherwise enter N.  If you enter N " +
                    "You will be prompted again to enter your Plateau's initial dimensions.");

            if(confirmInput(scanner)) {
                System.out.println("Rover initial position input successfully.");
                System.out.println();
                return provisionalInput;
            } else {
                break;
            }
        }
        return "";
    }

    public static String inputRoverInstructions(Scanner scanner) {

        RoverInstructionParser roverInstructionParser = new RoverInstructionParser();

        boolean inputIsConfirmed = false;

        while(!inputIsConfirmed) {
            System.out.println("Please enter your Rover's instruction in the format: " +
                    "instruction instruction instruction etc.  The available instructions are L (turn left i.e. " +
                    "rotate 90 degrees anti-clockwise), R (turn right i.e. rotate 90 degrees clockwise), " +
                    "M (move i.e. move one coordinate point in the direction the Rover is facing) " +
                    "e.g. L M R M L L M M M");
            System.out.println("Please note: all invalid instructions are ignored by the parser.");
            String provisionalInput = scanner.nextLine();
            ArrayList<Instruction> provisionalInstructions = roverInstructionParser.parseRoverInstruction(provisionalInput);

            System.out.println("The input will be interpreted by the parser as follows:");
            System.out.println("Rover instructions: " + provisionalInstructions);
            System.out.println("If you are happy to submit these values, enter Y, otherwise enter N.  If you enter N " +
                    "You will be prompted again to enter your Plateau's initial dimensions.");

            if(confirmInput(scanner)) {
                System.out.println("Rover instructions input successfully.");
                System.out.println();
                return provisionalInput;
            } else {
                break;
            }
        }
        return "";
    }

    private static boolean confirmInput(Scanner scanner) {
        boolean isValidInput = false;
        while (!isValidInput) {
            String input = scanner.nextLine().toUpperCase();
            if(input.equals("Y")) {
                return true;
            } else if (input.equals("N")) {
                return false;
            } else {
                System.out.println("Input not recognised.  Please enter the single character 'Y' or 'N'");
            }
        }
        return false;
    }
}
