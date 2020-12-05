package racingcar;

import exception.InvalidInputException;
import exception.NonNumberRoundException;
import exception.ZeroRoundException;

import java.util.InputMismatchException;

public class RoundParser {

    private static final int MIN_ROUND = 1;

    private String line;
    private int round;

    public RoundParser(String line) {
        this.line = line;
    }


    public int parseRound() {
        getRoundFromLine();
        validateRound();
        return round;
    }

    private void validateRound() throws InvalidInputException {
        if (round < MIN_ROUND)
            throw new ZeroRoundException();
    }

    private void getRoundFromLine() throws InvalidInputException {
        try {
            round = Integer.parseInt(line);
        } catch (InputMismatchException | NumberFormatException e) {
            throw new NonNumberRoundException();
        }
    }
}
