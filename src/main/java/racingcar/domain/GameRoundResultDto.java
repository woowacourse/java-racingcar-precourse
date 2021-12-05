package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameRoundResultDto {

    private final List<String> statuses = new ArrayList<>();

    public void appendStatus(String status) {
        statuses.add(status);
    }

    public List<String> getStatuses() {
        return this.statuses;
    }
}
