package com.minuyim.race.domain;

import java.util.ArrayList;
import java.util.List;

import com.minuyim.race.utils.Constants;

public class Winner {
    private List<Car> cars;
    
    public Winner(Race race) {
        this.cars = race.getCars();
    }
    
    private int calculateMaxPosition() {
        int max = 0;
        
        for (int i = 0; i < cars.size(); i++) {
            if (max < cars.get(i).getPosition()) {
                max = cars.get(i).getPosition();
            }
        }
        
        return max;
    }
    
    private List<Car> getWinner(){
        List<Car> winner = new ArrayList<Car>();
        int maxPosition = calculateMaxPosition();
        
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winner.add(car);
            }
        }
        
        return winner;
    }
    
    public void printWinner() {
        List<String> winnerName = new ArrayList<String>();
        for (Car car : getWinner()) {
            winnerName.add(car.getName());
        }
        System.out.println(String.format("%s" + Constants.WINNER_MESSAGE, String
                .join(", ", winnerName)));
    }
}