package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class InputManagerTest {

    @Test
    public void testCase1_isNumberOfAttemptsNumeric() {
        //GIVEN
        String numberOfAttempts = "10";
        InputManager inputManager = new InputManager(new Scanner(numberOfAttempts));
        boolean expectedResult = true;

        //WHEN
        boolean actualRusult = true;
        try {
            inputManager.inputTrialCount();
        } catch (Exception e) {
            if (e.getMessage().equals(Constants.COUNT_ERROR_STATEMENT)) {
                actualRusult = false;
            }
        }

        //THEN
        Assertions.assertEquals(expectedResult, actualRusult);
    }

    @Test
    public void testCase2_isNumberOfAttemptsNumeric() {
        //GIVEN
        String numberOfAttempts = "a5";
        InputManager inputManager = new InputManager(new Scanner(numberOfAttempts));
        boolean expectedResult = false;

        //WHEN
        boolean actualRusult = true;
        try {
            inputManager.inputTrialCount();
        } catch (Exception e) {
            if (e.getMessage().equals(Constants.COUNT_ERROR_STATEMENT)) {
                actualRusult = false;
            }
        }

        //THEN
        Assertions.assertEquals(expectedResult, actualRusult);
    }

    @Test
    public void testCase3_isNumberOfAttemptsNumeric() {
        //GIVEN
        String numberOfAttempts = "09";
        InputManager inputManager = new InputManager(new Scanner(numberOfAttempts));
        boolean expectedResult = true;

        //WHEN
        boolean actualRusult = true;
        try {
            inputManager.inputTrialCount();
        } catch (Exception e) {
            if (e.getMessage().equals(Constants.COUNT_ERROR_STATEMENT)) {
                actualRusult = false;
            }
        }

        //THEN
        Assertions.assertEquals(expectedResult, actualRusult);
    }

    @Test
    public void testCase4_isNumberOfAttemptsNumeric() {
        //GIVEN
        String numberOfAttempts = "aB";
        InputManager inputManager = new InputManager(new Scanner(numberOfAttempts));
        boolean expectedResult = false;

        //WHEN
        boolean actualRusult = true;
        try {
            inputManager.inputTrialCount();
        } catch (Exception e) {
            if (e.getMessage().equals(Constants.COUNT_ERROR_STATEMENT)) {
                actualRusult = false;
            }
        }

        //THEN
        Assertions.assertEquals(expectedResult, actualRusult);
    }

    @Test
    public void testCase5_isNumberOfAttemptsNumeric() {
        //GIVEN
        String numberOfAttempts = "10a";
        InputManager inputManager = new InputManager(new Scanner(numberOfAttempts));
        boolean expectedResult = false;

        //WHEN
        boolean actualRusult = true;
        try {
            inputManager.inputTrialCount();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (e.getMessage().equals(Constants.COUNT_ERROR_STATEMENT)) {
                actualRusult = false;
            }
        }

        //THEN
        Assertions.assertEquals(expectedResult, actualRusult);
    }
}
