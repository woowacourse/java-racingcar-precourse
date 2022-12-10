package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.CarVenueService;
import racingcar.view.View;

import java.util.List;

import static racingcar.message.Message.ESCAPE_SEQUENCE;

public class RacingCarController {
    private final View view = new View();

    public void play() {
        List<Car> cars = view.inputCar();
        int round = view.inputRound();
        CarVenueService carVenueService = new CarVenueService(cars, round);
        moveAndPrint(carVenueService);
    }

    private void moveAndPrint(CarVenueService carVenueService) {
        StringBuilder print = new StringBuilder();
        while (!carVenueService.isEnd()) {
            carVenueService.moveTurn();
            print.append(carVenueService.printTurn() + ESCAPE_SEQUENCE.getMessage());
        }
        view.printResult(print.toString());
        whoIsWinner(carVenueService);
    }
    private void whoIsWinner(CarVenueService carVenueService){
        view.printWinner(carVenueService.printWinner());
    }
}
