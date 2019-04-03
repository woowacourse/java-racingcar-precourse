package com.nekisse;

import com.nekisse.domain.CarName;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    static List<CarName> parseStringToGetCarNames(String names) {
        List<CarName> carNames = new ArrayList<>();
        String[] splitNames = names.trim().split(",");
        for (String splitName : splitNames) {
            CarName name = CarName.newCarName(splitName.trim());
            carNames.add(name);
        }
        return carNames;
    }


}
