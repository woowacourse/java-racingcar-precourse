package racingcar.controller.dto;

import java.util.ArrayList;
import java.util.List;

public class GameTotalResultDto {

    private final List<GameRoundResultDto> roundResults = new ArrayList<>();
    private final List<String> winners = new ArrayList<>();

    public void appendRoundResult(GameRoundResultDto roundResult) {
        roundResults.add(roundResult);
    }

    public void appendWinner(String winner) {
        winners.add(winner);
    }

    public List<GameRoundResultDto> getRoundResults() {
        return roundResults;
    }

    public List<String> getWinners() {
        return winners;
    }

}
