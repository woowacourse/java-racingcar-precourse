package racingcar.controller;

import java.util.List;
import java.util.function.Supplier;
import racingcar.domain.GameResult;
import racingcar.domain.Player;
import racingcar.domain.RacingGame;
import racingcar.domain.car.NumberGenerator;
import racingcar.domain.car.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private RacingGame racingGame;
    private GameResult gameResult;

    public GameController() {
        setUp();
    }

    private void setUp() {
        InputView inputView = new InputView();
        List<String> playerNames = repeat(inputView::readPlayerName);
        Player player = new Player(playerNames);
        this.gameResult = new GameResult(player);
        int gameRound = repeat(inputView::readGameRound);
        this.racingGame = new RacingGame(player, gameRound);
    }

    public void start() {
        OutputView outputView = new OutputView();
        outputView.printResultMessage();
        do {
            NumberGenerator numberGenerator = new RandomNumberGenerator();
            racingGame.play(numberGenerator);
            outputView.printRoundResult(gameResult);
        } while (racingGame.isGameContinue());
        outputView.printFinalWinner(gameResult);
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            OutputView outputView = new OutputView();
            outputView.printErrorMessage(e.getMessage());
            return repeat(inputReader);
        }
    }
}
