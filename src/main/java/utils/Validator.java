package utils;

import java.util.List;

public class Validator {

    public void isValidCarName(List<String> carList) {
        for (String carName : carList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(ExceptionMessage.isNotValidCarName);
            }
        }
    }

    public void isPlayRoundInteger (String playRound) {
        try {
            Integer.parseInt(playRound);
        } catch (NumberFormatException ne) {
            throw new NumberFormatException(ExceptionMessage.isNotInteger);
        }
    }

}
