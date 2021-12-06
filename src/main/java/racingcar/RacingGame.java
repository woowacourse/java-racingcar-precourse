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

    private void winner(Car[] cars) {
        int max = Integer.parseInt(cars[0].getResult()[1]);
        String winner = cars[0].getResult()[0];
        int winnerIndex = 0;

        for (int i = 1; i < cars.length; i++) {
            if (Integer.parseInt(cars[i].getResult()[1]) > max) {
                max = Integer.parseInt(cars[i].getResult()[1]);
                winner = cars[i].getResult()[0];
                winnerIndex = i;
            }
        }

        System.out.print("최종 우승자 : " + winner);
        for (int j = 0; j < cars.length; j++) {
            if (j == winnerIndex) {
                continue;
            }
            if (Integer.parseInt(cars[j].getResult()[1]) == max) {
                System.out.print(", " + cars[j].getResult()[0]);
            }
        }
    }

    public void start() {
        Car[] cars = makeCar();
        int times = InputData.getNumberOfTimes();

        for (int i = 0; i < times; i++) {
            moveForward(cars);
        }

        winner(cars);
    }
}
