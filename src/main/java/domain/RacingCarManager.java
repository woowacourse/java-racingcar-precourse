package domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RacingCarManager {
    List<String> carName = new LinkedList<>();
    List<Car> registeredCars = new LinkedList<>();
    private String carNames;
    private int tryTimes;

    public boolean start() {
        if (!carNameGenerator()) {
            return false;
        }

       if (!tryTimeGenerator()) {
           return false;
       }

        return true;
    }

    public boolean carNameGenerator() {
        Validator validator = new Validator();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = new Scanner(System.in).next();

        carName = validator.splitName(carNames);

        return validator.isNotNull(carName) && validator.isNotExcess(carName) && validator.isNotBelowZero(carName);
    }

    public boolean tryTimeGenerator() {
        System.out.println("시도할 회수는 몇회인가요?");
        tryTimes = new Scanner(System.in).nextInt();

        return new Validator().isNotBelowZero(tryTimes);
    }
}
