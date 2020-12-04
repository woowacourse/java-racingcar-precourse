package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
        validateCarName();
    }

    // 추가 기능 구현
    public String getCarName() {
        return name;
    }

    private void validateCarName() {
        if (this.name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 입력 해주세요.");
        }
        for (int i = 0; i < this.name.length(); i++) {
            char targetChar = this.name.charAt(i);
            validateSingleChar(targetChar);
        }
    }

    private void validateSingleChar(char targetChar) {
        if (targetChar == 32) {
            throw new IllegalArgumentException("[ERROR] 이름에 스페이스바는 허용되지 않습니다.");
        }
        if (targetChar < 65 || (targetChar > 90 && targetChar < 97) || targetChar > 122) {
            throw new IllegalArgumentException("[ERROR] 이름에는 대,소문 영문자만 입력 해주세요.");
        }
    }
}
