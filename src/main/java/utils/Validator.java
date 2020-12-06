package utils;

import java.util.Arrays;

public class Validator {

    private static int NAME_MAX_LENGTH = 5;

    public Validator() {
    }

    /*
     * 1. 중복값이 있는지 확인
     * 2. 5글자가 넘는지 확인
     * 3. Repeat Count 양의 정수인지 확인!!
     *
     * */
    public static void validateNames(String[] input) {

        if (input.length == 0 && input == null) {
            throw new IllegalArgumentException("널,빈문자");
        }

        if (hasDuplicate(input)) {
            throw new IllegalArgumentException("중복이 있다");
        }

        if (isLengthOver(input)) {
            throw new IllegalArgumentException("이름은 5자 이하로");
        }

    }

    /*
     * 반복횟수에 대한 제한은 없지만
     * 1. 음수 불가
     * 2. 소수 당연히 불가
     * */
    public static void validateRepeat(String input) {

        if (!isNumberType(input)) {
            throw new IllegalArgumentException("숫자만 넣어줘");
        }

        double number = Double.parseDouble(input);
        if (number != (int) number) {
            throw new IllegalArgumentException("소수 불가!");
        }

        if (number < 0) {
            throw new IllegalArgumentException("양수만 넣어줘");
        }
    }

    public static boolean isLengthOver(String... names) {

        for (String name : names) {
            if (name.length() > NAME_MAX_LENGTH) {
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
