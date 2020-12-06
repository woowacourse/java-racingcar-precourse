package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RaceTest {

    @Test
    public void testCase1_isCarNameEnteredCorrectly() {
        //GIVEN
        String carNames = "pobi,jun,woni";
        InputManager inputManager = new InputManager(new Scanner(carNames));
        String[] splitedNames = carNames.split(Constants.SEPARATOR);
        boolean expectedResult = true;

        //WHEN
        boolean actualRusult = true;
        try {
            Race race = Race.generateRace(inputManager);
            if (splitedNames.length != race.getCars().size()) {
                actualRusult = false;
            }
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
        String[] splitedNames = carNames.split(Constants.SEPARATOR);
        boolean expectedResult = true;

        //WHEN
        boolean actualRusult = true;
        try {
            Race race = Race.generateRace(inputManager);
            if (splitedNames.length != race.getCars().size()) {
                actualRusult = false;
            }
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
        String[] splitedNames = carNames.split(Constants.SEPARATOR);
        boolean expectedResult = true;

        //WHEN
        boolean actualRusult = true;
        try {
            Race race = Race.generateRace(inputManager);
            if (splitedNames.length != race.getCars().size()) {
                actualRusult = false;
            }
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
        String[] splitedNames = carNames.split(Constants.SEPARATOR);
        boolean expectedResult = true;

        //WHEN
        boolean actualRusult = true;
        try {
            Race race = Race.generateRace(inputManager);
            if (splitedNames.length != race.getCars().size()) {
                actualRusult = false;
            }
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
        String[] splitedNames = carNames.split(Constants.SEPARATOR);
        boolean expectedResult = true;

        //WHEN
        boolean actualRusult = true;
        try {
            Race race = Race.generateRace(inputManager);
            if (splitedNames.length != race.getCars().size()) {
                actualRusult = false;
            }
        } catch (Exception e) {
            if (e.getMessage() == null) {
                actualRusult = false;
            }
        }

        //THEN
        Assertions.assertEquals(expectedResult, actualRusult);
    }

    @Test
    public void testCase6_isCarNameEnteredCorrectly() {
        //GIVEN
        String carNames = "pobi, jun,woni";
        InputManager inputManager = new InputManager(new Scanner(carNames));
        String[] splitedNames = carNames.split(Constants.SEPARATOR);
        boolean expectedResult = true;

        //WHEN
        boolean actualRusult = true;
        try {
            Race race = Race.generateRace(inputManager);
            if (splitedNames.length != race.getCars().size()) {
                actualRusult = false;
            }
        } catch (Exception e) {
            if (e.getMessage() == null) {
                actualRusult = false;
            }
        }

        //THEN
        Assertions.assertEquals(expectedResult, actualRusult);
    }

    @Test
    public void testCase7_isCarNameEnteredCorrectly() {
        //GIVEN
        String carNames = " , , ";
        InputManager inputManager = new InputManager(new Scanner(carNames));
        String[] splitedNames = carNames.split(Constants.SEPARATOR);
        boolean expectedResult = true;

        //WHEN
        boolean actualRusult = true;
        try {
            Race race = Race.generateRace(inputManager);
            if (splitedNames.length != race.getCars().size()) {
                actualRusult = false;
            }
        } catch (Exception e) {
            if (e.getMessage() == null) {
                actualRusult = false;
            }
        }

        //THEN
        Assertions.assertEquals(expectedResult, actualRusult);
    }

    @Test
    public void testCase1_isWinnerDecidedCorrectly() {
        //GIVEN
        List<Car> cars = Arrays.asList(new Car("davinci").setPosition(2),
                                        new Car("pobi").setPosition(4),
                                        new Car("woni").setPosition(1));
        Race race = new Race(cars);
        String expectedResult = "최종 우승자: pobi";

        //WHEN
        String actualResult = race.decideWinner();

        //THEN
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase2_isWinnerDecidedCorrectly() {
        //GIVEN
        List<Car> cars = Arrays.asList(new Car("davinci").setPosition(4),
                                        new Car("pobi").setPosition(4),
                                        new Car("woni").setPosition(1));
        Race race = new Race(cars);
        String expectedResult = "최종 우승자: davinci, pobi";

        //WHEN
        String actualResult = race.decideWinner();

        //THEN
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase3_isWinnerDecidedCorrectly() {
        //GIVEN
        List<Car> cars = Arrays.asList(new Car("davinci").setPosition(2),
                                        new Car("pobi").setPosition(2),
                                        new Car("woni").setPosition(2));
        Race race = new Race(cars);
        String expectedResult = "최종 우승자: davinci, pobi, woni";

        //WHEN
        String actualResult = race.decideWinner();

        //THEN
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase4_isWinnerDecidedCorrectly() {
        //GIVEN
        List<Car> cars = Arrays.asList(new Car("davinci").setPosition(1),
                                        new Car("pobi").setPosition(2),
                                        new Car("woni").setPosition(3));

        Race race = new Race(cars);
        String expectedResult = "최종 우승자: woni";

        //WHEN
        String actualResult = race.decideWinner();

        //THEN
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase5_isWinnerDecidedCorrectly() {
        //GIVEN
        List<Car> cars = Arrays.asList(new Car("davinci").setPosition(1),
                                        new Car("pobi").setPosition(2),
                                        new Car("woni").setPosition(2));
        Race race = new Race(cars);
        String expectedResult = "최종 우승자: pobi, woni";

        //WHEN
        String actualResult = race.decideWinner();

        //THEN
        Assertions.assertEquals(expectedResult, actualResult);
    }

}
