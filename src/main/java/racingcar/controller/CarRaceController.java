package racingcar.controller;

import racingcar.controller.dto.NameDto;

public class CarRaceController {

    public void inputCarName(String carNames) {
        NameDto dto = NameDto.builder()
                .names(carNames)
                .build();
    }
}
