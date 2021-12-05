package racingcar;

import racingcar.controller.GameController;
import racingcar.service.GameService;
import racingcar.service.picker.NumberPicker;
import racingcar.service.picker.RandomNumberPicker;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.input.ConsoleReader;
import racingcar.view.input.Reader;

public class AppConfig {

	private static final AppConfig instance = new AppConfig();

	public final Reader reader;
	public final OutputView outputView;
	public final InputView inputView;
	public final NumberPicker numberPicker;
	public final GameService gameService;
	public final GameController gameController;

	private AppConfig() {
		this.reader = new ConsoleReader();
		this.outputView = new OutputView();
		this.inputView = new InputView(reader, outputView);

		this.numberPicker = new RandomNumberPicker();
		this.gameService = new GameService(numberPicker);
		this.gameController = new GameController(gameService, inputView, outputView);
	}

	public static AppConfig getInstance() {
		return instance;
	}

}
