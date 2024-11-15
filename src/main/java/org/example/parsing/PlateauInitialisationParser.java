package org.example.parsing;

import java.util.ArrayList;
import java.util.Arrays;

public class PlateauInitialisationParser {
    public static int extractXDimension(String input){

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

    public static int extractYDimension(String input){

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

}
