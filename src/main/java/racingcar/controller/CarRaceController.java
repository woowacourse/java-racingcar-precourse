package racingcar.controller;

import racingcar.controller.dto.NameDto;
import racingcar.controller.dto.TrialDto;
import racingcar.domain.Cars;
import racingcar.service.CarRaceService;

public class CarRaceController {

    private final CarRaceService service;

    public CarRaceController(CarRaceService service) {
        this.service = service;
    }

    public void inputCarName(String carNames) {
        NameDto dto = NameDto.builder()
                .names(carNames)
                .build();

        service.saveCarName(dto);
    }

    public void inputTrial(String trial) {
        TrialDto dto = TrialDto.builder()
                .trial(trial)
                .build();

        service.saveTrial(dto);
    }

    public boolean raceIsEnd() {
        return service.isEnd();
    }

    public Cars race() {
        return service.race();
    }
}
