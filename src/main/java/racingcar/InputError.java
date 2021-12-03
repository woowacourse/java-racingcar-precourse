package racingcar;

import java.io.IOException;

public class InputError {

    private final int MIN_CAR_LIST = 1;
    private final int MAX_NAME_LENGTH = 5;
    private final String NULL = "";
    private final String SPACE = " ";
    private final String SEPARATOR = ",";

    public boolean isValidCar(String userInput) {
        String[] carList = userInput.split(SEPARATOR);
        return isValidListLength(carList) && isValidNameLength(carList) && hasNotContainSpace(carList) && streamDuplicateCheck(carList);
        }

    private boolean isValidListLength(String[] carList) {
        for (String carName : carList) {
            if (carName.length() > MAX_NAME_LENGTH) {

            }
    }
}
}
