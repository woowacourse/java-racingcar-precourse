package racingcar.model;

import java.util.HashMap;
import java.util.Map;

public class Car {
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
            convertPosition.append("-");
        }
        return convertPosition.toString();
    }

    public Map<String, String> getCarInfos() {
        printCarInfos.put("name", this.name);
        String convertedPosition = positionConvertToDash();
        printCarInfos.put("position", convertedPosition);
        return printCarInfos;
    }
}
