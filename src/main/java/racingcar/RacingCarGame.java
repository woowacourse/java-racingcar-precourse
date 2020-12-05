package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingCarGame {

    ArrayList<Car> carList = new ArrayList<>();
    private int carCount = 0;
    private int tryCount = 0;
//    private int firstScore = 0;

    public void start(Scanner scanner) {
        carNamesInput(scanner);
        tryCountInput(scanner);
        gameProgress();
        // printCarName();
    }

    private void carNamesInput(Scanner scanner) {
        try {
            System.out.println(Constants.NAME_INPUT_REQ_MSG);
            String names = scanner.nextLine();
            if (!Validator.isValidName(names)) throw new Exception(Constants.STANDARD_ERROR_MSG);
            setCarList(names);

        } catch (Exception e) {
            System.err.println(e.getMessage() + " " + Constants.NAME_ERROR_MSG);
            carNamesInput(scanner);
        }
    }

    private void setCarList(String names) {
        String[] splitNames = names.split(",");
        for (String name : splitNames) {
            carList.add(new Car(name));
            carCount++;
        }
    }

    private void tryCountInput(Scanner scanner) {
        try {
            System.out.println(Constants.TRY_COUNT_INPUT_REQ_MSG);
            tryCount = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.err.println(Constants.STANDARD_ERROR_MSG + " " + Constants.TRY_COUNT_ERROR_MSG);
            tryCountInput(scanner);
        }
    }

    private void gameProgress() {
        for (int i = 0; i < tryCount; ++i) {
            carMoveOrNot();
        }
    }

    private void carMoveOrNot() {
        for (Car car : carList) {
            int randomNum = RandomUtils.nextInt(0, 9);
            car.carMove(randomNum);
        }
    }

    private void printCarName() {
        for (Car car : carList) {
            System.out.println(car.getName());
        }
    }
}
