package racingcar;

import util.CarConstant;

import static util.CarConstant.*;

public class CarValidator {

    public static void isNameLowerThanFive(String[] input){
        for(int i = 0 ; i < input.length; i++){
            if(input[i].length() > 5){
                throw new IllegalArgumentException(ERROR_PREFIX + " " + NUMBER_ERROR_MESSAGE);
            }
        }
    }
}
