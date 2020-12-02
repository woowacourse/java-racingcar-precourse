package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import view.InputView;
import view.OutputView;

public class Game {

    public static final String NAME_SEPARATOR = ",";
    public static final int MINIMUM_NAME_LENGTH = 1;
    public static final int MAXIMUM_NAME_LENGTH = 5;
    public static final int MINIMAL_ROUND_COUNT = 1;

    private final InputView inputView;
    private RacingCars racingCars;
    private int roundCount;

    public Game(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        createPlayingCars();
        moveCars();
    }

    private void moveCars() {
        try {
            roundCount = getRoundCount();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            moveCars();
        }
    }

    private int getRoundCount() {
        String rawRoundCount = inputView.getRoundCount();
        validateRoundCount(rawRoundCount);
        return Integer.parseInt(rawRoundCount);
    }

    private void validateRoundCount(String rawRoundCount) {
        validateNumeric(rawRoundCount);
        validateBiggerThanMinimalRoundCount(rawRoundCount);
    }

    private void validateBiggerThanMinimalRoundCount(String rawRoundCount) {
        if (isLessThanMinimalRoundCount(rawRoundCount)) {
            throw new IllegalArgumentException(OutputView.IS_SMALLER_THAN_MINIMAL_ERROR);
        }
    }

    private boolean isLessThanMinimalRoundCount(String rawRoundCount) {
        return Integer.parseInt(rawRoundCount) < MINIMAL_ROUND_COUNT;
    }

    private void validateNumeric(String rawRoundCount) {
        try {
            Integer.parseInt(rawRoundCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(OutputView.NOT_NUMBER_ERROR);
        }
    }

    private void createPlayingCars() {
        try {
            List<Car> userCars = Stream.of(getCarNames())
                    .map(Car::new)
                    .collect(Collectors.toList());
            racingCars = new RacingCars(userCars);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            createPlayingCars();
        }
    }

    private String[] getCarNames() {
        return getRawCarNames().split(NAME_SEPARATOR);
    }

    private String getRawCarNames() {
        String rawCarNames = inputView.getCarNames();
        validateCarNames(rawCarNames);
        return rawCarNames;
    }

    private void validateCarNames(String rawCarNames) {
        validateNoName(rawCarNames);
        validateExceedingLength(rawCarNames);
    }

    private void validateExceedingLength(String rawCarNames) {
        if (hasNameExceedingLength(rawCarNames)) {
            throw new IllegalArgumentException(OutputView.EXCEEDING_LENGTH_ERROR);
        }
    }

    private void validateNoName(String rawCarNames) {
        if (hasNoName(rawCarNames)) {
            throw new IllegalArgumentException(OutputView.NO_NAME_ERROR);
        }
    }

    private boolean hasNoName(String rawCarNames) {
        return rawCarNames.length() < MINIMUM_NAME_LENGTH;
    }

    private boolean hasNameExceedingLength(String rawCarNames) {
        return Stream.of(rawCarNames.split(NAME_SEPARATOR))
                .anyMatch(Game::exceedMaximumLength);
    }

    private static boolean exceedMaximumLength(String name) {
        return name.length() > MAXIMUM_NAME_LENGTH;
    }
}
