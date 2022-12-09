package racingcar.service;

import racingcar.controller.dto.NameDto;
import racingcar.controller.dto.TrialDto;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class CarRaceService {

    private Cars cars;
    private int trial;

    public void saveCarName(NameDto dto) {
        List<Car> cars = dto.getNames().stream()
                .map(Car::new)
                .collect(Collectors.toList());

        this.cars = new Cars(cars);
    }

    public void saveTrial(TrialDto dto) {
        this.trial = dto.getTrial();
    }

    public boolean isEnd() {
        return this.trial > 0;
    }

    public void race() {

    }
}
