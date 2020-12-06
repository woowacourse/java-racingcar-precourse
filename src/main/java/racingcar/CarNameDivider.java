package racingcar;

import java.util.ArrayList;
import java.util.HashSet;

public class CarNameDivider {

    public static String divideName(String carNameInput) {
        ArrayList<String> carNameList = new ArrayList<>();
        HashSet<String> carNameSet = new HashSet<>();

        String[] carNames = carNameInput.split(",");

        for (String carName : carNames) {
            if (carName.trim().length() > 5) {
                return "LongName";
            }
            carNameList.add(carName.trim());
            carNameSet.add(carName.trim());
        }

        if (carNameList.size() != carNameSet.size()) {
            return "DuplicationName";
        }

        if (carNameList.indexOf("") != -1 || carNames.length == 0) {
            return "NoName";
        }
        return carNameInput;
    }
}