package racingcar;

import java.util.Arrays;
import java.util.Iterator;

public class CarNames {
    private static final int LIMIT = 5;
    private String[] names;
    private Iterator<String> iterator;

    public CarNames(String[] input) {
        validate(input);
        this.names = input;
        iterator = Arrays.stream(names).iterator();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public String next() {
        if (hasNext()) {
            return iterator.next();
        }

        throw new IllegalArgumentException("[ERROR] CarName이 더이상 존재하지 않습니다");
    }

    private void validate(String[] input) {
        validateRange(input);
        validateSize(input);
        validateDuplicate(input);
    }

    private void validateDuplicate(String[] input) {
        if (isDuplicated(input)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복되어선 안됩니다");
        }
    }

    private boolean isDuplicated(String[] input) {
        return input.length != Arrays.stream(input).distinct().count();
    }

    private void validateSize(String[] input) {
        if (input.length > LIMIT) {
            throw new IllegalArgumentException("[ERROR] 자동차 수는 " + LIMIT + "대를 초과해 입력받을 수 없습니다");
        }
    }

    private void validateRange(String[] input) {
        boolean isOver = Arrays.stream(input)
                .anyMatch(s -> s.length() > 6);
        if (isOver) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1글자 이상 5글자 이하여야 합니다");
        }
    }

}
