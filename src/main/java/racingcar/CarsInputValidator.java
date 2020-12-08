package racingcar;

import static racingcar.Messages.NAMES_SHOULD_NOT_DUPLICATE;
import static racingcar.Messages.INVALID_NAMES_FORMAT;
import static utils.PrintUtils.print;

import exceptions.InvalidInputException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CarsInputValidator {

    public static final char COMMA = ',';

    private boolean valid;
    private List<Car> cars;

    public CarsInputValidator() {
        valid = false;
        cars = null;
    }

    public List<Car> getCars() {
        return cars;
    }

    public boolean isValid() {
        return valid;
    }

    public void validate(String input) {
        List<String> names;
        try {
            names = validateComma(input);
            validateEachName(names);
            validateDuplicateName();

            validationSuccess();
        } catch (InvalidInputException e) {
            print(e.getMessage());
        }
    }

    private List<String> validateComma(String input) {
        String[] names = input.split(String.valueOf(COMMA));
        int countOfComma = (int) input.chars()
                .filter(ch -> ch == COMMA).count();

        if (countOfComma + 1 != names.length) {
            throw new InvalidInputException(INVALID_NAMES_FORMAT);
        }

        return Arrays.asList(names);
    }

    private void validateEachName(List<String> names) {
        cars = names.stream().map(Car::new).collect(Collectors.toList());
    }

    private void validateDuplicateName() {
        HashSet<Car> carSet = new HashSet<>(cars);

        if (carSet.size() != cars.size()) {
            throw new InvalidInputException(NAMES_SHOULD_NOT_DUPLICATE);
        }
    }

    private void validationSuccess() {
        valid = true;
    }
}