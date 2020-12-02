package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import utils.ValidateUtils;
import view.InputView;
import view.OutputView;

public class Game {

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
        setRoundCount();
    }

    public void setRoundCount() {
        try {
            roundCount = userInputRoundCount();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            moveCars();
        }
   }

    private int userInputRoundCount() {
        String rawRoundCount = inputView.getRoundCount();
        ValidateUtils.validateRoundCount(rawRoundCount);
        return Integer.parseInt(rawRoundCount);
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
        return getRawCarNames().split(ValidateUtils.NAME_SEPARATOR);
    }

    private String getRawCarNames() {
        String rawCarNames = inputView.getCarNames();
        ValidateUtils.validateCarNames(rawCarNames);
        return rawCarNames;
    }
}
