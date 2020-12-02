package racingcar;

import java.util.stream.Stream;
import view.InputView;
import view.OutputView;

public class Game {

    public static final String NAME_SEPARATOR = ",";
    public static final int MINIMUM_NAME_LENGTH = 1;
    public static final int MAXIMUM_NAME_LENGTH = 5;

    private final InputView inputView;

    public Game(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        initialize();
        createPlayingCars();
    }

    private void initialize() {
    }

    private void createPlayingCars() {
        String rawCarNames = inputView.getCarNames();
        try {
            validate(rawCarNames);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            createPlayingCars();
        }
    }

    private void validate(String rawCarNames) {
        validateNoName(rawCarNames);
        validateExceedingLength(rawCarNames);
    }

    private void validateExceedingLength(String rawCarNames) {
        if (hasNameExceedingLength(rawCarNames)) {
            throw new IllegalArgumentException("[ERROR] 이름은 5글자 내로 만들어야한다.");
        }
    }

    private void validateNoName(String rawCarNames) {
        if (hasNoName(rawCarNames)) {
            throw new IllegalArgumentException("[ERROR] 최소 하나의 자동차 이름을 입력해야한다.");
        }
    }

    private boolean hasNoName(String rawCarNames) {
        return rawCarNames.length() == 0;
    }

    private boolean hasNameExceedingLength(String rawCarNames) {
        return Stream.of(rawCarNames.split(NAME_SEPARATOR))
                .anyMatch(Game::exceedMaximumLength);
    }

    private static boolean exceedMaximumLength(String name) {
        return name.length() > MAXIMUM_NAME_LENGTH;
    }
}
