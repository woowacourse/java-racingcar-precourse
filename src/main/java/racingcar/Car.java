package racingcar;

public class Car {

    public static final int MIN_FUEL = 0;
    public static final int MAX_FUEL = 9;
    public static final int MIN_MOVE_FUEL = 4;

    public static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    // 추가 기능 구현
    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(Message.CAR_NAME_VALIDATION);
        }
    }


    public void moveOrStop(int fuel) {
        validateFuel(fuel);
        if (fuel >= MIN_MOVE_FUEL) {
            move();
        }
    }

    private void validateFuel(int fuel) {
        if (fuel < MIN_FUEL || fuel > MAX_FUEL) {
            throw new IllegalArgumentException(Message.CAR_FUEL_VALIDATION);
        }
    }

    private void move() {
        position++;
    }

    public int getCurrentPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
