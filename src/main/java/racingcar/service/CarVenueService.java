package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.util.CarOperator;
import racingcar.util.RandomNumberGenerate;

import java.util.List;

import static racingcar.message.Message.WINNER;

public class CarVenueService {
    private final Cars cars;
    private final CarOperator carOperator;
    private final Round round;


    public CarVenueService(List<Car> cars, int finalRound) {
        this.cars = new Cars(cars);
        this.carOperator = new CarOperator(new RandomNumberGenerate(), cars.size());
        this.round = new Round(finalRound);
    }

    public void moveTurn() {
        round.next();
        cars.moveCars(carOperator);
    }

    public String printTurn() {
        return cars.printCars();
    }

    public boolean isEnd() {
        if (round.isFinish()) return true;
        return false;
    }

    public String printWinner() {
        StringBuilder print = new StringBuilder(WINNER.getMessage());
        print.append(cars.getWinCar());
        return print.toString();
    }
}
