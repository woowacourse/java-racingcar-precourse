package domain;

import java.util.Random;

public class Car {
    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final int MIN_CAR_MOVE_VALUE = 4;
    public static final int CAR_MOVE_RANGE_SIZE = 10;
    private final String name;
    private int position = 0;
    Random random;

    public Car(String name) {
        assertName(name);
        this.name = name;
        random = new Random();
    }

    private void assertName(String name) {
        if(name.length() > MAX_CAR_NAME_LENGTH || name.length() <= 0)
            throw new IllegalArgumentException("이름은 5자 이하로 입력해주세요.");
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveOrStopCar() {
        if(random.nextInt(CAR_MOVE_RANGE_SIZE) >= MIN_CAR_MOVE_VALUE)
            position++;
    }

}
