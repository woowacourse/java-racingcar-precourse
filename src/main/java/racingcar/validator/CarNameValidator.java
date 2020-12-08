package racingcar.validator;

public class CarNameValidator {
    private static final int ZERO = 0;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String TAB = "\t";
    private static final String TWO_SPACE = "  ";

    public static String validate(String name) {
        validateNameLengthZero(name);
        validateNameLengthLong(name);
        validateNameContainsTab(name);
        validateNameContainsTwoOrMoreSpace(name);
        return name;
    }

    private static void validateNameLengthZero(String name) {
        if (name.length() == ZERO) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 입력되지 않았습니다.");
        }
    }

    private static void validateNameLengthLong(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 지동차의 이름이 너무 깁니다. name: " + name);
        }
    }

    private static void validateNameContainsTab(String name) {
        if (name.contains(TAB)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름에는 tab이 포함되면 안 됩니다. name: " + name);
        }
    }

    private static void validateNameContainsTwoOrMoreSpace(String name) {
        if (name.contains(TWO_SPACE)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름에는 2개 이상의 공백이 연속으로 포함되면 안 됩니다. name: " + name);
        }
    }
}
