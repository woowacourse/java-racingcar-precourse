package com.codemcd.racingcar;

public class Main {

    public static void main(String[] args) {

        Car[] cars;

        String[] carNames = Input.inputCarName();
        int numberOfMove = Input.inputHowManyMove();
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

            Output.outputMoveResult(cars);
        }

        String[] winners = GameProcess.tellWinner(cars);
        Output.outputWhoIsWinners(winners);
    }
}
