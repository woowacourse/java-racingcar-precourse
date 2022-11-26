package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.RandomNumberGenerator;
import racingcar.dto.CarPositionDto;
import racingcar.dto.WinnerDto;

public class RacingGame {

    private final Cars cars;
    private final CountOfMoves countOfMoves;

    public RacingGame(Cars cars, CountOfMoves countOfMoves) {
        this.cars = cars;
        this.countOfMoves = countOfMoves;
    }

    public List<CarPositionDto> move() {
        cars.play(new RandomNumberGenerator());
        countOfMoves.upperCurrentRound();
        return getCarPosition(cars);
    }

    public boolean isOver() {
        return countOfMoves.getGoalCount();
    }

    public List<WinnerDto> getWinners() {
        return getWinnerPositionDto(cars.getWinners());
    }

    private List<CarPositionDto> getCarPosition(Cars cars) {
        return cars.getCars()
                .stream()
                .map(CarPositionDto::of)
                .collect(Collectors.toList());
    }

    private List<WinnerDto> getWinnerPositionDto(List<Car> winners) {
        return winners.stream()
                .map(car -> new WinnerDto(car.getName()))
                .collect(Collectors.toList());
    }
}
