package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        String[] carNames = UserInput.getCarNames(scanner);
        int stageCount = UserInput.getStageCount(scanner);
        Car[] cars = createCars(carNames);
        Simulator.simulateGame(cars, stageCount);
    }

    public static Car[] createCars(String[] carNames) {
        Car[] cars = new Car[carNames.length];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(carNames[i]);
        }

        return cars;
    }
}
