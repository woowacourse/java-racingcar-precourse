package racingcar.domain;

import java.util.Collections;

public class Car {
    private final String name;
    private int position = 0;
    private Engine engine = new Engine();

    public Car(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(CarToStringUtil.colonWithSpace);
        sb.append(Collections.nCopies(position, CarToStringUtil.distanceIndicator));
        return sb.toString();
    }

    private class CarToStringUtil{
        public static final String colonWithSpace = " : ";
        public static final String distanceIndicator = "-";
    }
}
