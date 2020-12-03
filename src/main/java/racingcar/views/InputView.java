package racingcar.views;

import racingcar.validators.CarNameValidator;
import utils.StringConverter;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private InputView() {
    }

    public static List<String> inputCarNames(Scanner scanner) {
        OutputView.printMessageAndNewLine(INPUT_CAR_NAMES);
        List<String> carNames = StringConverter.toListSplitByComma(scanner.nextLine());
        try {
            CarNameValidator.validateCarNames(carNames);
        } catch (IllegalArgumentException e) {
            OutputView.printMessageAndNewLine(e.getMessage());
            carNames = inputCarNames(scanner);
        }
        return carNames;
    }
}
