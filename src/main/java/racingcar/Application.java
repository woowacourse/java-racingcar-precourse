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
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }

    private static int findMaxPosition(Car[] cars) {
        int maxNumber = 0;
        for (int i = 0; i < cars.length; i++) {
            if (maxNumber < cars[i].getPosition()) {
                maxNumber = cars[i].getPosition();
            }
        }
        return maxNumber;
    }

    private static void printResult(Car[] cars) {
        int maxPosition = findMaxPosition(cars);
        String resultStr = "최종 우승자:";
        for (int i = 0; i < cars.length; i++) {
            if (maxPosition == cars[i].getPosition()) {
                resultStr += " " + cars[i].getName() + ",";
            }
        }
        final int startIndex = 0;
        final int endIndex = resultStr.length()-1;
        resultStr = resultStr.substring(startIndex, endIndex);
        System.out.println(resultStr);
    }


    public static void main(String[] args) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        String[] carNames = inputCarNames(scanner);
        int attemptNumber = inputNumberOfAttempts(scanner);
        Car[] cars = createCars(carNames);
        for (int i = 0; i < attemptNumber; i++) {
            for (int j = 0; j < cars.length; j++) {
                cars[j].carMove();
            }
            System.out.println();
        }
        printResult(cars);
    }
}