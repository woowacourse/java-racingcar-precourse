package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Log;
import racingcar.util.Parser;
import racingcar.validation.InputValidator;

import java.util.List;

public class InputView {

    public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String TRIAL_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public List<String> readCarNames() {
        printMessage(CAR_NAME_INPUT_MESSAGE);
        String carNames = Console.readLine();

        return checkCarNames(carNames);
    }

    private List<String> checkCarNames(String carNames) {
        try {
            List<String> names = Parser.getNames(carNames);
            InputValidator.checkNames(names);
            return names;
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return readCarNames();
        }
    }

    public int readGameTrial() {
        printMessage(TRIAL_INPUT_MESSAGE);
        String trial = Console.readLine();

        return checkGameTrial(trial);
    }

    private int checkGameTrial(String trial) {
        try {
            InputValidator.checkTrial(trial);
            return Integer.valueOf(trial);
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return readGameTrial();
        }
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
