package racingcar;

import racingcar.controller.GameController;
import racingcar.service.GameService;
import racingcar.service.picker.NumberPicker;
import racingcar.service.picker.RandomNumberPicker;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.input.ConsoleReader;
import racingcar.view.input.Reader;

public class Application {

    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(reader, outputView);

        NumberPicker numberPicker = new RandomNumberPicker();
        GameService gameService = new GameService(numberPicker);
        GameController gameController = new GameController(gameService, inputView, outputView);

        gameController.run();
    }

}
