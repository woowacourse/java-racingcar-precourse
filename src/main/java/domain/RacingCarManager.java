package domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RacingCarManager {
    List<Car> registeredCars = new LinkedList<>();

    public boolean start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        if (!carName(new Scanner(System.in).next())) {
            return false;
        }

        System.out.println("시도할 회수는 몇회인가요?");
        //tryTimes();

        return true;
    }

    public boolean carName(String name) {
        Validator validator = new Validator();

        //registeredCars = validator.splitName(name);
        /*if (validator.isNotNull(registeredCars)
                && validator.isNotExcess(registeredCars) && validator.isNotBelowZero(registeredCars)) {
            return true;
        }*/
        return false;
    }

}
