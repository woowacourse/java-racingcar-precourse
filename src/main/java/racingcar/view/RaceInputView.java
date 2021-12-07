package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import racingcar.util.ViewMessage;
import racingcar.util.validator.CarNameValidator;
import racingcar.util.validator.NumberOfRaceValidator;

public class RaceInputView {
    private final CarNameValidator carNameValidator;
    private final NumberOfRaceValidator numberOfRaceValidator;

    public RaceInputView() {
        this.carNameValidator = new CarNameValidator();
        this.numberOfRaceValidator = new NumberOfRaceValidator();
    }

    public String[] inputCarName() {
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

    public int inputNumberOfRaces() {
        while (true) {
            try {
                System.out.println(ViewMessage.INPUT_NUMBER_OF_RACES.getMessage());
                String input = readLine();

                numberOfRaceValidator.validate(input);

                return numberOfRaceValidator.convertToInteger(input);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private String readLine() {
        return Console.readLine();
    }
}
