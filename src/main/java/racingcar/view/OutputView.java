package racingcar.view;

import static racingcar.utils.PrintMessage.*;

public class OutputView {

    public void printInputRacing() {
        System.out.println(INPUT_CAR_NAME.getMessage());
    }

    public void printInputTryCount() {
        System.out.println(INPUT_TRY_COUNT.getMessage());
    }

    // TODO : 실행결과 데이터를 받아서 출력
    public void printRacingStart() {
        System.out.printf(PRINT_BEFORE_RACING_RESULT.getMessage());
    }

    public void printRacingLog(String log) {
        System.out.println(log);
    }

    public void printWinner(String winners) {
        System.out.printf(PRINT_WINNER.getMessage(), winners);
    }
}
