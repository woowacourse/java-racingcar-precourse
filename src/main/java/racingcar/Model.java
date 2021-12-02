package racingcar;

public class Model {
    private static final String NUM_REGEX = "^[0-9]+$";
    
    public Model() {}
    
    public boolean checkValidationForCars(String carNames) {
        String [] cars = carNames.split(",");
        
        for(int i = 0; i < cars.length; i++) {
            if(cars[i].equals(null) || cars[i].length() > 5) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean checkValidationForAttempt(String attempt) {
        if(attempt.matches(NUM_REGEX)) {
            return true;
        }
        
        return false;
    }
}
