package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import racingcar.util.ViewMessage;
import racingcar.util.validator.CarNameValidator;

public class RaceInputView {
    private final CarNameValidator carNameValidator;

    public RaceInputView() {
        this.carNameValidator = new CarNameValidator();
    }

    public String[] inputRacerName() {
        while (true) {
            try {
                System.out.println(ViewMessage.INPUT_CAR_NAME.getMessage());
                String input = readLine();

                carNameValidator.validate(input);

                return carNameValidator.splitByComma(input);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private String readLine() {
        return Console.readLine();
    }
}
