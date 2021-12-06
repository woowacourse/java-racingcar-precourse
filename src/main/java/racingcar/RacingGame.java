package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
    private Car[] makeCar() {
        String[] carNames = InputData.getCarName();
        Car[] cars = new Car[carNames.length];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(carNames[i]);
        }

        return cars;
    }

    private void moveForward(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
//            System.out.print(randomNumber);
            if (randomNumber >= 4) {
//                System.out.print(" 전진");
                cars[i].moveForward();
            }
//            System.out.println();
            cars[i].moveResult();
        }
        System.out.println();
    }

    public void start() {
        Car[] cars = makeCar();
        int times = InputData.getNumberOfTimes();

        for (int i = 0; i < times; i++) {
            moveForward(cars);
        }
    }
}
