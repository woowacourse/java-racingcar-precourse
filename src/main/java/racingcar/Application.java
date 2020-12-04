package racingcar;

import java.util.Scanner;

public class Application {

    private static String[] inputCarNames(Scanner scanner) throws Exception {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = scanner.next();
        String[] carNames = names.split(",");
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > 4) {
                throw new Exception("자동차 이름은 5자 이하여만 한다.");
            }
        }
        return carNames;
    }

    private static int inputNumberOfAttempts(Scanner scanner) throws Exception {
        int attemptNumber = 0;
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            attemptNumber = scanner.nextInt();
        } catch (Exception e) {
            throw new Exception("[ERROR] 시도횟수는 숫자여야 한다.");
        }
        return attemptNumber;
    }

    private static Car[] createCars(String[] carNames) {
        return new Car[0];
    }

    private static int findMaxPosition(Car[] cars) {
        return 0;
    }

    private static void printResult(Car[] cars) {

    }


    public static void main(String[] args) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        String[] carNames = inputCarNames(scanner);
        int attemptNumber = inputNumberOfAttempts(scanner);
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