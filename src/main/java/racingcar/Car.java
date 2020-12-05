package racingcar;

public class Car {
    private static final int MOVE_DISTANCE = 1;

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

    public int getPosition() {
        return position;
    }

    public void moveCar(int randomNumber) {
        if (randomNumber >= 4 && randomNumber < 10) {
            addPosition();
        }
    }

    private void addPosition() {
        this.position += MOVE_DISTANCE;
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
