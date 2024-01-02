package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
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

    public static void validateCarNames(List<String> carNames) {
        for (String inputName : carNames) {
            int MAX_NAME_LENGTH = 5;
            if (inputName.isEmpty() || inputName.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
        Set<String> uniqueNames = new HashSet<>(carNames); // 중복을 허용하지 않는 자료구조
        if (uniqueNames.size() < carNames.size()) { // 작다면 중복된 이름이 있다는 것을 의미함
            throw new IllegalArgumentException();
        }
    }
}
