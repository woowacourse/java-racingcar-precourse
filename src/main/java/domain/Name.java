package domain;

public class Name {
    private static final int NAME_MAX_LENGTH = 5;
    private static final String TOO_LONG_NAME_EXCEPTION = "[ERROR] 이름은 5자 이하여야 합니다.";
    private static final String EMPTY_NAME = "";
    private static final String EMPTY_NAME_EXCEPTION = "[ERROR] 이름은 공백일 수 없습니다.";

    private String name;

    public Name(String name) {
        isValidLengthName(name);
        isEmptyName(name);
        this.name = name;
    }

    private void isValidLengthName(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(TOO_LONG_NAME_EXCEPTION);
        }
    }

    private void isEmptyName(String name) {
        if (name.equals(EMPTY_NAME)) {
            throw new IllegalArgumentException(EMPTY_NAME_EXCEPTION);
        }
    }

    public String getName() {
        return name;
    }
}
