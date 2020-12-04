package racingcar;

import java.util.Scanner;

public class Application {

    private static String[] inputCarNames(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = scanner.next();
        return names.split(",");
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
        String[] carNames = inputCarNames(scanner);
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