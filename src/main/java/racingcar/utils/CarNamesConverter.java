package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNamesConverter {
    private static final String COMMA = ",";

    public static List<String> convert(String carNamesInput) {
        return Arrays.stream(carNamesInput.split(COMMA))
                .map(s -> s.trim())
                .collect(Collectors.toList());
    }
}
