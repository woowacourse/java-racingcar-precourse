package racingcar;

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
        makeListOfRacingCars();
    }

    private void makeListOfRacingCars() {
        try {
            gameDisplay.printInputCarNameMessage();

            String inputCarNames = userInput.inputCarNames();
            List<Car> splitCarNames = userInput.splitInputCarNames(inputCarNames);

            validator.validateRuleOfCarNamesLength(splitCarNames);
            validator.validateRuleOfCarCount(splitCarNames);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            makeListOfRacingCars();
        }
    }

}
