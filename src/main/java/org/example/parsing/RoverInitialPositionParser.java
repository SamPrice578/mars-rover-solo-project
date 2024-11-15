package org.example.parsing;

import org.example.Direction;

public class RoverInitialPositionParser {
    public static int extractXCoordinate(String input){

        if (input == null) {
            return 0;
        }

        String[] splitInput = input.split(" ");

        for (String string : splitInput) {
            try {
                int stringAsInteger = Integer.parseInt(string);
                if (stringAsInteger > 0) {
                    return stringAsInteger;
                }
            } catch (NumberFormatException e) {
                //do nothing
            }
        }
        return 0;
    };

    public static int extractYCoordinate(String input){

        if (input == null) {
            return 0;
        }

        String[] splitInput = input.split(" ");

        int counter = 0;

        for (String string : splitInput) {
            try {
                int stringAsInteger = Integer.parseInt(string);
                if (stringAsInteger > 0) {
                    if (counter == 1) {
                        return stringAsInteger;
                    } else {
                        counter ++;
                    }
                }
            } catch (NumberFormatException e) {
                //do nothing
            }
        }
        return 0;
    };

    public static Direction extractDirection(String input) {

        if (input == null) {
            return Direction.N;
        }

        String[] splitInput = input.split(" ");

        for (String string : splitInput) {
            switch (string.toUpperCase()) {
                case "N":
                    return Direction.N;
                case "E":
                    return Direction.E;
                case "S":
                    return Direction.S;
                case "W":
                    return Direction.W;
                default:
                    break;
            }
        }

        return Direction.N;
    }
}
