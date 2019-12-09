package com.minuyim.race.domain;

import java.util.ArrayList;
import java.util.List;

import com.minuyim.race.utils.MessageStrings;

public class Winner {
    private List<Car> cars;
    
    public Winner(Race race) {
        this.cars = race.getCars();
    }
    
    private int calculateMaxPosition() {
        int max = 0;
        
        for (Car car : this.cars) {
            if (max < car.getPosition()) {
                max = car.getPosition();
            }
        }
        
        return max;
    }
    
    private List<String> getWinnerName(){
        List<String> winnerName = new ArrayList<String>();
        
        for (Car car : this.cars) {
            if (car.isPosition(calculateMaxPosition())) {
                winnerName.add(car.getName());
            }
        }
        
        return winnerName;
    }
    
    public void printWinner() {
        List<String> winnerName = getWinnerName();
        
        System.out.println(String.format("%s" + MessageStrings.WINNER_MESSAGE, String
                .join(", ", winnerName)));
    }
}
