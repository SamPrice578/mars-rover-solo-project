package org.example;

import java.sql.Array;
import java.util.ArrayList;

public class RoverInstructor {
    public void instructRover(Rover rover, Plateau plateau, ArrayList<Instruction> instructions) {
        if (instructions.isEmpty()) {
            System.out.println("Unable to instruct Rover: no instructions provided");
            return;
        }
        for (Instruction instruction : instructions) {
            switch (instruction) {
                case Instruction.L:
                    rover.turnLeft(plateau);
                case Instruction.R:
                    rover.turnRight(plateau);
                case Instruction.M:
                    rover.move(plateau);
                default:
                    break;
            }
        }
    }
}
