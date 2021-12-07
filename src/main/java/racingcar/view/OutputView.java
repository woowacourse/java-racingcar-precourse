package racingcar.view;

import java.util.List;

import racingcar.controller.dto.GameRoundResultDto;
import racingcar.controller.dto.GameTotalResultDto;
import racingcar.resource.message.ErrorMessage;
import racingcar.resource.message.OutputMessage;
import racingcar.utils.Delimiter;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(String message) {
        this.printMessage(ErrorMessage.TAG + message);
    }

    public void printGameTotalResult(GameTotalResultDto gameTotalResult) {
        printBlankNewLine();
        printMessage(OutputMessage.OUTPUT_GAME_RESULT_INTRO_MESSAGE);
        printGameRoundResults(gameTotalResult.getRoundResults());
        printGameWinners(gameTotalResult.getWinners());
    }

    private void printGameRoundResults(List<GameRoundResultDto> gameRoundResults) {
        gameRoundResults.forEach(this::printGameRoundResult);
    }

    private void printGameRoundResult(GameRoundResultDto gameRoundResult) {
        gameRoundResult.getCarStatuses().forEach(System.out::println);
        printBlankNewLine();
    }

    private void printGameWinners(List<String> winners) {
        System.out.println(OutputMessage.OUTPUT_GAME_WINNER_FRONT_MESSAGE + Delimiter.joinWithComma(winners));
    }

    private void printBlankNewLine() {
        System.out.println();
    }

}
