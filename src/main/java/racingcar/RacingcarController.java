package racingcar;

import View.InputView;
import error.Validator;
import error.customException.NotValidInputException;

import java.util.Scanner;

public class RacingcarController {

    private static final String DELIMITER = ",";
    private static final String EMPTY_CAR_NAME_ERROR_MESSAGE = "자동차 이름이 입력되어야 합니다.";
    private final Scanner scanner;

    public RacingcarController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        String inputCarName = InputView.inputCarName(scanner);
        validateCarNameInSingleLine(inputCarName);
    }

    private void validateCarNameInSingleLine (String inputLine) {

        if (inputLine.equals("") || inputLine.split(DELIMITER).length == 0) {
            try {
                throw new NotValidInputException(EMPTY_CAR_NAME_ERROR_MESSAGE);
            } catch (NotValidInputException e) {
                e.printStackTrace();
            }
        }
    }

}
