package utils;

import java.util.List;

public class Validator {
    private static final int CAR_NAME_MAX_SIZE = 5;
    private static final int MINIMUM_NUMBER_OF_RACE_CARS = 2;
    private static final int MINIMUM_NUMBER_OF_RACES = 1;

    public void isValidCarsInput(List<String> carList) {
        isValidNumberOfCars(carList);
        isValidCarNameSize(carList);
    }

    public void isValidRaceRoundInput(String raceRound) {
        isValidRaceRoundInteger(raceRound);
        isRaceRoundOverOne(raceRound);
    }

    private void isValidNumberOfCars(List<String> carList) {
        if (carList.size() < MINIMUM_NUMBER_OF_RACE_CARS) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_VALID_NUMBERS_OF_CARS);
        }
    }

    private void isValidCarNameSize(List<String> carList) {
        for (String carName : carList) {
            if (carName.length() > CAR_NAME_MAX_SIZE) {
                throw new IllegalArgumentException(ExceptionMessage.IS_NOT_VALID_CAR_NAME_SIZE);
            }
        }
    }

    private void isValidRaceRoundInteger(String raceRound) {
        try {
            Integer.parseInt(raceRound);
        } catch (IllegalArgumentException ie) {
            throw new IllegalArgumentException(ExceptionMessage.IS_RACE_ROUND_NOT_INTEGER);
        }
    }

    private void isRaceRoundOverOne(String raceRound) {
        if (Integer.parseInt(raceRound) < MINIMUM_NUMBER_OF_RACES) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_VALID_RACE_ROUND);
        }
    }
}
