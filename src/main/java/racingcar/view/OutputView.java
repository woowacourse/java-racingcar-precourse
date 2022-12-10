package racingcar.view;

import racingcar.message.Message;

import static racingcar.message.Message.*;

public class OutputView {
    public void printCarsName() {
        System.out.println(PRINT_INPUT_NAMES);
    }

    public void printInputFinalRound() {
        System.out.println(PRINT_INPUT_FINAL_ROUND);
    }

    public void printResult(String result) {
        System.out.println(PRINT_OUTPUT);
        System.out.println(result);
    }

    public void printWinner(String winner){
        System.out.println(winner);
    }
}
