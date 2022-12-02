package racingcar;

import java.util.Arrays;
import java.util.Iterator;

public class CarNames {
    private String[] names;
    private Iterator<String> iterator;

    public CarNames(String[] input) {
        validateRange(input);
        this.names = input;
        iterator = Arrays.stream(names).iterator();
    }

    public int amount() {
        return names.length;
    }

    public String next() {
        if (iterator.hasNext()) {
            return iterator.next();
        }

        throw new IllegalArgumentException("[ERROR] CarName이 더이상 존재하지 않습니다");
    }


    private void validateRange(String[] input) {
        boolean isOver = Arrays.stream(input)
                .anyMatch(s -> s.length() > 6);
        if (isOver) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1글자 이상 5글자 이하여야 합니다");
        }
    }

}
