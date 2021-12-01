package racingcar;


import static util.CarConstant.*;

public class CarValidator {

    public static void isNameLowerThanFive(String[] input){
        for(int i = 0 ; i < input.length; i++){
            if(input[i].length() > 5){
                throw new IllegalArgumentException(ERROR_PREFIX + " " + NAME_LENGTH_ERROR_MESSAGE);
            }
        }
    }

    public static void isRightTryNumber(String input){
        isNumber(input);
        isRightRange(input);
    }

    private static void isNumber(String input){
        for(int i = 0 ; i < input.length(); i++){
            if (!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException(ERROR_PREFIX + " " + TRY_NUMBER_NOT_NUMBER_MESSAGE);
            }
        }
    }

    private static void isRightRange(String input){
        int inputNum = Integer.parseInt(input);
        if(inputNum <= ZERO){
            throw new IllegalArgumentException(ERROR_PREFIX + " " + NUMBER_OUT_OF_RANGE_MESSAGE);
        }
    }
}
