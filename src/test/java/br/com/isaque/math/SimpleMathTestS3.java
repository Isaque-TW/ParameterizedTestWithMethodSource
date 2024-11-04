package br.com.isaque.math;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("Test Math Operations in SimpleMath Class")
public class SimpleMathTestS3 {

    SimpleMath math;
    @BeforeAll
    static void setup() {
        System.out.println("Running @BeforeAll method!");
    }
    @AfterAll
    static void cleanup() {
        System.out.println("Running @AfterAll method!");
    }

    @BeforeEach
    void beforeEachMethod() {
        math = new SimpleMath();
        System.out.println("Running @BeforeEach method!");
    }

    @AfterEach
    void afterEachMethod() {
        System.out.println("Running @AfterEach method!");
    }

    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @Test
    @DisplayName("Test 6.2 + 2 = 8.2")
    void testSum_When_SixDotTwoIsAddedByTwo_ShouldReturnEightDotTwo() {
        System.out.println("Test 6.2 + 2 = 8.2");
        // Given / Arrange
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        double expected = 8.2D;
        // When / Act
        Double actual = math.sum(firstNumber, secondNumber); // Chamar o SimpleMath, fazer uma operacao e verificar se é o que esperamos.

        // Then / Assert
        assertEquals(expected, actual,  () -> firstNumber
                + "+" + secondNumber + " did not produce "
                + expected + "!" ); // Usamos a classe Assertion do JUnit para comparar diversas possibilidades. Verifica se o resultado da operação é verdadeiro da variavel result
        assertNotEquals(9.2, actual, "6.2+2 did not produce 8.2");
        assertNotNull(actual);
    }

    @Test
    @DisplayName("Test 6.2 - 2 = 4.2")
    void testSubtraction() {
        System.out.println("Test 6.2 - 2 = 4.2");

        double firstNumber = 6.2D;
        double secondNumber = 2D;

        Double actual = math.subtraction(firstNumber, secondNumber);
        double expected = 4.2D;

        assertEquals(expected, actual,
                () -> firstNumber + "-" + secondNumber +
                        " did not produce " + expected + "!");
    }

    @Test
    @DisplayName("Test 6.2 * 2 = 12.4")
    void testMultiplication() {
        System.out.println("Test 6.2 * 2 = 12.4");

        double firstNumber = 6.2D;
        double secondNumber = 2D;

        Double actual = math.multiplication(firstNumber, secondNumber);
        double expected = 12.4;

        assertEquals(expected, actual,
                () -> firstNumber + "*" + secondNumber +
                " did not produce" + expected + "!");
    }

    @Test
    @DisplayName("Test 6.2 / 2 = 3.1")
    void testDivision() {
        System.out.println("Test 6.2 / 2 = 3.1");

        double firstNumber = 6.2D;
        double secondNumber = 2D;

        Double actual = math.division(firstNumber, secondNumber);
        double expected = 3.1;

        assertEquals(expected, actual,
                () -> firstNumber + "/" + secondNumber +
                " did not produce" + expected + "!");
    }

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

    @Test
    @DisplayName("Test (6.2 + 2) / 2 = 4.1")
    void testMean() {
        System.out.println("Test (6.2 + 2) / 2 = 4.1");

        double firstNumber = 6.2D;
        double secondNumber = 2D;

        Double actual = math.mean(firstNumber, secondNumber);
        double expected = 4.1D;

        assertEquals(expected, actual,
                () -> "(" + firstNumber + "+" + secondNumber + ")/2" +
                " did not produce " + expected + "!");
    }

    @Test
    @DisplayName("Test Square Root of 81 = 9")
    void testSquareRoot() {
        System.out.println("Test Square Root of 81 = 9");

        double number = 81D;
        double expected = 9D;

        Double actual = math.squareRoot(number);

        assertEquals(expected, actual,
                () -> "Square Root of " + number +
                " did not produce " + expected + "!");
    }

    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @DisplayName("Display Name")
    @Test
    void testABCD_When_XYZ_Should() {
        System.out.println("Test BDD");
        // Given / Arrange
        // When / Act
        // Then / Assert
        // test
    }
}
