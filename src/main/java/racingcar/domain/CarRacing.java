package racingcar.domain;

import racingcar.view.OutputView;

import java.util.*;

/**
 * 자동차 경주 게임에 대한 클래스
 *
 * @author Daeun Lee
 */
public class CarRacing {
    private static ArrayList<Car> cars = new ArrayList<>();
    private static int times;

    /**
     * @param scanner 입력 값
     */
    public static void runCarRacing(Scanner scanner) {
        startCarRacing(scanner);
        playCarRacing();
        finishCarRacing();
    }

    /**
     * @param scanner 입력 값
     */
    public static void startCarRacing(Scanner scanner) {
        cars = Initialization.initCars(scanner);
        times = Initialization.initTimes(scanner);
        OutputView.printNewLine();
    }

    public static void playCarRacing() {
        OutputView.printResultText();

        for (int i = 0; i < times; i++) {
            for (Car car : cars) {
                Car.moveCar(car);
            }
            Result.showResult(cars);
            OutputView.printNewLine();
        }
    }

    public static void finishCarRacing() {
        Winner.showWinner(cars);
    }
}
