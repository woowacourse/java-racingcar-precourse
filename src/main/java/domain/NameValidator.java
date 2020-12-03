package domain;

import java.util.Arrays;
import java.util.List;

public class NameValidator {
    private String inputData;

    public NameValidator(String inputData) {
        this.inputData = inputData;
    }

    public static void checkSomethingIsHere(String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }
    }

    public static void checkLengthIsFive(String s) {
        if (s.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 한다.");
        }
    }

    public List<String> makeDataToNames() {
        List<String> names = Arrays.asList(this.inputData.split(",").clone());
        names.forEach(NameValidator::checkSomethingIsHere);
        names.forEach(NameValidator::checkLengthIsFive);
        return names;
    }

}
