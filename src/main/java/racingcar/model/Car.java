package racingcar.model;

import java.util.HashMap;
import java.util.Map;

public class Car {

    private static final String CAR_POSITION_KEY = "position";
    private static final String CAR_NAME_KEY = "name";
    private static final String DASH = "-";

    private final String name;
    private int position = 0;
    private final Map<String, String> printCarInfos = new HashMap<>();

    public Car(String name) {
        this.name = name;
    }

    public void forward() {
        this.position++;
    }

    public String positionConvertToDash() {
        StringBuilder convertPosition = new StringBuilder();
        for (int repeatIndex = 0; repeatIndex < this.position; repeatIndex++) {
            convertPosition.append(DASH);
        }
        return convertPosition.toString();
    }

    public Map<String, String> getCarInfos() {
        printCarInfos.put(CAR_NAME_KEY, this.name);
        String convertedPosition = positionConvertToDash();
        printCarInfos.put(CAR_POSITION_KEY, convertedPosition);
        return printCarInfos;
    }
}
