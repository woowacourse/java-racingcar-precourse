package racingcar;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;

public class Model {
    private static final String NUM_REGEX = "^[0-9]+$";
    
    public Model() {}
    
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
    
    public List<Car> getCarNames(String input) {
        String [] carNames = input.split(",");
        
        return Arrays.stream(carNames).map(s -> new Car(s)).collect(Collectors.toList());
    }
    
    public void setPositions(final List<Car> participants) {
        
        participants.stream().forEach(c -> c.moveCar());
    }
    
    public boolean hasWinner(final List<Car> participants, final int goal) {
        
        return participants.stream().anyMatch(car -> car.getPosition() == goal);
    }
    
    public List <Car> getWinner(List<Car> participants, final int goal) {
        
        return participants.stream().filter(car -> car.getPosition() == goal).collect(Collectors.toList());
    }


}
