package racingcar;

import racingcar.domain.Car;
import racingcar.view.InputDisplay;
import racingcar.view.OutputDisplay;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final InputDisplay inputDisplay;
    private final OutputDisplay outputDisplay;

    private static final String SPACE = " ";
    private static final String PRINT_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String NAME_SEPARATOR = ",";

    public RacingGame(InputDisplay gameDisplay, OutputDisplay outputDisplay) {
        this.inputDisplay = gameDisplay;
        this.outputDisplay = outputDisplay;
    }

    public void startRacingGame() {
        User user = new User(inputDisplay, outputDisplay);
        GameRound gameRound = new GameRound(inputDisplay, outputDisplay, user);

        playRacingGame(user, gameRound);
    }

    private void playRacingGame(User user, GameRound gameRound) {
        List<Car> playerNames = user.makeCarNameList();
        int rounds = Integer.parseInt(gameRound.determineGameRound());

        playAllRound(playerNames, rounds);
        announceWinner(playerNames);
    }

    private void announceWinner(List<Car> cars) {
        List<String> winners = makeWinnerList(cars);
        String makeWinnerPrintFormat = makeWinnerPrintFormat(winners);

        outputDisplay.printWinner(makeWinnerPrintFormat);
    }

    private void playAllRound(List<Car> cars, int rounds) {
        outputDisplay.printEmptyLine();
        outputDisplay.printExecutionResultMessage();

        for (int i = 0; i < rounds; i++) {
            playEachRound(cars);
            outputDisplay.printEmptyLine();
        }
    }

    private String makeWinnerPrintFormat(List<String> winners) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PRINT_WINNER_MESSAGE);

        for (int i = 0; i < winners.size(); i++) {
            stringBuilder.append(winners.get(i));

            if (i != winners.size() - 1) {
                stringBuilder.append(NAME_SEPARATOR).append(SPACE);
            }
        }

        return stringBuilder.toString();
    }

    private List<String> makeWinnerList(final List<Car> cars) {
        final List<String> winners = new ArrayList<>();
        final int topSpeed = findTopSpeed(cars);

        for (Car car : cars) {
            if (topSpeed == car.getPosition()) {
                winners.add(car.getCarName());
            }
        }

        return winners;
    }

    private int findTopSpeed(final List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    private void playEachRound(List<Car> cars) {
        for (Car car : cars) {
            int randomNumberToMove = car.inputMoveForwardNumber();

            if (car.decideMoveCar(randomNumberToMove)) {
                car.moveForward();
                car.addSpeed();
            }

            outputDisplay.printEachRoundResult(car);
        }
    }

}
