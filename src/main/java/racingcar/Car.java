package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position;

    public Car(String inputName) {
        validateCarNames(inputName);
        this.name = inputName;
        this.position = 0;
    }

    public void moveForward() {
        int randomValue = Randoms.pickNumberInRange(0,9);
        if (randomValue >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateCarNames(String inputName) {
        int MAX_NAME_LENGTH = 5;
        if (inputName.isEmpty() || inputName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
