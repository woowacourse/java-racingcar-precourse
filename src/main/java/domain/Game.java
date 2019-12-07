package domain;

import java.util.Random;

public class Game {
    public Game() {
        UserInput userInput = new UserInput();
        Car[] cars = new Car[userInput.carNames.length];
        this.convertObject(cars, userInput.carNames);
        for (int i = 0; i < userInput.raceCount; i++) {
            this.currentResult(cars);
        }
        this.finalResult(cars);
    }

    private void convertObject(Car[] cars, String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    public void currentResult(Car[] cars) {
        final int FORWARD = 4;
        Random random = new Random();
        for (Car car : cars) {
            if (random.nextInt(10) >= FORWARD) {
                car.moveCar();
            }
            System.out.println(car.getName() + " : " + car.currentMove());
        }
        System.out.println();
    }

    public void finalResult(Car[] cars) {
        StringBuffer winner = new StringBuffer();
        int winnerPosition = -1;
        for (Car car : cars) {
            if (winnerPosition < car.getPosition()) {
                winnerPosition = car.getPosition();
                winner.delete(0, winner.length());
                winner.append(car.getName());
                continue;
            }
            if (winnerPosition == car.getPosition()) {
                winner.append(", " + car.getName());
            }
        }
        System.out.println(winner.toString() + "가 최종 우승하였습니다.");
    }
}
