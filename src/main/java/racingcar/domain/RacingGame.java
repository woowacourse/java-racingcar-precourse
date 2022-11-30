package racingcar.domain;

import java.util.List;
import racingcar.NumberGenerator;
import racingcar.dto.CarPositionDto;
import racingcar.dto.WinnerDto;

public class RacingGame {

    private final Cars cars;
    private final CountOfMoves countOfMoves;

    public RacingGame(Cars cars, CountOfMoves countOfMoves) {
        this.cars = cars;
        this.countOfMoves = countOfMoves;
    }

    public List<CarPositionDto> move(NumberGenerator numberGenerator) {
        cars.play(numberGenerator);
        countOfMoves.upperCurrentRound();
        return CarPositionDto.of(cars);
    }

    public boolean isOver() {
        return countOfMoves.reachTargetNumber();
    }

    public List<WinnerDto> getWinners() {
        return WinnerDto.of(cars.findWinners());
    }
}
