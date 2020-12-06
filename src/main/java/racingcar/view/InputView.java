package racingcar.view;

import racingcar.domain.exception.CarNameDuplicationException;
import racingcar.domain.exception.CarNameLengthException;
import racingcar.domain.exception.RacingTryCountsNumberFormatException;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_CAR_NAMES_NOTICE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_RACING_TRY_COUNTS_NOTICE_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String COMMA_DELIMITER = ",";
    private static final int SPLIT_LIMIT_THRESHOLD_PARAMETER = -1;
    private static final int MINIMUM_CAR_NAME_LENGTH = 1;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final char ZERO_DIGIT_NUMBER_CHARACTER = '0';

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_NOTICE_MESSAGE);
        List<String> carNames = scanCarNames();
        while (!isValidCarNames(carNames)) {
            carNames = scanCarNames();
        }
        return carNames;
    }

    private List<String> scanCarNames() {
        String[] carNames = this.scanner.nextLine()
                .split(COMMA_DELIMITER, SPLIT_LIMIT_THRESHOLD_PARAMETER);
        return Arrays.stream(carNames)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private boolean isValidCarNames(List<String> carNames) {
        try {
            validateCarNameLength(carNames);
            validateDuplication(carNames);
            return true;
        } catch (RuntimeException runtimeException) {
            System.out.println(runtimeException.getMessage());
            return false;
        }
    }

    private void validateCarNameLength(List<String> carNames) {
        boolean isAllValidCarNameLength = carNames.stream()
                .allMatch(this::isValidCarNameLength);
        if (!isAllValidCarNameLength) {
            throw new CarNameLengthException();
        }
    }

    private boolean isValidCarNameLength(String carName) {
        int carNameLength = carName.length();
        return MINIMUM_CAR_NAME_LENGTH <= carNameLength && carNameLength <= MAXIMUM_CAR_NAME_LENGTH;
    }

    private void validateDuplication(List<String> carNames) {
        Set<String> distinctCarNames = new HashSet<>(carNames);
        if (distinctCarNames.size() != carNames.size()) {
            throw new CarNameDuplicationException();
        }
    }

    public int inputRacingTryCounts() {
        System.out.println(INPUT_RACING_TRY_COUNTS_NOTICE_MESSAGE);
        String racingTryCounts = this.scanner.nextLine();
        while (!isValidRacingTryCounts(racingTryCounts)) {
            racingTryCounts = this.scanner.nextLine();
        }
        return Integer.parseInt(racingTryCounts);
    }

    private boolean isValidRacingTryCounts(String racingTryCounts) {
        try {
            validateRacingTryCountsNumberFormat(racingTryCounts);
            return true;
        } catch (RuntimeException runtimeException) {
            System.out.println(runtimeException.getMessage());
            return false;
        }
    }

    private void validateRacingTryCountsNumberFormat(String racingTryCounts) {
        boolean isAllValidPositiveDigitNumber = racingTryCounts.chars()
                .allMatch(Character::isDigit);
        if (!isAllValidPositiveDigitNumber) {
            throw new RacingTryCountsNumberFormatException();
        }
        boolean isZero = racingTryCounts.chars()
                .allMatch(digitNumber -> digitNumber == ZERO_DIGIT_NUMBER_CHARACTER);
        if (isZero) {
            throw new RacingTryCountsNumberFormatException();
        }
    }
}
