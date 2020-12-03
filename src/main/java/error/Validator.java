package error;

import error.customException.NotValidInputException;

public class Validator {

    private static final char DELIMITER = ',';
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String EMPTY_CAR_NAME_ERROR_MESSAGE = "자동차 이름이 입력되어야 합니다.";
    private static final String EXCEED_MAX_CAR_NAME_ERROR_MESSAGE = "자동차 이름은 " + MAX_CAR_NAME_LENGTH + "글자 이하여야 합니다.";

    public static void validateCarNameInSingleLine (String inputLine) throws NotValidInputException {

        if (inputLine.equals("") || inputLine.split(",").length == 0) {
            throw new NotValidInputException(EMPTY_CAR_NAME_ERROR_MESSAGE);
        }
    }

    public static void validatePerCarName (String carName) throws NotValidInputException {

        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new NotValidInputException(EXCEED_MAX_CAR_NAME_ERROR_MESSAGE);
        }
    }

}
