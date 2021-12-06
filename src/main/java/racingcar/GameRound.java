package racingcar;

import racingcar.view.InputDisplay;
import racingcar.view.OutputDisplay;

public class GameRound {

    private final InputDisplay inputDisplay;
    private final OutputDisplay outputDisplay;
    private final User user;

    private static final String REGULAR_TRY_COUNT_EXPRESSION = "^[1-9]{1}$";
    private static final String ERROR_MESSAGE_TRY_COUNT = "[ERROR] 게임 시도 횟수는 1~9 범위의 숫자만 가능합니다.";

    public GameRound(InputDisplay inputDisplay, OutputDisplay outputDisplay, User user) {
        this.inputDisplay = inputDisplay;
        this.outputDisplay = outputDisplay;
        this.user = user;
    }

    public String determineGameRound() {
        String inputRound = "";

        do {
            try {
                inputRound = inputRound();
                checkRoundCountError(inputRound);
            } catch (IllegalArgumentException e) {
                outputDisplay.printErrorMessage(e);
            }
        } while (!validateGameRound(inputRound));

        return inputRound;
    }

    private String inputRound() {
        inputDisplay.printInputRoundMessage();

        return user.inputValue();
    }

    private boolean validateGameRound(final String inputRound) {
        return checkRoundCountRule(inputRound);
    }

    private void checkRoundCountError(final String inputRound) {
        if (!checkRoundCountRule(inputRound)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_TRY_COUNT);
        }
    }

    private boolean checkRoundCountRule(String inputRound) {
        return inputRound.matches(REGULAR_TRY_COUNT_EXPRESSION);
    }

}
