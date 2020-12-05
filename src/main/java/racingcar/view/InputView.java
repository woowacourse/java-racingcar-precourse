package racingcar.view;

import java.util.Scanner;

import racingcar.domain.exception.ValidationException;
import racingcar.domain.validator.NameValidator;
import racingcar.domain.validator.RoundValidator;
import racingcar.domain.validator.Validator;

public class InputView {

    public static final String DELIMITER = ",";

    public static final String CAR_NAMES_QUESTION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static final String ROUND_QUESTION = "시도할 회수는 몇회인가요?";

    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public String askCarNames() {
        return ask(CAR_NAMES_QUESTION, new NameValidator());
    }

    public int askRound() {
        return Integer.parseInt(ask(ROUND_QUESTION, new RoundValidator()));
    }

    private String ask(String message, Validator validator) {
        System.out.println(message);

        String input = scanner.nextLine();

        while (!isValid(validator, input)) {
            input = scanner.nextLine();
        }

        return input;
    }

    private boolean isValid(Validator validator, String input) {
        try {
            validator.validate(input);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
