package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.RandomNumberGenerator;
import racingcar.dto.WinnerDto;

public class RacingGame {

    public void play(Cars cars) {
        cars.play(new RandomNumberGenerator());
    }

    public List<WinnerDto> getWinners(Cars cars) {
        int maximum = cars.getCars()
                .stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .get();
        return cars.getCars()
                .stream()
                .filter(car -> car.getPosition() == maximum)
                .map(car -> new WinnerDto(car.getName()))
                .collect(Collectors.toList());
    }
}
