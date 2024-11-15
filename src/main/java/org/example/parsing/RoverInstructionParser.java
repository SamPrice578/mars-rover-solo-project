package org.example.parsing;

import org.example.Direction;
import org.example.Instruction;

import java.util.ArrayList;
import java.util.List;

public class RoverInstructionParser {

    public static ArrayList<Instruction> parseRoverInstruction(String input){

        ArrayList<Instruction> instructions = new ArrayList<>();

        if (input == null || input.isEmpty() || input.isBlank()) {
            return instructions;
        }

        String[] splitInput = input.split(" ");

        for (String string : splitInput) {
            switch (string.toUpperCase()) {
                case "L":
                    instructions.add(Instruction.L);
                    break;
                case "R":
                    instructions.add(Instruction.R);
                    break;
                case "M":
                    instructions.add(Instruction.M);
                    break;
                default:
                    break;
            }
        }

        return instructions;
    };
}
