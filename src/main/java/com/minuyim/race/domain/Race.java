package com.minuyim.race.domain;

import java.util.List;
import java.util.ArrayList;

import com.minuyim.race.utils.MessageStrings;
import com.minuyim.race.utils.NumberInputs;
import com.minuyim.race.utils.StringsInputs;

public class Race {
    private List<Car> cars = new ArrayList<Car>();
    
    public Race() {
        registeCars();
    }
    
    private void registeCars() {
        StringsInputs stringInput = new StringsInputs();
        addCars(stringInput.getOutput());
    }
    
    private void addCars(String[] names) {
        for (String name : names) {
            this.cars.add(new Car(name));
        }
    }
    
    List<Car> getCars() {
        return this.cars;
    }
    
    public void startRace() {
        NumberInputs numberInput = new NumberInputs();
        
        System.out.println(MessageStrings.START_RESULT_MESSAGE);
        for (int i = 0; i < numberInput.getOutput(); i++) {
            moveCars();
            printRace();
        }
    }
    
    private void moveCars() {
        for (Car car : this.cars) {
            car.moveFoward();
        }
    }
    
    private void printRace() {
        for (Car car : this.cars) {
            car.printPosition();
        }
        System.out.println();
    }
}
