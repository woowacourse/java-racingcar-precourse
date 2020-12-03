package error;

import error.customException.NotValidInputException;

public class Validator {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String EXCEED_MAX_CAR_NAME_ERROR_MESSAGE = "자동차 이름은 " + MAX_CAR_NAME_LENGTH + "글자 이하여야 합니다.";

    public static void validatePerCarName (String carName){

        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            try {
                throw new NotValidInputException(EXCEED_MAX_CAR_NAME_ERROR_MESSAGE);
            } catch (NotValidInputException e) {
                e.printStackTrace();
            }
        }
    }

}
