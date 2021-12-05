package racingcar.controller.dto;

import java.util.ArrayList;
import java.util.List;

public class GameRoundResultDto {

    private final List<String> carStatuses = new ArrayList<>();

    public void appendCarStatus(String carStatus) {
        carStatuses.add(carStatus);
    }

    public List<String> getCarStatuses() {
        return carStatuses;
    }

}
