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
                    System.out.println("Rover instruction: L");
                    rover.turnLeft(plateau);
                    break;
                case Instruction.R:
                    System.out.println("Rover instruction: R");
                    rover.turnRight(plateau);
                    break;
                case Instruction.M:
                    System.out.println("Rover instruction: M");
                    rover.move(plateau);
                    break;
                default:
                    break;
            }
        }
    }
}
