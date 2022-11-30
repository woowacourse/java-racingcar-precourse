package racingcar.controller;

import racingcar.dto.CarsNameDTO;
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
    }
}
