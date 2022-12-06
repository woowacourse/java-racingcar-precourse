package racingcar.domain;

import racingcar.exception.CarsDuplicatedNameException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private static final String DELIMITER = ",";
    private static final String DUPLICATED_DELIMITER_REGEX = ",+";
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCarNameByWord(String input) {
        List<Car> cars = new ArrayList<>();
        String[] words = divideWord(input);
        validate(words);

        for (String carName : words) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    private static void validate(String[] words) {
        validateDuplicatedWord(words);
    }

    private static void validateDuplicatedWord(String[] words) {
        Set<String> uniqueWord = new HashSet<>();
        for (String word : words) {
            if (!uniqueWord.add(word)) {
                throw new CarsDuplicatedNameException();
            }
        }
    }

    private static String[] divideWord(String word) {
        return word.replaceAll(DUPLICATED_DELIMITER_REGEX, DELIMITER).split(DELIMITER);
    }
}
