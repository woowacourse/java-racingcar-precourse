package utils;

import racingcar.view.OutputView;

import static racingcar.Constant.*;

public class RepetitionCountValidator {

    public static void checkValidRepetitionCount(String count){
        checkInteger(count);
        checkPositiveInteger(count);
    }

    private static void checkInteger(String count){
        try {
            Integer.parseInt(count);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_NOT_INTEGER);
        }
    }

    private static void checkPositiveInteger(String count){
        if(Integer.parseInt(count) <= 0){
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_NOT_POSITIVE_INTEGER);
        }
    }

}
