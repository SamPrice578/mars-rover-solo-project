package org.example.parse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoverInitialPositionParserTest {
    @Test
    @DisplayName("extractXCoordinate returns 0 when passed null input string")
    public void testExtractXCoordinateWhenNull() {
        //Arrange
        int expectedResult = 0;

        //Act
        int result = RoverInitialPositionParser.extractXCoordinate(null);

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("extractXCoordinate returns 0 when passed empty input string")
    public void testExtractXCoordinateWhenEmpty() {
        //Arrange
        int expectedResult = 0;

        //Act
        int result = RoverInitialPositionParser.extractXCoordinate("");

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("extractXCoordinate return int which ignores unrecognised strings")
    public void testPExtractXCoordinateWhenNonDigit() {
        //Arrange

        //Act
        int result1 = RoverInitialPositionParser.extractXCoordinate("a b 1 2 N");
        int result2 = RoverInitialPositionParser.extractXCoordinate(") 10 aa 20a 20 N");
        int result3 = RoverInitialPositionParser.extractXCoordinate("a !! 100 @ 200 N $");
        int result4 = RoverInitialPositionParser.extractXCoordinate("a bb ### 1000 2000 # N %% %");

        //Assert
        assertAll(
                () -> assertEquals(1, result1),
                () -> assertEquals(10, result2),
                () -> assertEquals(100, result3),
                () -> assertEquals(1000, result4)
        );
    }

    @Test
    @DisplayName("extractXCoordinate returns correct int when passed String with too many characters")
    public void testExtractXCoordinateWhenTooManyChars() {
        //Arrange

        //Act
        int result1 = RoverInitialPositionParser.extractXCoordinate("1 2 N 3");
        int result2 = RoverInitialPositionParser.extractXCoordinate("10 20 30 40 E");
        int result3 = RoverInitialPositionParser.extractXCoordinate("101 201 301 S a");

        //Assert
        assertAll(
                () -> assertEquals(1, result1),
                () -> assertEquals(10, result2),
                () -> assertEquals(101, result3)
        );
    }

    @Test
    @DisplayName("extractXCoordinate returns integer which ignores unrecognised strings")
    public void testExtractXDimensionWhenUnrecognised() {
        //Arrange

        //Act
        int result1 = RoverInitialPositionParser.extractXCoordinate("a b 1 2");
        int result2 = RoverInitialPositionParser.extractXCoordinate(") 10 aa 20");
        int result3 = RoverInitialPositionParser.extractXCoordinate("a !! 100 @ 200");
        int result4 = RoverInitialPositionParser.extractXCoordinate("a bb ### 1000 2000 #");

        //Assert
        assertAll(
                () -> assertEquals(1, result1),
                () -> assertEquals(10, result2),
                () -> assertEquals(100, result3),
                () -> assertEquals(1000, result4)
        );
    }

    @Test
    @DisplayName("extractXCoordinate returns integer which ignores negative integers")
    public void testExtractXDimensionWhenNegative() {
        //Arrange

        //Act
        int result1 = RoverInitialPositionParser.extractXCoordinate("-1 1 2");
        int result2 = RoverInitialPositionParser.extractXCoordinate("-2 10 -33 20");
        int result3 = RoverInitialPositionParser.extractXCoordinate("-4 -55 100 -22 200");
        int result4 = RoverInitialPositionParser.extractXCoordinate("-66 -7 -1000 1000 2000 -55");

        //Assert
        assertAll(
                () -> assertEquals(1, result1),
                () -> assertEquals(10, result2),
                () -> assertEquals(100, result3),
                () -> assertEquals(1000, result4)
        );
    }

    @Test
    @DisplayName("extractXCoordinate returns correct int when passed appropriate string with too many spaces")
    public void testExtractXCoordinateWhenTooManySpaces() {
        //Arrange

        //Act
        int result1 = RoverInitialPositionParser.extractXCoordinate("  1 2 N");
        int result2 = RoverInitialPositionParser.extractXCoordinate("10  20  E");
        int result3 = RoverInitialPositionParser.extractXCoordinate("101 202  S  ");

        //Assert
        assertAll(
                () -> assertEquals(1, result1),
                () -> assertEquals(10, result2),
                () -> assertEquals(101, result3)
        );
    }

    @Test
    @DisplayName("extractXCoordinate returns correct int when passed appropriate string")
    public void testExtractXCoordinateWhenAppropriate() {
        //Arrange

        //Act
        int result1 = RoverInitialPositionParser.extractXCoordinate("1 2 N");
        int result2 = RoverInitialPositionParser.extractXCoordinate("10 20 E");
        int result3 = RoverInitialPositionParser.extractXCoordinate("101 202 S");

        //Assert
        assertAll(
                () -> assertEquals(1, result1),
                () -> assertEquals(10, result2),
                () -> assertEquals(101, result3)
        );
    }

    //ExtractYCoordinate

    @Test
    @DisplayName("extractXCoordinate returns 0 when passed null input string")
    public void testExtractYCoordinateWhenNull() {
        //Arrange
        int expectedResult = 0;

        //Act
        int result = RoverInitialPositionParser.extractYCoordinate(null);

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("extractXCoordinate returns 0 when passed empty input string")
    public void testExtractYCoordinateWhenEmpty() {
        //Arrange
        int expectedResult = 0;

        //Act
        int result = RoverInitialPositionParser.extractYCoordinate("");

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("extractYCoordinate returns 0 when passed input string with one Coordinate")
    public void testExtractYCoordinateWhenOneCoordinate() {
        //Arrange
        int expectedResult = 0;

        //Act
        int result1 = RoverInitialPositionParser.extractYCoordinate("1 ");
        int result2 = RoverInitialPositionParser.extractYCoordinate(" 1");

        //Assert
        assertAll(
                () -> assertEquals(expectedResult, result1),
                () -> assertEquals(expectedResult, result2)
        );
    }

    @Test
    @DisplayName("extractYCoordinate return int which ignores unrecognised strings")
    public void testPExtractYCoordinateWhenNonDigit() {
        //Arrange

        //Act
        int result1 = RoverInitialPositionParser.extractYCoordinate("a b 1 2 N");
        int result2 = RoverInitialPositionParser.extractYCoordinate(") 10 aa 20a 20 N");
        int result3 = RoverInitialPositionParser.extractYCoordinate("a !! 100 @ 200 N $");
        int result4 = RoverInitialPositionParser.extractYCoordinate("a bb ### 1000 2000 # N %% %");

        //Assert
        assertAll(
                () -> assertEquals(2, result1),
                () -> assertEquals(20, result2),
                () -> assertEquals(200, result3),
                () -> assertEquals(2000, result4)
        );
    }

    @Test
    @DisplayName("extractYCoordinate returns integer which ignores negative integers")
    public void testExtractYDimensionWhenNegative() {
        //Arrange

        //Act
        int result1 = RoverInitialPositionParser.extractYCoordinate("-1 1 2");
        int result2 = RoverInitialPositionParser.extractYCoordinate("-2 10 -33 20");
        int result3 = RoverInitialPositionParser.extractYCoordinate("-4 -55 100 -22 200");
        int result4 = RoverInitialPositionParser.extractYCoordinate("-66 -7 -1000 1000 2000 -55");

        //Assert
        assertAll(
                () -> assertEquals(2, result1),
                () -> assertEquals(20, result2),
                () -> assertEquals(200, result3),
                () -> assertEquals(2000, result4)
        );
    }

    @Test
    @DisplayName("extractYCoordinate returns correct int when passed String with too many characters")
    public void testExtractYCoordinateWhenTooManyChars() {
        //Arrange

        //Act
        int result1 = RoverInitialPositionParser.extractYCoordinate("1 2 3 N");
        int result2 = RoverInitialPositionParser.extractYCoordinate("10 20 E 30 40");
        int result3 = RoverInitialPositionParser.extractYCoordinate("101 201 301 a S");

        //Assert
        assertAll(
                () -> assertEquals(2, result1),
                () -> assertEquals(20, result2),
                () -> assertEquals(201, result3)
        );
    }

    @Test
    @DisplayName("extractYCoordinate returns correct int when passed appropriate string with too many spaces")
    public void testExtractYCoordinateWhenTooManySpaces() {
        //Arrange

        //Act
        int result1 = RoverInitialPositionParser.extractYCoordinate(" 1 2 N");
        int result2 = RoverInitialPositionParser.extractYCoordinate("10  20  E");
        int result3 = RoverInitialPositionParser.extractYCoordinate("101 202  S   ");

        //Assert
        assertAll(
                () -> assertEquals(2, result1),
                () -> assertEquals(20, result2),
                () -> assertEquals(202, result3)
        );
    }

    @Test
    @DisplayName("extractYCoordinate returns correct int when passed appropriate string")
    public void testExtractYCoordinateWhenAppropriate() {
        //Arrange

        //Act
        int result1 = RoverInitialPositionParser.extractYCoordinate("1 2 N");
        int result2 = RoverInitialPositionParser.extractYCoordinate("10 20 E");
        int result3 = RoverInitialPositionParser.extractYCoordinate("101 202 S");

        //Assert
        assertAll(
                () -> assertEquals(2, result1),
                () -> assertEquals(20, result2),
                () -> assertEquals(202, result3)
        );
    }

    //ExtractDirection

    @Test
    @DisplayName("extractDirection returns N (default Direction) when passed null input string")
    public void testExtractDirectionWhenNull() {
        //Arrange

        //Act
        Direction result = RoverInitialPositionParser.extractDirection(null);

        //Assert
        assertEquals(Direction.N, result);
    }

    @Test
    @DisplayName("extractDirection returns N (default Direction) when passed empty input string")
    public void testExtractDirectionWhenEmpty() {
        //Arrange

        //Act
        Direction result = RoverInitialPositionParser.extractDirection("");

        //Assert
        assertEquals(Direction.N, result);
    }

    @Test
    @DisplayName("extractDirection returns N (default Direction) when passed input string with only Coordinates")
    public void testExtractDirectionWhenOnlyCoordinates() {
        //Arrange
        Direction expectedResult = Direction.N;

        //Act
        Direction result1 = RoverInitialPositionParser.extractDirection("1");
        Direction result2 = RoverInitialPositionParser.extractDirection(" 1");
        Direction result3 = RoverInitialPositionParser.extractDirection("1 2");
        Direction result4 = RoverInitialPositionParser.extractDirection(" 1 2");


        //Assert
        assertAll(
                () -> assertEquals(expectedResult, result1),
                () -> assertEquals(expectedResult, result2),
                () -> assertEquals(expectedResult, result3),
                () -> assertEquals(expectedResult, result4)
        );
    }

    @Test
    @DisplayName("extractDirection returns N (default Direction) when passed input string with unrecognised position")
    public void testExtractYCoordinateWhenUnrecognised() {
        //Arrange
        Direction expectedResult = Direction.N;

        //Act
        Direction result1 = RoverInitialPositionParser.extractDirection("1 2 a");
        Direction result2 = RoverInitialPositionParser.extractDirection("1 2 B");
        Direction result3 = RoverInitialPositionParser.extractDirection("1 2 !");
        Direction result4 = RoverInitialPositionParser.extractDirection("1 2 NE");
        Direction result5 = RoverInitialPositionParser.extractDirection("1 2 EW");
        Direction result6 = RoverInitialPositionParser.extractDirection("1 2 # N12");

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
    @DisplayName("extractDirection return int which ignores unrecognised strings")
    public void testExtractDirectionWhenNonDirection() {
        //Arrange

        //Act
        Direction result1 = RoverInitialPositionParser.extractDirection("a b 1 2 f g N");
        Direction result2 = RoverInitialPositionParser.extractDirection(") 10 aa 20a 20 E");
        Direction result3 = RoverInitialPositionParser.extractDirection("a !! 100 @ 200 b hello S $");
        Direction result4 = RoverInitialPositionParser.extractDirection("a bb ### 1000 oops 2000 # W %% %");

        //Assert
        assertAll(
                () -> assertEquals(Direction.N, result1),
                () -> assertEquals(Direction.E, result2),
                () -> assertEquals(Direction.S, result3),
                () -> assertEquals(Direction.W, result4)
        );
    }

    @Test
    @DisplayName("extractDirection returns correct Direction when passed String with too many characters")
    public void testExtractDirectionWhenTooManyChars() {
        //Arrange

        //Act
        Direction result1 = RoverInitialPositionParser.extractDirection("1 2 N 3");
        Direction result2 = RoverInitialPositionParser.extractDirection("10 20 E 40 50");
        Direction result3 = RoverInitialPositionParser.extractDirection("101 201 S a 301 c");

        //Assert
        assertAll(
                () -> assertEquals(Direction.N, result1),
                () -> assertEquals(Direction.E, result2),
                () -> assertEquals(Direction.S, result3)
        );
    }

    @Test
    @DisplayName("extractDirection returns correct Direction when passed String with too many characters")
    public void testExtractDirectionWhenTooFewCoordinates() {
        //Arrange

        //Act
        Direction result1 = RoverInitialPositionParser.extractDirection("1 N");
        Direction result2 = RoverInitialPositionParser.extractDirection("10 E");
        Direction result3 = RoverInitialPositionParser.extractDirection("S");

        //Assert
        assertAll(
                () -> assertEquals(Direction.N, result1),
                () -> assertEquals(Direction.E, result2),
                () -> assertEquals(Direction.S, result3)
        );
    }

    @Test
    @DisplayName("extractDirection returns correct Direction when passed appropriate string with too many spaces")
    public void testExtractDirectionTooManySpaces() {
        //Arrange

        //Act
        Direction result1 = RoverInitialPositionParser.extractDirection("  1 2 N");
        Direction result2 = RoverInitialPositionParser.extractDirection("10  20  E");
        Direction result3 = RoverInitialPositionParser.extractDirection("101 202  S   ");
        Direction result4 = RoverInitialPositionParser.extractDirection("   1010 2020  W   ");

        //Assert
        assertAll(
                () -> assertEquals(Direction.N, result1),
                () -> assertEquals(Direction.E, result2),
                () -> assertEquals(Direction.S, result3),
                () -> assertEquals(Direction.W, result4)
        );
    }

    @Test
    @DisplayName("extractDirection returns correct Direction when passed appropriate string with incorrect case")
    public void testExtractDirectionIncorrectCase() {
        //Arrange

        //Act
        Direction result1 = RoverInitialPositionParser.extractDirection("1 2 n");
        Direction result2 = RoverInitialPositionParser.extractDirection("10 20 e");
        Direction result3 = RoverInitialPositionParser.extractDirection("101 202 s");
        Direction result4 = RoverInitialPositionParser.extractDirection("101 202 w");


        //Assert
        assertAll(
                () -> assertEquals(Direction.N, result1),
                () -> assertEquals(Direction.E, result2),
                () -> assertEquals(Direction.S, result3),
                () -> assertEquals(Direction.W, result4)

        );
    }

    @Test
    @DisplayName("extractDirection returns correct Direction when passed appropriate string")
    public void testExtractDirectionWhenAppropriate() {
        //Arrange

        //Act
        Direction result1 = RoverInitialPositionParser.extractDirection("1 2 N");
        Direction result2 = RoverInitialPositionParser.extractDirection("10 20 E");
        Direction result3 = RoverInitialPositionParser.extractDirection("101 202 S");
        Direction result4 = RoverInitialPositionParser.extractDirection("10 20 W");

        //Assert
        assertAll(
                () -> assertEquals(Direction.N, result1),
                () -> assertEquals(Direction.E, result2),
                () -> assertEquals(Direction.S, result3),
                () -> assertEquals(Direction.W, result4)
        );
    }
}