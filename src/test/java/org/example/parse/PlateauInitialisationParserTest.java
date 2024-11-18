package org.example.parse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlateauInitialisationParserTest {
    @Test
    @DisplayName("extractXDimension returns 0 when passed null input string")
    public void testExtractXDimensionWhenNull() {
        //Arrange
        PlateauInitialisationParser testParser = new PlateauInitialisationParser();
        int expectedResult = 0;

        //Act
        int result = testParser.extractXDimension(null);

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("extractXDimension returns 0 when passed empty input string")
    public void testExtractXDimensionWhenEmpty() {
        //Arrange
        PlateauInitialisationParser testParser = new PlateauInitialisationParser();
        int expectedResult = 0;

        //Act
        int result = testParser.extractXDimension("");

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("extractXDimension returns integer which ignores unrecognised strings")
    public void testExtractXDimensionWhenUnrecognised() {
        //Arrange
        PlateauInitialisationParser testParser = new PlateauInitialisationParser();
        int expectedResult = 0;

        //Act
        int result1 = testParser.extractXDimension("a b 1 2");
        int result2 = testParser.extractXDimension(") 10 aa 20");
        int result3 = testParser.extractXDimension("a !! 100 @ 200");
        int result4 = testParser.extractXDimension("a bb ### 1000 2000 #");

        //Assert
        assertAll(
                () -> assertEquals(1, result1),
                () -> assertEquals(10, result2),
                () -> assertEquals(100, result3),
                () -> assertEquals(1000, result4)
        );
    }

    @Test
    @DisplayName("extractXDimension returns integer which ignores negative integers")
    public void testExtractXDimensionWhenNegative() {
        //Arrange
        PlateauInitialisationParser testParser = new PlateauInitialisationParser();
        int expectedResult = 0;

        //Act
        int result1 = testParser.extractXDimension("-1 1 2");
        int result2 = testParser.extractXDimension("-2 10 -33 20");
        int result3 = testParser.extractXDimension("-4 -55 100 -22 200");
        int result4 = testParser.extractXDimension("-66 -7 -1000 1000 2000 -55");

        //Assert
        assertAll(
                () -> assertEquals(1, result1),
                () -> assertEquals(10, result2),
                () -> assertEquals(100, result3),
                () -> assertEquals(1000, result4)
        );
    }

    @Test
    @DisplayName("extractXDimension returns correct int when passed String with too many characters")
    public void testExtractXDimensionWhenTooManyChars() {
        //Arrange
        PlateauInitialisationParser testParser = new PlateauInitialisationParser();

        //Act
        int result1 = testParser.extractXDimension("1 2 3");
        int result2 = testParser.extractXDimension("10 20 30 40");
        int result3 = testParser.extractXDimension("101 201 301 a");

        //Assert
        assertAll(
                () -> assertEquals(1, result1),
                () -> assertEquals(10, result2),
                () -> assertEquals(101, result3)
        );
    }

    @Test
    @DisplayName("extractXDimension returns correct int when passed appropriate string with too many spaces")
    public void testExtractXDimensionWhenTooManySpaces() {
        //Arrange
        PlateauInitialisationParser testParser = new PlateauInitialisationParser();

        //Act
        int result1 = testParser.extractXDimension(" 1 2");
        int result2 = testParser.extractXDimension("10  20");
        int result3 = testParser.extractXDimension("101  202  ");

        //Assert
        assertAll(
                () -> assertEquals(1, result1),
                () -> assertEquals(10, result2),
                () -> assertEquals(101, result3)
        );
    }

    @Test
    @DisplayName("extractXDimension returns correct int when passed appropriate string")
    public void testExtractXDimensionWhenAppropriate() {
        //Arrange
        PlateauInitialisationParser testParser = new PlateauInitialisationParser();

        //Act
        int result1 = testParser.extractXDimension("1 2");
        int result2 = testParser.extractXDimension("10 20");
        int result3 = testParser.extractXDimension("101 202");

        //Assert
        assertAll(
                () -> assertEquals(1, result1),
                () -> assertEquals(10, result2),
                () -> assertEquals(101, result3)
        );
    }

    //ExtractYDimension

    @Test
    @DisplayName("extractYDimension returns 0 when passed null input string")
    public void testExtractYDimensionWhenNull() {
        //Arrange
        PlateauInitialisationParser testParser = new PlateauInitialisationParser();
        int expectedResult = 0;

        //Act
        int result = testParser.extractYDimension(null);

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("extractYDimension returns 0 when passed empty input string")
    public void testExtractYDimensionWhenEmpty() {
        //Arrange
        PlateauInitialisationParser testParser = new PlateauInitialisationParser();
        int expectedResult = 0;

        //Act
        int result = testParser.extractYDimension("");

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("extractYDimension returns 0 when passed input string with one dimension")
    public void testExtractYDimensionWhenOneDimension() {
        //Arrange
        PlateauInitialisationParser testParser = new PlateauInitialisationParser();
        int expectedResult = 0;

        //Act
        int result1 = testParser.extractYDimension("1 ");
        int result2 = testParser.extractYDimension(" 1");

        //Assert
        assertAll(
                () -> assertEquals(expectedResult, result1),
                () -> assertEquals(expectedResult, result2)
        );
    }

    @Test
    @DisplayName("extractYDimension returns integer which ignores unrecognised strings")
    public void testExtractYDimensionWhenUnrecognised() {
        //Arrange
        PlateauInitialisationParser testParser = new PlateauInitialisationParser();
        int expectedResult = 0;

        //Act
        int result1 = testParser.extractYDimension("a b 1 2");
        int result2 = testParser.extractYDimension(") 10 aa 20");
        int result3 = testParser.extractYDimension("a !! 100 @ 200");
        int result4 = testParser.extractYDimension("a bb ### 1000 2000 #");

        //Assert
        assertAll(
                () -> assertEquals(2, result1),
                () -> assertEquals(20, result2),
                () -> assertEquals(200, result3),
                () -> assertEquals(2000, result4)
        );
    }

    @Test
    @DisplayName("extractYDimension returns integer which ignores negative integers")
    public void testExtractYDimensionWhenNegative() {
        //Arrange
        PlateauInitialisationParser testParser = new PlateauInitialisationParser();
        int expectedResult = 0;

        //Act
        int result1 = testParser.extractYDimension("-1 1 2");
        int result2 = testParser.extractYDimension("-2 10 -33 20");
        int result3 = testParser.extractYDimension("-4 -55 100 -22 200");
        int result4 = testParser.extractYDimension("-66 -7 -1000 1000 2000 -55");

        //Assert
        assertAll(
                () -> assertEquals(2, result1),
                () -> assertEquals(20, result2),
                () -> assertEquals(200, result3),
                () -> assertEquals(2000, result4)
        );
    }

    @Test
    @DisplayName("extractYDimension returns correct int when passed String with too many characters")
    public void testExtractYDimension() {
        //Arrange
        PlateauInitialisationParser testParser = new PlateauInitialisationParser();

        //Act
        int result1 = testParser.extractYDimension("1 2 3");
        int result2 = testParser.extractYDimension("10 20 30 40");
        int result3 = testParser.extractYDimension("101 201 301 a");

        //Assert
        assertAll(
                () -> assertEquals(2, result1),
                () -> assertEquals(20, result2),
                () -> assertEquals(201, result3)
        );
    }

    @Test
    @DisplayName("extractYDimension returns correct int when passed appropriate string with too many spaces")
    public void testExtractYDimensionWhenTooManySpaces() {
        //Arrange
        PlateauInitialisationParser testParser = new PlateauInitialisationParser();

        //Act
        int result1 = testParser.extractYDimension(" 1 2");
        int result2 = testParser.extractYDimension("10  20");
        int result3 = testParser.extractYDimension("101  202  ");

        //Assert
        assertAll(
                () -> assertEquals(2, result1),
                () -> assertEquals(20, result2),
                () -> assertEquals(202, result3)
        );
    }

    @Test
    @DisplayName("extractYDimension returns correct int when passed appropriate string")
    public void testExtractYDimensionWhenAppropriate() {
        //Arrange
        PlateauInitialisationParser testParser = new PlateauInitialisationParser();

        //Act
        int result1 = testParser.extractYDimension("1 2");
        int result2 = testParser.extractYDimension("10 20");
        int result3 = testParser.extractYDimension("101 202");

        //Assert
        assertAll(
                () -> assertEquals(2, result1),
                () -> assertEquals(20, result2),
                () -> assertEquals(202, result3)
        );
    }
}