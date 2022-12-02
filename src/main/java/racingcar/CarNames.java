package racingcar;

import java.util.Arrays;

public class CarNames {
    private String[] names;

    private CarNames(String[] input) {
        validateRange(input);
        this.names = input;
    }

    public static CarNames from(String[] input) {
        return new CarNames(input);
    }

    private void validateRange(String[] input) {
        boolean isOver = Arrays.stream(input)
                .anyMatch(s -> s.length() > 6);
        if (isOver) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1글자 이상 5글자 이하여야 합니다");
        }
    }

}
