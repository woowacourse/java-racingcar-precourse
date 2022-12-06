package racingcar.domain;

import racingcar.exception.TryCommandNumberException;
import racingcar.exception.TryCommandRangeException;

public class TryCommand {

    private static final int MIN_TRY = 1;
    private static final int MAX_TRY = 100000;
    private int tryCount;

    private TryCommand(int tryCount) {
        this.tryCount = tryCount;
    }

    public static TryCommand createTryCommandByString(String input) {
        int number = convertInt(input);
        validate(number);
        return new TryCommand(number);
    }

    private static void validate(int number) {
        validateRange(number);
    }

    private static void validateRange(int number) {
        if(number < MIN_TRY || number > MAX_TRY) {
            throw new TryCommandRangeException(MIN_TRY, MAX_TRY);
        }
    }

    private static int convertInt(String input) {
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException exception) {
            throw new TryCommandNumberException();
        }
    }

    public boolean tryMove() {
        if(tryCount > 0) {
            tryCount--;
            return true;
        }
        return false;
    }
}
