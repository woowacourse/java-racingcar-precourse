package racingcar;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;

public class Model {
    private static final String NUM_REGEX = "^[0-9]+$";
    
    public Model() {}
    
    public boolean checkValidationForCars(String input) {
        String [] cars = input.split(",");
        
        if(Arrays.stream(cars).anyMatch(s -> s.equals("") || s.length() > 5)) {
            return false;
        }
   
        return true;
    }
    
    public boolean checkValidationForAttempt(String input) {
        if(input.matches(NUM_REGEX)) {
            return true;
        }
        
        return false;
    }
}
