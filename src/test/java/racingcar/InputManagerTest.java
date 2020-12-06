package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class InputManagerTest {

    @Test
    public void testCase1_isCountOfAttemptsNumeric() {
        //GIVEN
        String countOfAttempts = "10";
        InputManager inputManager = new InputManager(new Scanner(countOfAttempts));

        //WHEN
        boolean actualResult = true;
        try {
            inputManager.inputCountOfAttempts();
        } catch (Exception e) {
            if (e.getMessage().equals(Constants.COUNT_ERROR_STATEMENT)) {
                actualResult = false;
            }
        }

        //THEN
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void testCase2_isNumberOfAttemptsNumeric() {
        //GIVEN
        String countOfAttempts = "a5";
        InputManager inputManager = new InputManager(new Scanner(countOfAttempts));

        //WHEN
        boolean actualResult = true;
        try {
            inputManager.inputCountOfAttempts();
        } catch (Exception e) {
            if (e.getMessage().equals(Constants.COUNT_ERROR_STATEMENT)) {
                actualResult = false;
            }
        }

        //THEN
        Assertions.assertFalse(actualResult);
    }

    @Test
    public void testCase3_isNumberOfAttemptsNumeric() {
        //GIVEN
        String countOfAttempts = "09";
        InputManager inputManager = new InputManager(new Scanner(countOfAttempts));

        //WHEN
        boolean actualResult = true;
        try {
            inputManager.inputCountOfAttempts();
        } catch (Exception e) {
            if (e.getMessage().equals(Constants.COUNT_ERROR_STATEMENT)) {
                actualResult = false;
            }
        }

        //THEN
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void testCase4_isNumberOfAttemptsNumeric() {
        //GIVEN
        String countOfAttempts = "aB";
        InputManager inputManager = new InputManager(new Scanner(countOfAttempts));

        //WHEN
        boolean actualResult = true;
        try {
            inputManager.inputCountOfAttempts();
        } catch (Exception e) {
            if (e.getMessage().equals(Constants.COUNT_ERROR_STATEMENT)) {
                actualResult = false;
            }
        }

        //THEN
        Assertions.assertFalse(actualResult);
    }

    @Test
    public void testCase5_isNumberOfAttemptsNumeric() {
        //GIVEN
        String countOfAttempts = "10a";
        InputManager inputManager = new InputManager(new Scanner(countOfAttempts));

        //WHEN
        boolean actualResult = true;
        try {
            inputManager.inputCountOfAttempts();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (e.getMessage().equals(Constants.COUNT_ERROR_STATEMENT)) {
                actualResult = false;
            }
        }

        //THEN
        Assertions.assertFalse(actualResult);
    }
}
