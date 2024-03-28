package racingcar;

import javax.naming.LimitExceededException;
import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) throws LimitExceededException {

        if (name.length() > 5) {
            throw new LimitExceededException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
        }

        this.name = name;
    }

    // 추가 기능 구현

    public void move() {
        if (new Random().nextInt(10) >= 4) {
            position = position + 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
