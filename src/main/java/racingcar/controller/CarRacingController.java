package racingcar.controller;

import racingcar.Car;
import racingcar.generator.NumberGenerator;
import racingcar.type.BoundaryType;
import racingcar.type.ErrorType;
import racingcar.type.TextType;
import racingcar.type.ValueType;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

/**
 * 자동차 경주 게임을 컨트롤하는 클래스
 *
 * @author Daeun Lee
 */
public class CarRacingController {

    private static ArrayList<Car> cars = new ArrayList<>();
    private static int times;
    private static ArrayList<Integer> carPositions = new ArrayList<>();
    private static int maxPosition = 1;
    private static ArrayList<String> winner = new ArrayList<>();

    public static void startCarRacing(Scanner scanner) {
        initRacingCar(scanner);
        playCarRacing();
        showWinner();
    }

    public static void initRacingCar(Scanner scanner) {
        initCars(scanner);
        initTimes(scanner);
        OutputView.printNewLine();
    }

    public static void initCars(Scanner scanner) {
        OutputView.printCarNamesText();
        cars = InputView.scanCars(cars, scanner);
    }

    public static void initTimes(Scanner scanner) {
        OutputView.printCarRacingTimesText();
        times = InputView.scanTimes(scanner);
    }

    public static void moveCar(Car car) {
        int randomNumber = NumberGenerator.generateNumber();

        if ((BoundaryType.MINIMUM_MOVE_NUMBER.getBoundary() <= randomNumber) &&
                (randomNumber <= BoundaryType.MAXIMUM_MOVE_NUMBER.getBoundary())) {
            // 자동차는 전진한다.
            car.movePosition();
        }

        if ((BoundaryType.MINIMUM_STOP_NUMBER.getBoundary() <= randomNumber) &&
                (randomNumber <= BoundaryType.MAXIMUM_STOP_NUMBER.getBoundary())) {
            // 자동차는 멈춘다.
            return;
        }
    }

    public static void playCarRacing() {
        OutputView.printResultText();

        for (int i = 0; i < times; i++) {
            for (Car car : cars) {
                moveCar(car);
            }
            showResult();
            OutputView.printNewLine();
        }
    }

    public static StringBuffer countPosition(Car car) {
        StringBuffer carPosition = new StringBuffer();
        for (int i = 0; i < car.getPosition(); i++) {
            carPosition.append(TextType.LINE_TEXT.getText());
        }

        return carPosition;
    }

    public static void showResult() {
        for (Car car : cars) {
            StringBuffer carPosition = countPosition(car);
            OutputView.printResult(car, carPosition);
        }
    }

    public static void addPosition() {
        for (Car car : cars) {
            carPositions.add(car.getPosition());
        }
    }

    public static void calculateMaxPosition() {
        addPosition();

        for (int currentPosition : carPositions) {
            if (maxPosition <= currentPosition) {
                maxPosition = currentPosition;
            }
        }
    }

    public static void checkWinner() {
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winner.add(car.getName());
            }
        }
    }

    public static void showWinner() {
        calculateMaxPosition();
        checkWinner();

        if (winner.size() == ValueType.ZERO.getValue()) {
            isNoWinner();
        }

        if (winner.size() != ValueType.ZERO.getValue()) {
            isWinner();
        }
    }

    public static void isNoWinner() {
        OutputView.printNoWinner();
    }

    public static void isWinner() {
        OutputView.printWinner(winner);
    }
}
