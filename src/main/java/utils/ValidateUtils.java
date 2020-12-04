package utils;

import java.util.List;
import java.util.Scanner;
import racingcar.exception.RacingCarErrorException;

/**
 * 입력값이 조건에 맞는지 검증하는 클래스
 */
public class ValidateUtils {

    private static final String CAR_NAME_INPUT_EXCEPTION_MESSAGE = "자동차 이름은 1자 이상 5자 이내여야 합니다.";
    private static final String CAR_NUMBERS_INPUT_EXCEPTION_MESSAGE = "자동차 갯수는 2개 이상이어야 합니다.";
    private static final String MOVES_INPUT_EXCEPTION_MESSAGE = "자연수를 입력해야 합니다.";
    private static final String CAR_NAME_INPUT_DUPLICATE_EXCEPTION_MESSAGE = "자동차 이름은 중복되면 안됩니다.";
    private static final int FIVE = 5;
    private static final int TWO = 2;
    private static final int ZERO = 0;

    private final Scanner scanner;

    public ValidateUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    public void isValid(List<String> cars) {
        if (!isMoreThanOne(cars)) {
            throw new RacingCarErrorException(CAR_NUMBERS_INPUT_EXCEPTION_MESSAGE);
        }
    }

    private boolean isMoreThanOne(List<String> cars) {
        if (cars.size() >= TWO) {
            isNotDuplicate(cars);
            isValidateCarNames(cars);
            return true;
        }
        throw new RacingCarErrorException(CAR_NUMBERS_INPUT_EXCEPTION_MESSAGE);
    }

    private void isNotDuplicate(List<String> cars) {
        if (cars.stream().distinct().count() != cars.size()) {
            throw new RacingCarErrorException(CAR_NAME_INPUT_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private void isValidateCarNames(List<String> carNames) {
        if (!carNames.stream().allMatch(this::hasLengthInRange)) {
            throw new RacingCarErrorException(CAR_NAME_INPUT_EXCEPTION_MESSAGE);
        }
    }

    private boolean hasLengthInRange(String carName) {
        return carName.length() < FIVE && carName.length() > ZERO;
    }

    public int isMoreThanZero() {
        try {
            int input = Integer.parseInt(scanner.nextLine());
            return isNaturalNumber(input);
        } catch (NumberFormatException | RacingCarErrorException exception) {
            throw new RacingCarErrorException(MOVES_INPUT_EXCEPTION_MESSAGE);
        }
    }

    private int isNaturalNumber(int input) {
        if (input > 0) {
            return input;
        }
        throw new RacingCarErrorException(MOVES_INPUT_EXCEPTION_MESSAGE);
    }
}
