package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RacingCarGame {

    private ArrayList<Car> carList = new ArrayList<>();
    private int tryCount = 0;
//    private int firstScore = 0;

    public void start(Scanner scanner) {
        carNamesInput(scanner);
        tryCountInput(scanner);
        System.out.println(Constants.PROGRESS_RESULT);
        gameProgress();
    }

    private void carNamesInput(Scanner scanner) {
        try {
            System.out.println(Constants.NAME_INPUT_REQ_MSG);
            String names = scanner.nextLine();
            if (!Validator.isValidName(names)) {
                throw new Exception(Constants.STANDARD_ERROR_MSG);
            }
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
            printCarStatus();
            System.out.println();
        }
    }

    private void carMoveOrNot() {
        for (Car car : carList) {
            int randomNum = RandomUtils.nextInt(0, 9);
            car.carMove(randomNum);
        }
    }

    private void printCarStatus() {
        for (Car car : carList) {
            car.printCurStatus();
        }
    }
}
