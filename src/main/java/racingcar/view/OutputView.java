package racingcar.view;

import java.util.List;

import racingcar.domain.GameRoundResultDto;
import racingcar.domain.GameTotalResultDto;
import racingcar.resource.message.OutputMessage;
import racingcar.resource.rule.Delimiter;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printGameTotalResult(GameTotalResultDto gameTotalResult) {
        printMessage(OutputMessage.OUTPUT_GAME_RESULT_INTRO_MESSAGE);
        printGameRoundResults(gameTotalResult.getRoundResults());
        printGameWinners(gameTotalResult.getWinners());
    }

    private void printGameRoundResults(List<GameRoundResultDto> gameRoundResults) {
        gameRoundResults.forEach(this::printGameRoundResult);
    }

    private void printGameRoundResult(GameRoundResultDto gameRoundResult) {
        gameRoundResult.getStatuses().forEach(System.out::println);
        printBlankNewLine();
    }

    private void printGameWinners(List<String> winners) {
        System.out.println(OutputMessage.OUTPUT_GAME_WINNER_FRONT_MESSAGE + Delimiter.joinWithComma(winners));
        printBlankNewLine();
    }

    private void printBlankNewLine() {
        System.out.println();
    }

}
