package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public static Car[] getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        return splitCars(carNames);
    }

    private static Car[] splitCars(String carNames) {
        String[] cars = carNames.split(",");
        Car[] car = new Car[cars.length];
        for (int i = 0; i < cars.length; i++) {
            car[i] = new Car(cars[i]);
        }
        return car;
    }

    public void move() {
        this.position += 1;
    }
}
