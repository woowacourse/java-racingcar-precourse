package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import racingcar.controller.ErrorException;
import racingcar.model.Car;

/**
 * 입력값이 조건에 맞는지 검증하는 클래스
 */
public class ValidUtils {

    private static final String CAR_NAME_INPUT_EXCEPTION_MESSAGE = "자동차 이름은 0자 이상 5자 이내여야 합니다.";
    private static final String CAR_NUMBERS_INPUT_EXCEPTION_MESSAGE = "자동차 갯수는 2개 이상이어야 합니다.";
    private static final String MOVES_INPUT_EXCEPTION_MESSAGE = "자연수를 입력해야 합니다.";
    private static final int FIVE = 5;
    private static final int TWO = 2;
    private static final int ZERO = 0;
    private final Scanner scanner;

    public ValidUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Car> isValid(String[] cars) {
        if (isMoreThanOne(cars)) {
            return makeCar(cars);
        }
        throw new ErrorException(CAR_NUMBERS_INPUT_EXCEPTION_MESSAGE);
    }

    private boolean isMoreThanOne(String[] input) {
        if (input.length >= TWO) {
            return isValidateCarNames(input);
        }
        throw new ErrorException(CAR_NUMBERS_INPUT_EXCEPTION_MESSAGE);
    }

    private boolean isValidateCarNames(String[] input) {
        if (Arrays.stream(input).allMatch(this::countCharacters)) {
            return true;
        }
        throw new ErrorException(CAR_NAME_INPUT_EXCEPTION_MESSAGE);
    }

    private boolean countCharacters(String carName) {
        return carName.length() < FIVE && carName.length() > ZERO;
    }

    private List<Car> makeCar(String[] names) {
        return Arrays.stream(names)
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public int moreThanZero() {
        try {
            int input = Integer.parseInt(scanner.nextLine());
            return isNaturalNumber(input);
        } catch (NumberFormatException | ErrorException exception) {
            throw new ErrorException(MOVES_INPUT_EXCEPTION_MESSAGE);
        }
    }

    private int isNaturalNumber(int input) {
        if (input > 0) {
            return input;
        }
        throw new ErrorException(MOVES_INPUT_EXCEPTION_MESSAGE);
    }
}
