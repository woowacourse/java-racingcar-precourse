package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public static Car[] createCars(String[] carNames){
        int N = carNames.length;
        Car[] cars = new Car[N];

        int idx = 0;
        for(String carName : carNames){
            cars[idx++] = new Car(carName);
        }

        return cars;
    }

    private int genertaeRandom(){
        return new Random().nextInt(9);
    }
}
