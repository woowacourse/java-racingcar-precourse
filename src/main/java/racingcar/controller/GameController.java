package racingcar.controller;

import java.util.List;

import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final GameService gameService;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(GameService gameService, InputView inputView, OutputView outputView) {
        this.gameService = gameService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> names = inputView.getNames();
        int executionCount = inputView.getExecutionCount();
        gameService.playGame(names, executionCount);
        outputView.printGameTotalResult(gameService.getGameTotalResult());
    }

}
