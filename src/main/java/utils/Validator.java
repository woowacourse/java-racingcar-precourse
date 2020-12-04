package utils;

import java.util.List;

public class Validator {
    private static final int MAX_CAR_NAME_SIZE = 5;

    public void isValidCarNameSize(List<String> carList) {
        for (String carName : carList) {
            if (carName.length() > MAX_CAR_NAME_SIZE) {
                throw new IllegalArgumentException(ExceptionMessage.isNotValidCarName);
            }
        }
    }

    public void isRaceRoundInteger (String playRound) {
        try {
            Integer.parseInt(playRound);
        } catch (NumberFormatException ne) {
            throw new NumberFormatException(ExceptionMessage.isNotInteger);
        }
    }

}
