package utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Validation {

    private static String EMPTY = " ";
    private static int MIN_LENGTH = 1;
    private static int MAX_LENGTH = 5;

    public void carValidate(String cars) {

        carInputCheck(cars);

        List<String> carList = Stream.of(cars.split(","))
                .collect(Collectors.toList());

        carLengthCheck(carList);
        carDuplicateCheck(carList);
        carEmptyCheck(carList);
    }

    public void turnsValidate(String times) {

        turnEmptyCheck(times);
        turnIsNumericCheck(times);
        turnIsPositiveCheck(times);

    }

    private void carInputCheck(String cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(Message.ERROR + Message.INPUT_NULL_ERROR);
        }
        if (cars.endsWith(",")) {
            throw new IllegalArgumentException(Message.ERROR + Message.INPUT_END_COMMA_ERROR);
        }

    }

    private void carLengthCheck(List<String> carList) {
        for (String carName : carList) {
            if (carName.length() < MIN_LENGTH || carName.length() > MAX_LENGTH) {
                throw new IllegalArgumentException(Message.ERROR + Message.NAME_LENGTH_ERROR);
            }
        }
    }

    private void carEmptyCheck(List<String> carList) {
        for (String carName : carList) {
            if (carName.equals(EMPTY)) {
                throw new IllegalArgumentException(Message.ERROR + Message.NAME_EMPTY_ERROR);
            }
        }
    }

    private void carDuplicateCheck(List<String> carList) {
        List<String> deleteDuplicateCarList = carList.stream()
                .distinct()
                .collect(Collectors.toList());

        if (carList.size() != deleteDuplicateCarList.size()) {
            throw new IllegalArgumentException(Message.ERROR + Message.NAME_DUPLICATE_ERROR);
        }

    }

    private void turnEmptyCheck(String times) {
        if (times.isEmpty()) {
            throw new IllegalArgumentException(Message.ERROR + Message.TIME_NULL_ERROR);
        }
    }

    private void turnIsNumericCheck(String times) {
        boolean isNumeric = times.matches("[+-]?\\d*(\\.\\d+)?");
        if (!isNumeric) {
            throw new IllegalArgumentException(Message.ERROR + Message.TIME_NUMERIC_ERROR);
        }
    }

    private void turnIsPositiveCheck(String times) {
        if (times.startsWith("-") || times.equals("0")) {
            throw new IllegalArgumentException(Message.ERROR + Message.TIME_NEGATIVE_ERROR);
        }
    }


}

