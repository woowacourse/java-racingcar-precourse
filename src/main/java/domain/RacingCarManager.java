package domain;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingCarManager {
    private int tryTimes;
    private List<String> carName = new LinkedList<>();
    private List<Car> registeredCar = new LinkedList<>();

    public boolean start() {
        if (!carNameGenerator() || !tryTimeGenerator()) {
            return false;
        }

        carGenerator(registeredCar, carName);
        gameProgressing();
        System.out.println(gameFinish(registeredCar) + "가 최종 우승했습니다.");

        return true;
    }

    private boolean carNameGenerator() {
        Validator validator = new Validator();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = new Scanner(System.in).nextLine();

        if (validator.isContainsSpace(carNames)) {
            return false;
        }
        carName = validator.splitName(carNames);

        return validator.isNotNull(carName)
                && validator.isNotExcess(carName)
                && validator.isNotBelowZero(carName)
                && validator.isNotOverlap(carName);
    }

    private boolean tryTimeGenerator() {
        System.out.println("시도할 회수는 몇회인가요?");
        tryTimes = new Scanner(System.in).nextInt();

        return new Validator().isNotBelowZero(tryTimes);
    }

    public int carGenerator(List<Car> target, List<String> source) {
        for (String name : source) {
            target.add(new Car(name));
        }

        return target.size();
    }

    private void gameProgressing() {
        RacingCarProcessor racingCarProcessor = new RacingCarProcessor();

        for (Car car : registeredCar) {
            car.setGoForward(racingCarProcessor
                    .carMovementRandomGenerator(tryTimes));
        }
        System.out.println("실행 결과");

        for (int i = 0; i < tryTimes; i++) {
            racingCarProcessor.iteratorCarPositionCheck(registeredCar, i);
        }
    }

    public String gameFinish(List<Car> registeredCar) {
        return registeredCar.stream()
                .filter(car -> car.getPosition() == highestPosition(registeredCar))
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int highestPosition(List<Car> registeredCar) {
        return registeredCar.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}
