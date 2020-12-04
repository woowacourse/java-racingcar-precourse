package racingcar;

import java.util.Scanner;

public class Application {

    private static String[] inputCarNames() {
        return new String[0];
    }

    private static int inputNumberOfAttempts() {
        return 0;
    }

    private static Car[] createCars(String[] carNames) {
        return new Car[0];
    }

    private static int findMaxPosition(Car[] cars) {
        return 0;
    }

    private static void printResult(Car[] cars) {

    }


    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        String[] carNames = inputCarNames();
        int attemptNumber = inputNumberOfAttempts();
        Car[] cars = createCars(carNames);
        boolean isNotFinish = true;
        for (int i = 0; i < attemptNumber; i++) {
            for (int j = 0; j < cars.length; i++) {
                cars[j].carMove();
            }
        }
        printResult(cars);
    }
}