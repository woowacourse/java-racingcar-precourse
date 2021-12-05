package model;

import java.util.Arrays;

public class InputValidation {
 private static final String NUM_REGEX = "^[0-9]+$";
    
    public InputValidation() {}
    
    public boolean checkValidationForCars(String input) {
        String [] cars = input.split(",",-1);
        
        if(Arrays.stream(cars).anyMatch(s -> s.equals("") || s.length() > 5)) {
            return false;
        }
   
        return true;
    }
    
    public boolean checkValidationForGoal(String input) {
        if(input.matches(NUM_REGEX)) {
            return true;
        }
        
        return false;
    }

}
