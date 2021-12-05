package model;

import java.util.Arrays;

public class InputValidation {
 private static final String NUM_REGEX = "^[0-9]+$";
    
    public InputValidation() {}
    
    public void checkValidationForCars(String input) {
        String [] cars = input.split(",",-1);
        
        if(Arrays.stream(cars).anyMatch(s -> s.equals("") || s.length() > 5)) {
            throw new IllegalArgumentException();
        }
    }
    
    public void checkValidationForGoal(String input) {
        if(!input.matches(NUM_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

}
