package racingcar;

public class Car {
    private static final int NAME_MAX_LENGTH = 5;
    private static final String LENGTH_OVER_EXCEPTION_MESSAGE = "[ERROR] 이름은 5자 이하여야 합니다.";
    private final String name;
    private int position = 0;

    public Car(String name) {
        isValidName(name);
        this.name = name;
    }

    private void isValidName(String name) {
        if(name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(LENGTH_OVER_EXCEPTION_MESSAGE);
        }
    }
}
