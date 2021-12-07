package racingcar;

import java.io.IOException;

public class CarRacingGame {
    private int numberOfAttempts; // 자동차 경주 게임의 시도 횟수는 numberOfAttempts다.

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
            OutputView.printError("잘못된 입력입니다.");
            return askCarName();
        }
    }

    private int askNumberOfAttempts() { // 터미널에서 게임 시도 횟수(1이상의 정수)를 받아서 반환하는 기능
        try {
            String inputNumberOfAttempts = InputView.getNumberOfAttempts(); // 터미널에서 입력한 문자열을 String 변수 inputNumberOfAttepmts에 저장
            InputErrorCheck.checkValidNumber(inputNumberOfAttempts); // 문자열 inputNumberOfAttempts가 1 이상의 정수인지 체크 -> 아니면 thorw IllegalArgumentException

            return Integer.parseInt(inputNumberOfAttempts); // true면 문자열 inputNumberOfAttepmpts를 parsing한 정수를 반환한다.
        } catch (IllegalArgumentException exception) {
            OutputView.printError("숫자를 입력하세요.");
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