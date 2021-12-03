package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final UserInput userInput;
    private final Validator validator;
    private final GameDisplay gameDisplay;

    private static final String SPACE = " ";
    private static final String PRINT_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String NAME_SEPARATOR = ",";

    public RacingGame(UserInput userInput, Validator validator, GameDisplay gameDisplay) {
        this.userInput = userInput;
        this.validator = validator;
        this.gameDisplay = gameDisplay;
    }

    public void startGame() {
        playRacingGame();
    }

    private void playRacingGame() {
        List<Car> cars = makeParticipantsList();
        int rounds = Integer.parseInt(determineGameRound());

        gameDisplay.printEmptyLine();
        gameDisplay.printExecutionResultMessage();

        playAllRound(cars, rounds);
        announceWinner(cars);
    }

    private void announceWinner(List<Car> cars) {
        List<String> winners = makeWinnerList(cars);
        String makeWinnerPrintFormat = makeWinnerPrintFormat(winners);

        gameDisplay.printWinner(makeWinnerPrintFormat);
    }

    private void playAllRound(List<Car> cars, int rounds) {
        for (int i = 0; i < rounds; i++) {
            playEachRound(cars);
            gameDisplay.printEmptyLine();
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

            gameDisplay.printEachRoundResult(car);
        }
    }

    private String determineGameRound() {
        gameDisplay.printInputRoundMessage();
        String totalRound = userInput.inputRound();

        try {
            validator.validateAttemptCount(totalRound);
        } catch (IllegalArgumentException e) {
            gameDisplay.printErrorMessage(e);
            determineGameRound();
        }

        return totalRound;
    }

    private List<Car> makeParticipantsList() {
        gameDisplay.printInputNameMessage();
        String inputNames = userInput.inputNames();
        List<Car> participantNames = userInput.splitInputNames(inputNames);

        try {
            validator.validateCar(participantNames);
        } catch (IllegalArgumentException e) {
            gameDisplay.printErrorMessage(e);
            makeParticipantsList();
        }

        return participantNames;
    }

}
