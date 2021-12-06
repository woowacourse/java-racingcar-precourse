package racingcar.domain;

import racingcar.view.InputDisplay;
import racingcar.view.OutputDisplay;

public class RacingRound {

    private static final String REGULAR_TRY_COUNT_EXPRESSION = "^[1-9]{1}$";
    private static final String ERROR_MESSAGE_TRY_COUNT = "[ERROR] 게임 시도 횟수는 1~9 범위의 숫자만 가능합니다.";

    private final InputDisplay inputDisplay;
    private final OutputDisplay outputDisplay;
    private final RacingGame racingGame;

    public RacingRound(RacingGame racingGame, InputDisplay inputDisplay, OutputDisplay outputDisplay) {
        this.racingGame = racingGame;
        this.inputDisplay = inputDisplay;
        this.outputDisplay = outputDisplay;
    }

    public String determineGameRound() {
        String inputRound = "";

        do {
            try {
                inputRound = inputRound();
                checkRoundCountError(inputRound);
            } catch (IllegalArgumentException illegalArgumentException) {
                outputDisplay.printErrorMessage(illegalArgumentException);
            }
        } while (!validateGameRound(inputRound));

        return inputRound;
    }

    protected boolean validateGameRound(final String inputRound) {
        return checkRoundCountRule(inputRound);
    }

    protected void checkRoundCountError(final String inputRound) {
        if (!checkRoundCountRule(inputRound)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_TRY_COUNT);
        }
    }

    protected boolean checkRoundCountRule(String inputRound) {
        return inputRound.matches(REGULAR_TRY_COUNT_EXPRESSION);
    }

    protected String inputRound() {
        inputDisplay.printInputRoundMessage();

        return racingGame.inputValue();
    }

}
