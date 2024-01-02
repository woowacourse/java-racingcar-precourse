package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = receiveCarNames();

        List<Car> cars = createCars(carNames);

        int tryCount = receiveTryCount();

        runRacingGame(cars, tryCount);

        printWinners(findWinners(cars));
    }


    private static List<String> receiveCarNames() {
        List<String> carNames;
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
            String input = Console.readLine();
            carNames = Arrays.asList(input.split(",", -1));
            try { // 예외가 발생한다면? -> catch
                validateCarNames(carNames); // 유효성 검사
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 형식의 자동차 이름을 입력하세요.");
            }
        }
        return carNames;
    }

    private static void validateCarNames(List<String> carNames) {
        for (String inputName : carNames) {
            int MAX_NAME_LENGTH = 5;
            if (inputName.isEmpty() || inputName.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
        Set<String> uniqueNames = new HashSet<>(carNames); // 중복을 허용하지 않는 자료구조
        if (uniqueNames.size() < carNames.size()) { // 작다면 중복된 이름이 있다는 것을 의미함
            throw new IllegalArgumentException();
        }
    }

    private static int receiveTryCount() {
        int tryCount;
        while (true) {
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

    private static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>(); // 리스트 생성 후 리스트의 원소가 Car 클래스의 인스턴스가 되도록
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
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
