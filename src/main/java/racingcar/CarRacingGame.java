package racingcar;

import java.io.IOException;

public class CarRacingGame {
    private int numberOfAttempts;

    public void startGame() throws IOException {
        String[] cars = askCarName();
        numberOfAttempts = askNumberOfAttempts();
        makeCarList(cars);
        moveCars();
        Car.getWinner();
    }

    private static void makeCarList(String[] cars) {
        for (String name : cars) {
            Car car = new Car(name);
            car.addCarList(car);
        }
    }

    private String[] askCarName() {
        try {
            String inputCars = InputView.getCarNameList();
            InputErrorCheck.isValidCar(inputCars);
            String SEPARATOR = ",";
            return inputCars.split(SEPARATOR);
        } catch (IllegalArgumentException exception) {
            OutputView.printError("잘못된입력입니다.");
            return askCarName();
        }
    }

    private int askNumberOfAttempts() {
        try {
            String inputNumberOfAttempts = InputView.getNumberOfAttempts();
            InputErrorCheck.checkValidNumber(inputNumberOfAttempts);
            return Integer.parseInt(inputNumberOfAttempts);
        } catch (IllegalArgumentException exception) {
            OutputView.printError("숫자를입력하세요.");
            return askNumberOfAttempts();
        }
    }

    private void moveCars() {
        OutputView.printGameResult();
        for (int i = 0; i < numberOfAttempts; i++) {
            Car.moveCar();
            for (Car car : Car.carList) {
                OutputView.printCarName(car.getName());
                OutputView.printPosition(car.getPosition());
            }
            System.out.println();
        }
    }
}