package racingcar;

import java.util.List;

public class StringParser {
    private static final String COMMA = ",";

    public static List<Car> parseStringToList(List<Car> cars, String input) {
        String[] carNames = input.split(COMMA);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public static int parseStringToNumber(String input) {
        return Integer.parseInt(input);
    }
}
