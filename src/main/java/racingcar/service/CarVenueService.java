package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Round;
import racingcar.util.CarOperator;
import racingcar.util.RandomNumberGenerate;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static racingcar.message.Message.*;

public class CarVenueService {
    private final List<Car> cars;
    private final CarOperator carOperator;
    private final Round round;
    private int maxPosition = 0;


    public CarVenueService(List<Car> cars, int finalRound) {
        this.cars = cars;
        this.carOperator = new CarOperator(new RandomNumberGenerate(), cars.size());
        this.round = new Round(finalRound);
    }

    public void moveTurn() {
        round.next();
        List<Integer> nowMove = carOperator.tempPosition();
        IntStream.range(0, cars.size()).forEach(index -> {
            cars.get(index).move(nowMove.get(index));
            maxPosition = Math.max(maxPosition, cars.get(index).getPosition());
        });
    }

    public String printTurn() {
        return cars.stream().map(car -> car.toString() + ESCAPE_SEQUENCE.getMessage()).collect(Collectors.joining());
    }

    public boolean isEnd() {
        if (round.isFinish()) return true;
        return false;
    }

    public String printWinner() {
        StringBuilder print = new StringBuilder(WINNER.getMessage());
        StringJoiner joiner = new StringJoiner(DELIMITER.getMessage() + " ");
        cars.stream().map(car -> car.getWinnerName(maxPosition)).
                filter(winOrLose -> !winOrLose.equals(LOSER.getMessage()))
                .forEach(joiner::add);
        return print.append(joiner).toString();
    }
}
