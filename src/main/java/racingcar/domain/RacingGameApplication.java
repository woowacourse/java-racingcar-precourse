package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameApplication {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameApplication(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        RacingGame racingGame = createRacingGame();
        outputView.printRunMessage();
        runningGame(racingGame);
        outputView.printWinnerNames(racingGame.getWinners());
    }

    private RacingGame createRacingGame() {
        Cars cars = createCars(inputView.sendNamesOfParticipatingCars());
        CountOfMoves countOfMoves = createCount(inputView.sendCountOfMoves());
        return new RacingGame(cars, countOfMoves);
    }

    private Cars createCars(String namesOfParticipatingCars) {
        List<Car> cars = Arrays.stream(namesOfParticipatingCars.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private CountOfMoves createCount(String countOfMoves) {
        int count = convertInputToInt(countOfMoves);
        return new CountOfMoves(count);
    }

    private int convertInputToInt(String input) {
        if (isNotNumber(input)) {
            throw new IllegalArgumentException("숫자를 입력해주세요. 입력값 : " + input);
        }
        return Integer.parseInt(input);
    }

    private boolean isNotNumber(String input) {
        return !input.chars().allMatch(Character::isDigit);
    }

    private void runningGame(RacingGame racingGame) {
        while (!racingGame.isOver()) {
            outputView.printCarsPosition(racingGame.move());
        }
    }
}
