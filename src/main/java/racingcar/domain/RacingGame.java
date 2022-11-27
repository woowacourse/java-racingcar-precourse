package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.NumberGenerator;
import racingcar.dto.CarPositionDto;
import racingcar.dto.WinnerDto;

//TODO 이 클래스가 DTO를 알아도될까?
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
        return getCarPositionDtos(cars);
    }

    public boolean isOver() {
        return countOfMoves.reachTargetNumber();
    }

    public List<WinnerDto> getWinners() {
        return cars.getWinners()
                .stream()
                .map(car -> new WinnerDto(car.getName()))
                .collect(Collectors.toList());
    }

    private List<CarPositionDto> getCarPositionDtos(Cars cars) {
        return cars.getCars()
                .stream()
                .map(CarPositionDto::of)
                .collect(Collectors.toList());
    }
}
