package util;

import model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    private static final String DELIMITER = ",";
    private static final String DISTANCE_SYMBOL = "-";

    public static List<String> getListFromString(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }

    public static String getPositionSymbol(int position) {
        return DISTANCE_SYMBOL.repeat(position);
    }

    public static String getNameJoinResult(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER));
    }

    public static List<String> removeBlank(List<String> names) {
        return names.stream()
                .filter(name -> !name.isBlank())
                .collect(Collectors.toList());
    }
}
