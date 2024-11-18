package org.example.parse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RoverInstructionParserTest {

    @Test
    @DisplayName("returns empty ArrayList when passed null input string")
    public void testParseRoverInstructionWhenNull() {
        //Arrange
        RoverInstructionParser testParser = new RoverInstructionParser();
        ArrayList<Instruction> expectedResult = new ArrayList<>();

        //Act
        ArrayList<Instruction> result = testParser.parseRoverInstruction(null);

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("returns empty ArrayList when passed empty input string")
    public void testParseRoverInstructionWhenEmpty() {
        //Arrange
        RoverInstructionParser testParser = new RoverInstructionParser();
        ArrayList<Instruction> expectedResult = new ArrayList<>();

        //Act
        ArrayList<Instruction> result = testParser.parseRoverInstruction("");

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("returns empty ArrayList when passed blank input string")
    public void testParseRoverInstructionWhenBlank() {
        //Arrange
        RoverInstructionParser testParser = new RoverInstructionParser();
        ArrayList<Instruction> expectedResult = new ArrayList<>();

        //Act
        ArrayList<Instruction> result1 = testParser.parseRoverInstruction(" ");
        ArrayList<Instruction> result2 = testParser.parseRoverInstruction("    ");

        //Assert
        assertEquals(expectedResult, result1);
    }

    @Test
    @DisplayName("returns ArrayList which ignores unrecognised instruction")
    public void testParseRoverInstructionWhenUnrecognised() {
        //Arrange
        RoverInstructionParser testParser = new RoverInstructionParser();

        ArrayList<Instruction> expectedResult1 = new ArrayList<>();

        ArrayList<Instruction> expectedResult2 = new ArrayList<>();
        expectedResult2.add(Instruction.L);
        expectedResult2.add(Instruction.M);

        ArrayList<Instruction> expectedResult3 = new ArrayList<>();
        expectedResult3.add(Instruction.L);
        expectedResult3.add(Instruction.R);
        expectedResult3.add(Instruction.M);

        ArrayList<Instruction> expectedResult4 = new ArrayList<>();
        expectedResult4.add(Instruction.R);
        expectedResult4.add(Instruction.M);

        //Act
        ArrayList<Instruction> result1 = testParser.parseRoverInstruction("a");
        ArrayList<Instruction> result2 = testParser.parseRoverInstruction(")l L M");
        ArrayList<Instruction> result3 = testParser.parseRoverInstruction("alm ! L R b M");
        ArrayList<Instruction> result4 = testParser.parseRoverInstruction("1 2M R a M ");

        //Assert
        assertAll(
                () -> assertEquals(expectedResult1, result1),
                () -> assertEquals(expectedResult2, result2),
                () -> assertEquals(expectedResult3, result3),
                () -> assertEquals(expectedResult4, result4)
        );
    }

    @Test
    @DisplayName("returns correct int when passed appropriate string with too many spaces")
    public void testParseRoverInstructionWhenTooManySpaces() {
        //Arrange
        RoverInstructionParser testParser = new RoverInstructionParser();

        ArrayList<Instruction> expectedResult1 = new ArrayList<>();
        expectedResult1.add(Instruction.M);
        expectedResult1.add(Instruction.L);
        expectedResult1.add(Instruction.R);

        ArrayList<Instruction> expectedResult2 = new ArrayList<>();
        expectedResult2.add(Instruction.L);
        expectedResult2.add(Instruction.R);
        expectedResult2.add(Instruction.M);

        ArrayList<Instruction> expectedResult3 = new ArrayList<>();
        expectedResult3.add(Instruction.R);
        expectedResult3.add(Instruction.M);
        expectedResult3.add(Instruction.L);

        //Act
        ArrayList<Instruction> result1 = testParser.parseRoverInstruction("  M L R");
        ArrayList<Instruction> result2 = testParser.parseRoverInstruction("L  R  M");
        ArrayList<Instruction> result3 = testParser.parseRoverInstruction("R M  L  ");

        //Assert
        assertAll(
                () -> assertEquals(expectedResult1, result1),
                () -> assertEquals(expectedResult2, result2),
                () -> assertEquals(expectedResult3, result3)
        );
    }

    @Test
    @DisplayName("returns correct ArrayList when passed appropriate string with incorrect case")
    public void testParseRoverInstructionIncorrectCase() {
        //Arrange
        RoverInstructionParser testParser = new RoverInstructionParser();

        ArrayList<Instruction> expectedResult1 = new ArrayList<>();
        expectedResult1.add(Instruction.L);
        expectedResult1.add(Instruction.R);
        expectedResult1.add(Instruction.M);

        ArrayList<Instruction> expectedResult2 = new ArrayList<>();
        expectedResult2.add(Instruction.L);
        expectedResult2.add(Instruction.L);
        expectedResult2.add(Instruction.R);
        expectedResult2.add(Instruction.R);
        expectedResult2.add(Instruction.M);
        expectedResult2.add(Instruction.M);

        ArrayList<Instruction> expectedResult3 = new ArrayList<>();
        expectedResult3.add(Instruction.L);
        expectedResult3.add(Instruction.L);
        expectedResult3.add(Instruction.L);
        expectedResult3.add(Instruction.L);
        expectedResult3.add(Instruction.L);
        expectedResult3.add(Instruction.L);

        //Act
        ArrayList<Instruction> result1 = testParser.parseRoverInstruction("l r m");
        ArrayList<Instruction> result2 = testParser.parseRoverInstruction("L l R r M m");
        ArrayList<Instruction> result3 = testParser.parseRoverInstruction("l l L L l l");

        //Assert
        assertAll(
                () -> assertEquals(expectedResult1, result1),
                () -> assertEquals(expectedResult2, result2),
                () -> assertEquals(expectedResult3, result3)
        );
    }

    @Test
    @DisplayName("returns correct Arraylist when passed appropriate string with one instruction")
    public void testParseRoverInstructionWhenAppropriateSingle() {
        //Arrange
        RoverInstructionParser testParser = new RoverInstructionParser();

        ArrayList<Instruction> expectedResult1 = new ArrayList<>();
        expectedResult1.add(Instruction.L);

        ArrayList<Instruction> expectedResult2 = new ArrayList<>();
        expectedResult2.add(Instruction.R);

        ArrayList<Instruction> expectedResult3 = new ArrayList<>();
        expectedResult3.add(Instruction.M);

        //Act
        ArrayList<Instruction> result1 = testParser.parseRoverInstruction("L");
        ArrayList<Instruction> result2 = testParser.parseRoverInstruction("R");
        ArrayList<Instruction> result3 = testParser.parseRoverInstruction("M");

        //Assert
        assertAll(
                () -> assertEquals(expectedResult1, result1),
                () -> assertEquals(expectedResult2, result2),
                () -> assertEquals(expectedResult3, result3)
        );
    }

    @Test
    @DisplayName("returns correct Arraylist when passed appropriate string with multiple instructions")
    public void testParseRoverInstructionWhenAppropriateMultiple() {
        //Arrange
        RoverInstructionParser testParser = new RoverInstructionParser();

        ArrayList<Instruction> expectedResult1 = new ArrayList<>();
        expectedResult1.add(Instruction.L);
        expectedResult1.add(Instruction.R);
        expectedResult1.add(Instruction.M);

        ArrayList<Instruction> expectedResult2 = new ArrayList<>();
        expectedResult2.add(Instruction.L);
        expectedResult2.add(Instruction.M);
        expectedResult2.add(Instruction.R);
        expectedResult2.add(Instruction.M);
        expectedResult2.add(Instruction.L);
        expectedResult2.add(Instruction.M);
        expectedResult2.add(Instruction.R);
        expectedResult2.add(Instruction.M);

        ArrayList<Instruction> expectedResult3 = new ArrayList<>();
        expectedResult3.add(Instruction.L);
        expectedResult3.add(Instruction.L);
        expectedResult3.add(Instruction.L);
        expectedResult3.add(Instruction.L);
        expectedResult3.add(Instruction.R);
        expectedResult3.add(Instruction.R);
        expectedResult3.add(Instruction.R);
        expectedResult3.add(Instruction.R);

        ArrayList<Instruction> expectedResult4 = new ArrayList<>();
        expectedResult4.add(Instruction.M);
        expectedResult4.add(Instruction.M);
        expectedResult4.add(Instruction.M);
        expectedResult4.add(Instruction.M);
        expectedResult4.add(Instruction.M);
        expectedResult4.add(Instruction.M);


        //Act
        ArrayList<Instruction> result1 = testParser.parseRoverInstruction("L R M");
        ArrayList<Instruction> result2 = testParser.parseRoverInstruction("L M R M L M R M");
        ArrayList<Instruction> result3 = testParser.parseRoverInstruction("L L L L R R R R");
        ArrayList<Instruction> result4 = testParser.parseRoverInstruction("M M M M M M");

        //Assert
        assertAll(
                () -> assertEquals(expectedResult1, result1),
                () -> assertEquals(expectedResult2, result2),
                () -> assertEquals(expectedResult3, result3),
                () -> assertEquals(expectedResult4, result4)
        );
    }

}