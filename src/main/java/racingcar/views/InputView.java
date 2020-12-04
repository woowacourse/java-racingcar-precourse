package racingcar.views;

import racingcar.validators.CarNameValidator;
import racingcar.validators.TrialCountValidator;
import utils.StringConverter;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_COUNT_OF_TRIAL = "시도할 회수는 몇회인가요?";

    private InputView() {
    }

    public static List<String> inputCarNames(Scanner scanner) {
        OutputView.printMessageAndNewLine(INPUT_CAR_NAMES);
        List<String> carNames = StringConverter.toListSplitByComma(scanner.nextLine());
        try {
            CarNameValidator.validateCarNames(carNames);
        } catch (IllegalArgumentException exception) {
            OutputView.printMessageAndNewLine(exception.getMessage());
            carNames = inputCarNames(scanner);
        }
        return carNames;
    }

    public static int inputTrialCount(Scanner scanner) {
        OutputView.printMessageAndNewLine(INPUT_COUNT_OF_TRIAL);
        String trialCount = scanner.nextLine();
        try {
            TrialCountValidator.validateTrialCount(trialCount);
            return Integer.parseInt(trialCount);
        } catch (IllegalArgumentException exception) {
            OutputView.printMessageAndNewLine(exception.getMessage());
            return inputTrialCount(scanner);
        }
    }
}
