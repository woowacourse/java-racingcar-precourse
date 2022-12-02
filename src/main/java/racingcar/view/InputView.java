package racingcar.view;

import racingcar.util.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private final Validator validator = new Validator();
    private final OutputView outputView = new OutputView();

    private final String READ_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분하며 5자 이내입니다.)";
    private final String READ_TRY_COUNT = "시도할 횟수를 입력하세요.";

    public String[] readNames() {
        outputView.printMessage(READ_NAMES_MESSAGE);
        while (true) {
            try {
                String[] names = readLine().trim().split(",");
                validator.validateNames(names);
                return names;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(READ_NAMES_MESSAGE);
            }
        }
    }

    public Long readTryCount() {
        outputView.printMessage(READ_TRY_COUNT);
        while (true) {
            try {
                String tryCount = readLine().trim();
                return Long.parseLong(tryCount);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(READ_TRY_COUNT);
            }
        }
    }
}
