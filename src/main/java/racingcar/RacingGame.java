package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final UserInput userInput;
    private final Validator validator;
    private final GameDisplay gameDisplay;

    public RacingGame(UserInput userInput, Validator validator, GameDisplay gameDisplay) {
        this.userInput = userInput;
        this.validator = validator;
        this.gameDisplay = gameDisplay;
    }

    public void startGame() {
        playGame();
    }

    private void playGame() {
        List<Car> cars = makeParticipantsListRacingGame();

        int rounds = determineRoundNumber();
        gameDisplay.printEmptyLine();
        gameDisplay.printExecutionResultMessage();

        for (int i = 0; i < rounds; i++) {
            playEachRound(cars);
            gameDisplay.printEmptyLine();
        }

        List<String> winners = makeWinnerList(cars);
        gameDisplay.printWinnerList(winners);
    }

    private List<String> makeWinnerList(final List<Car> cars) {
        final int topSpeed = findTopSpeed(cars);
        final List<String> winners = new ArrayList<>();

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

    private int determineRoundNumber() {
        int totalRoundNumber = 0;

        try {
            gameDisplay.printInputRoundMessage();
            String totalRound = userInput.inputRound();
            validator.validateAttemptCount(totalRound);

            totalRoundNumber = Integer.parseInt(totalRound);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            determineRoundNumber();
        }

        return totalRoundNumber;
    }

    private List<Car> makeParticipantsListRacingGame() {
        List<Car> carNames = new ArrayList<>();

        try {
            gameDisplay.printInputCarNameMessage();
            String inputCarNames = userInput.inputCarNames();
            carNames = userInput.splitInputCarNames(inputCarNames);

            validator.validateCar(carNames);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            makeParticipantsListRacingGame();
        }

        return carNames;
    }

}
