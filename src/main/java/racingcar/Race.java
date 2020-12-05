package racingcar;
/*
 * Race
 *
 * version 1.0
 *
 * 2020.12.05
 *
 * Copyright (c) by Davinci.J
 */
import java.util.Collections;
import java.util.List;

public class Race {
    private List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    /**
     * only for test
     */
    public List<Car> getCars() {
        return this.cars;
    }

    public static Race generateRace(InputManager inputManager) {
        System.out.println(Constants.CAR_INPUT_STATEMENT);
        while (true) {
            try {
                return new Race(inputManager.generateCars());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void startCarRace(int trialCount) {
        System.out.println(Constants.RACE_RESULT);
        for (int i=0; i<trialCount; i++) {
            for (Car car : cars) {
                car.moveCar();
                System.out.println(car.toString());
            }
            System.out.println();
        }
    }

    public String decideWinner() {
        Collections.sort(cars);
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.WINNERS);
        for (Car car : cars) {
            if (car.isWinner(cars.get(0))) {
                sb.append(car.getName()).append(Constants.SEPARATOR).append(Constants.BLANK);
            }
        }
        sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
