package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
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

    @Test
    public void testCase1_isWinnerDecidedCorrectly() {
        //GIVEN
        List<Car> cars = new ArrayList<>();
        Car davinciCar = new Car("davinci");
        davinciCar.setPosition(2);
        Car pobiCar = new Car("pobi");
        pobiCar.setPosition(4);
        Car woniCar = new Car("woni");
        woniCar.setPosition(1);
        cars.add(davinciCar);
        cars.add(pobiCar);
        cars.add(woniCar);

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
        List<Car> cars = new ArrayList<>();
        Car davinciCar = new Car("davinci");
        davinciCar.setPosition(4);
        Car pobiCar = new Car("pobi");
        pobiCar.setPosition(4);
        Car woniCar = new Car("woni");
        woniCar.setPosition(1);
        cars.add(davinciCar);
        cars.add(pobiCar);
        cars.add(woniCar);

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
        List<Car> cars = new ArrayList<>();
        Car davinciCar = new Car("davinci");
        davinciCar.setPosition(2);
        Car pobiCar = new Car("pobi");
        pobiCar.setPosition(2);
        Car woniCar = new Car("woni");
        woniCar.setPosition(2);
        cars.add(davinciCar);
        cars.add(pobiCar);
        cars.add(woniCar);

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
        List<Car> cars = new ArrayList<>();
        Car davinciCar = new Car("davinci");
        davinciCar.setPosition(1);
        Car pobiCar = new Car("pobi");
        pobiCar.setPosition(2);
        Car woniCar = new Car("woni");
        woniCar.setPosition(3);
        cars.add(davinciCar);
        cars.add(pobiCar);
        cars.add(woniCar);

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
        List<Car> cars = new ArrayList<>();
        Car davinciCar = new Car("davinci");
        davinciCar.setPosition(1);
        Car pobiCar = new Car("pobi");
        pobiCar.setPosition(2);
        Car woniCar = new Car("woni");
        woniCar.setPosition(2);
        cars.add(davinciCar);
        cars.add(pobiCar);
        cars.add(woniCar);

        Race race = new Race(cars);
        String expectedResult = "최종 우승자: pobi, woni";

        //WHEN
        String actualResult = race.decideWinner();

        //THEN
        Assertions.assertEquals(expectedResult, actualResult);
    }

}
