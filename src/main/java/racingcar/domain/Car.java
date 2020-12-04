package racingcar.domain;

public class Car implements Comparable<Car> {
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final char BLANK = ' ';
    private static final char BAR = '-';
    private static final String COLON = " : ";
    private static final String NAME_LENGTH_ERROR = "[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.";
    private static final String NAME_BLANK_ERROR = "[ERROR] 자동차 이름에 공백이 있으면 안됩니다.";

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateNameLength(name);
        validateNameBlank(name);
        this.name = name;
    }

    // 추가 기능 구현
    private void validateNameLength(String name) {
        if (name.length() < MIN_CAR_NAME_LENGTH || name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    private void validateNameBlank(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == BLANK) {
               throw new IllegalArgumentException(NAME_BLANK_ERROR);
            }
        }
    }

    public void moveCar() {
        position++;
    }

    public boolean isMaxPosition(int maxPosition) {
        if (position == maxPosition) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private String positionToBars() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(BAR);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return name + COLON + positionToBars();
    }

    @Override
    public int compareTo(Car car) {
        return car.getPosition() - getPosition();
    }
}
