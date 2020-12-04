package racingcar;

public class Car {
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
            System.out.println("[ERROR] 자동차 이름이 정해지지 않았습니다.");
            throw new RuntimeException();
        }
    }

    private void checkCarNameGreaterThenFive(String name) {
        if (name.length() > 5) {
            System.out.println("[ERROR] 자동차 이름은 5글자 이하만 가능합니다.");
            throw new RuntimeException();
        }
    }
}
