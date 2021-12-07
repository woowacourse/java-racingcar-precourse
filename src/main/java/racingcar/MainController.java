package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.racing.RacingController;
import racingcar.service.ValidationService;
import racingcar.type.DelimiterType;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {

	public void run() {
		List<String> carNames = getCarNames();
		int tryNumber = getTryNumber();

		RacingController racingController = new RacingController();
		racingController.run(carNames, tryNumber);
	}

	private List<String> getCarNames() {
		List<String> carNames;
		while (true) {
			try {
				carNames = separateCarNames(InputView.scanCarNames());
				break;
			} catch (IllegalArgumentException e) {
				OutputView.printError(e.getMessage());
			}
		}
		return carNames;
	}

	private int getTryNumber() {
		int tryNumber;
		while (true) {
			try {
				String number = InputView.scanTryNumber();
				ValidationService.checkTryNumberIsValid(number);
				tryNumber = Integer.parseInt(number);
				break;
			} catch (IllegalArgumentException e) {
				OutputView.printError(e.getMessage());
			}
		}
		return tryNumber;
	}

	private List<String> separateCarNames(String names) {
		ValidationService.checkCarNames(names, DelimiterType.CAR_NAME_DELIMITER.getDelimiter());
		return makeClearCarNames(names.split(DelimiterType.CAR_NAME_DELIMITER.getDelimiter()));
	}

	private List<String> makeClearCarNames(String[] names) {
		List<String> result = Arrays.stream(names).map(String::trim).collect(Collectors.toList());
		ValidationService.checkDuplicatedCarName(result);
		ValidationService.checkEachCarName(result);
		return result;
	}
}
