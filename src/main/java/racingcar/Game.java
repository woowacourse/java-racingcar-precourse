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
        roundCount = getRoundCount();
    }

    private int getRoundCount() {
        String rawInput = inputView.getRoundCount();
        return Integer.parseInt(rawInput);
    }


    private void createPlayingCars() {
        List<Car> userCars = Stream.of(getCarNames())
                .map(Car::new)
                .collect(Collectors.toList());
        racingCars = new RacingCars(userCars);
    }

    private String[] getCarNames() {
        return getUserInput().split(NAME_SEPARATOR);
    }

    private String getUserInput() {
        String rawInput = inputView.getCarNames();
        isValidOrEnterAgain(rawInput);
        return rawInput;
    }

    private void isValidOrEnterAgain(String rawInput) {
        try {
            validateCarNames(rawInput);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            createPlayingCars();
        }
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
