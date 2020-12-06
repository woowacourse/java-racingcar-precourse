package racingcar.domain;

public class Car {

    private final String name;
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
        if (position == maxPosition) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String distanceSign = "";
        for (int i = 0; i < position; i++) {
            distanceSign += "-";
        }
        return name + " : " + distanceSign;
    }

}
