package racingcar;

import utils.TextResource;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RaceSetting {
    private Round round;

    public void init() {
        round = new Round(Round.DEFAULT_ROUND);
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Scanner scanner) throws InputMismatchException {
        System.out.println(TextResource.STATEMENT_INPUT_ROUND);
        int round = scanner.nextInt();
        this.round.setRoundValue(round);
    }
}
