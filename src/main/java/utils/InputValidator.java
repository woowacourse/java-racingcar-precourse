package utils;

import racingcar.Car;
import racingcar.Rounds;

import java.util.Arrays;

public class InputValidator {
    private InputValidator(){}

    public static void checkValidCarName(String name){
        if(!isValidLength(name.trim(), Car.MIN_NAME_LEN,  Car.MAX_NAME_LEN)){
            throw new IllegalArgumentException("적절하지 않은 길이의 자동차 이름");
        }
    }

    private static boolean isValidLength(String input, int min, int max){
        return (input.length() >= min &&  input.length() <= max);
    }

    public static void checkDuplicatedCarName(String[] name){
        if(hasDuplicatedValue(name)){
            throw new IllegalArgumentException("중복된 이름을 포함할 수 없습니다.");
        }
    }

    private static boolean hasDuplicatedValue(String[] input){
        return Arrays.stream(input)
                .map(String::trim)
                .distinct()
                .count() != input.length;
    }

    public static void checkValidRounds(int totalRound){
        if(!isValidRangeNumber(totalRound, Rounds.MIN_TOTAL_ROUND, Rounds.MAX_TOTAL_ROUND)){
            throw new IllegalArgumentException("유효하지 않은 범위의 시도 숫자입니다.");
        }
    }

    private static boolean isValidRangeNumber(int input, int min, int max){
        return (input >= min && input <= max);
    }
}
