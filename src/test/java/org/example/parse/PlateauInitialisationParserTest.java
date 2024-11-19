package org.example.parse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlateauInitialisationParserTest {
    @Test
    @DisplayName("extractXDimension returns 0 when passed null input string")
    public void testExtractXDimensionWhenNull() {
        //Arrange
        int expectedResult = 0;

        //Act
        int result = PlateauInitialisationParser.extractXDimension(null);

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("extractXDimension returns 0 when passed empty input string")
    public void testExtractXDimensionWhenEmpty() {
        //Arrange
        int expectedResult = 0;

        //Act
        int result = PlateauInitialisationParser.extractXDimension("");

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("extractXDimension returns integer which ignores unrecognised strings")
    public void testExtractXDimensionWhenUnrecognised() {
        //Arrange
        int expectedResult = 0;

        //Act
        int result1 = PlateauInitialisationParser.extractXDimension("a b 1 2");
        int result2 = PlateauInitialisationParser.extractXDimension(") 10 aa 20");
        int result3 = PlateauInitialisationParser.extractXDimension("a !! 100 @ 200");
        int result4 = PlateauInitialisationParser.extractXDimension("a bb ### 1000 2000 #");

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
        int expectedResult = 0;

        //Act
        int result1 = PlateauInitialisationParser.extractXDimension("-1 1 2");
        int result2 = PlateauInitialisationParser.extractXDimension("-2 10 -33 20");
        int result3 = PlateauInitialisationParser.extractXDimension("-4 -55 100 -22 200");
        int result4 = PlateauInitialisationParser.extractXDimension("-66 -7 -1000 1000 2000 -55");

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

        //Act
        int result1 = PlateauInitialisationParser.extractXDimension("1 2 3");
        int result2 = PlateauInitialisationParser.extractXDimension("10 20 30 40");
        int result3 = PlateauInitialisationParser.extractXDimension("101 201 301 a");

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

        //Act
        int result1 = PlateauInitialisationParser.extractXDimension(" 1 2");
        int result2 = PlateauInitialisationParser.extractXDimension("10  20");
        int result3 = PlateauInitialisationParser.extractXDimension("101  202  ");

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

        //Act
        int result1 = PlateauInitialisationParser.extractXDimension("1 2");
        int result2 = PlateauInitialisationParser.extractXDimension("10 20");
        int result3 = PlateauInitialisationParser.extractXDimension("101 202");

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
        int expectedResult = 0;

        //Act
        int result = PlateauInitialisationParser.extractYDimension(null);

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("extractYDimension returns 0 when passed empty input string")
    public void testExtractYDimensionWhenEmpty() {
        //Arrange
        int expectedResult = 0;

        //Act
        int result = PlateauInitialisationParser.extractYDimension("");

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("extractYDimension returns 0 when passed input string with one dimension")
    public void testExtractYDimensionWhenOneDimension() {
        //Arrange
        int expectedResult = 0;

        //Act
        int result1 = PlateauInitialisationParser.extractYDimension("1 ");
        int result2 = PlateauInitialisationParser.extractYDimension(" 1");

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
        int expectedResult = 0;

        //Act
        int result1 = PlateauInitialisationParser.extractYDimension("a b 1 2");
        int result2 = PlateauInitialisationParser.extractYDimension(") 10 aa 20");
        int result3 = PlateauInitialisationParser.extractYDimension("a !! 100 @ 200");
        int result4 = PlateauInitialisationParser.extractYDimension("a bb ### 1000 2000 #");

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
        int expectedResult = 0;

        //Act
        int result1 = PlateauInitialisationParser.extractYDimension("-1 1 2");
        int result2 = PlateauInitialisationParser.extractYDimension("-2 10 -33 20");
        int result3 = PlateauInitialisationParser.extractYDimension("-4 -55 100 -22 200");
        int result4 = PlateauInitialisationParser.extractYDimension("-66 -7 -1000 1000 2000 -55");

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

        //Act
        int result1 = PlateauInitialisationParser.extractYDimension("1 2 3");
        int result2 = PlateauInitialisationParser.extractYDimension("10 20 30 40");
        int result3 = PlateauInitialisationParser.extractYDimension("101 201 301 a");

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

        //Act
        int result1 = PlateauInitialisationParser.extractYDimension(" 1 2");
        int result2 = PlateauInitialisationParser.extractYDimension("10  20");
        int result3 = PlateauInitialisationParser.extractYDimension("101  202  ");

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

        //Act
        int result1 = PlateauInitialisationParser.extractYDimension("1 2");
        int result2 = PlateauInitialisationParser.extractYDimension("10 20");
        int result3 = PlateauInitialisationParser.extractYDimension("101 202");

        //Assert
        assertAll(
                () -> assertEquals(2, result1),
                () -> assertEquals(20, result2),
                () -> assertEquals(202, result3)
        );
    }
}