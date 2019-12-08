package com.racingcar;

import java.util.*;

/**
 * Input
 *
 * @author hyochan
 * @version 0.0.1
 * @since 2019-12-06
 */

public class Input {
    Scanner scan = new Scanner(System.in);

    public List<Car> inputCarNames() {
        Validator validator = new Validator();
        List<String> carNames;
        String input;

        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            input = scan.nextLine();
            carNames = splitNames(input);
            if (validator.isValidName(carNames)) {
                break;
            }
            System.out.println("정상적인 입력이 아닙니다.");
        }
        return stringToCar(carNames);
    }

    public List<String> splitNames(String input) {
        List<String> carNames = new ArrayList<>();
        Collections.addAll(carNames, input.split(","));
        return carNames;
    }

    public List<Car> stringToCar(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        Iterator itr = carNames.iterator();
        while (itr.hasNext()) {
            String carName = (String) itr.next();
            Car tmpObject = new Car(carName);
            cars.add(tmpObject);
        }
        return cars;
    }

    public int inputCount() {
        Validator validator = new Validator();
        int count;

        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            count = scan.nextInt();
            if (validator.isValidCount(count)) {
                break;
            }
            System.out.println("정상적인 입력이 아닙니다.");
        }
        return count;
    }
}
