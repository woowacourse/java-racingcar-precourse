package racingcar.view;

import static racingcar.ErrorCode.NOT_TRY_COUNT;
import static racingcar.ErrorCode.NOT_VALID_TRY_COUNT;

public class inputValidator {

    public void validateMovingCount(String input) {
        isNumber(input);

        int movingCount = Integer.parseInt(input);
        if(movingCount < 1) {
            NOT_VALID_TRY_COUNT.throwError();
        }
    }

    public void isNumber(String input) {
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e) {
            NOT_TRY_COUNT.throwError();
        }
    }
}
