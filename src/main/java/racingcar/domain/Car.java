package racingcar.domain;

public class Car {

    public static final String MOVING_LINE = "-";
    public static final int MOVING_THRESHOLD = 4;
    public static final int MAXIMUM_NAME_LENGTH = 5;
    public static final String ERROR_OUT_OF_NAME_LENGTH = "[ERROR] 이름은 5글자 이하여야 합니다.";

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_OUT_OF_NAME_LENGTH);
        }
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            position++;
            return;
        }
    }

    public void printPosition() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(name);
        stringBuffer.append(" : ");
        for (int i = 0; i < position; i++) {
            stringBuffer.append(MOVING_LINE);
        }
        System.out.println(stringBuffer);
    }

    public boolean isEndGame(int tryNumber) {
        return position >= tryNumber;
    }
}
