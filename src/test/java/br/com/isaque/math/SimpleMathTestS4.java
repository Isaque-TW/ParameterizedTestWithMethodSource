package br.com.isaque.math;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math Operations in SimpleMath Class")
public class SimpleMathTestS4 {

    SimpleMath math;

    @ParameterizedTest
    @ValueSource(strings = {"Pele", "Senna", "Keith Moon"})
    void testValueSource(String firstName) {
        System.out.println(firstName);
        assertNotNull(firstName);
    }

    @BeforeEach
    void beforeEachMethod() {
        math = new SimpleMath();

    }
    @DisplayName("Test double subtraction [firstNumber, secondNumber, expected]")
    @ParameterizedTest
    //@MethodSource("testDivisionInputParameters")
    //@MethodSource()
    /*@CsvSource({
            "6.2, 2, 3.1",
            "71, 14, 5.07",
            "18.3, 3.1, 5.90"
    })*?
    /*
    @CsvSource({
        "Pelé, Football",
        "Senna, F1",
        "Keith Moon, ''"
     */
    @CsvFileSource(resources = "/testDivision.csv")
    void testDivision(double firstNumber, double secondNumber, double expected) {

        System.out.println("Test " + firstNumber + " / " + secondNumber + " = " + expected + "!");
        Double actual = math.division(firstNumber, secondNumber);

        assertEquals(expected, actual, 2D,
                () -> firstNumber + "/" + secondNumber +
                " did not produce" + expected + "!");
    }

    /*public static Stream<Arguments> testDivision() {
        return Stream.of(
                Arguments.of(6.2D,2D,3.1),
                Arguments.of(71D, 14D, 5.07D),
                Arguments.of(18.3, 3.1D, 5.90D)
        );
    }*/

    // @Disabled("TODO: We need still work on it!")
    @Test
    @DisplayName("Test Division by Zero")
    void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException() {

        // Given
        double firstNumber = 6.2D;
        double secondNumber = 0D;

        var expectedMessage = "Impossible to divide by zero!";

        // When & Then
        ArithmeticException actual = assertThrows(
                ArithmeticException.class, () -> {
                    // When & Then
                    math.division(firstNumber, secondNumber);
                }, () -> "Division by zero should throw an ArithmeticException");

        assertEquals(expectedMessage, actual.getMessage(),
                () -> "Unexpected exception message!");
    }
}
