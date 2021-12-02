package racingcar.validator;


import java.util.HashSet;
import java.util.Set;

import static util.CarConstant.*;

public class NameValidator {

    public static void isRightName(String[] cars){
        isInputBlank(cars);
        isNameLowerThanFive(cars);
        isDuplicateName(cars);
    }

    private static void isInputBlank(String[] cars){
        if(cars.length == ZERO){
            throw new IllegalArgumentException(ERROR_PREFIX + SPACE + NAME_NOT_BLANK);
        }
        for(int i = 0 ; i < cars.length; i++){
            isCarNameBlank(cars[i]);
        }
    }

    private static void isCarNameBlank(String car) {
        for(int i = 0 ; i < car.length(); i++){
            char digit = car.charAt(i);
            if(!Character.isWhitespace(digit)){
                return;
            }
        }
        throw new IllegalArgumentException(ERROR_PREFIX + SPACE + NAME_NOT_BLANK);
    }

    private static void isNameLowerThanFive(String[] cars){
        for(int i = 0 ; i < cars.length; i++){
            if(cars[i].length() > LIMIT_SIZE_OF_NAME){
                throw new IllegalArgumentException(ERROR_PREFIX + SPACE + NAME_LENGTH_ERROR_MESSAGE);
            }
        }
    }

    private static void isDuplicateName(String[] car){
        Set<String> tempSet = new HashSet<>();
        for(int i = 0 ; i < car.length; i++){
            tempSet.add(car[i]);
        }
        if(tempSet.size() < car.length){
            throw new IllegalArgumentException(ERROR_PREFIX + SPACE + NAME_DUPLICATE);
        }
    }
}
