package racingcar;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private Scanner scanner;
    private List<Car> carList;

    public RacingGame(Scanner scanner){
        this.scanner = scanner;
    }

    public void runGame(){

    }

    public void setup(){
        try {
            String carNames = scanner.nextLine();
            setupCars(carNames);
        } catch (IllegalArgumentException ie){

        }
    }

    public void setupCars(String inputCars){
        String[] cars = inputCars.split(",");
        for(String car : cars){
            checkCarNameLength(car);
        }
        initializeCars(cars);
    }

    public void initializeCars(String[] cars){
        carList = new LinkedList<>(Arrays.stream(cars)
                .map(name -> new Car(name))
                .collect(Collectors.toList()));
    }

    public void checkCarNameLength(String car){
        if(car.length() >= MAX_CAR_NAME_LENGTH)
            throw new IllegalArgumentException();
    }
}
