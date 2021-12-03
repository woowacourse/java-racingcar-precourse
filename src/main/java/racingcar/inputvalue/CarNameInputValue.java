package racingcar.inputvalue;

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

    void validate(String[] input) {
        if (Arrays.isNullOrEmpty(input)) {
            throw new IllegalArgumentException();
        }

        if (validateEachString(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean validateEachString(String[] input) {
        for (String string : input) {
            if (string.isEmpty() || string.contains(" ")) {
                return true;
            }
        }
        return false;
    }
}
