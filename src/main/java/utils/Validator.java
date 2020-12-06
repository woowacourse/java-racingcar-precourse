package utils;

import racingcar.domain.setting.CarSetting;
import racingcar.exception.DuplicateNameException;
import racingcar.exception.InvalidNameException;
import racingcar.exception.InvalidNumberException;

import java.util.Arrays;

public class Validator {

    public Validator() {
    }

    public static void validateNames(String[] input) {

        if (input.length == 0 && input == null) {
            throw new InvalidNameException();
        }

        if (hasDuplicate(input)) {
            throw new InvalidNameException(input);
        }

        if (isLengthOver(input)) {
            throw new InvalidNameException();
        }

    }

    /*
     * 반복횟수에 대한 제한은 없지만
     * 1. 음수 불가
     * 2. 소수 당연히 불가
     * */
    public static void validateRepeat(String input) {

        if (!isNumberType(input)) {
            throw new InvalidNumberException(input);
        }

        double number = Double.parseDouble(input);
        if (number != (int) number) {
            throw new InvalidNumberException(input);
        }

        if (number < 0) {
            throw new InvalidNumberException(input);
        }
    }

    public static boolean isLengthOver(String[] names) {

        for (String name : names) {
            if (name.length() > CarSetting.NAME_MAX_LENGTH.get()) {
                return true;
            }
        }
        return false;
    }


    private static boolean hasDuplicate(String[] names) {
        return Arrays.stream(names)
                .distinct()
                .count() != names.length;
    }

    private static boolean isNumberType(String count) {
        try {
            Integer.parseInt(count);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
