package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarVenue;
import racingcar.view.View;

import java.util.List;

import static racingcar.message.Message.ESCAPE_SEQUENCE;

public class RacingCarController {
    private final View view = new View();

    public void play() {
        List<Car> cars = view.inputCar();
        int round = view.inputRound();
        CarVenue carVenue = new CarVenue(cars, round);
        moveAndPrint(carVenue);
    }

    private void moveAndPrint(CarVenue carVenue) {
        StringBuilder print = new StringBuilder();
        while (!carVenue.isEnd()) {
            carVenue.moveTurn();
            print.append(carVenue.printTurn() + ESCAPE_SEQUENCE.getMessage());
        }
        view.printResult(print.toString());
        whoIsWinner(carVenue);
    }
    private void whoIsWinner(CarVenue carVenue){
        view.printWinner(carVenue.printWinner());
    }
}
