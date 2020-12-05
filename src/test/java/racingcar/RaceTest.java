package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class RaceTest {

    @Test
    public void testCase1_isCarNameEnteredCorrectly() {
        //GIVEN
        String carNames = "pobi,jun,woni";
        InputManager inputManager = new InputManager(new Scanner(carNames));
        boolean expectedResult = true;

        //WHEN
        boolean actualRusult = true;
        try {
            Race.generateRace(inputManager);
        } catch (Exception e) {
            if (e.getMessage() == null) {
                actualRusult = false;
            }
        }

        //THEN
        Assertions.assertEquals(expectedResult, actualRusult);
    }

    @Test
    public void testCase2_isCarNameEnteredCorrectly() {
        //GIVEN
        String carNames = "pobieg,jun,woni";
        InputManager inputManager = new InputManager(new Scanner(carNames));
        boolean expectedResult = false;

        //WHEN
        boolean actualRusult = true;
        try {
            Race.generateRace(inputManager);
        } catch (Exception e) {
            if (e.getMessage() == null) {
                actualRusult = false;
            }
        }

        //THEN
        Assertions.assertEquals(expectedResult, actualRusult);
    }

    @Test
    public void testCase3_isCarNameEnteredCorrectly() {
        //GIVEN
        String carNames = "pobi,pobi,woni";
        InputManager inputManager = new InputManager(new Scanner(carNames));
        boolean expectedResult = false;

        //WHEN
        boolean actualRusult = true;
        try {
            Race.generateRace(inputManager);
        } catch (Exception e) {
            if (e.getMessage() == null) {
                actualRusult = false;
            }
        }

        //THEN
        Assertions.assertEquals(expectedResult, actualRusult);
    }

    @Test
    public void testCase4_isCarNameEnteredCorrectly() {
        //GIVEN
        String carNames = ",,";
        InputManager inputManager = new InputManager(new Scanner(carNames));
        boolean expectedResult = false;

        //WHEN
        boolean actualRusult = true;
        try {
            Race.generateRace(inputManager);
        } catch (Exception e) {
            if (e.getMessage() == null) {
                actualRusult = false;
            }
        }

        //THEN
        Assertions.assertEquals(expectedResult, actualRusult);
    }

    @Test
    public void testCase5_isCarNameEnteredCorrectly() {
        //GIVEN
        String carNames = ",pobi,";
        InputManager inputManager = new InputManager(new Scanner(carNames));
        boolean expectedResult = false;

        //WHEN
        boolean actualRusult = true;
        try {
            Race.generateRace(inputManager);
        } catch (Exception e) {
            if (e.getMessage() == null) {
                actualRusult = false;
            }
        }

        //THEN
        Assertions.assertEquals(expectedResult, actualRusult);
    }

}
