package racingcar.domain;

import racingcar.message.Message;
import racingcar.util.CarOperator;
import racingcar.util.RandomNumberGenerate;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static racingcar.message.Message.*;

public class CarVenue {
    private final List<Car> cars;
    private final CarOperator carOperator;
    private final Round round;


    public CarVenue(List<Car> cars, int finalRound) {
        this.cars = cars;
        this.carOperator = new CarOperator(new RandomNumberGenerate(), cars.size());
        this.round = new Round(finalRound);
    }

    public void moveTurn(){
        round.next();
        List<Integer> nowMove = carOperator.tempPosition();
        IntStream.range(0, cars.size()).forEach(index -> cars.get(index).move(nowMove.get(index)));
    }
    public String printTurn(){
        return cars.stream().map(car -> car.toString() + "\n").collect(Collectors.joining());
    }

    public boolean isEnd(){
        if(round.isFinish()) return true;
        return false;
    }
    public String printWinner(){
        StringBuilder print = new StringBuilder(WINNER.getMessage());
        StringJoiner joiner = new StringJoiner(", ");
        cars.stream().map(car -> car.getWinnerName(round.getFinalRound()))
                .filter(winOrLose -> !winOrLose.equals(LOSER.getMessage()))
                .forEach(joiner::add);
        return print.append(joiner).toString();
    }
}
