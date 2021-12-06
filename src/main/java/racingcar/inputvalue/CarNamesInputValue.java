package racingcar.inputvalue;

import static racingcar.utils.StringUtils.DELIMITER_TO_SEPARATE_CAR_NAME_INPUT;
import static racingcar.utils.StringUtils.ERROR_MASSAGE_ABOUT_EMPTY_CAR_NAMES_INPUT;

import org.assertj.core.util.Arrays;

public class CarNamesInputValue extends InputValue<String[]> {
    public CarNamesInputValue(String input) {
        super(input);
    }

    @Override
    String[] convertTypeToRacingElement() {
        String[] input = inputString.split(DELIMITER_TO_SEPARATE_CAR_NAME_INPUT);
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
