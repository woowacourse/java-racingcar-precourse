package racingcar.controller;

import racingcar.controller.dto.NameDto;
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
}
