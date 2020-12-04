package domain;

public class Car {
    private static final int NAME_MAX_LENGTH = 5;
    private static final int FOUR_TO_NINE_GO = 4;
    private static final String TOO_LONG_NAME_EXCEPTION = "[ERROR] 이름은 5자 이하여야 합니다.";
    private static final String EMPTY_NAME = "";
    private static final String EMPTY_NAME_EXCEPTION = "[ERROR] 이름은 공백일 수 없습니다.";

    private final String name;
    private int position = 0;

    public Car(String name) {
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

    // 0~9의 랜덤한 숫자를 매개변수로 입력
    public void moveCar(int randomNumber) {
        if (randomNumber >= FOUR_TO_NINE_GO) {
            this.position += 1;
        }
    }
}
