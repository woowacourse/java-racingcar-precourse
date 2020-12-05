package utils;

import java.util.List;

public class Validator {
    private static final int MAX_CAR_NAME_SIZE = 5;

    public void isValidCarsInput(List<String> carList) {
        isValidNumberOfCars(carList);
        isValidCarNameSize(carList);
    }

    public void isValidRaceRoundInput(String raceRound) {
        isValidRaceRoundInteger(raceRound);
        isRaceRoundOverOne(raceRound);
    }

    private void isValidNumberOfCars(List<String> carList) {
        if (carList.size() < 2) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_VALID_NUMBERS_OF_CARS);
        }
    }

    private void isValidCarNameSize(List<String> carList) {
        for (String carName : carList) {
            if (carName.length() > MAX_CAR_NAME_SIZE) {
                throw new IllegalArgumentException(ExceptionMessage.IS_NOT_VALID_CAR_NAME_SIZE);
            }
        }
    }

    private void isValidRaceRoundInteger(String raceRound) {
        try {
            Integer.parseInt(raceRound);
        } catch (IllegalArgumentException ie) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_INTEGER);
        }
    }

    private void isRaceRoundOverOne(String raceRound) {
        if (Integer.parseInt(raceRound) < 1) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_VALID_RACE_ROUND);
        }
    }
}
