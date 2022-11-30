package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.domain.movables.engine.MovablesCreator;
import racingcar.domain.movables.factory.MovablesFactoryBean;
import racingcar.dto.CarsNameDTO;
import racingcar.dto.GameResultDTO;
import racingcar.dto.NumberOfTryDTO;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    
    public RacingCarController() {
        inputView = new InputView();
        outputView = new OutputView();
    }
    
    public void run() {
        final CarsNameDTO carsNameDTO = inputView.inputCarsName(outputView);
        final NumberOfTryDTO numberOfTryDTO = inputView.inputNumberOfTry(outputView);
    
        final MovablesCreator movablesCreator = new MovablesFactoryBean().createMovablesCreator();
        final RacingGame racingGame = new RacingGame(carsNameDTO.getCarsName(), movablesCreator);
    
        while (!racingGame.isFinished(numberOfTryDTO.getNumberOfTry())) {
            racingGame.race();
            printMoveResult(racingGame);
        }
    }
    
    private void printMoveResult(final RacingGame racingGame) {
        outputView.printMoveResultGuideMessage();
        outputView.printMoveResult(new GameResultDTO(racingGame));
    }
}
