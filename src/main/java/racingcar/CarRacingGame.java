package racingcar;

import java.io.IOException;
import java.util.List;

public class CarRacingGame {
    private final String RESTART_GAME_MESSAGE = "[ERROR] 잘못된 입력입니다.";

    private static final List<Car> carList = Car.carList;

    public void startGame() throws IOException {
        String[] cars = askCarName();
        int numberOfAttempts = askNumberOfAttempts();
        makeCarList(cars);
        printDistance(carList, numberOfAttempts);
        Car.getWinner();
    }

    public static void printDistance(List<Car> carList, int trialNum) {
        OutputView.printGameResult();
        for (int i = 0; i < trialNum; i++) {
            for (Car car : carList) {
                Car.canMove(car);
                OutputView.printPlayerAndPosition(car);
            }
            System.out.println();
        }
    }

    private static void makeCarList(String[] cars) {
        for (String name : cars) {
            Car car = new Car(name, 0);
            car.addCarList(car);
        }
    }

    private String[] askCarName() throws IOException {
        String inputCars = InputView.getCarNameList();
        boolean result = InputErrorCheck.isValidCar(inputCars);
        try {
            if (!result) {
                throw new IllegalArgumentException(RESTART_GAME_MESSAGE);
            }
        } catch (Exception e) {
            askCarName();
            throw e;
        }
        String SEPARATOR = ",";
        return inputCars.split(SEPARATOR);
    }

    private int askNumberOfAttempts() throws IOException {
        String inputNumberOfAttempts = InputView.getNumberOfAttempts();
        boolean result = InputErrorCheck.isValidNum(inputNumberOfAttempts);
        try {
            if (!result) {
                throw new IllegalArgumentException(RESTART_GAME_MESSAGE);
            }
        } catch (Exception e) {
            askNumberOfAttempts();
            throw e;
        }
        return Integer.parseInt(inputNumberOfAttempts);
    }
}