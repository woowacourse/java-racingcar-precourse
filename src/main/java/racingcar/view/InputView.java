package racingcar.view;

import racingcar.exception.*;

import java.util.*;

public class InputView {
    private static final int ZERO = 0;
    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String NAME_DELIMITER = ",";
    private static final String INPUT_RACING_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)";
    private static final String INPUT_RACING_ROUND = "시도할 회수는 몇회인가요?";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> inputRacingCars() {
        System.out.println(INPUT_RACING_CARS);
        String racingCarNames = scanner.nextLine();
        validate(racingCarNames);
        return Arrays.asList(racingCarNames.split(NAME_DELIMITER));
    }

    private void validate(String racingCarNames) {
        validateSpaceInput(racingCarNames);
        validateDelimiterInput(racingCarNames);
        validateNameLength(racingCarNames);
        validateInputWithoutName(racingCarNames);
        validateNameDuplication(racingCarNames);
    }

    private void validateSpaceInput(String racingCarNames) {
        if (racingCarNames.trim().length() == ZERO) {
            throw new SpaceInputException();
        }
    }

    private void validateDelimiterInput(String racingCarNames) {
        if (!racingCarNames.contains(NAME_DELIMITER)) {
            throw new DelimiterInputException();
        }
    }

    private void validateNameLength(String racingCarNames) {
        Optional<String> first = Arrays.stream(racingCarNames.split(NAME_DELIMITER))
                .filter(name
                        -> name.trim().length() < MINIMUM_NAME_LENGTH || name.trim().length() > MAXIMUM_NAME_LENGTH)
                .findFirst();
        if (first.isPresent()) {
            throw new InvalidNameLengthException();
        }
    }

    private void validateInputWithoutName(String racingCarNames) {
        if (racingCarNames.split(NAME_DELIMITER).length == ZERO) {
            throw new InputWithoutNameException();
        }
    }

    private void validateNameDuplication(String racingCarNames) {
        boolean duplicated = Arrays.stream(racingCarNames.split(NAME_DELIMITER))
                .distinct()
                .count() != racingCarNames.split(NAME_DELIMITER).length;
        if (duplicated) {
            throw new NameDuplicationException();
        }
    }

    public int inputRacingRound() {
        System.out.println(INPUT_RACING_ROUND);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            throw new RoundIllegalArgumentException();
        }
    }

}
