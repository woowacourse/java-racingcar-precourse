package domain;

import java.util.Random;

public class ForwardCar {
    static final int FOWARD_CAR = 4;
    int randomNum = 0;

    void randomNum() {
        Random random = new Random();
        randomNum = random.nextInt(10);
    }

    void decideForward(Car car) {
        randomNum();
        if (randomNum >= FOWARD_CAR)
            car.forwardCar();
    }
}
