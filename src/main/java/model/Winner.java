package model;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    public Winner() {}

    public boolean hasWinner(final List<Car> participants, final int goal) {
        
        return participants.stream().anyMatch(car -> car.getPosition() == goal);
    }
    
    public List <Car> getWinner(final List<Car> participants, final int goal) {
        
        return participants.stream().filter(car -> car.getPosition() == goal).collect(Collectors.toList());
    }
}
