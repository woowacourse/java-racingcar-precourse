package racingcar.domain;

public class Car {

    private final String name;
    private static final String MINUS = ",";
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int move() {
        position++;
        return position;
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }

    @Override
    public String toString() {
        StringBuilder distanceSign = new StringBuilder();
        for (int i = 0; i < position; i++) {
            distanceSign.append(MINUS);
        }
        return name + " : " + distanceSign;
    }

}
