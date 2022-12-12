package racingcar.view;

import racingcar.domain.CarGroup;

import static racingcar.message.PrintMessage.*;

public class OutputView {

    public void printInputRacing() {
        System.out.println(INPUT_CAR_NAME.getMessage());
    }

    public void printInputTryCount() {
        System.out.println(INPUT_TRY_COUNT.getMessage());
    }

    public void printRacingStart() {
        System.out.println(PRINT_BEFORE_RACING_RESULT.getMessage());
    }

    public void printRacingLog(CarGroup group) {
        System.out.println(group.toProgressMessage());
    }

    public void printWinner(CarGroup group) {
        System.out.printf(PRINT_WINNER.getMessage(), group.toWinnerMessage());
    }
}
