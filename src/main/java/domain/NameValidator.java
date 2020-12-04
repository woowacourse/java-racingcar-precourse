package domain;

import java.util.Arrays;
import java.util.List;

public class NameValidator {
    public static final String COMMA_DELIMITER = ",";
    public static final int MAXIMUM_NAME_LENGTH = 5;

    private final String inputData;

    public NameValidator(String inputData) {
        this.inputData = inputData;
    }

    public static void checkSomethingIsHere(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름을 다시 입력해주세요.");
        }
    }

    public static void checkLengthIsFive(String s) {
        if (s.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하여야 한다.");
        }
    }

    public List<String> makeDataToNames() {
        List<String> names = Arrays.asList(this.inputData.split(COMMA_DELIMITER, -1));
        names.forEach(s -> {
            checkSomethingIsHere(s);
            checkLengthIsFive(s);
        });
        return names;
    }

}
