package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class InputValidator {
    static final int MAX_CAR_NAME_LENGTH = 5;
    static final int MIN_CAR_NAME_LENGTH = 1;
    public InputValidator(){

    }
    public List<String> validateCarName(String inputCarNames){
        List<String> carNames = splitAndTrim(inputCarNames);
        if(checkCarNameLength(carNames) == false) throw new IllegalArgumentException();
        return carNames;
    }
    public int validateTryNumber(String inputTryNumber){
        int number = -1;
        try {
            number = Integer.parseInt(inputTryNumber);
            if( number < 0 ) throw new IllegalArgumentException();
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
        return number;
    }
    private List<String> splitAndTrim(String inputCarNames){
        String carNames[] = inputCarNames.split(",");
        for (int i = 0; i < carNames.length ; i++ ){
            String carName = carNames[i];
            carNames[i] = carName.trim();
        }
        System.out.println("carNames.toString() = " + carNames.toString());
        return Arrays.asList(carNames);
    }
    private boolean checkCarNameLength(List<String> carNames){
        long errorNumber = carNames.stream().filter((carName)->
                carName.length() >= MAX_CAR_NAME_LENGTH || carName.length() < MIN_CAR_NAME_LENGTH ).count();
        if(errorNumber != 0 ) return false;
        return true;
    }

}
