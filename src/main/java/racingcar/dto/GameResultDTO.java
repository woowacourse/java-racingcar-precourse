package racingcar.dto;

import racingcar.domain.RacingGame;

import java.util.List;

public class GameResultDTO {
    private final List<String> movablesName;
    private final List<Integer> movablesPosition;
    
    public GameResultDTO(final RacingGame racingGame) {
        movablesName = racingGame.movablesName();
        movablesPosition = racingGame.movablesPosition();
    }
    
    public List<String> getMovablesName() {
        return movablesName;
    }
    
    public List<Integer> getMovablesPosition() {
        return movablesPosition;
    }
}
