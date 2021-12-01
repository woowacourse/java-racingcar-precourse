package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public void goForward() {
        this.position++;
    }

    // TODO ERROR문 상수로 처리하기
    public static void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자 이하로 입력해주세요.");
        }

        String nameRegex = "[^A-Za-z0-9]+";
        if (name.matches(nameRegex)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 영어 혹은 숫자로만 입력해주세요.");
        }
    }
}
