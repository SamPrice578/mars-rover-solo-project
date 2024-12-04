package org.example.deliver;

import org.example.parse.Instruction;
import org.example.perform.Plateau;
import org.example.perform.Rover;

import java.util.ArrayList;

public class RoverInstructor {
    public static void instructRover(Rover rover, Plateau plateau, ArrayList<Instruction> instructions) {
        System.out.println("Instructing Rover...");
        System.out.println(instructions);
        System.out.println("Rover initial position: " + plateau.getPlateauInstructablesPositions().get(rover));
        System.out.println();

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
        System.out.println("Rover instruction complete");
        System.out.println();
        System.out.println("Rover final position: " + plateau.getPlateauInstructablesPositions().get(rover));
        System.out.println();
    }
}
