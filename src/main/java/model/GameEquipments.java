package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameEquipments {
    
    public GameEquipments() {}
    
    public List<Car> toList(String input) {
        String[] carNames = input.split(",");
        
        return Arrays.stream(carNames).map(s -> new Car(s)).collect(Collectors.toList());
    }
    
    public void setPositions(final List<Car> participants) {
        
        participants.stream().forEach(c -> c.moveCar());
    }
}
