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
        progressGame();
    }

    private void progressGame() {
        List<Car> cars = makeParticipantsListRacingGame();
        System.out.println("경주차 개수: " + cars.size());
        int attempt = determineAttemptNumber();
    }

    private int determineAttemptNumber() {
        int attemptNumber = 0;

        try {
            gameDisplay.printInputTryCountMessage();
            String inputAttemptCount = userInput.inputAttemptCount();
            validator.validateAttemptCount(inputAttemptCount);

            attemptNumber = Integer.parseInt(inputAttemptCount);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            determineAttemptNumber();
        }

        return attemptNumber;
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
