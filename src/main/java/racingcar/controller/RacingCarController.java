package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.domain.movables.engine.MovablesCreator;
import racingcar.domain.movables.factory.MovablesFactoryBean;
import racingcar.dto.CarsNameDTO;
import racingcar.dto.GameResultDTO;
import racingcar.dto.NumberOfTryDTO;
import racingcar.dto.WinnersDTO;
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
        final RacingGame racingGame = initRacingGame(movablesCreator());
    
        race(numberOfTryDTO(), racingGame);
        printWinners(racingGame);
    }
    
    private NumberOfTryDTO numberOfTryDTO() {
        return inputView.inputNumberOfTry(outputView);
    }
    
    private MovablesCreator movablesCreator() {
        return new MovablesFactoryBean().createMovablesCreator();
    }
    
    private RacingGame initRacingGame(final MovablesCreator movablesCreator) {
        return new RacingGame(carsName(), movablesCreator);
    }
    
    private String carsName() {
        return carsNameDTO().getCarsName();
    }
    
    private CarsNameDTO carsNameDTO() {
        return inputView.inputCarsName(outputView);
    }
    
    private void race(final NumberOfTryDTO numberOfTryDTO, final RacingGame racingGame) {
        while (!racingGame.isFinished(numberOfTryDTO.getNumberOfTry())) {
            racingGame.race();
            printMoveResult(racingGame);
        }
    }
    
    private void printMoveResult(final RacingGame racingGame) {
        outputView.printMoveResultGuideMessage();
        outputView.printMoveResult(new GameResultDTO(racingGame));
    }
    
    private void printWinners(final RacingGame racingGame) {
        outputView.printWinners(new WinnersDTO(racingGame.winners()));
    }
}
