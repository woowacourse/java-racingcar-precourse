package domain;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingCarManager {
    private final int BEST_DRIVER_POSITION = 0;
    private List<String> carName = new LinkedList<>();
    private List<Car> registeredCar = new LinkedList<>();
    private int tryTimes;

    public boolean start() {
        if (!carNameGenerator() || !tryTimeGenerator()) {
            return false;
        }

        carGenerator(registeredCar, carName);
        gameProgressing();

        return true;
    }

    public boolean carNameGenerator() {
        Validator validator = new Validator();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = new Scanner(System.in).next();

        carName = validator.splitName(carNames);

        return validator.isNotNull(carName)
                && validator.isNotExcess(carName)
                && validator.isNotBelowZero(carName);
    }

    public boolean tryTimeGenerator() {
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

    public void gameProgressing() {
        RacingCarProcessor racingCarProcessor = new RacingCarProcessor();

        for (Car car : registeredCar) {
            car.setGoForward(racingCarProcessor.carMovementRandomGenerator(tryTimes));
        }
        System.out.println("실행 결과");
        for (int i = 0; i < tryTimes; i++) {
            racingCarProcessor.iteratorCarPositionCheck(registeredCar, i);
        }
    }
}
