package game;

import domain.Car;
import domain.TrialTimes;
import exception.InvalidInputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameInitializer {

    private static final int MINIMUM_SIZE = 2;
    private static final String CAR_NAME_DELIMITER = ",";

    public List<Car> makeCarList(String inputString) {
        List<String> names = Arrays.asList(inputString.split(CAR_NAME_DELIMITER));
        validatesMinimumSize(names);
        validatesDuplicateNames(names);
        return names.stream().map(name -> new Car(name.trim())).collect(Collectors.toList());
    }

    private void validatesMinimumSize(List<String> names) {
        if (names.size() < MINIMUM_SIZE) {
            throw new InvalidInputException(InvalidInputException.NAMES_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private void validatesDuplicateNames(List<String> names) {
        if (names.stream().distinct().count() != names.size()) {
            throw new InvalidInputException(InvalidInputException.NAME_DUPLICATION_EXCEPTION_MESSAGE);
        }
    }

    public TrialTimes makeTrialTimes(String inputString) {
        return new TrialTimes(inputString);
    }

}
