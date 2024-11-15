package org.example.parsing;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoverInitialPositionParserTest {
    @Test
    @DisplayName("returns 0 when passed null input string")
    public void testExtractXCoordinateWhenNull() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();
        int expectedResult = 0;

        //Act
        int result = testParser.extractXCoordinate(null);

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("returns 0 when passed empty input string")
    public void testExtractXCoordinateWhenEmpty() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();
        int expectedResult = 0;

        //Act
        int result = testParser.extractXCoordinate("");

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("return int which ignores unrecognised strings")
    public void testPExtractXCoordinateWhenNonDigit() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();

        //Act
        int result1 = testParser.extractXCoordinate("a b 1 2 N");
        int result2 = testParser.extractXCoordinate(") 10 aa 20a 20 N");
        int result3 = testParser.extractXCoordinate("a !! 100 @ 200 N $");
        int result4 = testParser.extractXCoordinate("a bb ### 1000 2000 # N %% %");

        //Assert
        assertAll(
                () -> assertEquals(1, result1),
                () -> assertEquals(10, result2),
                () -> assertEquals(100, result3),
                () -> assertEquals(1000, result4)
        );
    }

    @Test
    @DisplayName("returns correct int when passed String with too many characters")
    public void testExtractXCoordinateWhenTooManyChars() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();

        //Act
        int result1 = testParser.extractXCoordinate("1 2 N 3");
        int result2 = testParser.extractXCoordinate("10 20 30 40 E");
        int result3 = testParser.extractXCoordinate("101 201 301 S a");

        //Assert
        assertAll(
                () -> assertEquals(1, result1),
                () -> assertEquals(10, result2),
                () -> assertEquals(101, result3)
        );
    }

    @Test
    @DisplayName("returns integer which ignores unrecognised strings")
    public void testExtractXDimensionWhenUnrecognised() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();

        //Act
        int result1 = testParser.extractXCoordinate("a b 1 2");
        int result2 = testParser.extractXCoordinate(") 10 aa 20");
        int result3 = testParser.extractXCoordinate("a !! 100 @ 200");
        int result4 = testParser.extractXCoordinate("a bb ### 1000 2000 #");

        //Assert
        assertAll(
                () -> assertEquals(1, result1),
                () -> assertEquals(10, result2),
                () -> assertEquals(100, result3),
                () -> assertEquals(1000, result4)
        );
    }

    @Test
    @DisplayName("returns integer which ignores negative integers")
    public void testExtractXDimensionWhenNegative() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();

        //Act
        int result1 = testParser.extractXCoordinate("-1 1 2");
        int result2 = testParser.extractXCoordinate("-2 10 -33 20");
        int result3 = testParser.extractXCoordinate("-4 -55 100 -22 200");
        int result4 = testParser.extractXCoordinate("-66 -7 -1000 1000 2000 -55");

        //Assert
        assertAll(
                () -> assertEquals(1, result1),
                () -> assertEquals(10, result2),
                () -> assertEquals(100, result3),
                () -> assertEquals(1000, result4)
        );
    }

    @Test
    @DisplayName("returns correct int when passed appropriate string with too many spaces")
    public void testExtractXCoordinateWhenTooManySpaces() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();

        //Act
        int result1 = testParser.extractXCoordinate("  1 2 N");
        int result2 = testParser.extractXCoordinate("10  20  E");
        int result3 = testParser.extractXCoordinate("101 202  S  ");

        //Assert
        assertAll(
                () -> assertEquals(1, result1),
                () -> assertEquals(10, result2),
                () -> assertEquals(101, result3)
        );
    }

    @Test
    @DisplayName("returns correct int when passed appropriate string")
    public void testExtractXCoordinateWhenAppropriate() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();

        //Act
        int result1 = testParser.extractXCoordinate("1 2 N");
        int result2 = testParser.extractXCoordinate("10 20 E");
        int result3 = testParser.extractXCoordinate("101 202 S");

        //Assert
        assertAll(
                () -> assertEquals(1, result1),
                () -> assertEquals(10, result2),
                () -> assertEquals(101, result3)
        );
    }

    //ExtractYCoordinate

    @Test
    @DisplayName("returns 0 when passed null input string")
    public void testExtractYCoordinateWhenNull() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();
        int expectedResult = 0;

        //Act
        int result = testParser.extractYCoordinate(null);

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("returns 0 when passed empty input string")
    public void testExtractYCoordinateWhenEmpty() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();
        int expectedResult = 0;

        //Act
        int result = testParser.extractYCoordinate("");

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("returns 0 when passed input string with one Coordinate")
    public void testExtractYCoordinateWhenOneCoordinate() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();
        int expectedResult = 0;

        //Act
        int result1 = testParser.extractYCoordinate("1 ");
        int result2 = testParser.extractYCoordinate(" 1");

        //Assert
        assertAll(
                () -> assertEquals(expectedResult, result1),
                () -> assertEquals(expectedResult, result2)
        );
    }

    @Test
    @DisplayName("return int which ignores unrecognised strings")
    public void testPExtractYCoordinateWhenNonDigit() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();

        //Act
        int result1 = testParser.extractXCoordinate("a b 1 2 N");
        int result2 = testParser.extractXCoordinate(") 10 aa 20a 20 N");
        int result3 = testParser.extractXCoordinate("a !! 100 @ 200 N $");
        int result4 = testParser.extractXCoordinate("a bb ### 1000 2000 # N %% %");

        //Assert
        assertAll(
                () -> assertEquals(2, result1),
                () -> assertEquals(20, result2),
                () -> assertEquals(200, result3),
                () -> assertEquals(2000, result4)
        );
    }

    @Test
    @DisplayName("returns integer which ignores negative integers")
    public void testExtractYDimensionWhenNegative() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();

        //Act
        int result1 = testParser.extractYCoordinate("-1 1 2");
        int result2 = testParser.extractYCoordinate("-2 10 -33 20");
        int result3 = testParser.extractYCoordinate("-4 -55 100 -22 200");
        int result4 = testParser.extractYCoordinate("-66 -7 -1000 1000 2000 -55");

        //Assert
        assertAll(
                () -> assertEquals(2, result1),
                () -> assertEquals(20, result2),
                () -> assertEquals(200, result3),
                () -> assertEquals(2000, result4)
        );
    }

    @Test
    @DisplayName("returns correct int when passed String with too many characters")
    public void testExtractYCoordinateWhenTooManyChars() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();

        //Act
        int result1 = testParser.extractYCoordinate("1 2 3 N");
        int result2 = testParser.extractYCoordinate("10 20 E 30 40");
        int result3 = testParser.extractYCoordinate("101 201 301 a S");

        //Assert
        assertAll(
                () -> assertEquals(2, result1),
                () -> assertEquals(20, result2),
                () -> assertEquals(201, result3)
        );
    }

    @Test
    @DisplayName("returns correct int when passed appropriate string with too many spaces")
    public void testExtractYCoordinateWhenTooManySpaces() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();

        //Act
        int result1 = testParser.extractXCoordinate(" 1 2 N");
        int result2 = testParser.extractXCoordinate("10  20  E");
        int result3 = testParser.extractXCoordinate("101 202  S   ");

        //Assert
        assertAll(
                () -> assertEquals(2, result1),
                () -> assertEquals(20, result2),
                () -> assertEquals(202, result3)
        );
    }

    @Test
    @DisplayName("returns correct int when passed appropriate string")
    public void testExtractYCoordinateWhenAppropriate() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();

        //Act
        int result1 = testParser.extractXCoordinate("1 2 N");
        int result2 = testParser.extractXCoordinate("10 20 E");
        int result3 = testParser.extractXCoordinate("101 202 S");

        //Assert
        assertAll(
                () -> assertEquals(2, result1),
                () -> assertEquals(20, result2),
                () -> assertEquals(202, result3)
        );
    }

    //ExtractDirection

    @Test
    @DisplayName("returns N (default Direction) when passed null input string")
    public void testExtractDirectionWhenNull() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();

        //Act
        Direction result = testParser.extractDirection(null);

        //Assert
        assertEquals(Direction.N, result);
    }

    @Test
    @DisplayName("returns N (default Direction) when passed empty input string")
    public void testExtractDirectionWhenEmpty() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();

        //Act
        Direction result = testParser.extractDirection("");

        //Assert
        assertEquals(Direction.N, result);
    }

    @Test
    @DisplayName("returns N (default Direction) when passed input string with only Coordinates")
    public void testExtractDirectionWhenOnlyCoordinates() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();
        Direction expectedResult = Direction.N;
        //Act
        Direction result1 = testParser.extractDirection("1");
        Direction result2 = testParser.extractDirection(" 1");
        Direction result3 = testParser.extractDirection("1 2");
        Direction result4 = testParser.extractDirection(" 1 2");


        //Assert
        assertAll(
                () -> assertEquals(expectedResult, result1),
                () -> assertEquals(expectedResult, result2),
                () -> assertEquals(expectedResult, result3),
                () -> assertEquals(expectedResult, result4)
        );
    }

    @Test
    @DisplayName("returns N (default Direction) when passed input string with unrecognised position")
    public void testExtractYCoordinateWhenUnrecognised() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();
        Direction expectedResult = Direction.N;

        //Act
        Direction result1 = testParser.extractDirection("1 2 a");
        Direction result2 = testParser.extractDirection("1 2 B");
        Direction result3 = testParser.extractDirection("1 2 !");
        Direction result4 = testParser.extractDirection("1 2 NE");
        Direction result5 = testParser.extractDirection("1 2 EW");
        Direction result6 = testParser.extractDirection("1 2 # N12");

        //Assert
        assertAll(
                () -> assertEquals(expectedResult, result1),
                () -> assertEquals(expectedResult, result2),
                () -> assertEquals(expectedResult, result3),
                () -> assertEquals(expectedResult, result4),
                () -> assertEquals(expectedResult, result5),
                () -> assertEquals(expectedResult, result6)
        );
    }

    @Test
    @DisplayName("return int which ignores unrecognised strings")
    public void testExtractDirectionWhenNonDirection() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();

        //Act
        Direction result1 = testParser.extractDirection("a b 1 2 f g N");
        Direction result2 = testParser.extractDirection(") 10 aa 20a 20 E");
        Direction result3 = testParser.extractDirection("a !! 100 @ 200 b hello S $");
        Direction result4 = testParser.extractDirection("a bb ### 1000 oops 2000 # W %% %");

        //Assert
        assertAll(
                () -> assertEquals(Direction.N, result1),
                () -> assertEquals(Direction.E, result2),
                () -> assertEquals(Direction.S, result3),
                () -> assertEquals(Direction.W, result4)
        );
    }

    @Test
    @DisplayName("returns correct Direction when passed String with too many characters")
    public void testExtractDirectionWhenTooManyChars() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();

        //Act
        Direction result1 = testParser.extractDirection("1 2 N 3");
        Direction result2 = testParser.extractDirection("10 20 E 40 50");
        Direction result3 = testParser.extractDirection("101 201 S a 301 c");

        //Assert
        assertAll(
                () -> assertEquals(Direction.N, result1),
                () -> assertEquals(Direction.E, result2),
                () -> assertEquals(Direction.S, result3)
        );
    }

    @Test
    @DisplayName("returns correct Direction when passed String with too many characters")
    public void testExtractDirectionWhenTooFewCoordinates() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();

        //Act
        Direction result1 = testParser.extractDirection("1 N");
        Direction result2 = testParser.extractDirection("10 E");
        Direction result3 = testParser.extractDirection("S");

        //Assert
        assertAll(
                () -> assertEquals(Direction.N, result1),
                () -> assertEquals(Direction.E, result2),
                () -> assertEquals(Direction.S, result3)
        );
    }

    @Test
    @DisplayName("returns correct Direction when passed appropriate string with too many spaces")
    public void testExtractDirectionTooManySpaces() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();

        //Act
        Direction result1 = testParser.extractDirection("  1 2 N");
        Direction result2 = testParser.extractDirection("10  20  E");
        Direction result3 = testParser.extractDirection("101 202  S   ");
        Direction result4 = testParser.extractDirection("   1010 2020  W   ");

        //Assert
        assertAll(
                () -> assertEquals(Direction.N, result1),
                () -> assertEquals(Direction.E, result2),
                () -> assertEquals(Direction.S, result3),
                () -> assertEquals(Direction.W, result4)
        );
    }

    @Test
    @DisplayName("returns correct Direction when passed appropriate string with incorrect case")
    public void testExtractDirectionIncorrectCase() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();

        //Act
        Direction result1 = testParser.extractDirection("1 2 n");
        Direction result2 = testParser.extractDirection("10 20 e");
        Direction result3 = testParser.extractDirection("101 202 s");
        Direction result4 = testParser.extractDirection("101 202 w");


        //Assert
        assertAll(
                () -> assertEquals(Direction.N, result1),
                () -> assertEquals(Direction.E, result2),
                () -> assertEquals(Direction.S, result3),
                () -> assertEquals(Direction.W, result4)

        );
    }

    @Test
    @DisplayName("returns correct Direction when passed appropriate string")
    public void testExtractDirectionWhenAppropriate() {
        //Arrange
        RoverInitialPositionParser testParser = new RoverInitialPositionParser();

        //Act
        Direction result1 = testParser.extractDirection("1 2 N");
        Direction result2 = testParser.extractDirection("10 20 E");
        Direction result3 = testParser.extractDirection("101 202 S");
        Direction result4 = testParser.extractDirection("10 20 W");

        //Assert
        assertAll(
                () -> assertEquals(Direction.N, result1),
                () -> assertEquals(Direction.E, result2),
                () -> assertEquals(Direction.S, result3),
                () -> assertEquals(Direction.W, result4)
        );
    }
}