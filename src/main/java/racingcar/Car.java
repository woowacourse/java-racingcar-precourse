package racingcar;

public class Car {
    private final int NAME_MAX_LENGTH = 5;
    private final String CAR_NAME_EMPTY_ERROR_MESSAGE = "[ERROR] 자동차 이름이 정해지지 않았습니다.";
    private final String CAR_NAME_GREATER_THEN_FIVE_ERROR_MESSAGE = "[ERROR] 자동차 이름은 " + NAME_MAX_LENGTH + "글자 이하만 가능합니다.";
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void carNameValidate() {
        checkCarNameNotEmpty(this.name);
        checkCarNameGreaterThenFive(this.name);
    }

    private void checkCarNameNotEmpty(String name) {
        if (name.isBlank()) {
            System.out.println(CAR_NAME_EMPTY_ERROR_MESSAGE);
            throw new RuntimeException();
        }
    }

    private void checkCarNameGreaterThenFive(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            System.out.println(CAR_NAME_GREATER_THEN_FIVE_ERROR_MESSAGE);
            throw new RuntimeException();
        }
    }

    public void increasePosition() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
