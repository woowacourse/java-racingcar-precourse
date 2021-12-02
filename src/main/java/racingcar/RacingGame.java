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

        for (int i = 0; i < rounds; i++) {
            playEachRound(cars);
            gameDisplay.printEmptyLine();
        }

        // 우승자를 선택하는 로직 구현.
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
