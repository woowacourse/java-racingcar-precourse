package racingcar.dto;

import racingcar.domain.Winners;

import java.util.List;

public class WinnersDTO {
    private final List<String> winnersName;
    
    public WinnersDTO(final Winners winners) {
        winnersName = winners.winnersName();
    }
    
    public List<String> getWinnersName() {
        return winnersName;
    }
}
