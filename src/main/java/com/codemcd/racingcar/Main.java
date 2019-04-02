package com.codemcd.racingcar;

public class Main {

    public static void main(String[] args) {

        Car[] cars;
        Input input = new Input();
        Draw draw = new Draw();

        String[] carNames = input.inputCarName();
        int numberOfMove = input.inputHowManyMove();
        int numberOfCar = carNames.length;

        cars = new Car[numberOfCar];
        for (int i = 0; i < numberOfCar; ++i) {
            cars[i] = new Car(carNames[i]);
        }

        for (int i = 0; i < numberOfMove; ++i) {
            for (int j = 0; j < numberOfCar; ++j) {
                int moveNumber = GameProcess.makeRandomNumber();
                if (moveNumber >= 4)
                    cars[j].goStraight();
            }

            draw.drawMoveResult(cars, numberOfCar);
        }

        String[] winners = GameProcess.tellWinner(cars);
        draw.drawWhoIsWinners(winners);
    }
}
