package org.example.parse;

public class RoverInitialPositionParser {
    public static int extractXCoordinate(String input){

        int defaultValue = 0;

        if (input == null) {
            return defaultValue;
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
        return defaultValue;
    };

    public static int extractYCoordinate(String input){

        int defaultValue = 0;

        if (input == null) {
            return defaultValue;
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
        return defaultValue;
    };

    public static Direction extractDirection(String input) {

        Direction defaultValue = Direction.N;

        if (input == null) {
            return defaultValue;
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

        return defaultValue;
    }
}
