package org.example.parse;

public class PlateauInitialisationParser {
    public static int extractXDimension(String input){
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

    public static int extractYDimension(String input){

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

}
