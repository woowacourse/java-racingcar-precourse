package racingcar;

import org.assertj.core.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class RacingController {

    public String[] inputCarNames() {
        String[] input = splitByComma(Console.readLine());
        validateCarNamesInput(input);
        return input;
    }

    private void validateCarNamesInput(String[] input) {
        if(Arrays.isNullOrEmpty(input)) {
            throw new IllegalArgumentException();
        }

        if(validateEachString(input)) {
            throw new IllegalArgumentException();
        }
    }

    private String[] splitByComma(String input) {
        return input.split(",");
    }

    private boolean validateEachString(String[] input) {
        for (String string : input) {
            if(string.isEmpty() || string.contains(" ")) {
                return true;
            }
        }
        return false;
    }
}
