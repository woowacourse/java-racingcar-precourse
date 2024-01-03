package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = createCars();

        int tryCount = receiveTryCount();

        runRacingGame(cars, tryCount);

        printWinners(findWinners(cars));
    }

    private static List<Car> createCars() {
        List<String> carNames = null;
        List<Car> cars = new ArrayList<>();
        while (carNames == null) {
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
            String input = Console.readLine();
            try {
                carNames = Arrays.asList(input.split(",", -1));
                carNames.forEach(inputName -> cars.add(new Car(inputName))); // carNames 리스트의 각 요소를 inputName으로 받아서 객체를 생성하고 cars 리스트에 추가함.
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 형식의 자동차 이름을 입력하세요.");
            }
        }
        return cars;
    }

    private static int receiveTryCount() {
        int tryCount = 0;
        while (tryCount == 0) {
            System.out.println("시도할 횟수는 몇 회인가요?");
            String input = Console.readLine();
            try {
                tryCount = Integer.parseInt(input); // 문자열을 정수로 변환하는 문법
                validateTryCount(tryCount);
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 형식의 숫자를 입력하세요.");
            }
        }
        return tryCount;
    }

    private static void validateTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void runRacingGame(List<Car> cars, int tryCount) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.moveForward();
            }
            printRoundResult(cars);
        }
    }

    private static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + new String(new char[car.getPosition()]).replace('\0', '-'));
        }
        System.out.println();
    }

    private static List<String> findWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private static int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
