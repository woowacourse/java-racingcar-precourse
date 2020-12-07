package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import view.InputView;
import view.OutputView;

public class Game {

    private final InputView inputView;
    private RacingCars racingCars;
    private GameRound gameRound;

    public Game(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        createRacingCars();
        moveCars();
        OutputView.printWinners(racingCars);
    }

    private void createRacingCars() {
        try {
            List<Car> userCars = Stream.of(setCarNames())
                    .map(String::trim)
                    .map(Car::new)
                    .collect(Collectors.toList());
            racingCars = new RacingCars(userCars);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            createRacingCars();
        }
    }

    private String[] setCarNames() {
        return userInputCarNames().split(CarNames.NAME_SEPARATOR);
    }

    private String userInputCarNames() {
        String rawCarNames = inputView.getCarNames();
        CarNames.validate(rawCarNames);
        return rawCarNames;
    }

    private void moveCars() {
        setRoundCount();
        racingCars.moveFor(gameRound.getCount());
    }

    private void setRoundCount() {
        try {
            gameRound = new GameRound(inputView.getRoundCount());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            setRoundCount();
        }
    }
}
