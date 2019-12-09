package com.minuyim.race.domain;

import java.util.List;
import java.util.ArrayList;

import com.minuyim.race.utils.Constants;
import com.minuyim.race.utils.NumberInputs;
import com.minuyim.race.utils.StringsInputs;

public class Race {
    private List<Car> cars = new ArrayList<Car>();
    
    public Race() {
        registeCars();
    }
    
    public List<Car> getCars() {
        return this.cars;
    }
    
    private void registeCars() {
        StringsInputs stringInput = new StringsInputs();
        addCars(stringInput.getOutput());
    }
    
    public void startRace() {
        NumberInputs numberInput = new NumberInputs();
        
        System.out.println(Constants.START_RESULT_MESSAGE);
        for (int i = 0; i < numberInput.getOutput(); i++) {
            moveCars();
            printRace();
        }
    }
    
    private void addCars(String[] names) {
        for (String name : names) {
            this.cars.add(new Car(name));
        }
    }
    
    private void moveCars() {
        for (Car car : this.cars) {
            car.moveFoward();
        }
    }
    
    private void printRace() {
        for (Car car : this.cars) {
            String repeatChar = new String(new char[car.getPosition()])
                    .replace("\0", Constants.REFEATED_CHAR);
            System.out.println(String.format("%s : %s", car.getName(), repeatChar));
        }
        System.out.println();
    }
}