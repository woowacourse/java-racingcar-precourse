package racingcar.inputvalue;

import static racingcar.utils.StringConstants.ERROR_MASSAGE_ABOUT_EMPTY_CAR_NAMES_INPUT;

import org.assertj.core.util.Arrays;

public class CarNameInputValue extends InputValue<String[]> {
    public CarNameInputValue(String input) {
        super(input);
    }

    @Override
    String[] convertTypeToRacingElement() {
        String[] input = inputString.split(",");
        validate(input);
        return input;
    }

    private void validate(String[] input) {
        if (Arrays.isNullOrEmpty(input) || validateEachString(input)) {
            throw new IllegalArgumentException(ERROR_MASSAGE_ABOUT_EMPTY_CAR_NAMES_INPUT);
        }
    }

    private boolean validateEachString(String[] input) {
        for (String string : input) {
            if (string.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
