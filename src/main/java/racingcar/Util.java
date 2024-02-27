package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Util {
    private final String DELIMETER = ",";


    public Car[] createCars(String[] carNames) {
        Car[] cars = new Car[carNames.length];

        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i].trim());
        }

        return cars;
    }

    public String[] parseCars(String input) throws IllegalArgumentException {
        String[] cars = input.split(DELIMETER, -1);

        checkCarsName(cars);

        return cars;
    }

    public void checkCarsName(String[] carNames) throws IllegalArgumentException {
        if (Arrays.stream(carNames).anyMatch(carName -> carName.length() > 5)) {
            throw new IllegalArgumentException();
        }
    }



    public int changeCount(String input) throws IllegalArgumentException {
        int count = Integer.parseInt(input);

        checkCountRange(count);

        return count;
    }
    public void checkCountRange(int count){
        if(count<0){
            throw new IllegalArgumentException();
        }
    }

    public List<Car> findWinners(Car[] cars) {
        List<Car> winners = new ArrayList<>();
        int maxPosition = 0;

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }



        return winners;
    }

    public String makeWinnerFormat(List<Car> cars){

        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }





}